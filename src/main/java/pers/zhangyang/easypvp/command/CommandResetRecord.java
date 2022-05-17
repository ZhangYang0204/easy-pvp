package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.sql.SQLException;

public class CommandResetRecord extends CommandBase {
    public CommandResetRecord(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {
            CommandService commandService = (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.recordReset();
        } catch (SQLException e) {
            e.printStackTrace();
            return true ;
        }

        MessageUtil.sendMessageTo(sender, MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_RESET_RECORD());

        return true ;
    }
}