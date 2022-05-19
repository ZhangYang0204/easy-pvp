package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.yaml.DanYaml;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import javax.annotation.Nonnull;
import java.util.*;

public class StarRankPage implements InventoryHolder {
    private final Inventory inventory;
    private final List<RecordMeta> recordMetaList;
    private int pageIndex;
    public StarRankPage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54,  ChatColor.translateAlternateColorCodes('&',title));
        }
        this.recordMetaList=new ArrayList<>();
    }


    public void init( int pageIndex, List<RecordMeta> recordMetaList){

        if (recordMetaList==null){throw new NullPointerException();}
        this.pageIndex=pageIndex;
        this.recordMetaList.clear();
        for (RecordMeta m:recordMetaList){this.recordMetaList.add(m.clone());}
        GuiYaml guiYaml = GuiYaml.getGuiManager();
        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=recordMetaList.size()){break;}

            String displayName= guiYaml.getBUTTON_STAR_RANK_PAGE_RECORD_DISPLAY_NAME();
            List<String> lore= guiYaml.getBUTTON_STAR_RANK_PAGE_RECORD_LORE();

            HashMap<String,String> rep=new HashMap<>();
            rep.put("{player}",Bukkit.getOfflinePlayer(UUID.fromString(recordMetaList.get(i).getPlayerUuid())).getName());
            rep.put("{season_all}", String.valueOf(recordMetaList.get(i).getSeasonAll()));
            rep.put("{season_win}", String.valueOf(recordMetaList.get(i).getSeasonWin()));
            rep.put("{season_lose}", String.valueOf(recordMetaList.get(i).getSeasonLose()));
            rep.put("{season_draw}", String.valueOf(recordMetaList.get(i).getSeasonDraw()));
            rep.put("{total_all}", String.valueOf(recordMetaList.get(i).getSeasonAll()));
            rep.put("{total_win}", String.valueOf(recordMetaList.get(i).getSeasonWin()));
            rep.put("{total_lose}", String.valueOf(recordMetaList.get(i).getSeasonLose()));
            rep.put("{total_draw}", String.valueOf(recordMetaList.get(i).getSeasonDraw()));
            rep.put("{season_star}", String.valueOf(recordMetaList.get(i).getSeasonStar()));
            rep.put("{total_streak}", String.valueOf(recordMetaList.get(i).getSeasonDraw()));
            rep.put("{season_streak}", String.valueOf(recordMetaList.get(i).getSeasonStreak()));
            rep.put("{cumulative_star}", String.valueOf(recordMetaList.get(i).getCumulativeStar()));
            Iterator<Integer> it= DanYaml.SETTING_YAML_MANAGER.getSECTION().keySet().stream().sorted().iterator();

            while (it.hasNext()){
                Integer iii=it.next();
                if (recordMetaList.get(i).getSeasonStar()>=iii){
                    rep.put("{dan}", DanYaml.SETTING_YAML_MANAGER.getSECTION().get(iii));
                }
            }

            if (displayName!=null) {
                displayName = ReplaceUtil.replace(displayName, rep);
                ReplaceUtil.replace(lore, rep);
            }
            ItemStack itemStack= ItemStackUtil.getItemStack(guiYaml.GUI_MANAGER.getBUTTON_STAR_RANK_PAGE_RECORD_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL(),
                guiYaml.getBUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_DISPLAY_NAME(), guiYaml.GUI_MANAGER.getBUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL(),
                guiYaml.getBUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_LORE());
        inventory.setItem(53,nextPage);


        ItemStack back=ItemStackUtil.getItemStack(guiYaml.getBUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYaml.getBUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE());
        inventory.setItem(49,back);



    }

    public int getPageIndex() {
        return pageIndex;
    }public void send(@Nonnull Player player){
        if (player==null) {throw new NullPointerException();}
        player.openInventory(inventory);
    }

    @Override
    @Nonnull
    public Inventory getInventory() {
        return inventory;
    }
}