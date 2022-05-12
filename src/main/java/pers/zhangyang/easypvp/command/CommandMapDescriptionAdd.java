package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.*;

public class CommandMapDescriptionAdd extends CommandBase {
    public CommandMapDescriptionAdd(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        try {

            if (args[2].contains(" ")){
                throw new IllegalArgumentException();
            }
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            MapMeta mapMeta=commandService.getMapMeta(args[1]);


            String[] descriptions = mapMeta.getDescription()==null?new String[0]:mapMeta.getDescription().split(" ");

            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));

            descriptionList.add(args[2]);

            commandService.mapDescriptionSet(args[1], descriptionList);
            RefreshUtil.refreshAllMapPage();

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{description}",args[2]);
            List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(sender, list);

            return true;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{description}",args[2]);
        List<String> list=MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_DESCRIPTION_ADD();
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(sender, list);
        return true;
    }
}
