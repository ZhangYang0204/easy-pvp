package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllKitPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.HashMap;
import java.util.List;

public class PlayerClickChooseKit implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof AllKitPage)) {
            return;
        }

        int slot = event.getRawSlot();
        if (slot < 0 || slot > 44) {
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
        Player player = (Player) event.getWhoClicked();
        Gamer gamer = GamerManager.GAMER_MANAGER.getGamer(player);
        AllKitPage allKitPage = (AllKitPage) event.getInventory().getHolder();
        KitMeta kitMeta = allKitPage.getKitMetaList().get(slot);

        Race race = gamer.getPlayingRace();
        race.sendKit(kitMeta, gamer);
        gamer.getPlayer().closeInventory();

        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_CHOOSE_KIT();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{kit}",kitMeta.getName());
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(player, list);
    }


}