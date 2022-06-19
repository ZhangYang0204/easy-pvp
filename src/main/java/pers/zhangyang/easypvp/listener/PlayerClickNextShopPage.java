package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.ShopPage;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.yaml.ShopYaml;

import java.util.List;

public class PlayerClickNextShopPage  implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof ShopPage)){
            return;
        }

        int slot=event.getRawSlot();
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


        int maxPageIndex= PageUtil.computeMaxPageIndex(ShopYaml.INSTANCE.getCONTENT_$_MATERIAL().size(),45);
        ShopPage starRankPage = (ShopPage) inventory.getHolder();
        int currentPageIndex= starRankPage.getPageIndex();
        if (currentPageIndex>=maxPageIndex){
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_NEXT_SHOP_PAGE_BECAUSE_NOT_NEXT();
            MessageUtil.sendMessageTo(player, list);
            return;
        }


        String title= GuiYaml.getINSTANCE().getTITLE_SHOP_PAGE();
        starRankPage =new ShopPage(title);

        starRankPage.init(currentPageIndex+1,PageUtil.pageString(currentPageIndex+1,45, ShopYaml.INSTANCE.getCONTENT_$_MATERIAL()),
                PageUtil.pageString(currentPageIndex+1,45, ShopYaml.INSTANCE.getCONTENT_$_DISPLAY_NAME()),
                PageUtil.pageListSTring(currentPageIndex+1,45, ShopYaml.INSTANCE.getCONTENT_$_LORE()),
                PageUtil.pageListSTring(currentPageIndex+1,45, ShopYaml.INSTANCE.getCONTENT_$_COMMAND()),
                PageUtil.pageInteger(currentPageIndex+1,45, ShopYaml.INSTANCE.getCONTENT_$_COST()),
                PageUtil.pageListSTring(currentPageIndex+1,45, ShopYaml.INSTANCE.getCONTENT_$_NOT_ENOUGH()));
        starRankPage.send(player);
        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_NEXT_SHOP_PAGE();
        MessageUtil.sendMessageTo(player, list);


    }



}