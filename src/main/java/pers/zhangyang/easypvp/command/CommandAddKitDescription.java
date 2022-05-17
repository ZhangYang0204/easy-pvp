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

public class CommandAddKitDescription extends CommandBase {
    public CommandAddKitDescription(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            KitMeta kitMeta=commandService.getKitMeta(args[1]);
            String[] descriptions = kitMeta.getDescription()==null?new String[0]:kitMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            descriptionList.add(args[2]);
            commandService.kitDescriptionSet(args[1], descriptionList);
        } catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotExistKitNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{kit}",args[1]);
            rep.put("{description}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_ADD_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{kit}",args[1]);
        rep.put("{description}",args[2]);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_ADD_KIT_DESCRIPTION();
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(sender, list);

        return true ;

    }

}
