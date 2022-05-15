package pers.zhangyang.easypvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
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
import java.util.HashMap;
import java.util.List;

public class PlayerMoveOutRaceMapInRacing implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(event.getPlayer());
        if (gamer.getStats().equals(GamerStatsEnum.WATCHING)){return;}
        Race race= gamer.getRace();
        if (race==null){return;}


        if (race.isInMap(gamer)){
            return;
        }

        race.out(gamer);

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
                List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW();
                HashMap rep = new HashMap<>();
                rep.put("{win_party}", race.getWinner().getPartyName());
                rep.put("{lose_party}", race.getLoser().getPartyName());

                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(p, list);
            }else {
                List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW();
                HashMap rep = new HashMap<>();
                rep.put("{red_party}", race.getRedParty().getPartyName());
                rep.put("{blue_party}", race.getBlueParty().getPartyName());
                ReplaceUtil.replace(list, rep);
                MessageUtil.sendMessageTo(p, list);
            }

        }


    }


}
