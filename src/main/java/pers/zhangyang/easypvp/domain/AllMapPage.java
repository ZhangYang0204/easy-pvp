package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllMapPage implements InventoryHolder {
    private final Inventory inventory;
    private Party party;
    private int pageIndex;
    private final List<MapMeta> mapMetaList;
    public AllMapPage(@Nullable String title){
        if (title==null){inventory= Bukkit.createInventory(this,54);
        }else {inventory = Bukkit.createInventory(this, 54, ChatColor.translateAlternateColorCodes('&',title));
        }
        this.mapMetaList=new ArrayList<>();
    }

    @NotNull
    public Party getParty() {
        return party;
    }

    @NotNull
    public List<MapMeta> getMapMetaList() {
        List<MapMeta> mapMetaList=new ArrayList<>();
        for (MapMeta m:this.mapMetaList){
            mapMetaList.add(m.clone());
        }
        return mapMetaList;
    }

    public void init(@NotNull Party party, int pageIndex,@NotNull List<MapMeta> mapMetaList){

        if (party==null||mapMetaList==null){throw new IllegalArgumentException();}
        this.pageIndex=pageIndex;
        this.party=party;
        this.mapMetaList.clear();
        for (MapMeta k:mapMetaList){this.mapMetaList.add(k.clone());}
        GuiYaml guiYaml = GuiYaml.getINSTANCE();

        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=mapMetaList.size()){break;}
            String displayName= guiYaml.getBUTTON_ALL_MAP_PAGE_MATCH_MAP_DISPLAY_NAME();

            List<String> lore= guiYaml.getBUTTON_ALL_MAP_PAGE_MATCH_MAP_LORE();

            if (displayName!=null) {
                displayName = ReplaceUtil.replace(displayName, Collections.singletonMap("{map}",
                        mapMetaList.get(i).getName()));
            }
            if (lore!=null) {
                ReplaceUtil.replace(lore, Collections.singletonMap("{map}",
                        mapMetaList.get(i).getName()));
            }
            String[] descriptions = mapMetaList.get(i).getDescription()==null?new String[0]:mapMetaList.get(i).getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            if (lore!=null) {
                ReplaceUtil.format(lore, "{[description]}", descriptionList);

            }
            ItemStack itemStack= ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_LORE());
        inventory.setItem(53,nextPage);


        //返回
        ItemStack back=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE());
        inventory.setItem(49,back);

        ItemStack cancelMatch=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL(),
                guiYaml.getBUTTON_ALL_MAP_PAGE_CANCEL_MATCH_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE());
        inventory.setItem(51,cancelMatch);

        ItemStack randomMatch=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL(),
                guiYaml.getBUTTON_ALL_MAP_PAGE_MATCH_RANDOM_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MAP_PAGE_MATCH_RANDOM_LORE());
        inventory.setItem(47,randomMatch);


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