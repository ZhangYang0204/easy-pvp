package pers.zhangyang.easypvp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.exception.NotEnoughStarException;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandSubtractCumulativeStar extends CommandBase {

    public CommandSubtractCumulativeStar(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        int index;
        try {
            index=Integer.parseInt(args[2]);
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
            Player player= Bukkit.getPlayer(args[1]);
            if (player==null){
                invalidArgument(args[1]);
                return true;
            }

            commandService.subtractCumulativeStar(player.getUniqueId().toString(),index );
        } catch (SQLException e) {
            e.printStackTrace();
            return true ;
        } catch (NotEnoughStarException e) {
            Map rep=new HashMap<>();
            rep.put("{player}",args[1]);
            rep.put("{amount}",args[2]);
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_FAILURE_SUBTRACT_CUMULATIVE_STAR_BECAUSE_NOT_ENOUGH_STAR();
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(sender, list);
            e.printStackTrace();
            return true;
        }
        Map rep=new HashMap<>();
        rep.put("{player}",args[1]);
        rep.put("{amount}",args[2]);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_SUBTRACT_CUMULATIVE_STAR();
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(sender, list);

        rep=new HashMap<>();
        rep.put("{player}",sender.getName());
        rep.put("{amount}",args[2]);
        list= MessageYaml.MESSAGE_YAML_MANAGER.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_WAS_SUBTRACTED_CUMULATIVE_STAR();
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(sender, list);
        return true ;
    }
}