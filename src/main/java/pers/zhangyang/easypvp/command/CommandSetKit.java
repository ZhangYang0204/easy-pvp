package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.util.*;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.KitItemStackMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;

import java.sql.SQLException;
import java.util.*;

public class CommandSetKit extends CommandBase {
    public CommandSetKit(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        Player player= (Player) sender;

        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            List<KitItemStackMeta> kitItemStackMetaList=new ArrayList<>();
            String uuid=UuidUtil.getUUID();
            for (int i=0;i<player.getInventory().getContents().length;i++){
                if (player.getInventory().getContents()[i]==null){continue;}
                KitItemStackMeta kitItemStackMeta =new KitItemStackMeta();
                kitItemStackMeta.setKitUuid(uuid);
                kitItemStackMeta.setData(ItemStackUtil.itemStackSerialize(player.getInventory().getContents()[i]));
                kitItemStackMeta.setSlot(i);
                kitItemStackMetaList.add(kitItemStackMeta);
            }

            commandService.setKit(args[1], kitItemStackMetaList);
        }  catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotExistKitNameException e) {
            Map rep=new HashMap<>();
            rep.put("{kit}", args[1]);
            List<String> list= MessageYaml.INSTANCE.getCHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME();
            if (list!=null) {
                ReplaceUtil.replace(list, rep);
            }
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }
        Map rep=new HashMap<>();
        rep.put("{kit}", args[1]);
        List<String> list= MessageYaml.INSTANCE.getCHAT_SUCCESS_SET_KIT();
        if (list!=null) {
            ReplaceUtil.replace(list, rep);
        }
        MessageUtil.sendMessageTo(sender, list);

        return true ;

    }
}
