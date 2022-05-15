package pers.zhangyang.easypvp.listener;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.RaceManager;

public class PlayerForceTeleportRaceWorldNotInRacingAntNotInWatching implements Listener {
    @EventHandler
    public void tp(PlayerTeleportEvent event){
        Player player=event.getPlayer();
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);

        if (gamer.getStats().equals(GamerStatsEnum.RACING)||gamer.getStats().equals(GamerStatsEnum.WATCHING)){return;}

            for (Race r: RaceManager.RACE_MANAGER.getRaceList()){
                World world=r.getWorld();
                if (world==null) {continue;}
                if (world.equals(event.getTo().getWorld())){
                    event.setCancelled(true);
                    return;
                }
            }

    }
}
