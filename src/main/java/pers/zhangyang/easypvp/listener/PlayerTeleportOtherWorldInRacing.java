package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerTeleportOtherWorldInRacing implements Listener {

    @EventHandler
    public void tp(PlayerTeleportEvent event){
        Player player=event.getPlayer();
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        Race race=gamer.getRacingRace();

        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){return;}



        if (!event.getTo().getWorld().equals(race.getWorld())){
            event.setCancelled(true);
        }




    }


}
