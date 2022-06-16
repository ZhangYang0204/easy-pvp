package pers.zhangyang.easypvp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
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

public class PlayerDeadInRacing implements Listener {
    @EventHandler
    public void onPlayerDie(PlayerDeathEvent event){
        Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(event.getEntity());
        if (gamer.getStats().equals(GamerStatsEnum.WATCHING)){return;}
        Race race=gamer.getRacingRace();
        if (!gamer.getStats().equals(GamerStatsEnum.RACING)){
            return;
        }

        if (race.getMapMeta().isKeepInventory()){
            event.setKeepInventory(true);
        }
        if (race.getMapMeta().isKeepExperience()){
            event.setKeepLevel(true);
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
        //告诉死掉的人
        List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_DEAD_IN_RACING();
        MessageUtil.sendMessageTo(gamer.getPlayer(), list);

        //告诉其他人
        list = MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SOMEONE_SUCCESS_DEAD_IN_RACING();
        HashMap<String,String> rep = new HashMap<>();
        rep.put("{player}", gamer.getPlayer().getName());
        if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
        List<Gamer> gamerList=new ArrayList<>();
        gamerList.addAll(race.getRedParty().getMemberList());
        gamerList.addAll(race.getBlueParty().getMemberList());
        gamerList.addAll(race.getWatcher());
        for (Gamer g:gamerList){
            if (g.equals(gamer)){continue;}
            MessageUtil.sendMessageTo(g.getPlayer(),list);
        }



        if (!race.getStats().equals(RaceStatsEnum.CELEBRATING)){
            return;
        }


        RaceUtil.AfterRaceStop(race);



    }


}
