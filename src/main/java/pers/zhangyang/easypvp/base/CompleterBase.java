package pers.zhangyang.easypvp.base;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class CompleterBase {
    protected boolean forcePlayer;
    protected CommandSender sender;
    protected String[] args;

    public CompleterBase(@Nonnull CommandSender sender, boolean forcePlayer ,@Nonnull String[] args) {
        if (args.length<1){throw new IllegalArgumentException();}
        this.sender=sender;
        this.forcePlayer = forcePlayer;
        this.args=args;
    }
    @Nonnull
    protected List<String> removeStartWith(@Nullable String latest, @Nonnull List<String> list){
        if (latest==null){return  list;}
        String ll = latest.toLowerCase();
        list.removeIf(k -> !k.toLowerCase().startsWith(ll));
        return list;
    }
    @Nonnull
    public List<String> process(){
        if (forcePlayer&&!(sender instanceof Player)){
            return new ArrayList<>();
        }
        if (!sender.hasPermission(args[0])){
            return new ArrayList<>();
        }
        return complete();
    }

    public abstract List<String> complete() ;
}
