package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllKitPage implements InventoryHolder {
    private final Inventory inventory;
    private final List<KitMeta> kitMetaList;
    private int pageIndex;

    public AllKitPage(@Nullable String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54, ChatColor.translateAlternateColorCodes('&',title));
        }
        kitMetaList=new ArrayList<>();
    }

    public void init(int pageIndex, @Nonnull List<KitMeta> kitMetaList){
        if (kitMetaList==null){throw new IllegalArgumentException();}
        this.pageIndex=pageIndex;
        this.kitMetaList.clear();
        for (KitMeta k:kitMetaList){this.kitMetaList.add(k.clone());}
        GuiYaml guiYaml = GuiYaml.getGuiManager();
        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=kitMetaList.size()){break;}
            String displayName= guiYaml.getBUTTON_ALL_KIT_PAGE_CHOOSE_KIT_DISPLAY_NAME();
            List<String> lore= guiYaml.getBUTTON_ALL_KIT_PAGE_CHOOSE_KIT_LORE();
            if (displayName!=null) {
                displayName = ReplaceUtil.replace(displayName, Collections.singletonMap("{kit}",
                        kitMetaList.get(i).getName()));
            }
            if (lore!=null) {
            ReplaceUtil.replace(lore,Collections.singletonMap("{kit}",
                    kitMetaList.get(i).getName()));
            }

            String[] descriptions = kitMetaList.get(i).getDescription()==null?new String[0]:kitMetaList.get(i).getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            if (lore!=null) {
                ReplaceUtil.format(lore, "{[description]}", descriptionList);
            }
            ItemStack itemStack= ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }
        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_LORE());
        inventory.setItem(53,nextPage);
    }
    public int getPageIndex() {
        return pageIndex;
    }
    public void send(@Nonnull Player player){
        if (player==null) {throw new NullPointerException();}
        player.openInventory(inventory);
    }
    @Override
    @Nonnull
    public Inventory getInventory() {
        return inventory;
    }

    @Nonnull
    public List<KitMeta> getKitMetaList() {
        List<KitMeta> rl=new ArrayList<>();
        for (KitMeta k:kitMetaList){rl.add(k.clone());}
        return kitMetaList;
    }
}