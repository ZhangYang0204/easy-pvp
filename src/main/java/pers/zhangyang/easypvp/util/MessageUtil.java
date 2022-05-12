package pers.zhangyang.easypvp.util;

import org.bukkit.command.CommandSender;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MessageUtil {

    public static void sendMessageTo(CommandSender sender,@Nullable List<String> strings) {
        if (strings==null){return;}


        ReplaceUtil.replace(strings, Collections.singletonMap("&","§"));
        for (String s : strings) {
            sender.sendMessage(s);
        }
    }
    public static void sendMessageTo(List<CommandSender> senderList,@Nullable List<String> strings) {
        if (strings==null){return;}


        for (CommandSender sender:senderList) {
            ReplaceUtil.replace(strings, Collections.singletonMap("&", "§"));
            for (String s : strings) {
                sender.sendMessage(s);
            }
        }
    }
    public static void sendMessageTo(List<CommandSender> senderList,@Nullable String s) {
        if (s==null){return;}
        for (CommandSender sender:senderList) {
            s = ReplaceUtil.replace(s, Collections.singletonMap("&", "§"));
            sender.sendMessage(s);
        }
    }
    public static void sendMessageTo(CommandSender sender,@Nullable String s) {
        if (s==null){return;}

        s=ReplaceUtil.replace(s, Collections.singletonMap("&","§"));
        sender.sendMessage(s);
    }
}
