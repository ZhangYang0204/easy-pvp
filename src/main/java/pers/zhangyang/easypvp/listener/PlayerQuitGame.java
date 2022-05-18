package pers.zhangyang.easypvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.exception.FailureDeleteWorldException;
import pers.zhangyang.easypvp.exception.FailureTeleportException;
import pers.zhangyang.easypvp.exception.FailureUnloadWorldException;
import pers.zhangyang.easypvp.manager.GamerManager;
import pers.zhangyang.easypvp.util.*;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class PlayerQuitGame implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQ(PlayerQuitEvent event){

        try {
            Gamer gamer= GamerManager.GAMER_MANAGER.getGamer(event.getPlayer());
            Player player=gamer.getPlayer();
            Party party= gamer.getParty();
            Race race=gamer.getRacingRace();
            GamerManager.GAMER_MANAGER.remove(player);

            if (party!=null&&party.getStats().equals(PartyStatsEnum.MATCHING)){
                //队伍取消匹配
                party.cancelMatch();
                //其他人通知
                for (Gamer g : party.getMemberList()) {
                    if (g.equals(gamer)) {
                        continue;
                    }
                    Player p=g.getPlayer();
                    List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                            .getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING();
                    HashMap<String,String> rep = new HashMap<>();
                    rep.put("{party}", party.getPartyName());
                    rep.put("{member}", player.getName());
                    if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
                    MessageUtil.sendMessageTo(p, list);
                }

            }

            if (gamer.getStats().equals(GamerStatsEnum.RACING)) {
                //离开游戏
                gamer.leaveRace();
                List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_RACING();

                race.getBlueParty().sendMessageToAll(list);
                race.getRedParty().sendMessageToAll(list);
             }

            if (gamer.getStats().equals(GamerStatsEnum.READING)){
            //离开队伍
            gamer.leaveParty();
                List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                        .getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_READING();
                HashMap<String,String> rep = new HashMap<>();
                rep.put("{party}", party.getPartyName());
                if (list!=null){
                        ReplaceUtil.replace(list, rep);
                    }
                race.getBlueParty().sendMessageToAll(list);
                race.getRedParty().sendMessageToAll(list);
              }



            //离开观战
            if (gamer.getStats().equals(GamerStatsEnum.WATCHING)) {
                gamer.unwatchRace();
            }


            RefreshUtil.refreshAllPartyPage();

            //刷新AllMemberPage
            RefreshUtil.refreshAllMemberPage();

            //刷新地图页面
            RefreshUtil.refreshAllMapPage();
            if (race==null){return;}



            if (!race.getStats().equals(RaceStatsEnum.ENDING)){
                return;
            }


            RaceUtil.AfterRaceStop(race);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
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

    }
}
