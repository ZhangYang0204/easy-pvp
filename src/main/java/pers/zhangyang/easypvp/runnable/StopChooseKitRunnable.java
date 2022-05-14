package pers.zhangyang.easypvp.runnable;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.util.MessageUtil;

import java.util.List;

public class StopChooseKitRunnable extends BukkitRunnable {
    private Race race;


    public StopChooseKitRunnable(Race race) {
        this.race = race;
    }

    @Override
    public void run() {
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

    }

}
