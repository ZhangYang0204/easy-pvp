package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerDestroyBlockInRacing implements Listener {
    @EventHandler
    public  void onPlayerDestroy(BlockBreakEvent event){
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        Race race=gamer.getRace();

        if (gamer.getStats().equals(GamerStatsEnum.WATCHING)){return;}
        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){
            return;
        }

        if (!race.isBuild()){
            event.setCancelled(true);
        }
    }
}
