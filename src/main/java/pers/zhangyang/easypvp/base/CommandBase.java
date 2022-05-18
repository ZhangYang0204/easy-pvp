package pers.zhangyang.easypvp.base;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public abstract class CommandBase {

    protected boolean forcePlayer;
    protected CommandSender sender;
    protected String[] args;
    public CommandBase(@Nonnull CommandSender sender, boolean forcePlayer ,@Nonnull String[] args) {
        if (args.length<1){throw new IllegalArgumentException();}
        this.sender=sender;
        this.forcePlayer = forcePlayer;
        this.args=args;
    }
    public boolean process(){
        if (!(sender instanceof Player)&&forcePlayer){
            MessageUtil.sendMessageTo(sender, MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_NOT_PLAYER());
            return true;
        }
        String permission="EasyPvp."+args[0];
        if (!sender.hasPermission(permission)){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_NO_PERMISSION();
            if (list!=null) {
                ReplaceUtil.replace(list, Collections.singletonMap("{permission}", permission));
            }
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }
        return run();
    }

    protected void invalidArgument(@Nonnull String arg){
        if (arg==null){throw new IllegalArgumentException();}
        List<String> list=  MessageYaml.MESSAGE_YAML_MANAGER.getCHAT_INVALID_ARGUMENT();
        if (list!=null) {
            ReplaceUtil.replace(list, Collections.singletonMap("{argument}", arg));
        }
        MessageUtil.sendMessageTo(sender, list);
    }

    protected abstract boolean run();

}

