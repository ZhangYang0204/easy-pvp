package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.DuplicateKitNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.KitItemStackMeta;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandKitCreate extends CommandBase {

    public CommandKitCreate(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        Player player= (Player) sender;
        try {
            KitMeta kitMeta=new KitMeta();
            String kitUuid= UuidUtil.getUUID();
            kitMeta.setUuid(kitUuid);
            kitMeta.setName(args[1]);
            List<KitItemStackMeta> kitItemStackMetaList =new ArrayList<>();
            for (int i=0;i<player.getInventory().getContents().length;i++){
                if (player.getInventory().getContents()[i]==null){continue;}
                KitItemStackMeta kitItemStackMeta =new KitItemStackMeta();
                kitItemStackMeta.setKitUuid(kitUuid);
                kitItemStackMeta.setData(ItemStackUtil.itemStackSerialize(player.getInventory().getContents()[i]));
                kitItemStackMeta.setSlot(i);
                kitItemStackMetaList.add(kitItemStackMeta);
            }
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.kitCreate(kitMeta, kitItemStackMetaList);

        } catch (DuplicateKitNameException e) {
           List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                   .getCHAT_FAILURE_KIT_CREATE_BECAUSE_DUPLICATE_KIT_NAME();
            ReplaceUtil.replace(list, Collections.singletonMap("{kit}",args[1]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_KIT_CREATE();
        ReplaceUtil.replace(list, Collections.singletonMap("{kit}",args[1]));
        MessageUtil.sendMessageTo(sender, list);

        return true;
    }
}
