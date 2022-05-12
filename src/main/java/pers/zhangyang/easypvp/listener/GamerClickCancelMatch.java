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
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.HashMap;
import java.util.List;

public class GamerClickCancelMatch implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof AllMapPage)) {
            return;
        }

        int slot = event.getSlot();
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
            List<String> list = MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING();
            HashMap<String, String> rep = new HashMap<>();
            rep.put("{party}", party.getPartyName());
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(player, list);
            return;
        }


        party.cancelMatch();


        //本人通知
        List<String> list = MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_CANCEL_MATCH();
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{party}", party.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(player, list);

        //其他人通知
        for (Gamer g : party.getMemberList()) {
            if (g.equals(gamer)) {
                continue;
            }

            list = MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_SOMEONE_SUCCESS_CANCEL_MATCH();
            rep = new HashMap<>();
            rep.put("{party}", party.getPartyName());
            rep.put("{member}", player.getName());
            ReplaceUtil.replace(list, rep);
            MessageUtil.sendMessageTo(player, list);
        }
        return;


    }


}