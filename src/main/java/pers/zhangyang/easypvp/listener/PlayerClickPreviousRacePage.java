package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.AllRacePage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.List;

public class PlayerClickPreviousRacePage implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllRacePage)){
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
        AllRacePage allPartyPage= (AllRacePage) inventory.getHolder();


        int currentPageIndex=allPartyPage.getPageIndex();
        if (currentPageIndex<=0){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_PREVIOUS_ALL_RACE_PAGE_BECAUSE_NOT_NEXT();
            MessageUtil.sendMessageTo(player, list);
            return;
        }
        allPartyPage.init(PageUtil.pageRace(currentPageIndex-1,45, RaceManager.RACE_MANAGER.getRaceList()),
                currentPageIndex-1);
        allPartyPage.send(player);

        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_PREVIOUS_ALL_RACE_PAGE();
        MessageUtil.sendMessageTo(player, list);
    }
}