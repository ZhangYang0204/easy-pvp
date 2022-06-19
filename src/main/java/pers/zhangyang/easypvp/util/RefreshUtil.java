package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.domain.*;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.ShopYaml;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class RefreshUtil {

    public static void refreshAllRacePage(){
        for (Player p: Bukkit.getOnlinePlayers()){

            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllRacePage){

                AllRacePage allRacePage= (AllRacePage) p.getOpenInventory().getTopInventory().getHolder();
                int maxPageIndex=PageUtil.computeMaxPageIndex(RaceManager.RACE_MANAGER.getRaceList().size(),45);
                allRacePage=new AllRacePage(GuiYaml.INSTANCE.getTITLE_ALL_RACE_PAGE());
                if (maxPageIndex>=allRacePage.getPageIndex()) {
                    allRacePage.init(PageUtil.pageRace(allRacePage.getPageIndex(), 45, RaceManager.RACE_MANAGER
                            .getRaceList()), allRacePage.getPageIndex());
                }else {
                    allRacePage.init(PageUtil.pageRace(maxPageIndex, 45,RaceManager.RACE_MANAGER.getRaceList()),
                            maxPageIndex);
                }


                p.openInventory(allRacePage.getInventory());
            }
        }
    }
    public static void refreshAllPartyPage(){
        for (Player p: Bukkit.getOnlinePlayers()){

            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllPartyPage){

                AllPartyPage allPartyPage= (AllPartyPage) p.getOpenInventory().getTopInventory().getHolder();
                int maxPageIndex=PageUtil.computeMaxPageIndex(PartyManager.PARTY_MANAGER.getPartyList().size(),45);
                String title= GuiYaml.INSTANCE.getTITLE_ALL_PARTY_PAGE();
                allPartyPage=new AllPartyPage(title);
                if (maxPageIndex>=allPartyPage.getPageIndex()) {
                    allPartyPage.init(PageUtil.pageParty(allPartyPage.getPageIndex(), 45, PartyManager.PARTY_MANAGER
                            .getPartyList()), allPartyPage.getPageIndex());
                }else {
                    allPartyPage.init(PageUtil.pageParty(maxPageIndex, 45,PartyManager.PARTY_MANAGER.getPartyList()),
                            maxPageIndex);
                }
                p.openInventory(allPartyPage.getInventory());

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
                allMemberPage=new AllMemberPage(GuiYaml.getINSTANCE().getTITLE_ALL_MEMBER_PAGE());
                if (maxPageIndex>=allMemberPage.getPageIndex()) {
                    allMemberPage.init(party,allMemberPage.getPageIndex(), PageUtil.pageGamer(allMemberPage.getPageIndex(),
                            45,party.getMemberList()));
                }else {
                    allMemberPage.init(party,maxPageIndex, PageUtil.pageGamer(maxPageIndex,45,party.getMemberList()));
                }

                p.openInventory(allMemberPage.getInventory());
            }


        }
    }
    public static void refreshAllMapPage( ) throws SQLException {

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllMapPage){

                List<MapMeta> mapMetaList;

                AllMapPage allPartyPage= (AllMapPage) p.getOpenInventory().getTopInventory().getHolder();
                Party party=allPartyPage.getParty();
                RaceService commandService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
                mapMetaList=commandService.getMapMeta(party.getMemberList().size());

                int maxPageIndex=PageUtil.computeMaxPageIndex(mapMetaList.size(),45);
                String title = GuiYaml.INSTANCE.getTITLE_ALL_MAP_PAGE();
                allPartyPage = new AllMapPage(title);
                if (maxPageIndex>=allPartyPage.getPageIndex()) {

                    allPartyPage.init(party, allPartyPage.getPageIndex(),PageUtil.pageMapMeta(allPartyPage.getPageIndex(),45,mapMetaList));
                }else {

                    allPartyPage.init(party, maxPageIndex,PageUtil.pageMapMeta(maxPageIndex,45,mapMetaList));
                }
                p.openInventory(allPartyPage.getInventory());

            }

        }
    }
    public static void refreshShopPage( )   {

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof ShopPage){

                List<RecordMeta> recordMetaList;

                ShopPage starRankPage = (ShopPage) p.getOpenInventory().getTopInventory().getHolder();

                int maxPageIndex=PageUtil.computeMaxPageIndex(ShopYaml.INSTANCE.getCONTENT_$_MATERIAL().size(),45);
                starRankPage =new ShopPage(GuiYaml.INSTANCE.getTITLE_SHOP_PAGE());
                if (maxPageIndex>= starRankPage.getPageIndex()) {

                    starRankPage.init(starRankPage.getPageIndex(),PageUtil.pageString(starRankPage.getPageIndex(),45, ShopYaml.INSTANCE.getCONTENT_$_MATERIAL()),
                            PageUtil.pageString(starRankPage.getPageIndex(),45, ShopYaml.INSTANCE.getCONTENT_$_DISPLAY_NAME()),
                            PageUtil.pageListSTring(starRankPage.getPageIndex(),45, ShopYaml.INSTANCE.getCONTENT_$_LORE()),
                            PageUtil.pageListSTring(starRankPage.getPageIndex(),45, ShopYaml.INSTANCE.getCONTENT_$_COMMAND()),
                            PageUtil.pageInteger(starRankPage.getPageIndex(),45, ShopYaml.INSTANCE.getCONTENT_$_COST()),
                            PageUtil.pageListSTring(starRankPage.getPageIndex(),45, ShopYaml.INSTANCE.getCONTENT_$_NOT_ENOUGH()));
                }else {
                    starRankPage.init(maxPageIndex,PageUtil.pageString(maxPageIndex,45, ShopYaml.INSTANCE.getCONTENT_$_MATERIAL()),
                            PageUtil.pageString(maxPageIndex,45, ShopYaml.INSTANCE.getCONTENT_$_DISPLAY_NAME()),
                            PageUtil.pageListSTring(maxPageIndex,45, ShopYaml.INSTANCE.getCONTENT_$_LORE()),
                            PageUtil.pageListSTring(maxPageIndex,45, ShopYaml.INSTANCE.getCONTENT_$_COMMAND()),
                            PageUtil.pageInteger(maxPageIndex,45, ShopYaml.INSTANCE.getCONTENT_$_COST()),
                            PageUtil.pageListSTring(maxPageIndex,45, ShopYaml.INSTANCE.getCONTENT_$_NOT_ENOUGH()));
                }
                p.openInventory(starRankPage.getInventory());

            }

        }
    }

    public static void refreshRankPage( ) throws SQLException {

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof StarRankPage){

                List<RecordMeta> recordMetaList;

                StarRankPage starRankPage = (StarRankPage) p.getOpenInventory().getTopInventory().getHolder();
                RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
                recordMetaList=raceService.getRecordMetaList();

                recordMetaList.sort(new Comparator<RecordMeta>() {
                    @Override
                    public int compare(RecordMeta o1, RecordMeta o2) {
                        int star2=o2.getSeasonStar();
                        int star1=o1.getSeasonStar();

                        return star2-star1;



                    }
                });
                int maxPageIndex=PageUtil.computeMaxPageIndex(recordMetaList.size(),45);
                starRankPage =new StarRankPage(GuiYaml.INSTANCE.getTITLE_STAR_RANK_PAGE());
                if (maxPageIndex>= starRankPage.getPageIndex()) {
                    starRankPage.init(starRankPage.getPageIndex(),PageUtil.pageRecordMeta(starRankPage.getPageIndex(),45,recordMetaList));
                }else {
                    starRankPage.init(maxPageIndex,PageUtil.pageRecordMeta(maxPageIndex,45,recordMetaList));
                }
                p.openInventory(starRankPage.getInventory());

            }

        }
    }
}
