package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllRacePage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.List;

public class PlayerClickUnwatchRace  implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof AllRacePage)) {
            return;
        }

        int slot = event.getRawSlot();
        if (slot !=50) {
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


        Player player=(Player) event.getWhoClicked();
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);

        if (!gamer.getStats().equals(GamerStatsEnum.WATCHING)){
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING();
            MessageUtil.sendMessageTo(player, list);
            return;
        }
        Race race=gamer.getPlayingRace();
        gamer.unwatchRace();
        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_UNWATCH_RACE();
        MessageUtil.sendMessageTo(player, list);
        return;
    }
}
