package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.RankPage;

public class PlayerClickRecord  implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof RankPage)) {
            return;
        }

        int slot = event.getSlot();
        if (slot <0||slot>44) {
            return;
        }
        ItemStack itemStack = event.getCurrentItem();
        if (itemStack == null || itemStack.getType().equals(Material.AIR)) {
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        event.setCancelled(true);
    }
}
