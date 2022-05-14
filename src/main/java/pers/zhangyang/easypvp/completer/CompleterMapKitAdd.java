package pers.zhangyang.easypvp.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.List;

public class CompleterMapKitAdd extends CompleterBase {
    @Override
    public List<String> complete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length==2){
            return removeStartWith(args[1], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_MAP_KIT_ADD());
        }
        if (args.length==3){
            return removeStartWith(args[2], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_MAP_KIT_ADD_$());
        }

        return new ArrayList<>();
    }
}
