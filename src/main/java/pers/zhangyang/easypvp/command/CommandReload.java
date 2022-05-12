package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.SettingYamlManager;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.io.IOException;

public class CommandReload extends CommandBase {
    public CommandReload(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {
            SettingYamlManager.SETTING_YAML_MANAGER.init();
            GuiYamlManager.GUI_MANAGER.init();
            MessageYamlManager.MESSAGE_YAML_MANAGER.init();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return true;
        }

        MessageUtil.sendMessageTo(sender, MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_RELOAD());
        return true;
    }
}
