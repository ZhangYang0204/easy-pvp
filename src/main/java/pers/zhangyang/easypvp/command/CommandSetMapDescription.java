package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistDesciptionRowException;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.*;

public class CommandSetMapDescription extends CommandBase {

    public CommandSetMapDescription(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        int index;
        try {
            index = Integer.parseInt(args[2]) - 1;
        } catch (NumberFormatException e) {
            invalidArgument(args[2]);
            return true;
        }
        if (index < 0) {
            invalidArgument(args[2]);
            return true;
        }
        try {
            CommandService commandService = (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.setMapDescription(args[1],index,args[3] );
            RefreshUtil.refreshAllMapPage();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String, String> rep = new HashMap<>();
            rep.put("{map}", args[1]);
            rep.put("{row}", args[2]);
            rep.put("{description}", args[3]);
            List<String> list = MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME();
            if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
            MessageUtil.sendMessageTo(sender, list);
            return true;
        } catch (NotExistDesciptionRowException e) {
            HashMap<String, String> rep = new HashMap<>();
            rep.put("{map}", args[1]);
            rep.put("{row}", args[2]);
            rep.put("{description}", args[3]);
            List<String> list = MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW();
            if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{map}", args[1]);
        rep.put("{row}", args[2]);
        rep.put("{description}", args[3]);
        List<String> list = MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_SET_MAP_DESCRIPTION();
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        MessageUtil.sendMessageTo(sender, list);


        return true ;
    }
}
