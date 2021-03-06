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
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.HashMap;
import java.util.List;

public class PlayerClickCancelMatch implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof AllMapPage)) {
            return;
        }

        int slot = event.getRawSlot();
        if (slot != 51) {
            return;
        }
        ItemStack itemStack = event.getCurrentItem();
        if (itemStack == null || itemStack.getType().equals(Material.AIR)) {
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        Gamer gamer = GamerManager.GAMER_MANAGER.getGamer(player);
        AllMapPage allMapPage = (AllMapPage) event.getInventory().getHolder();

        Party party = allMapPage.getParty();


        if (!party.getStats().equals(PartyStatsEnum.MATCHING)) {
            List<String> list = MessageYaml.INSTANCE
                    .getCHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING();
            HashMap<String, String> rep = new HashMap<>();
            rep.put("{party}", party.getPartyName());
            if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
            MessageUtil.sendMessageTo(player, list);
            return;
        }


        party.cancelMatch();


        //????????????
        List<String> list = MessageYaml.INSTANCE
                .getCHAT_SUCCESS_CANCEL_MATCH();
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{party}", party.getPartyName());
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        MessageUtil.sendMessageTo(player, list);

        //???????????????
        for (Gamer g : party.getMemberList()) {
            if (g.equals(gamer)) {
                continue;
            }
            Player p=g.getPlayer();

            list = MessageYaml.INSTANCE
                    .getCHAT_SOMEONE_SUCCESS_CANCEL_MATCH();
            rep = new HashMap<>();
            rep.put("{party}", party.getPartyName());
            rep.put("{member}", player.getName());
            if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
            MessageUtil.sendMessageTo(p, list);
        }
        return;


    }


}