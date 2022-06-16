package pers.zhangyang.easypvp.runnable;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.util.Collections;
import java.util.List;

public class StopChooseKitRunnable extends BukkitRunnable {
    private Race race;
    private int rest;

    public StopChooseKitRunnable(Race race) {
        this.race = race;
        this.rest=race.getMapMeta().getChooseKitTime();
    }

    @Override
    public void run() {



        if (rest>0){


            String title=MessageYaml.MESSAGE_YAML_MANAGER.getTITLE_CHOOSE_KIT_TIME_TITLE();
            if (title!=null){
                title=ReplaceUtil.replace(MessageYaml.MESSAGE_YAML_MANAGER.getTITLE_CHOOSE_KIT_TIME_TITLE(),
                        Collections.singletonMap("{time}",String.valueOf(rest)));
            }
            String stitle=MessageYaml.MESSAGE_YAML_MANAGER.getTITLE_CHOOSE_KIT_TIME_SUBTITLE();
            if (stitle!=null){
                stitle=ReplaceUtil.replace(MessageYaml.MESSAGE_YAML_MANAGER.getTITLE_CHOOSE_KIT_TIME_SUBTITLE(),
                        Collections.singletonMap("{time}",String.valueOf(rest)));
            }
            race.sendTitleToAll(title, stitle);
            rest-=1;
            return;

        }




        race.stopChooseKit();
        List<String> list= MessageYaml.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_STOP_CHOOSE_KIT();


        for (Gamer g:race.getRedAlive()) {
            Player p=g.getPlayer();
            MessageUtil.sendMessageTo(p, list);
        }
        for (Gamer g:race.getBlueAlive()) {
            Player p=g.getPlayer();
            MessageUtil.sendMessageTo(p, list);
        }
        this.cancel();


    }

}
