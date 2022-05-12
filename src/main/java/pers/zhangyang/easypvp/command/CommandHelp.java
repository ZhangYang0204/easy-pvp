package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.util.MessageUtil;

public class CommandHelp extends CommandBase {


    public CommandHelp(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        MessageUtil.sendMessageTo(sender, MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_HELP());
        return true;
    }
}
