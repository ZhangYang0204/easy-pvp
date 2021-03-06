package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllMemberPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.util.List;

public class PlayerClickNextAllMemberPage implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllMemberPage)){
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
        AllMemberPage allPartyPage= (AllMemberPage) inventory.getHolder();


        int maxPageIndex=PageUtil.computeMaxPageIndex(party.getMemberList().size(),45);
        int currentPageIndex=allPartyPage.getPageIndex();
        if (currentPageIndex>=maxPageIndex){
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_NEXT_ALL_MEMBER_PAGE_BECAUSE_NOT_NEXT();
            MessageUtil.sendMessageTo(player, list);
            return;
        }

        allPartyPage=new AllMemberPage(GuiYaml.getINSTANCE().getTITLE_ALL_MEMBER_PAGE());
        allPartyPage.init(party,currentPageIndex+1, PageUtil.pageGamer(currentPageIndex+1,45,
                party.getMemberList()));
        allPartyPage.send(player);

        List<String> list= MessageYaml.INSTANCE
                .INSTANCE.INSTANCE.getCHAT_SUCCESS_NEXT_ALL_MEMBER_PAGE();
        MessageUtil.sendMessageTo(player, list);
    }
}