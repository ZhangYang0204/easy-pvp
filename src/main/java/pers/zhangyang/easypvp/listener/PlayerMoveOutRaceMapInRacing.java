package pers.zhangyang.easypvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerMoveOutRaceMapInRacing implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(event.getPlayer());
        if (gamer.getStats().equals(GamerStatsEnum.WATCHING)){return;}
        Race race= gamer.getRacingRace();
        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){
            return;
        }
        if (race.isInMap(gamer)){
            return;
        }

        race.out(gamer);

        //告诉其他人
        List<String>list = MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP();
        HashMap<String,String> rep = new HashMap<>();
        rep.put("{player}", gamer.getPlayer().getName());
        ReplaceUtil.replace(list, rep);
        List<Gamer> gamerList=new ArrayList<>();
        gamerList.addAll(race.getRedParty().getMemberList());
        gamerList.addAll(race.getBlueParty().getMemberList());
        for (Gamer g:gamerList){
            if (g.equals(gamer)){continue;}
            MessageUtil.sendMessageTo(g.getPlayer(),list);
        }

        //告诉出界的人
       list = MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MOVE_OUT_MAP();
        MessageUtil.sendMessageTo(gamer.getPlayer(), list);


        if (!race.getStats().equals(RaceStatsEnum.ENDING)){
            return;
        }



        try {

                RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
                if (race.getWinner()==null) {
                    for (Gamer g : race.getRedParty().getMemberList()) {
                        raceService.recordDraw(g.getPlayer().getUniqueId().toString());
                    }
                    for (Gamer g : race.getBlueParty().getMemberList()) {
                        raceService.recordDraw(g.getPlayer().getUniqueId().toString());
                    }
                }else {
                    for (Gamer g : race.getWinner().getMemberList()) {
                        raceService.recordWin(g.getPlayer().getUniqueId().toString());
                    }
                    for (Gamer g : race.getLoser().getMemberList()) {
                        raceService.recordLose(g.getPlayer().getUniqueId().toString());
                    }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }


        for (Player p: Bukkit.getOnlinePlayers()){
            if (race.getWinner()!=null) {
               list = MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW();
              rep = new HashMap<>();
                rep.put("{win_party}", race.getWinner().getPartyName());
                rep.put("{lose_party}", race.getLoser().getPartyName());

                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(p, list);
            }else {
                list = MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW();
              rep = new HashMap<>();
                rep.put("{red_party}", race.getRedParty().getPartyName());
                rep.put("{blue_party}", race.getBlueParty().getPartyName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(p, list);
            }

        }


    }


}
