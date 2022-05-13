package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerDestroyBlockInRace implements Listener {
    @EventHandler
    public  void onPlayerDestroy(BlockBreakEvent event){
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        Race race=gamer.getRace();
        if (race==null){
            return;
        }

        if (!race.isBuild()){
            event.setCancelled(true);
        }
    }
}
