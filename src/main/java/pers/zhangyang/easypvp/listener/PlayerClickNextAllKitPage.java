package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.*;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerClickNextAllKitPage implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllKitPage)){
            return;
        }

        int slot=event.getSlot();
        if (slot!=53){
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

        int maxPageIndex= PageUtil.computeMaxPageIndex(race.getKitItemMap().keySet().size(),45);
        int currentPageIndex=allPartyPage.getPageIndex();
        if (currentPageIndex>=maxPageIndex){
            List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_NEXT_ALL_KIT_PAGE_BECAUSE_NOT_NEXT();
            MessageUtil.sendMessageTo(player, list);
            return;
        }

        allPartyPage.init(currentPageIndex+1, PageUtil.pageKitMeta(currentPageIndex+1,45,
                new ArrayList<>(race.getKitItemMap().keySet())));
        allPartyPage.send(player);

        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .MESSAGE_YAML_MANAGER.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_NEXT_ALL_KIT_PAGE();
        MessageUtil.sendMessageTo(player, list);
    }
}