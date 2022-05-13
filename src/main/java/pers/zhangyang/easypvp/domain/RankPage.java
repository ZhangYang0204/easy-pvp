package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.*;

public class RankPage  implements InventoryHolder {
    private final Inventory inventory;
    private final List<RecordMeta> recordMetaList;
    private int pageIndex;
    public RankPage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54, ReplaceUtil.replace(title, Collections.singletonMap("&","§")));
        }
        this.recordMetaList=new ArrayList<>();
    }


    public void init( int pageIndex, List<RecordMeta> recordMetaList){
        this.pageIndex=pageIndex;
        for (RecordMeta m:recordMetaList){this.recordMetaList.add(m.clone());}

        GuiYamlManager guiYamlManager=GuiYamlManager.getGuiManager();
        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=recordMetaList.size()){break;}

            String displayName=guiYamlManager.getBUTTON_RANK_PAGE_RECORD_DISPLAY_NAME();
            List<String> lore=guiYamlManager.getBUTTON_RANK_PAGE_RECORD_LORE();

            HashMap<String,String> rep=new HashMap<>();
            rep.put("{player}",Bukkit.getOfflinePlayer(UUID.fromString(recordMetaList.get(i).getPlayerUuid())).getName());
            rep.put("{all}", String.valueOf(recordMetaList.get(i).getAll()));
            rep.put("{win}", String.valueOf(recordMetaList.get(i).getWin()));
            rep.put("{lose}", String.valueOf(recordMetaList.get(i).getLose()));
            rep.put("{draw}", String.valueOf(recordMetaList.get(i).getDraw()));

            displayName=ReplaceUtil.replace(displayName,rep);
            ReplaceUtil.replace(lore,rep);

            ItemStack itemStack= ItemStackUtil.getItemStack(guiYamlManager.GUI_MANAGER.getBUTTON_RANK_PAGE_RECORD_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL(),
                guiYamlManager.getBUTTON_RANK_PAGE_PREVIOUS_PAGE_DISPLAY_NAME(),guiYamlManager.GUI_MANAGER.getBUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL(),
                guiYamlManager.getBUTTON_RANK_PAGE_NEXT_PAGE_DISPLAY_NAME(),guiYamlManager.getBUTTON_RANK_PAGE_NEXT_PAGE_LORE());
        inventory.setItem(53,nextPage);


        ItemStack back=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYamlManager.getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(),guiYamlManager.getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE());
        inventory.setItem(49,back);



    }

    public int getPageIndex() {
        return pageIndex;
    }
    public void send(Player player){
        player.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}