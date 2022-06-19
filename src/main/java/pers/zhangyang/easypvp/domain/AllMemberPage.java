package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllMemberPage implements InventoryHolder {
    private final Inventory inventory;
    private Party party;
    private int pageIndex;
    private List<Gamer> gamerList;
    public AllMemberPage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54, ChatColor.translateAlternateColorCodes('&',title));
        }
        gamerList=new ArrayList<>();
    }

    @NotNull
    public List<Gamer> getGamerList() {
        return new ArrayList<>(gamerList);
    }

    @NotNull
    public Party getParty() {
        return party;
    }

    public void init(Party party, int pageIndex,List<Gamer> gamerList){

        if (party==null||gamerList==null){throw new IllegalArgumentException();}
        this.pageIndex=pageIndex;
        this.party=party;
        this.gamerList.clear();
        this.gamerList.addAll(gamerList);
        GuiYaml guiYaml = GuiYaml.getGuiManager();

        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=gamerList.size()){break;}
            String displayName= guiYaml.getBUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME();
            List<String> lore= guiYaml.getBUTTON_ALL_MEMBER_PAGE_MEMBER_LORE();

            if (displayName!=null)
            displayName=ReplaceUtil.replace(displayName,Collections.singletonMap("{member}",
                    party.getMemberList().get(i).getPlayer().getName()));

            if (lore!=null) {
                ReplaceUtil.replace(lore, Collections.singletonMap("{member}",
                        party.getMemberList().get(i).getPlayer().getName()));
            }
            ItemStack itemStack= ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL(),
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

        //设置46选地图
        ItemStack chooseMap=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_LORE());
        inventory.setItem(47,chooseMap);

        ItemStack back=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE());
        inventory.setItem(49,back);

        ItemStack leaveParty=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL(),
                guiYaml.getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE());
        inventory.setItem(51,leaveParty);

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