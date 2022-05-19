package pers.zhangyang.easypvp.completer;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.List;

public class CompleterSubtractCumulativeStar extends CompleterBase {
    public CompleterSubtractCumulativeStar(@NotNull CommandSender sender, boolean forcePlayer, @NotNull String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public List<String> complete() {
        if (args.length==2){
            List<String> list=MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR();
            if (list==null){return new ArrayList<>();}else {

                List<String> na=new ArrayList<>();
                for (Player p: Bukkit.getOnlinePlayers()){
                    na.add(p.getName());
                }

                ReplaceUtil.format(list,"{[$]}", na);
            }

            return removeStartWith(args[1], list==null?new ArrayList<>():list);
        }
        if (args.length==3){
            return removeStartWith(args[2], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$()
                    ==null?new ArrayList<>():MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$()
            );
        }
        return new ArrayList<>();
    }
}