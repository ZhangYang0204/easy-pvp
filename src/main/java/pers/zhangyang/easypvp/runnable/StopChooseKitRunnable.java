package pers.zhangyang.easypvp.runnable;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
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
        List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MY_PARTY();


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
