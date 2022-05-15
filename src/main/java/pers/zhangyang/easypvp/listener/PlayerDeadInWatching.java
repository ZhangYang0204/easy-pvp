package pers.zhangyang.easypvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerDeadInWatching implements Listener {

    @EventHandler
    public void tp(PlayerDeathEvent event){
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(event.getEntity());
        if (!gamer.getStats().equals(GamerStatsEnum.WATCHING)){return;}

        Player p=event.getEntity();
        Location l=p.getLocation();
        p.spigot().respawn();
        p.teleport(l);

    }


}