package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.yaml.GuiYaml;
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

        GuiYaml guiYaml = GuiYaml.getGuiManager();
        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=recordMetaList.size()){break;}

            String displayName= guiYaml.getBUTTON_RANK_PAGE_RECORD_DISPLAY_NAME();
            List<String> lore= guiYaml.getBUTTON_RANK_PAGE_RECORD_LORE();

            HashMap<String,String> rep=new HashMap<>();
            rep.put("{player}",Bukkit.getOfflinePlayer(UUID.fromString(recordMetaList.get(i).getPlayerUuid())).getName());
            rep.put("{all}", String.valueOf(recordMetaList.get(i).getAll()));
            rep.put("{win}", String.valueOf(recordMetaList.get(i).getWin()));
            rep.put("{lose}", String.valueOf(recordMetaList.get(i).getLose()));
            rep.put("{draw}", String.valueOf(recordMetaList.get(i).getDraw()));

            displayName=ReplaceUtil.replace(displayName,rep);
            ReplaceUtil.replace(lore,rep);

            ItemStack itemStack= ItemStackUtil.getItemStack(guiYaml.GUI_MANAGER.getBUTTON_RANK_PAGE_RECORD_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL(),
                guiYaml.getBUTTON_RANK_PAGE_PREVIOUS_PAGE_DISPLAY_NAME(), guiYaml.GUI_MANAGER.getBUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL(),
                guiYaml.getBUTTON_RANK_PAGE_NEXT_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_RANK_PAGE_NEXT_PAGE_LORE());
        inventory.setItem(53,nextPage);


        ItemStack back=ItemStackUtil.getItemStack(guiYaml.getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYaml.getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE());
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