package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.runnable.RaceAfterStopRunnable;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class RaceUtil {
    public static void AfterRaceStop(Race race){


        new RaceAfterStopRunnable(race).runTaskTimer(EasyPvp.getInstance(),1,20);

        try {

            RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            if (race.getWinner()==null) {

                for (Gamer g : race.getRedParty().getMemberList()) {
                    raceService.gamerDraw(g.getPlayer().getUniqueId().toString());
                }
                for (Gamer g : race.getBlueParty().getMemberList()) {
                    raceService.gamerDraw(g.getPlayer().getUniqueId().toString());
                }
            }else {
                for (Gamer g : race.getWinner().getMemberList()) {
                    raceService.gamerWin(g.getPlayer().getUniqueId().toString());
                    RecordMeta recordMeta=raceService.getRecordMetaList(g.getPlayer().getUniqueId().toString());
                    for (int x:MessageYaml.INSTANCE.getCHAT_STREAK().keySet()) {
                        if (recordMeta.getTotalStreak() ==x){
                            List<String> list = MessageYaml.INSTANCE.getCHAT_STREAK().get(x);
                            HashMap<String,String> rep = new HashMap<>();
                            rep.put("{player}", g.getPlayer().getName());
                            if (list!=null){
                                ReplaceUtil.replace(list, rep);
                            }
                            MessageUtil.sendMessageTo(Bukkit.getOnlinePlayers(), list);

                        }
                    }
                }
                for (Gamer g : race.getLoser().getMemberList()) {
                    raceService.gamerLose(g.getPlayer().getUniqueId().toString());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }


        if (race.getWinner()!=null) {
            List<String> list = MessageYaml.INSTANCE.getCHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW();
            HashMap<String,String> rep = new HashMap<>();
            rep.put("{win_party}", race.getWinner().getPartyName());
            rep.put("{lose_party}", race.getLoser().getPartyName());

            if (list!=null){
                ReplaceUtil.replace(list, rep);
            }
            MessageUtil.sendMessageTo(Bukkit.getOnlinePlayers(), list);


        }else {
            List<String>  list=MessageYaml.INSTANCE.getCHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW();
            HashMap<String,String>  rep = new HashMap<>();
            rep.put("{red_party}", race.getRedParty().getPartyName());
            rep.put("{blue_party}", race.getBlueParty().getPartyName());
            if (list!=null){
                ReplaceUtil.replace(list, rep);
            }
            MessageUtil.sendMessageTo(Bukkit.getOnlinePlayers(), list);
        }
    RefreshUtil.refreshAllRacePage();
        try {
            RefreshUtil.refreshRankPage();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }


}
