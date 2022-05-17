package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CommandDeleteKit extends CommandBase {

    public CommandDeleteKit(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.kitDelete(args[1]);
        } catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotExistKitNameException e) {
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_DELETE_KIT_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list, Collections.singletonMap("{kit}",args[1]));
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_DELETE_KIT();
        ReplaceUtil.replace(list, Collections.singletonMap("{kit}",args[1]));
        MessageUtil.sendMessageTo(sender, list);

        return true ;
    }
}
