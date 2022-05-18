package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerMoveWhenChooseKit implements Listener {
    @EventHandler
    public void onM(PlayerMoveEvent event){

        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){
            return;
        }

        Race race=gamer.getRacingRace();
        if (event.getTo().getX()==event.getFrom().getX()&&event.getTo().getY()==event.getFrom().getY()
            &&event.getTo().getZ()==event.getFrom().getZ()){
            return;
        }

        if ((race.getStartTimeMillis()+race.getChooseTime()*1000)>System.currentTimeMillis()){
            event.setCancelled(true);
        }

    }
}
