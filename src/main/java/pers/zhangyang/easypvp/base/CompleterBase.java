package pers.zhangyang.easypvp.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class CompleterBase {
    @Nonnull
    protected List<String> removeStartWith(@Nullable String latest, @Nullable List<String> list){
        if (latest==null||list==null){return  new ArrayList<>();}
        String ll = latest.toLowerCase();
        list.removeIf(k -> !k.toLowerCase().startsWith(ll));
        return list;
    }
    public abstract List<String> complete(CommandSender sender, Command command, String alias, String[] args) ;
}
