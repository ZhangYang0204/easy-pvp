package pers.zhangyang.easypvp.listener;

import org.bukkit.Material;
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
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

import java.util.List;

public class PlayerClickMyParty implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        Inventory inventory=event.getInventory();
        if (!(inventory.getHolder() instanceof AllPartyPage)){
            return;
        }

        int slot=event.getSlot();
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


            Party party= gamer.getParty();
            if (party==null){
                List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_FAILURE_SHOW_ALL_MEMBER_PAGE_BECAUSE_NOT_JOIN_PARTY();
                MessageUtil.sendMessageTo(player, list);
                return;
            }
            AllMemberPage allMemberPage=new AllMemberPage(GuiYaml.getGuiManager().getTITLE_ALL_MEMBER_PAGE());
        allMemberPage.init(party,0, PageUtil.pageGamer(0,45,party.getMemberList()));
            allMemberPage.send(player);

        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE();
        MessageUtil.sendMessageTo(player, list);



    }



}