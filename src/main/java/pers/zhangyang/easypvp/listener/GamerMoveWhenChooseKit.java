package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.GamerManager;

public class GamerMoveWhenChooseKit implements Listener {
    @EventHandler
    public void onM(PlayerMoveEvent event){

        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        Race race=gamer.getRace();
        if (race==null){
            return;
        }

        if (event.getTo().getX()==event.getFrom().getX()&&event.getTo().getY()==event.getFrom().getY()
            &&event.getTo().getZ()==event.getFrom().getZ()){
            return;
        }

        if ((race.getStartTime()+race.getChooseTick()*20)>System.currentTimeMillis()){
            event.setCancelled(true);
        }

    }
}
