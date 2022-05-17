package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.MapAlreadyAddKitException;
import pers.zhangyang.easypvp.exception.NotExistKitNameException;
import pers.zhangyang.easypvp.exception.NotExistMapNameException;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.MapKitMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CommandAddMapKit extends CommandBase {

    public CommandAddMapKit(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {

        try {

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            MapKitMeta mapKitMeta=new MapKitMeta();
            mapKitMeta.setKitUuid(commandService.getKitMeta(args[2]).getUuid());
            mapKitMeta.setMapUuid(commandService.getMapMeta(args[1]).getUuid());
            commandService.mapKitAdd(mapKitMeta);

        } catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotExistKitNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{kit}",args[2]);
            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);

            return true ;
        } catch (NotExistMapNameException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{kit}",args[2]);
            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        } catch (MapAlreadyAddKitException e) {
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{map}",args[1]);
            rep.put("{kit}",args[2]);
            List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_ADD_MAP_KIT_BECAUSE_MAP_ALREADY_ADD_KIT();
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(sender, list);
            return true ;
        }
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{map}",args[1]);
        rep.put("{kit}",args[2]);

        List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_ADD_MAP_KIT();
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(sender, list);

        return true ;
    }
}
