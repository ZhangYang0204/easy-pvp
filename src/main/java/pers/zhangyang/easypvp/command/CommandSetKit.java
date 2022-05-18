package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.KitItemStackMeta;
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

public class CommandSetKit extends CommandBase {
    public CommandSetKit(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        Player player= (Player) sender;

        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.setKit(args[1], player.getInventory().getContents());
        }  catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotExistKitNameException e) {
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME();
            if (list!=null) {
                ReplaceUtil.replace(list, Collections.singletonMap("{kit}", args[1]));
            }
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }

        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_SET_KIT();
        if (list!=null) {
            ReplaceUtil.replace(list, Collections.singletonMap("{kit}", args[1]));
        }
        MessageUtil.sendMessageTo(sender, list);

        return true ;

    }
}
