package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.*;

public class CommandSetKitDescription extends CommandBase {
    public CommandSetKitDescription(CommandSender sender, boolean forcePlayer, String[] args) {
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
            KitMeta kitMeta = commandService.getKitMeta(args[1]);
            String[] descriptions = kitMeta.getDescription() == null ? new String[0] : kitMeta.getDescription().split(" ");
            if (descriptions.length < index + 1) {
                HashMap<String, String> rep = new HashMap<>();
                rep.put("{kit}", args[1]);
                rep.put("{row}", args[2]);
                rep.put("{description}", args[3]);
                List<String> list = MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW();
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(sender, list);
                return true;
            }
            descriptions[index] = args[3];
            commandService.kitDescriptionSet(args[1], Arrays.asList(descriptions));
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistKitNameException e) {
            HashMap<String, String> rep = new HashMap<>();
            rep.put("{kit}", args[1]);
            rep.put("{row}", args[2]);
            rep.put("{description}", args[3]);
            List<String> list = MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{kit}", args[1]);
        rep.put("{row}", args[2]);
        rep.put("{description}", args[3]);
        List<String> list = MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_SET_KIT_DESCRIPTION();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);

        return true ;
    }
}
