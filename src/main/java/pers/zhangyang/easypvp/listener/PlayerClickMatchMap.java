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
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.HashMap;
import java.util.List;

public class PlayerClickMatchMap implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllMapPage)){
            return;
        }

        int slot=event.getRawSlot();
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
        Party party=((AllMapPage)event.getInventory().getHolder()).getParty();
        MapMeta mapMeta=((AllMapPage)event.getInventory().getHolder()).getMapMetaList().get(slot);


            if (!party.getCaptain().equals(gamer)) {
                List<String> list= MessageYaml.INSTANCE
                        .getCHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_NOT_CAPTAIN();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{map}",mapMeta.getName());
                rep.put("{party}",party.getPartyName());
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
                MessageUtil.sendMessageTo(player, list);return;
            }
            if (party.getStats().equals(PartyStatsEnum.MATCHING)) {
                List<String> list= MessageYaml.INSTANCE
                        .getCHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_PARTY_IS_MATCHING();
                HashMap<String,String> rep=new HashMap<>();
                rep.put("{map}",mapMeta.getName());

                rep.put("{party}",party.getPartyName());
                rep.put("{captain}",party.getCaptain().getPlayer().getName());
                if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
                MessageUtil.sendMessageTo(player, list);return;
            }

            party.startMatch(mapMeta);

        //????????????
        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_START_SPECIFIC_MATCH();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{captain}",party.getCaptain().getPlayer().getName());

        rep.put("{party}",party.getPartyName());
        rep.put("{map}",mapMeta.getName());
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        MessageUtil.sendMessageTo(player, list);

        //???????????????
        for (Gamer g:party.getMemberList()) {
            if (g.equals(gamer)){continue;}
            Player p=g.getPlayer();
            list= MessageYaml.INSTANCE
                    .getCHAT_SOMEONE_SUCCESS_START_SPECIFIC_MATCH();
            rep=new HashMap<>();
            rep.put("{captain}",party.getCaptain().getPlayer().getName());

            rep.put("{party}",party.getPartyName());
            rep.put("{map}",mapMeta.getName());
            if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
            MessageUtil.sendMessageTo(p, list);
        }



    }
}

