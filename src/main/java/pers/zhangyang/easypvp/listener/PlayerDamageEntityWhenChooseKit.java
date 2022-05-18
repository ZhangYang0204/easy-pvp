package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerDamageEntityWhenChooseKit implements Listener {

    @EventHandler
    public void onDa(EntityDamageEvent event){
        Entity entity=event.getEntity();
        if (!(entity instanceof Player)){return;}
        Player player= (Player) entity;


        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);
        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){
            return;
        }
        Race race=gamer.getRacingRace();

        if ((race.getStartTimeMillis()+race.getChooseTime()*1000)>System.currentTimeMillis()){
            event.setCancelled(true);
        }



    }

}
