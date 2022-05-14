package pers.zhangyang.easypvp.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.List;

public class CompleterMapBuildSet extends CompleterBase {
    @Override
    public List<String> complete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length==2){
            return removeStartWith(args[1], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_MAP_BUILD_SET());
        }
        if (args.length==3){
            return removeStartWith(args[2], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_MAP_BUILD_SET_$());
        }
        return new ArrayList<>();
    }
}
