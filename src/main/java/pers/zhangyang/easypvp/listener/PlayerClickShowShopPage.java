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
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.yaml.ShopYaml;

import java.util.List;

public class PlayerClickShowShopPage  implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
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
        ShopPage shopPage=new ShopPage(title);
        shopPage.init(0,PageUtil.pageString(0,45, ShopYaml.INSTANCE.getCONTENT_$_MATERIAL()),
                PageUtil.pageString(0,45, ShopYaml.INSTANCE.getCONTENT_$_DISPLAY_NAME()),
                PageUtil.pageListSTring(0,45, ShopYaml.INSTANCE.getCONTENT_$_LORE()),
                PageUtil.pageListSTring(0,45, ShopYaml.INSTANCE.getCONTENT_$_COMMAND()),
                PageUtil.pageInteger(0,45, ShopYaml.INSTANCE.getCONTENT_$_COST()),
                PageUtil.pageListSTring(0,45, ShopYaml.INSTANCE.getCONTENT_$_NOT_ENOUGH()));
        shopPage.send(player);
        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_SHOW_SHOP_PAGE();
        MessageUtil.sendMessageTo(player, list);


    }



}