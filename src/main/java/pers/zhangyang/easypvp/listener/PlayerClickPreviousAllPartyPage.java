package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.util.List;

public class PlayerClickPreviousAllPartyPage implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
            return;
        }

        int slot=event.getSlot();
        if (slot!=45){
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


        Party party= gamer.getParty();
        AllPartyPage allPartyPage= (AllPartyPage) inventory.getHolder();


        int currentPageIndex=allPartyPage.getPageIndex();
        if (currentPageIndex<=0){
            List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_PREVIOUS_ALL_PARTY_PAGE_BECAUSE_NOT_PREVIOUS();
            MessageUtil.sendMessageTo(player, list);
            return;
        }
        allPartyPage.init(PageUtil.pageParty(currentPageIndex-1,45,PartyManager.PARTY_MANAGER.getPartyList()),
                currentPageIndex-1);
        allPartyPage.send(player);

        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_PREVIOUS_ALL_PARTY_PAGE();
        MessageUtil.sendMessageTo(player, list);
    }
}