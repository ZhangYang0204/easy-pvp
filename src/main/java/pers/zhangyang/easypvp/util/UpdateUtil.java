package pers.zhangyang.easypvp.util;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.manager.MessageYamlManager;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class UpdateUtil {
    public static void updateNotify(CommandSender sender){

        new BukkitRunnable() {
            @Override
            public void run() {
                String latestVersion;
                try {
                    String version = ResourceUtil.getFirstLine(new URL("https://zhangyang0204.github.io/easy-pvp/index.html"));
                    latestVersion = version;
                } catch (IOException e) {
                    latestVersion="版本获取失败";
                }
                String finalLatestVersion = latestVersion;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        HashMap<String,String> hashMap=new HashMap<>();
                        hashMap.put("{latest}",finalLatestVersion);
                        hashMap.put("{current}",EasyPvp.getInstance().getDescription().getVersion());
                        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_VERSION_NOTIFY();
                        ReplaceUtil.replace(list,hashMap);
                        MessageUtil.sendMessageTo(sender,list);
                    }
                }.runTask(EasyPvp.getInstance());
            }
        }.runTaskAsynchronously(EasyPvp.getInstance());
    }


}
