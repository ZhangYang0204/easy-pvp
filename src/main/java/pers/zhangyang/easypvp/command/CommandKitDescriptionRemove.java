package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
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

public class CommandKitDescriptionRemove extends CommandBase {

    public CommandKitDescriptionRemove(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        int index;
        try {
            index=Integer.parseInt(args[2])-1;
        }catch (NumberFormatException e){

            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list,Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list );
            return true;
        }
        if (index<0){
            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list,Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list );
            return true;
        }

        try {
            if (index<0){
                throw new IllegalArgumentException();
            }

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            KitMeta kitMeta=commandService.getKitMeta(args[1]);

            String[] descriptions = kitMeta.getDescription()==null?new String[0]:kitMeta.getDescription().split(" ");

            if (descriptions.length<index+1){
                throw new NotExistDesciptionRowException();
            }

            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));

            descriptionList.remove(index);

            commandService.kitDescriptionSet(args[1], descriptionList);






        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistDesciptionRowException e) {
            Map rep=new HashMap<>();
            rep.put("{kit}",args[1]);
            rep.put("{row}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW();
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        } catch (NotExistKitNameException e) {
            Map rep=new HashMap<>();
            rep.put("{kit}",args[1]);
            rep.put("{row}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        Map rep=new HashMap<>();
        rep.put("{kit}",args[1]);
        rep.put("{row}",args[2]);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_KIT_DESCRIPTION_REMOVE();
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(sender, list);
        return true;
    }
}
