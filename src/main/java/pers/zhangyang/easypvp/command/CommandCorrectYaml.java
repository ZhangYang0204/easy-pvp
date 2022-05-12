package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.SettingYamlManager;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.io.IOException;

public class CommandCorrectYaml extends CommandBase {
    public CommandCorrectYaml(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {
            SettingYamlManager.SETTING_YAML_MANAGER.correct();
            GuiYamlManager.GUI_MANAGER.correct();
            MessageYamlManager.MESSAGE_YAML_MANAGER.correct();
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }

        MessageUtil.sendMessageTo(sender,MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_CORRECT_YAML());
        return true;
    }
}
