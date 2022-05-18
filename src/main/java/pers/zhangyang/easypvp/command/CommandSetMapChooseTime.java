package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CommandSetMapChooseTime extends CommandBase {

    public CommandSetMapChooseTime(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        int chooseTick;
        try {
            chooseTick=Integer.parseInt(args[2]);
        }catch (NumberFormatException e) {
           invalidArgument(args[2]);
            return true ;
        }

        if (chooseTick<0){
            invalidArgument(args[2]);
            return true ;
        }


        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.setMapChooseTime(args[1],chooseTick);
            RefreshUtil.refreshAllMapPage();
        } catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{time}",args[2]);
            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_SET_MAP_CHOOSE_TIME_BECAUSE_NOT_EXIST_MAP_NAME();
            if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{time}",args[2]);
        List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_SET_MAP_CHOOSE_TIME();
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        MessageUtil.sendMessageTo(sender, list);

        return true ;
    }
}