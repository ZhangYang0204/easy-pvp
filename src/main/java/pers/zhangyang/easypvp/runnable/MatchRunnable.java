package pers.zhangyang.easypvp.runnable;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Matcher;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.manager.MatcherManager;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.*;

public class MatchRunnable extends BukkitRunnable {
    private Matcher matcher;
    private int acc;

    public MatchRunnable(Matcher matcher) {
        this.matcher = matcher;
        acc=0;

    }

    @Override
    public void run() {





       /* if (!matcher.getParty().getStats().equals(PartyStatsEnum.MATCHING)) {
            cancel();
            return;
        }*/
        if (!MatcherManager.MATCHER_MANAGER.contains(matcher)){
            cancel();
            return;
        }
        if (acc!=0) {
            
            String s=MessageYaml.INSTANCE.getTITLE_MATCH_TIME_TITLE();
            if (s!=null) {
            s=ReplaceUtil.replace(s, Collections.singletonMap("{time}", String.valueOf(acc)));
            }
            String ss=MessageYaml.INSTANCE.getTITLE_MATCH_TIME_SUBTITLE();
            if (ss!=null) {
                ss=ReplaceUtil.replace(s,
                        Collections.singletonMap("{time}", String.valueOf(acc)));
            }
            matcher.getParty().sendTitleToAll(s,ss);
            

        }

        acc++;

        Matcher tar =null;
        tar=MatcherManager.MATCHER_MANAGER.matchMatcher(matcher);
        if (tar == null) {
            return;
        }
        if (tar.equals(matcher)) {
            return;
        }
        MatcherManager.MATCHER_MANAGER.remove(matcher);

        MatcherManager.MATCHER_MANAGER.remove(tar);
        MapMeta mapMeta= tar.getMapMeta();

        if (mapMeta==null){
            List<MapMeta> mapMetaList;
            try {
                RaceService commandService = (RaceService) InvocationUtil.getService(new RaceServiceImpl());
                mapMetaList = commandService.getMapMeta(matcher.getParty().getMemberList().size());
            } catch (SQLException e) {
                
                e.printStackTrace();
                return;
            }
            mapMeta= mapMetaList.get(new Random().nextInt(mapMetaList.size()));
        }


        Party red = matcher.getParty();
        Party blue = tar.getParty();

        try {
            RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            List<MapBlockMeta> mapBlockMetaList =raceService.getMapBlockMetaList(mapMeta.getUuid());
            HashMap<KitMeta,List<KitItemStackMeta>> kitItemMap=new HashMap<>();
            for (KitMeta k:raceService.getKitMetaList(mapMeta.getUuid())){
                List<KitItemStackMeta> kitItemStackMetaList =raceService.getKitItemStackMetaList(k.getUuid());
                kitItemMap.put(k, kitItemStackMetaList);
            }
            List<MapBlockInventoryItemStackMeta> mapContainerInventoryItemStackMetaList =raceService.getContainerInventoryItemStackMetaList(mapMeta.getUuid());

            //比赛开始
            Race race=new Race(mapMeta, mapBlockMetaList,kitItemMap, mapContainerInventoryItemStackMetaList);

            new RaceStartReadyRunnable(race,red,blue).runTaskTimer(EasyPvp.getInstance(),1,20);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        //玩家发生消息，告知对手
        List<CommandSender> playerList = new ArrayList<>();
        for (Gamer g : red.getMemberList()) {
            playerList.add(g.getPlayer());
        }
        List<String> list = MessageYaml.INSTANCE
                .getCHAT_SUCCESS_MATCH();
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{captain}", blue.getCaptain().getPlayer().getName());
        rep.put("{party}", blue.getPartyName());
        rep.put("{time}", String.valueOf(mapMeta.getRaceStartReadyTime()));
        rep.put("{race_time}", String.valueOf(mapMeta.getRaceTime()));
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        MessageUtil.sendMessageTo(playerList, list);

        playerList = new ArrayList<>();
        for (Gamer g : blue.getMemberList()) {
            playerList.add(g.getPlayer());
        }
        list = MessageYaml.INSTANCE
                .getCHAT_SUCCESS_MATCH();
        rep = new HashMap<>();
        rep.put("{captain}", red.getCaptain().getPlayer().getName());
        rep.put("{time}", String.valueOf(mapMeta.getRaceStartReadyTime()));
        rep.put("{race_time}", String.valueOf(mapMeta.getRaceTime()));
        rep.put("{party}", red.getPartyName());
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        MessageUtil.sendMessageTo(playerList, list);


    }
}
