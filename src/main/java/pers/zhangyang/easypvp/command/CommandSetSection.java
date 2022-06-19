package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.manager.SectionManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.Collections;
import java.util.List;

public class CommandSetSection extends CommandBase {
    public CommandSetSection(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        Player player = (Player) sender;

        if (args[1].equalsIgnoreCase("first")) {
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setFirst(player.getLocation());

        } else if (args[1].equalsIgnoreCase("second")) {
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setSecond(player.getLocation());

        } else if (args[1].equalsIgnoreCase("red")) {
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setRed(player.getLocation());

        } else if (args[1].equalsIgnoreCase("blue")) {
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setBlue(player.getLocation());
        } else {
            invalidArgument(args[1]);
            return true;
        }

        List<String> list = MessageYaml.INSTANCE.getCHAT_SUCCESS_SET_SECTION();
        if (list!=null) {
            ReplaceUtil.replace(list, Collections.singletonMap("{point}", args[1]));
        }
        MessageUtil.sendMessageTo(sender, list);

        return true ;
    }
}
