package pers.zhangyang.easypvp.completer;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.List;

public class CompleterCreateMap extends CompleterBase {
    public CompleterCreateMap(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public @NotNull List<String> complete() {
        if (args.length==2){
            return removeStartWith(args[1], MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_CREATE_MAP() ==null?new ArrayList<>():MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_CREATE_MAP()
            );
        }
        return new ArrayList<>();
    }
}
