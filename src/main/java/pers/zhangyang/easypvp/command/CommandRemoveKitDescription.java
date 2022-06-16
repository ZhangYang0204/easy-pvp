package pers.zhangyang.easypvp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistDesciptionRowException;
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

public class CommandRemoveKitDescription extends CommandBase {

    public CommandRemoveKitDescription(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        int index;
        try {
            index=Integer.parseInt(args[2])-1;
        }catch (NumberFormatException e){
           invalidArgument(args[2]);
            return true ;
        }
        if (index<0){
            invalidArgument(args[2]);
            return true ;
        }

        try {

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.removeKitDescription(args[1],index );
        } catch (SQLException e) {
            e.printStackTrace();
             
            return true;
        } catch (NotExistDesciptionRowException e) {
            Map rep=new HashMap<>();
            rep.put("{kit}",args[1]);
            rep.put("{row}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW();
            if (list!=null) {
                ReplaceUtil.replace(list, rep);
            }
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        } catch (NotExistKitNameException e) {
            Map rep=new HashMap<>();
            rep.put("{kit}",args[1]);
            rep.put("{row}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME();
            if (list!=null) {
                ReplaceUtil.replace(list, rep);
            }
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }
        Map rep=new HashMap<>();
        rep.put("{kit}",args[1]);
        rep.put("{row}",args[2]);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_KIT_DESCRIPTION_REMOVE();
        if (list!=null) {
            ReplaceUtil.replace(list, rep);
        }
        MessageUtil.sendMessageTo(sender, list);
        return true ;
    }
}
