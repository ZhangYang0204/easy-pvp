package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.yaml.*;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.io.IOException;

public class CommandReloadYaml extends CommandBase {
    public CommandReloadYaml(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {
            SettingYaml.INSTANCE.init();
            GuiYaml.INSTANCE.init();
            MessageYaml.INSTANCE.init();
            DanYaml.INSTANCE.init();
            ShopYaml.INSTANCE.init();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
             
            return true;
        }

        MessageUtil.sendMessageTo(sender, MessageYaml.INSTANCE.getCHAT_SUCCESS_RELOAD_YAML());
        return true ;
    }
}
