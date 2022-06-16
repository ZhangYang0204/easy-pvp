package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerDamageEntityInRacing implements Listener {

    @EventHandler
    public void onDa(EntityDamageByEntityEvent event){
        Entity entity=event.getDamager();
        if (!(entity instanceof Player)){return;}
        Player player= (Player) entity;
        Entity tar=event.getEntity();
        if (!(tar instanceof Player)){return;}
        Player target= (Player) tar;
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);
        Gamer tarGa=GamerManager.GAMER_MANAGER.getGamer(target);
        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){
            return;
        }
        Race race=gamer.getPlayingRace();

        if ((race.getStartTimeMillis()+race.getMapMeta().getChooseKitTime()*1000)>System.currentTimeMillis()){
            event.setCancelled(true);
        }

        Party party=gamer.getParty();
        Party tarPart=tarGa.getParty();
        if (party.equals(tarPart)&&race.getMapMeta().isIgnorePartyDamage()){
            event.setCancelled(true);
        }

    }

}
