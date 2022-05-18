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
import pers.zhangyang.easypvp.domain.RankPage;
import pers.zhangyang.easypvp.manager.GamerManager;
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

public class PlayerClickPreviousRankPage implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof RankPage)){
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


        List<RecordMeta> recordMetaList;
        try {
            RaceService raceService = (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            recordMetaList = raceService.getRecordMetaList();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        int maxPageIndex= PageUtil.computeMaxPageIndex(recordMetaList.size(),45);
        RankPage rankPage= (RankPage) inventory.getHolder();


        int currentPageIndex=rankPage.getPageIndex();
        if (currentPageIndex<=0){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_PREVIOUS_RANK_PAGE_BECAUSE_NOT_NEXT();
            MessageUtil.sendMessageTo(player, list);
            return;
        }

        recordMetaList.sort(new Comparator<RecordMeta>() {
            @Override
            public int compare(RecordMeta o1, RecordMeta o2) {
                int cha2=o2.getWin()-o2.getLose();
                int cha1=o1.getWin()-o1.getLose();
                int all1=o1.getAll();
                int all2=o2.getAll();
                int draw1=o1.getDraw();
                int draw2=o2.getDraw();
                if (cha2!=cha1){
                    return cha2-cha1;
                }else if (draw1!=draw2){
                    return draw2-draw1;
                }else {
                    return all2-all1;
                }
            }
        });

        rankPage.init(currentPageIndex-1, PageUtil.pageRecordMeta(currentPageIndex-1,45,recordMetaList));
        rankPage.send(player);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_PREVIOUS_RANK_PAGE();
        MessageUtil.sendMessageTo(player, list);


    }



}