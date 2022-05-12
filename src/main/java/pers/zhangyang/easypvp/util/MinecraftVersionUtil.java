package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;

public class MinecraftVersionUtil {

    public static int getBigVersion(){
        String[] args= Bukkit.getBukkitVersion().split("\\.");
        int big = Integer.parseInt(args[0]);
        return big;
    }
    public static int getMiddleVersion(){
        String[] args= Bukkit.getBukkitVersion().split("\\.");

        int mid = Integer.parseInt(args[1]);
        return mid;
    }
}
