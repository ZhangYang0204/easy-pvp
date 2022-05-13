package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.Collections;
import java.util.List;

public class AllMemberPage implements InventoryHolder {
    private final Inventory inventory;
    private Party party;
    private int pageIndex;
    public AllMemberPage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54, ReplaceUtil.replace(title, Collections.singletonMap("&","§")));
        }
    }

    public Party getParty() {
        return party;
    }

    public void init(Party party, int pageIndex,List<Gamer> gamerList){
        this.pageIndex=pageIndex;
        this.party=party;

        GuiYamlManager guiYamlManager=GuiYamlManager.getGuiManager();

        inventory.clear();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=gamerList.size()){break;}
            String displayName=guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME();
            List<String> lore=guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_MEMBER_LORE();

            displayName=ReplaceUtil.replace(displayName,Collections.singletonMap("{member}",
                    party.getMemberList().get(i).getPlayer().getName()));

            ReplaceUtil.replace(lore,Collections.singletonMap("{member}",
                    party.getMemberList().get(i).getPlayer().getName()));

            ItemStack itemStack= ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL(),
                    displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL(),
                guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_DISPLAY_NAME(),guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL(),
                guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_DISPLAY_NAME(),guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_LORE());
        inventory.setItem(53,nextPage);

        //设置49xuan地图
        ItemStack chooseMap=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL(),
                guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_DISPLAY_NAME(),guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_LORE());
        inventory.setItem(47,chooseMap);

        ItemStack back=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL(),
                guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME(),guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE());
        inventory.setItem(49,back);

        ItemStack leaveParty=ItemStackUtil.getItemStack(guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL(),
                guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME(),guiYamlManager.getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE());
        inventory.setItem(51,leaveParty);

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