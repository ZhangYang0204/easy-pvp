package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.domain.*;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class RefreshUtil {

    public static void refreshAllRacePage(){
        for (Player p: Bukkit.getOnlinePlayers()){

            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllRacePage){

                AllRacePage allRacePage= (AllRacePage) p.getOpenInventory().getTopInventory().getHolder();
                int maxPageIndex=PageUtil.computeMaxPageIndex(RaceManager.RACE_MANAGER.getRaceList().size(),45);
                if (maxPageIndex>=allRacePage.getPageIndex()) {
                    allRacePage.init(PageUtil.pageRace(allRacePage.getPageIndex(), 45, RaceManager.RACE_MANAGER
                            .getRaceList()), allRacePage.getPageIndex());
                }else {
                    allRacePage.init(PageUtil.pageRace(maxPageIndex, 45,RaceManager.RACE_MANAGER.getRaceList()),
                            maxPageIndex);
                }


            }
        }
    }
    public static void refreshAllPartyPage(){
        for (Player p: Bukkit.getOnlinePlayers()){

            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllPartyPage){

                AllPartyPage allPartyPage= (AllPartyPage) p.getOpenInventory().getTopInventory().getHolder();
                int maxPageIndex=PageUtil.computeMaxPageIndex(PartyManager.PARTY_MANAGER.getPartyList().size(),45);
                if (maxPageIndex>=allPartyPage.getPageIndex()) {
                    allPartyPage.init(PageUtil.pageParty(allPartyPage.getPageIndex(), 45, PartyManager.PARTY_MANAGER
                            .getPartyList()), allPartyPage.getPageIndex());
                }else {
                    allPartyPage.init(PageUtil.pageParty(maxPageIndex, 45,PartyManager.PARTY_MANAGER.getPartyList()),
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
                    allMemberPage.init(party,allMemberPage.getPageIndex(), PageUtil.pageGamer(allMemberPage.getPageIndex(),
                            45,party.getMemberList()));
                }else {
                    allMemberPage.init(party,maxPageIndex, PageUtil.pageGamer(maxPageIndex,45,party.getMemberList()));
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
                    allPartyPage.init(party, allPartyPage.getPageIndex(),PageUtil.pageMapMeta(allPartyPage.getPageIndex(),45,mapMetaList));
                }else {

                    allPartyPage.init(party, maxPageIndex,PageUtil.pageMapMeta(maxPageIndex,45,mapMetaList));
                }

            }

        }
    }


    public static void refreshRankPage( ) throws SQLException {

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof RankPage){

                List<RecordMeta> recordMetaList;

                RankPage rankPage= (RankPage) p.getOpenInventory().getTopInventory().getHolder();
                RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
                recordMetaList=raceService.getRecord();

                recordMetaList.sort(new Comparator<RecordMeta>() {
                    @Override
                    public int compare(RecordMeta o1, RecordMeta o2) {
                        int cha2=o2.getWin()-o2.getLose();
                        int cha1=o1.getWin()-o1.getLose();
                        int all1=o1.getAll();
                        int all2=o2.getAll();
                        int draw1=o1.getDraw();
                        int draw2=o2.getDraw();
                        if (cha2!=cha1){
                            return cha2-cha1;
                        }else if (draw1!=draw2){
                            return draw2-draw1;
                        }else {
                            return all2-all1;
                        }
                    }
                });

                int maxPageIndex=PageUtil.computeMaxPageIndex(recordMetaList.size(),45);
                if (maxPageIndex>=rankPage.getPageIndex()) {
                    rankPage.init(rankPage.getPageIndex(),PageUtil.pageRecordMeta(rankPage.getPageIndex(),45,recordMetaList));
                }else {
                    rankPage.init(maxPageIndex,PageUtil.pageRecordMeta(maxPageIndex,45,recordMetaList));
                }

            }

        }
    }
}
