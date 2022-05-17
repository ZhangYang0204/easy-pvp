package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllMemberPage;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerClickLeaveParty implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllMemberPage)){
            return;
        }

        int slot=event.getRawSlot();
        if (slot!=51){
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
        Party party=((AllMemberPage)event.getInventory().getHolder()).getParty();



            //检查队伍是不是在匹配
            if (party.getStats().equals(PartyStatsEnum.MATCHING)){
                List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_LEAVE_PARTY_BECAUSE_PARTY_IS_MATCHING();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list,rep);
                MessageUtil.sendMessageTo(player, list);
                return;
            }




            //离开队伍
            gamer.leaveParty();

            RefreshUtil.refreshAllPartyPage();

            //刷新AllMemberPage
            RefreshUtil.refreshAllMemberPage();
        try {
            //刷新地图页面
            RefreshUtil.refreshAllMapPage();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
            //mem打开上一个页面
            String title= GuiYaml.GUI_MANAGER.getTITLE_ALL_PARTY_PAGE();
            AllPartyPage allPartyPage=new AllPartyPage(title);
            allPartyPage.init(PageUtil.pageParty(0,45, PartyManager.PARTY_MANAGER.getPartyList()),0);
            allPartyPage.send(player);




        //通知队员有人离开了
        List<CommandSender> playerList=new ArrayList<>();
        for (Gamer g:party.getMemberList()){
            if (g.equals(gamer)){continue;}
            playerList.add(g.getPlayer());
        }
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SOMEONE_SUCCESS_LEAVE_PARTY();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{player}",player.getName());
        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(playerList, list);


        list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_LEAVE_PARTY();
        rep=new HashMap<>();
        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(player, list);


    }



}