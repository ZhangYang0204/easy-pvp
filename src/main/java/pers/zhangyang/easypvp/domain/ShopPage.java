package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.DanYaml;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.ShopYaml;

import javax.annotation.Nonnull;
import java.util.*;

public class ShopPage implements InventoryHolder {
    private final Inventory inventory;
    private final List<String> materialMap;
    private final List<String> displayNameMap;

    private final List<Integer> costList;
    private final List<List<String>> loreMap;
    private final List<List<String>> cmdMap;

    private final List<List<String>> notEnughtList;
    private int pageIndex;
    public ShopPage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54,  ChatColor.translateAlternateColorCodes('&',title));
        }
        materialMap=new ArrayList<>();
        displayNameMap=new ArrayList<>();
        loreMap=new ArrayList<>();
        cmdMap=new ArrayList<>();
        costList=new ArrayList<>();
        notEnughtList=new ArrayList<>();
    }


    public List<List<String>> getCmdMap() {
        return cmdMap;
    }

    public List<List<String>> getNotEnughtList() {
        List<List<String>> list= new ArrayList<>(notEnughtList);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        return list;
    }

    public void init(int pageIndex, List<String> materialMap, List<String> displayNameMap, List<List<String>> loreMap,
                     List<List<String>> cmdMap, List<Integer> costList, List<List<String>> notEnughtList){

        this.notEnughtList.clear();
        this.costList.clear();
        this.materialMap.clear();
        this.displayNameMap.clear();
        this.loreMap.clear();
        this.cmdMap.clear();
        this.costList.addAll(costList);
        this.materialMap.addAll(materialMap);
        this.displayNameMap.addAll(displayNameMap);
        List<List<String>> list= new ArrayList<>(loreMap);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        this.loreMap.addAll(list);
         list= new ArrayList<>(cmdMap);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        this.cmdMap.addAll(cmdMap);
        list= new ArrayList<>(notEnughtList);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        this.notEnughtList.addAll(notEnughtList);

        this.pageIndex=pageIndex;
        GuiYaml guiYaml = GuiYaml.getGuiManager();
        inventory.clear();

        //设置内容

        for (int i=0;i<45;i++){
            if (materialMap.size()<i+1){break;}

            ItemStack itemStack=ItemStackUtil.getItemStack(materialMap.get(i),displayNameMap.get(i),loreMap.get(i));
            inventory.setItem(i,itemStack);
        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL(),
                guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_DISPLAY_NAME(), guiYaml.GUI_MANAGER.GUI_MANAGER.getBUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL(),
                guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_DISPLAY_NAME(), guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_LORE());
        inventory.setItem(53,nextPage);
        //设置53下一页
        ItemStack back=ItemStackUtil.getItemStack(guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(), guiYaml.GUI_MANAGER.getBUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_LORE());
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

    public List<Integer> getCostList() {
        return new ArrayList<>(costList);
    }
}