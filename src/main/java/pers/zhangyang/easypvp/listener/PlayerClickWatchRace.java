package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.AllRacePage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.domain.RankPage;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.HashMap;
import java.util.List;

public class PlayerClickWatchRace  implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof AllRacePage)) {
            return;
        }

        int slot = event.getRawSlot();
        if (slot <0||slot>44) {
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


        Player player=(Player) event.getWhoClicked();
        AllRacePage allRacePage= (AllRacePage) inventory.getHolder();
        Race race=allRacePage.getRaceList().get(slot);
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(player);

        if (gamer.getStats().equals(GamerStatsEnum.READING)){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_WATCH_RACE_BECAUSE_IN_PARTY();
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{red}",race.getRedParty().getPartyName());
            rep.put("{blue}",race.getBlueParty().getPartyName());
            rep.put("{map}",race.getMapMeta().getName());
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(player, list);
            return;
        }
        if (gamer.getStats().equals(GamerStatsEnum.WATCHING)){
            List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING();
            HashMap<String,String> rep=new HashMap<>();
            rep.put("{red}",race.getRedParty().getPartyName());
            rep.put("{blue}",race.getBlueParty().getPartyName());
            rep.put("{map}",race.getMapMeta().getName());
            ReplaceUtil.replace(list,rep);
            MessageUtil.sendMessageTo(player, list);
            return;
        }

        gamer.watchRace(race);

        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_WATCH_RACE();
        HashMap<String,String> rep=new HashMap<>();
        rep.put("{red}",race.getRedParty().getPartyName());
        rep.put("{blue}",race.getBlueParty().getPartyName());
        rep.put("{map}",race.getMapMeta().getName());
        ReplaceUtil.replace(list,rep);
        MessageUtil.sendMessageTo(player, list);
        return;


    }
}
