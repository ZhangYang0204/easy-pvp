package pers.zhangyang.easypvp.listener;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.RaceManager;

public class PlayerTeleportRaceWorldNotInRace implements Listener {
    @EventHandler
    public void tp(PlayerTeleportEvent event){
        Player player=event.getPlayer();
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        Race race=gamer.getRace();
        if (race!=null){return;}
        
        
            for (Race r: RaceManager.RACE_MANAGER.getPartyGamerMap().values()){
                World world=r.getWorld();
                if (world==null) {continue;}
                if (world.equals(event.getTo().getWorld())){
                    event.setCancelled(true);
                    return;
                }
            }

    }
}
