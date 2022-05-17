package pers.zhangyang.easypvp.completer;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.List;

public class CompleterSetKitDescription extends CompleterBase {
    public CompleterSetKitDescription(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public List<String> complete() {
        if (args.length==2){
            return removeStartWith(args[1], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_KIT_SET_DESCRIPTION());
        }
        if (args.length==3){
            return removeStartWith(args[2], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_SET_KIT_DESCRIPTION_$());
        }
        if (args.length==4){
            return removeStartWith(args[3], MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_KIT_SET_DESCRIPTION_$_$());
        }
        return new ArrayList<>();
    }
}
