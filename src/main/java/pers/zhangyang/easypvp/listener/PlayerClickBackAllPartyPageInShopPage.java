package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.ShopPage;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.List;

public class PlayerClickBackAllPartyPageInShopPage implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof ShopPage)){
            return;
        }

        int slot=event.getRawSlot();
        if (slot!=49){
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


        String title= GuiYaml.getINSTANCE().getTITLE_SHOP_PAGE();
        AllPartyPage allPartyPage=new AllPartyPage(title);
        allPartyPage.init(PageUtil.pageParty(0,45,
                PartyManager.PARTY_MANAGER.getPartyList()),0);
        allPartyPage.send(player);
        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_SHOP_PAGE();
        MessageUtil.sendMessageTo(player, list);

    }



}