package pers.zhangyang.easypvp.completer;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.List;

public class CompleterSectionSet extends CompleterBase {
    public CompleterSectionSet(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public List<String> complete() {
        if (args.length==2){
            return removeStartWith(args[1], MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_SET_SECTION()
                    ==null?new ArrayList<>():MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_SET_SECTION()
            );
        }

        return new ArrayList<>();
    }
}
