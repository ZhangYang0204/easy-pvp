package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pers.zhangyang.easypvp.util.UpdateUtil;

public class PlayerJoinGame implements Listener {
    @EventHandler
    public void onJo(PlayerJoinEvent event){
        Player player=event.getPlayer();
        if (player.hasPermission("EasyPvp.updateNotify")){
            UpdateUtil.updateNotify(player);
        }

    }
}
