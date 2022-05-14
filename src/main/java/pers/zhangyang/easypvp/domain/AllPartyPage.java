package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AllPartyPage implements InventoryHolder {
    private final Inventory inventory;
    private final List<Party> partyList;
    private int pageIndex;
    public AllPartyPage(String title){
        if (title==null){
            inventory= Bukkit.createInventory(this,54);
        }else {
            inventory = Bukkit.createInventory(this, 54, ReplaceUtil.replace(title, Collections.singletonMap("&","§")));
        }
        partyList=new ArrayList<>();
    }

    public List<Party> getPartyList() {
        return partyList;
    }

    public void init(List<Party> partyList, int pageIndex){
        this.pageIndex=pageIndex;
        this.partyList.addAll(partyList);
        inventory.clear();

        GuiYaml guiYaml = GuiYaml.getGuiManager();
        //设置内容
        for (int i=0;i<45;i++){
            if (i>=partyList.size()){break;}
            String displayName= guiYaml.getBUTTON_ALL_PARTY_PAGE_PARTY_DISPLAY_NAME();
            List<String> lore= guiYaml.getBUTTON_ALL_PARTY_PAGE_PARTY_LORE();

            HashMap<String,String> rep=new HashMap<>();
            rep.put("{captain}",partyList.get(i).getCaptain().getPlayer().getName());
            rep.put("{party}",partyList.get(i).getPartyName());

            displayName=ReplaceUtil.replace(displayName,rep);

            ReplaceUtil.replace(lore,rep);
            ItemStack itemStack=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL(),
                displayName,lore);
            inventory.setItem(i,itemStack);

        }


        //设置45上一页
        ItemStack previousPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_LORE());
        inventory.setItem(45,previousPage);

        //设置53下一页
        ItemStack nextPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL(),
                guiYaml.getBUTTON_ALL_PARTY_PAGE_NEXT_PAGE_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_PARTY_PAGE_NEXT_PAGE_LORE());
        inventory.setItem(53,nextPage);
        //设置48创建队伍
        ItemStack createParty=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL(),
                guiYaml.getBUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE());
        inventory.setItem(47,createParty);
        //设置48创建队伍
        ItemStack rankPage=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL(),
                guiYaml.GUI_MANAGER.getBUTTON_ALL_PARTY_PAGE_RANK_PAGE_DISPLAY_NAME(), guiYaml.GUI_MANAGER.getBUTTON_ALL_PARTY_PAGE_RANK_PAGE_LORE());
        inventory.setItem(49,rankPage);

        //设置50加入队伍
        ItemStack myParty=ItemStackUtil.getItemStack(guiYaml.getBUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL(),
                guiYaml.getBUTTON_ALL_PARTY_PAGE_MY_PARTY_DISPLAY_NAME(), guiYaml.getBUTTON_ALL_PARTY_PAGE_MY_PARTY_LORE());
        inventory.setItem(51,myParty);




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
