package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommandMapChooseTickSet extends CommandBase {

    public CommandMapChooseTickSet(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        long chooseTick;
        try {
            chooseTick=Long.parseLong(args[2]);
        }catch (NumberFormatException e) {

            List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }

        if (chooseTick<0){
            List<String> list=MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }


        try {


            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.mapChooseTickSet(args[1],chooseTick);
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{tick}",args[2]);
            List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_CHOOSE_TICK_SET_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{tick}",args[2]);
        List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_CHOOSE_TICK_SET();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);

        return true;
    }
}