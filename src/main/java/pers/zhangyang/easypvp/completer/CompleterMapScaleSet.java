package pers.zhangyang.easypvp.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.manager.MessageYamlManager;

import java.util.ArrayList;
import java.util.List;

public class CompleterMapScaleSet extends CompleterBase {
    @Override
    public List<String> complete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length==2){
            return removeStartWith(args[1], MessageYamlManager.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_MAP_SCALE_SET());
        }
        if (args.length==3){
            return removeStartWith(args[2], MessageYamlManager.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_MAP_SCALE_SET_$());
        }

        return new ArrayList<>();
    }
}
