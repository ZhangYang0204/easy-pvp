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

public class PlayerClickRankPage implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
            return;
        }

        int slot=event.getSlot();
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
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);


        Party party= gamer.getParty();


        List<RecordMeta> recordMetaList;
        try {
            RaceService raceService = (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            recordMetaList = raceService.getRecord();
        } catch (SQLException e) {
            e.printStackTrace();
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

        RankPage rankPage=new RankPage(GuiYaml.GUI_MANAGER.getTITLE_RANK_PAGE());
        rankPage.init(0,PageUtil.pageRecordMeta(0,45,recordMetaList));
        rankPage.send(player);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_RANK_PAGE();
        MessageUtil.sendMessageTo(player, list);


    }



}