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
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayerClickPreviousAllKitPage implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllKitPage)){
            return;
        }

        int slot=event.getRawSlot();
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
        AllKitPage allPartyPage= (AllKitPage) inventory.getHolder();

        Race race=party.getRace();

        int currentPageIndex=allPartyPage.getPageIndex();
        if (currentPageIndex<=0){
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_PREVIOUS_ALL_KIT_PAGE_BECAUSE_NOT_PREVIOUS();
            MessageUtil.sendMessageTo(player, list);
            return;
        }
        allPartyPage = new AllKitPage(GuiYaml.getINSTANCE().getTITLE_ALL_KIT_PAGE());
        allPartyPage.init(currentPageIndex-1, PageUtil.pageKitMeta(currentPageIndex-1,45,
                new ArrayList<>(race.getKitItemMap().keySet())));
        allPartyPage.send(player);

        List<String> list= MessageYaml.INSTANCE
                .INSTANCE.INSTANCE.INSTANCE.getCHAT_SUCCESS_PREVIOUS_ALL_KIT_PAGE();
        MessageUtil.sendMessageTo(player, list);
    }
}