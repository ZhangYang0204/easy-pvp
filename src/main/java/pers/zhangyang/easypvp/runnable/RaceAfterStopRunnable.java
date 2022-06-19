package pers.zhangyang.easypvp.runnable;

import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.exception.FailureDeleteWorldException;
import pers.zhangyang.easypvp.exception.FailureTeleportException;
import pers.zhangyang.easypvp.exception.FailureUnloadWorldException;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.Collections;

public class RaceAfterStopRunnable extends BukkitRunnable {
    private Race race;
    private int rest;

    public RaceAfterStopRunnable(Race race) {
        this.race = race;
        this.rest=race.getMapMeta().getCelebrateTime();
    }
    @Override
    public void run() {



        if (rest>0){


            String title= MessageYaml.INSTANCE.getTITLE_CELEBRATE_TIME_TITLE();
            if (title!=null){
                title= ReplaceUtil.replace(MessageYaml.INSTANCE.getTITLE_CELEBRATE_TIME_TITLE(),
                        Collections.singletonMap("{time}",String.valueOf(rest)));
            }
            String stitle=MessageYaml.INSTANCE.getTITLE_CELEBRATE_TIME_SUBTITLE();
            if (stitle!=null){
                stitle=ReplaceUtil.replace(MessageYaml.INSTANCE.getTITLE_CELEBRATE_TIME_SUBTITLE(),
                        Collections.singletonMap("{time}",String.valueOf(rest)));
            }
            race.sendTitleToAll(title, stitle);
            rest-=1;
            return;

        }


        try {
            race.afterStop();
        } catch (FailureTeleportException e) {
            e.printStackTrace();
            return;
        } catch (FailureDeleteWorldException e) {
            e.printStackTrace();
            return;
        } catch (FailureUnloadWorldException e) {
            e.printStackTrace();
            return;
        }

        this.cancel();


    }
}
