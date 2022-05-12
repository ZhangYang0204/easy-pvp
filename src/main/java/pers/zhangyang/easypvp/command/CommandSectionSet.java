package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.SectionManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.Collections;
import java.util.List;

public class CommandSectionSet extends CommandBase {
    public CommandSectionSet(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        Player player= (Player) sender;
        if (!args[1].equalsIgnoreCase("first")&&!args[1].equalsIgnoreCase("second")
            &&!args[1].equalsIgnoreCase("red")&&!args[1].equalsIgnoreCase("blue")){

            List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_INVALID_ARGUMENT();
            ReplaceUtil.replace(list,  Collections.singletonMap("{argument}",args[1]));
            MessageUtil.sendMessageTo(sender, list);

            return true;
        }

        if (args[1].equalsIgnoreCase("first")){
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setFirst(player.getLocation());

        }
        if (args[1].equalsIgnoreCase("second")){
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setSecond(player.getLocation());

        }
        if (args[1].equalsIgnoreCase("red")){
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setRed(player.getLocation());

        }
        if (args[1].equalsIgnoreCase("blue")){
            SectionManager.SECTION_MANAGER.getPlayerSection(player).setBlue(player.getLocation());
        }


        List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_SECTION_SET();
        ReplaceUtil.replace(list,  Collections.singletonMap("{point}",args[1]));
        MessageUtil.sendMessageTo(sender, list);


        return true;
    }
}
