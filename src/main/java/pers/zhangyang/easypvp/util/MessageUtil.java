package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MessageUtil {

    public static void sendTitleTo(@NotNull Player player, @Nullable String title,@Nullable String subtitle){
        if (player==null){
            throw new NullPointerException();
        }
        player.sendTitle(ChatColor.translateAlternateColorCodes('&',title),ChatColor.translateAlternateColorCodes('&',subtitle),10,10,20);
    }

    public static void sendMessageTo(CommandSender sender,@Nullable List<String> strings) {
        if (sender==null){throw new NullPointerException();}
        if (strings==null){return;}


        for (String s : strings) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',s));
        }
    }
    public static void sendMessageTo(Collection<? extends CommandSender> senderList, @Nullable List<String> strings) {
        if (senderList==null){throw new NullPointerException();}
        if (strings==null){return;}


        for (CommandSender sender:senderList) {
            for (String s : strings) {sender.sendMessage(ChatColor.translateAlternateColorCodes('&',s));
            }
        }
    }
    public static void sendMessageTo(Collection<? extends CommandSender> senderList,@Nullable String s) {
        if (senderList==null){throw new NullPointerException();}
        if (s==null){return;}
        for (CommandSender sender:senderList) {sender.sendMessage(ChatColor.translateAlternateColorCodes('&',s));
        }
    }
    public static void sendMessageTo(CommandSender sender,@Nullable String s) {
        if (sender==null){throw new NullPointerException();}
        if (s==null){return;}
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',s));
    }
}
