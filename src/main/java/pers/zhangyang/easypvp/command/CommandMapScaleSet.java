package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommandMapScaleSet extends CommandBase {

    public CommandMapScaleSet(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        int scale;
        try {
         scale=Integer.parseInt(args[2]);
        }catch (NumberFormatException e) {

            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }

        if (scale<1){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }


        try {

            if (scale<1){throw new IllegalArgumentException();}

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.mapScaleSet(args[1],scale);
            RefreshUtil.refreshAllMapPage();


        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{scale}",args[2]);
            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_SCALE_SET_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{scale}",args[2]);
        List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_SCALE_SET();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);

        return true;
    }
}
