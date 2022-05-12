package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.io.IOException;
import java.sql.SQLException;

public class CommandRecordReset extends CommandBase {
    public CommandRecordReset(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.recordReset();
        } catch (SQLException e) {
         throw new RuntimeException();
        }

        MessageUtil.sendMessageTo(sender, MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_RECORD_RESET());
        return true;
    }
}