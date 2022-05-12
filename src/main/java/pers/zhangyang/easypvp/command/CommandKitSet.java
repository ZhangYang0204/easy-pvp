package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.meta.ItemMeta;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandKitSet extends CommandBase {
    public CommandKitSet(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        Player player= (Player) sender;
        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            KitMeta kitMeta= commandService.getKitMeta(args[1]);

            String kitUuid= kitMeta.getUuid();
            List<ItemMeta> itemMetaList=new ArrayList<>();
            for (int i=0;i<player.getInventory().getContents().length;i++){
                if (player.getInventory().getContents()[i]==null){continue;}
                ItemMeta itemMeta=new ItemMeta();
                itemMeta.setKitUuid(kitUuid);
                itemMeta.setData(ItemStackUtil.itemStackSerialize(player.getInventory().getContents()[i]));
                itemMeta.setSlot(i);
                itemMetaList.add(itemMeta);
            }
            commandService.kitSet(args[1],itemMetaList);


        }  catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistKitNameException e) {
            List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_KIT_SET_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list, Collections.singletonMap("{kit}",args[1]));
            MessageUtil.sendMessageTo(sender, list);

            return true;
        }

        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_KIT_SET();
        ReplaceUtil.replace(list, Collections.singletonMap("{kit}",args[1]));
        MessageUtil.sendMessageTo(sender, list);


        return true;
    }
}
