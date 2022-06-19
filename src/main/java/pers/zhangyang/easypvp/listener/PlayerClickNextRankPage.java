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
import pers.zhangyang.easypvp.domain.StarRankPage;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class PlayerClickNextRankPage implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof StarRankPage)){
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


        List<RecordMeta> recordMetaList;
        try {
            RaceService raceService = (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            recordMetaList = raceService.getRecordMetaList();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        int maxPageIndex= PageUtil.computeMaxPageIndex(recordMetaList.size(),45);
        StarRankPage starRankPage = (StarRankPage) inventory.getHolder();


        int currentPageIndex= starRankPage.getPageIndex();
        if (currentPageIndex>=maxPageIndex){
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_NEXT_RANK_PAGE_BECAUSE_NOT_NEXT();
            MessageUtil.sendMessageTo(player, list);
            return;
        }

        recordMetaList.sort(new Comparator<RecordMeta>() {
            @Override
            public int compare(RecordMeta o1, RecordMeta o2) {
                int star2=o2.getSeasonStar();
                int star1=o1.getSeasonStar();

                    return star2-star1;



            }
        });
        starRankPage =new StarRankPage(GuiYaml.INSTANCE.getTITLE_STAR_RANK_PAGE());
        starRankPage.init(currentPageIndex+1, PageUtil.pageRecordMeta(currentPageIndex+1,45,recordMetaList));
        starRankPage.send(player);
        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_NEXT_RANK_PAGE();
        MessageUtil.sendMessageTo(player, list);


    }



}