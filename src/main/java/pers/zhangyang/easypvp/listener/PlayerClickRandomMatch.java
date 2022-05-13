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
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class PlayerClickRandomMatch implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllMapPage)){
            return;
        }

        int slot=event.getSlot();
        if (slot!=47){
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
        AllMapPage allMapPage= (AllMapPage) event.getInventory().getHolder();
        Party party=allMapPage.getParty();
        try {
            if (!party.getCaptain().equals(gamer)){
                List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_CAPTAIN();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(player, list);return;
            }
            if (party.getStats().equals(PartyStatsEnum.MATCHING)){
                List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_PARTY_IS_MATCHING();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(player, list);return;
            }
            List<MapMeta> mapMetaList;
            CommandService commandService = (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            mapMetaList = commandService.getMapByScale(party.getMemberList().size());
            if (mapMetaList.isEmpty()){
                List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_AVAILABLE_MAP();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                rep.put("{party}",party.getPartyName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(player, list);return;
            }



            party.startMatch();


        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        //本人通知
        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_START_RANDOM_MATCH();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{captain}",party.getCaptain().getPlayer().getName());
        rep.put("{party}",party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(player, list);

        //其他人通知
        for (Gamer g:party.getMemberList()) {
            if (g.equals(gamer)){continue;}

            list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_SOMEONE_SUCCESS_START_RANDOM_MATCH();
            rep=new HashMap<>();
            rep.put("{captain}",party.getCaptain().getPlayer().getName());
            rep.put("{party}",party.getPartyName());
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(player, list);
        }



    }



}