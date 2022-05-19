package pers.zhangyang.easypvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.domain.ShopPage;
import pers.zhangyang.easypvp.domain.StarRankPage;
import pers.zhangyang.easypvp.exception.NotEnoughStarException;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PlayerClickBuyGood implements Listener {


    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getHolder() instanceof ShopPage)) {
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


        Player player= (Player) event.getWhoClicked();
        ShopPage shopPage= (ShopPage) inventory.getHolder();
        List<String> cmdMap=shopPage.getCmdMap().get(slot);
        int cost=shopPage.getCostList().get(slot);
        //扣除
        try {
            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.subtractCumulativeStar(player.getUniqueId().toString(),cost);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } catch (NotEnoughStarException e) {
            List<String> no=shopPage.getNotEnughtList().get(slot);
            ReplaceUtil.replace(no, Collections.singletonMap("{player}",player.getName()));
            MessageUtil.sendMessageTo(player,no);
            return;
        }

        try {
            RefreshUtil.refreshRankPage();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }


        ReplaceUtil.replace(cmdMap, Collections.singletonMap("{player}",player.getName()));
        //执行命令
        for (String s:cmdMap){
            if (s.split(":").length<2){continue;}
            String cmd=s.split(":")[1];
            String people=s.split(":")[0];
            if (people.equalsIgnoreCase("op")){
                if (!player.isOp()){
                    player.setOp(true);
                    Bukkit.dispatchCommand(player,cmd);
                    player.setOp(false);
                }else {
                    Bukkit.dispatchCommand(player,cmd);
                }
            }else if (people.equalsIgnoreCase("console")){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),cmd);

            }else if (people.equalsIgnoreCase("player")){
                Bukkit.dispatchCommand(player,cmd);
            }
        }



    }
}
