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

public class CommandMapDescriptionRemove extends CommandBase {

    public CommandMapDescriptionRemove(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        int index;
        try {
            index=Integer.parseInt(args[2])-1;
        }catch (NumberFormatException e){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);

            return true;
        }
        if (index<0){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}",args[2]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }

        try {

            if (index<0){
                throw new IllegalArgumentException();
            }

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            MapMeta mapMeta=commandService.getMapMeta(args[1]);

            String[] descriptions = mapMeta.getDescription()==null?new String[0]:mapMeta.getDescription().split(" ");

            if (descriptions.length<index+1){
                throw new NotExistDesciptionRowException();
            }

            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));

            descriptionList.remove(index);

            commandService.mapDescriptionSet(args[1], descriptionList);

            RefreshUtil.refreshAllMapPage();

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{row}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);

            return true;
        } catch (NotExistDesciptionRowException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{row}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{row}",args[2]);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_DESCRIPTION_REMOVE();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);
        return true;

    }
}
