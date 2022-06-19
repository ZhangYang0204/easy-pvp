package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.yaml.*;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.io.IOException;

public class CommandCorrectYaml extends CommandBase {
    public CommandCorrectYaml(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        try {
            SettingYaml.INSTANCE.correct();
            GuiYaml.INSTANCE.correct();
            MessageYaml.INSTANCE.correct();
            DanYaml.INSTANCE.correct();
            ShopYaml.INSTANCE.correct();
        } catch (IOException e) {
            e.printStackTrace();
             
            return true;
        }
        MessageUtil.sendMessageTo(sender, MessageYaml.INSTANCE.getCHAT_SUCCESS_CORRECT_YAML());
        return true ;
    }
}
