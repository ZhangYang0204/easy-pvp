package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.GuiYaml;

import org.jetbrains.annotations.NotNull;
import java.util.*;

public class AllRacePage implements InventoryHolder {
    private final Inventory inventory;
    private final List<Race> raceList;
    private int pageIndex;
    public AllRacePage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54, ChatColor.translateAlternateColorCodes('&',title));
        }
        raceList=new ArrayList<>();
    }

    @NotNull
    public List<Race> getRaceList() {
        return new ArrayList<>(raceList);
    }

    public void init(List<Race> raceList, int pageIndex){

        if (raceList==null){throw new NullPointerException();}
        this.pageIndex=pageIndex;
        this.raceList.clear();
        this.raceList.addAll(raceList);
        inventory.clear();

        GuiYaml guiYaml = GuiYaml.getINSTANCE();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=raceList.size()){break;}
            String displayName= guiYaml.getBUTTON_ALL_RACE_PAGE_WATCH_RACE_DISPLAY_NAME();
            List<String> lore= guiYaml.INSTANCE.getBUTTON_ALL_RACE_PAGE_WATCH_RACE_LORE();

            HashMap<String,String> rep=new HashMap<>();
            rep.put("{red}",raceList.get(i).getRedParty().getPartyName());
            rep.put("{blue}",raceList.get(i).getBlueParty().getPartyName());
            rep.put("{map}",raceList.get(i).getMapMeta().getName());

            if (displayName!=null) {
                displayName = ReplaceUtil.replace(displayName, rep);
            }
            if (lore!=null) {
                ReplaceUtil.replace(lore, rep);
            }

            String[] descriptions = raceList.get(i).getMapMeta().getDescription()==null?new String[0]:raceList.get(i).getMapMeta().getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            if (lore!=null) {
                ReplaceUtil.format(lore, "{[description]}", descriptionList);
            }
            ItemStack itemStack= ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_LORE());
        inventory.setItem(53,nextPage);

        //设置50加入队伍
        ItemStack back=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_LORE());
        inventory.setItem(48,back);

        //设置50加入队伍
        ItemStack unwatch=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL(),
                guiYaml.INSTANCE.getBUTTON_ALL_RACE_PAGE_UNWATCH_RACE_DISPLAY_NAME(), guiYaml.INSTANCE.getBUTTON_ALL_RACE_PAGE_UNWATCH_RACE_LORE());
        inventory.setItem(50,unwatch);


    }

    public int getPageIndex() {
        return pageIndex;
    }public void send(@NotNull Player player){
        if (player==null) {throw new NullPointerException();}
        player.openInventory(inventory);
    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return inventory;
    }
}