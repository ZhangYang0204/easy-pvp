package pers.zhangyang.easypvp.runnable;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.exception.FailureDeleteWorldException;
import pers.zhangyang.easypvp.exception.FailureTeleportException;
import pers.zhangyang.easypvp.exception.FailureUnloadWorldException;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.RaceUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.Collections;
import java.util.List;

public class RaceTimeRunnable extends BukkitRunnable {
    private Race race;
    private long endTime;

    public RaceTimeRunnable(Race race) {
        this.race = race;
        this.endTime=race.getMapMeta().getRaceTime()*1000+ System.currentTimeMillis();
    }


    @Override
    public void run() {



        if (endTime>0){
            endTime-=1000;
            return;
        }

            race.stop();


        RaceUtil.AfterRaceStop(race);

        this.cancel();


    }
}
