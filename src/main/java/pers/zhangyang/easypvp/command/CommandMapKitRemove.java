package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.MapNotAddKitException;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CommandMapKitRemove extends CommandBase {
    public CommandMapKitRemove(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        try {

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());

            commandService.mapKitRemove(args[1],args[2]);
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{kit}",args[2]);
            List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistKitNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{kit}",args[2]);
            List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        } catch (MapNotAddKitException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{kit}",args[2]);
            List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{kit}",args[2]);
        List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_KIT_REMOVE();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);
        return true;
    }
}
