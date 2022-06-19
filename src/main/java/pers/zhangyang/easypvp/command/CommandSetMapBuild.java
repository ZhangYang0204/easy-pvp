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
import java.util.HashMap;
import java.util.List;

public class CommandSetMapBuild extends CommandBase {

    public CommandSetMapBuild(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        if (!args[2].equalsIgnoreCase("true") && !args[2].equalsIgnoreCase("false")) {
            invalidArgument(args[2]);
            return true;
        }
        boolean build = Boolean.parseBoolean(args[2]);
        try {
            CommandService commandService = (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.setMapBuild(args[1], build);
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String, String> rep = new HashMap<>();
            rep.put("{map}", args[1]);
            rep.put("{build}", args[2]);
            List<String> list = MessageYaml.INSTANCE.getCHAT_FAILURE_SET_MAP_BUILD_BECAUSE_NOT_EXIST_MAP_NAME();
            if (list != null) {
                ReplaceUtil.replace(list, rep);
            }
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{map}", args[1]);
        rep.put("{build}", args[2]);
        List<String> list = MessageYaml.INSTANCE.getCHAT_SUCCESS_SET_MAP_BUILD();
        if (list != null) {
            ReplaceUtil.replace(list, rep);
        }
        MessageUtil.sendMessageTo(sender, list);

        return true;
    }
}
