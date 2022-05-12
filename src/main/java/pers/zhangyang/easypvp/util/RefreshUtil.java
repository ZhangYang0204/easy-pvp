package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.domain.AllMapPage;
import pers.zhangyang.easypvp.domain.AllMemberPage;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class RefreshUtil {


    public static void refreshAllPartyPage(){
        for (Player p: Bukkit.getOnlinePlayers()){

            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllPartyPage){

                AllPartyPage allPartyPage= (AllPartyPage) p.getOpenInventory().getTopInventory().getHolder();
                int maxPageIndex=PageUtil.computeMaxPageIndex(PartyManager.PARTY_MANAGER.getPartyList().size(),45);
                if (maxPageIndex>=allPartyPage.getPageIndex()) {
                    allPartyPage.init(PageUtil.page(allPartyPage.getPageIndex(), 45, PartyManager.PARTY_MANAGER
                            .getPartyList()), allPartyPage.getPageIndex());
                }else {
                    allPartyPage.init(PageUtil.page(maxPageIndex, 45,PartyManager.PARTY_MANAGER.getPartyList()),
                            maxPageIndex);
                }


            }
        }
    }
    //刷新这个队伍成员页面
    public static void refreshAllMemberPage(){
        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllMemberPage){

                AllMemberPage allMemberPage= (AllMemberPage) p.getOpenInventory().getTopInventory().getHolder();
                Party party=allMemberPage.getParty();
                int maxPageIndex= PageUtil.computeMaxPageIndex(party.getMemberList().size(),45);
                if (maxPageIndex>=allMemberPage.getPageIndex()) {
                    allMemberPage.init(party, allMemberPage.getPageIndex());
                }else {
                    allMemberPage.init(party,maxPageIndex);
                }

            }

        }
    }
    public static void refreshAllMapPage( ) throws SQLException {

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllMapPage){

                List<MapMeta> mapMetaList;

                AllMapPage allPartyPage= (AllMapPage) p.getOpenInventory().getTopInventory().getHolder();
                Party party=allPartyPage.getParty();
                CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
                mapMetaList=commandService.getMapByScale(party.getMemberList().size());

                int maxPageIndex=PageUtil.computeMaxPageIndex(mapMetaList.size(),45);
                if (maxPageIndex>=allPartyPage.getPageIndex()) {
                    allPartyPage.init(party, allPartyPage.getPageIndex(),mapMetaList);
                }else {

                    allPartyPage.init(party,maxPageIndex,mapMetaList);
                }

            }

        }
    }


}
