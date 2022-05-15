package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.*;

public class PlayerClickParty implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
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
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);
        Party party=((AllPartyPage)event.getInventory().getHolder()).getPartyList().get(slot);

        try {
            if (gamer.hasParty()){
                List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{target_party}",party.getPartyName());
                rep.put("{self_party}",gamer.getParty().getPartyName());
                ReplaceUtil.replace(list,rep);
                MessageUtil.sendMessageTo(player, list);
                return;
            }
            if (party.getStats().equals(PartyStatsEnum.MATCHING)){
                List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_MATCHING();

                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list,rep);
                MessageUtil.sendMessageTo(player, list);
                return;
            }
            if (party.getStats().equals(PartyStatsEnum.GAMING)){
                List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING();

                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list,rep);
                MessageUtil.sendMessageTo(player, list);
                return;
            }
            if (gamer.getStats().equals(GamerStatsEnum.WATCHING)){
                List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                        .MESSAGE_YAML_MANAGER.getCHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING();

                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list,rep);
                MessageUtil.sendMessageTo(player, list);
                return;
            }


            gamer.joinParty(party);
            //刷新页面
            RefreshUtil.refreshAllMemberPage();

            RefreshUtil.refreshAllMapPage();

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        //通知加入者本人
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_JOIN_PARTY();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{captain}",party.getCaptain().getPlayer().getName());
        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(player, list);
        //通知队伍其他人
        List<CommandSender> playerList=new ArrayList<>();
        for (Gamer g:party.getMemberList()){
            if (g.equals(gamer)){continue;}
            playerList.add(g.getPlayer());
        }
        list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SOMEONE_SUCCESS_JOIN_PARTY();
        rep=new HashMap<>();
        rep.put("{captain}",party.getCaptain().getPlayer().getName());
        rep.put("{player}",player.getName());

        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(playerList, list);



    }
}
