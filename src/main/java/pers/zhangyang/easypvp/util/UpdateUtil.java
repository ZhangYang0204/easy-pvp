package pers.zhangyang.easypvp.util;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.runnable.NotifyVersionRunnable;

import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.net.URL;

public class UpdateUtil {
    public static void notifyVersion(@NotNull CommandSender sender){
        if (sender==null){throw new NullPointerException();}

        new BukkitRunnable() {
            @Override
            public void run() {
                String latestVersion;
                try {
                    String version = ResourceUtil.getFirstLine(new URL("https://zhangyang0204.github.io/easy-pvp/index.html"));
                    latestVersion = version;
                } catch (Throwable e) {
                    latestVersion=null;
                }
                new NotifyVersionRunnable(latestVersion,sender).runTask(EasyPvp.getInstance());
            }
        }.runTaskAsynchronously(EasyPvp.getInstance());
    }


}
