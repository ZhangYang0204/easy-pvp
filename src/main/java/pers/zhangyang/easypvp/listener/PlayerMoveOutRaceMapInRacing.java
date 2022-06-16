package pers.zhangyang.easypvp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.exception.FailureDeleteWorldException;
import pers.zhangyang.easypvp.exception.FailureTeleportException;
import pers.zhangyang.easypvp.exception.FailureUnloadWorldException;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.util.RaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

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

        try {
            race.out(gamer);
        } catch (FailureDeleteWorldException e) {
            e.printStackTrace();
            return;
        } catch (FailureUnloadWorldException e) {
            e.printStackTrace();
            return;
        } catch (FailureTeleportException e) {
            e.printStackTrace();
            return;
        }

        //告诉其他人
        List<String>list = MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP();
        HashMap<String,String> rep = new HashMap<>();
        rep.put("{player}", gamer.getPlayer().getName());
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
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


        if (!race.getStats().equals(RaceStatsEnum.CELEBRATING)){
            return;
        }

        RaceUtil.AfterRaceStop(race);

    }


}
