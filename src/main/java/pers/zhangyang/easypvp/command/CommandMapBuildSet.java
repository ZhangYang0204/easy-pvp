package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommandMapBuildSet extends CommandBase  {

    public CommandMapBuildSet(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        if (!args[2].equalsIgnoreCase("true")&&!args[2].equalsIgnoreCase("false")){


            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);

            return true;
        }

        boolean build=Boolean.parseBoolean(args[2]);


        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.mapBuildSet(args[1],build);

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{build}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_BUILD_SET_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);

            return true;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{build}",args[2]);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_BUILD_SET();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);

        return true;
    }
}
