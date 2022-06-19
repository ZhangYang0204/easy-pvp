package pers.zhangyang.easypvp.runnable;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.exception.FailureCreateWorldException;
import pers.zhangyang.easypvp.exception.FailureTeleportException;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RaceStartReadyRunnable extends BukkitRunnable {
    private Race race;
    private int rest;
    private Party red;
    private Party blue;

    public RaceStartReadyRunnable(Race race, Party red, Party blue) {
        this.race = race;
        this.rest=race.getMapMeta().getRaceStartReadyTime();
        this.red=red;
        this.blue=blue;
    }


    @Override
    public void run() {
        if (rest>0){


            String title= MessageYaml.INSTANCE.getTITLE_RACE_START_READY_TIME_TITLE();
            if (title!=null){
                title= ReplaceUtil.replace(MessageYaml.INSTANCE.getTITLE_RACE_START_READY_TIME_TITLE(),
                        Collections.singletonMap("{time}",String.valueOf(rest)));
            }
            String stitle=MessageYaml.INSTANCE.INSTANCE.getTITLE_RACE_START_READY_TIME_SUBTITLE();
            if (stitle!=null){
                stitle=ReplaceUtil.replace(MessageYaml.INSTANCE.getTITLE_RACE_START_READY_TIME_SUBTITLE(),
                        Collections.singletonMap("{time}",String.valueOf(rest)));
            }
            red.sendTitleToAll(title, stitle);
            blue.sendTitleToAll(title, stitle);
            rest-=1;
            return;

        }
        if (!red.getMemberList().isEmpty()&&blue.getMemberList().isEmpty()){
            List<CommandSender> playerList = new ArrayList<>();
            for (Gamer g : red.getMemberList()) {
                playerList.add(g.getPlayer());
            }
            List<String> list = MessageYaml.INSTANCE
                    .getCHAT_FAILURE_START_RACE_BECAUSE_ENEMY_ALL_QUIT();
            MessageUtil.sendMessageTo(playerList, list);
            this.cancel();
            red.cancelMatch();
            return;
        }
        if (red.getMemberList().isEmpty()&&!blue.getMemberList().isEmpty()){
            List<CommandSender> playerList = new ArrayList<>();
            for (Gamer g : blue.getMemberList()) {
                playerList.add(g.getPlayer());
            }
            List<String> list = MessageYaml.INSTANCE
                    .getCHAT_FAILURE_START_RACE_BECAUSE_ENEMY_ALL_QUIT();
            MessageUtil.sendMessageTo(playerList, list);
            this.cancel();
            blue.cancelMatch();
            return;
        }


        try {
            race.start(red,blue);
            //几秒后关闭gui
            new StopChooseKitRunnable(race).runTaskTimer(EasyPvp.getInstance(),1,20);

            new RaceTimeRunnable(race).runTaskTimer(EasyPvp.getInstance(),1,20);
        } catch (FailureCreateWorldException e) {
            e.printStackTrace();
            return;
        } catch (FailureTeleportException e) {
            e.printStackTrace();
            return;
        }finally {
            this.cancel();
        }
        //通知进入地图
        //玩家发生消息，告知对手
        List<CommandSender> playerList = new ArrayList<>();
        for (Gamer g : red.getMemberList()) {
            playerList.add(g.getPlayer());
        }
        List<String> list = MessageYaml.INSTANCE
                .getCHAT_SUCCESS_START_RACE();
        HashMap<String, String> rep = new HashMap<>();

        rep.put("{captain}", blue.getCaptain().getPlayer().getName());
        rep.put("{party}", blue.getPartyName());
        rep.put("{time}", String.valueOf(race.getMapMeta().getChooseKitTime()));
        rep.put("{race_time}", String.valueOf(race.getMapMeta().getRaceTime()));
        if (list!=null){
            ReplaceUtil.replace(list, rep);
        }
        MessageUtil.sendMessageTo(playerList, list);

        playerList = new ArrayList<>();
        for (Gamer g : blue.getMemberList()) {
            playerList.add(g.getPlayer());
        }
        list = MessageYaml.INSTANCE
                .getCHAT_SUCCESS_START_RACE();
        rep = new HashMap<>();
        rep.put("{captain}", red.getCaptain().getPlayer().getName());
        rep.put("{time}", String.valueOf(race.getMapMeta().getChooseKitTime()));
        rep.put("{party}", red.getPartyName());
        rep.put("{race_time}", String.valueOf(race.getMapMeta().getRaceTime()));
        if (list!=null){
            ReplaceUtil.replace(list, rep);
        }
        MessageUtil.sendMessageTo(playerList, list);

    }
}
