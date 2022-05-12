package pers.zhangyang.easypvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.util.MessageUtil;

public class GamerClickCreateParty implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
            return;
        }

        int slot=event.getSlot();
        if (slot!=48){
            return;
        }
        ItemStack itemStack=event.getCurrentItem();
        if (itemStack==null||itemStack.getType().equals(Material.AIR)){
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)){
            return;
        }
        event.setCancelled(true);
        Player player= (Player) event.getWhoClicked();

        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);




            //创建队伍并注册
        Bukkit.getPluginManager().registerEvents(new GamerTryCreateParty(gamer), EasyPvp.getInstance());
        MessageUtil.sendMessageTo(player,MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_HOW_TO_CREATE_PARTY());
        player.closeInventory();


    }



}
