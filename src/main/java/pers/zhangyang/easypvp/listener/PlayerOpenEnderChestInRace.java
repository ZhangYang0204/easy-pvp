package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.GamerManager;

public class PlayerOpenEnderChestInRace implements Listener {
    @EventHandler
    public void onPlayerOpenEnderChest(InventoryOpenEvent event){

        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer((Player) event.getPlayer());
        Race race=gamer.getRace();
        if (race==null){
            return;
        }
        if (!race.isFair()){
            return;
        }

        if (event.getPlayer().getEnderChest().equals(event.getInventory())){
            event.setCancelled(true);
        }
    }
}
