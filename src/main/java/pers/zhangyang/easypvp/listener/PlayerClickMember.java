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
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerClickMember implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllMemberPage)){
            return;
        }

        int slot=event.getSlot();
        if (slot<0||slot>44){
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
        Gamer clicker= GamerManager.GAMER_MANAGER.getGamer(player);
        Party party=((AllMemberPage)event.getInventory().getHolder()).getParty();
        Gamer member=party.getMemberList().get(slot);
        Player m=member.getPlayer();
       

            //判断踢人的人是不是队长
            if (!party.getCaptain().equals(clicker)){
                List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{member}",m.getName());
                rep.put("{party}",party.getPartyName());
                rep.put("{captain}",player.getName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(player, list);
                return;
            }

            if (party.getStats().equals(PartyStatsEnum.MATCHING)){
                List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_KICK_MEMBER_BECAUSE_PARTY_IS_MATCHING();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{member}",m.getName());
                rep.put("{party}",party.getPartyName());
                rep.put("{captain}",player.getName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(m, list);
                return;
            }
            

            //踢出目标玩家
            party.kickGamer(member);

            //刷新
            RefreshUtil.refreshAllMemberPage();

            RefreshUtil.refreshAllPartyPage();

        try {
            //刷新地图页面
            RefreshUtil.refreshAllMapPage();
        }  catch (SQLException e) {
            e.printStackTrace();
            return;
        }

            //mem打开上一个页面
            Player memPlayer=member.getPlayer();
            String title= GuiYamlManager.GUI_MANAGER.getTITLE_ALL_PARTY_PAGE();
            AllPartyPage allPartyPage=new AllPartyPage(title);
            allPartyPage.init(PageUtil.pageParty(0,45, PartyManager.PARTY_MANAGER.getPartyList()),0);
            allPartyPage.send(memPlayer);





     

        //通知被t者
        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_WAS_KICKED_PARTY();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{kicker}",player.getName());

        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(m, list);

        //通知队员有人被t了
        List<CommandSender> playerList=new ArrayList<>();
        for (Gamer g:party.getMemberList()){
            if (g.equals(clicker)){continue;}
            playerList.add(g.getPlayer());
        }
        list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY();
        rep=new HashMap<>();
        rep.put("{kicker}",player.getName());
        rep.put("{member}",m.getName());
        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(playerList, list);

        //通知踢人者
        list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_KICK_MEMBER();
        rep=new HashMap<>();
        rep.put("{member}",m.getName());
        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(player, list);

    }
}
