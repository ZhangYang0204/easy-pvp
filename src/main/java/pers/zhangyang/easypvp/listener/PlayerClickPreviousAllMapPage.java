package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllMapPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.sql.SQLException;
import java.util.List;

public class PlayerClickPreviousAllMapPage implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllMapPage)){
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
        AllMapPage allPartyPage= (AllMapPage) inventory.getHolder();

        List<MapMeta> mapMetaList;
        try {
            RaceService commandService = (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            mapMetaList = commandService.getMapMeta(party.getMemberList().size());
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        int currentPageIndex=allPartyPage.getPageIndex();
        if (currentPageIndex<=0){
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_PREVIOUS_ALL_MAP_PAGE_BECAUSE_NOT_PREVIOUS();
            MessageUtil.sendMessageTo(player, list);
            return;
        }
        String title = GuiYaml.INSTANCE.getTITLE_ALL_MAP_PAGE();
        allPartyPage = new AllMapPage(title);
        allPartyPage.init(party,currentPageIndex-1, PageUtil.pageMapMeta(currentPageIndex-1,45,
                mapMetaList));
        allPartyPage.send(player);

        List<String> list= MessageYaml.INSTANCE
                .INSTANCE.INSTANCE.getCHAT_SUCCESS_PREVIOUS_ALL_MAP_PAGE();
        MessageUtil.sendMessageTo(player, list);
    }
}