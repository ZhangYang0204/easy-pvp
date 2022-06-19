package pers.zhangyang.easypvp.runnable;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import org.jetbrains.annotations.Nullable;
import java.util.HashMap;
import java.util.List;

public class NotifyVersionRunnable extends BukkitRunnable {

    private String latest;
    private CommandSender sender;
    public NotifyVersionRunnable(@Nullable String latest, CommandSender sender){
        this.latest=latest;
        this.sender=sender;
    }

    @Override
    public void run() {
        List<String> list;
        if (latest!=null) {
            list = MessageYaml.INSTANCE.getCHAT_SUCCESS_NOTIFY_VERSION();
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("{current}", EasyPvp.getInstance().getDescription().getVersion());
            hashMap.put("{latest}",latest);
            if (list!=null) {
                ReplaceUtil.replace(list, hashMap);
            }
        }else {
            list = MessageYaml.INSTANCE.getCHAT_FAILURE_NOTIFY_VERSION_BECAUSE_NOT_GET_LATEST_VERSION();
        }
        MessageUtil.sendMessageTo(sender,list);
    }
}
