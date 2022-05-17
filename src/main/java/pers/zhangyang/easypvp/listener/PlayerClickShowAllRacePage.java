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
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class PlayerClickShowAllRacePage implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
            return;
        }

        int slot=event.getRawSlot();
        if (slot!=48){
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


        List<Race> raceList= RaceManager.RACE_MANAGER.getRaceList();

        AllRacePage allRacePage=new AllRacePage(GuiYaml.GUI_MANAGER.getTITLE_ALL_RACE_PAGE());
        allRacePage.init(PageUtil.pageRace(0,45,raceList),0 );
        allRacePage.send(player);
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_SHOW_ALL_RACE_PAGE();
        MessageUtil.sendMessageTo(player, list);


    }



}