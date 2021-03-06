package pers.zhangyang.easypvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;
import pers.zhangyang.easypvp.util.RefreshUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.util.Collections;
import java.util.List;

public class PlayerChatAfterClickCreateParty implements Listener {
    private Gamer gamer;

    public PlayerChatAfterClickCreateParty(Gamer gamer) {
        this.gamer = gamer;
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event){

        Player player=event.getPlayer();
        if (!player.equals(gamer.getPlayer())){return;}
        event.setCancelled(true);
        String input=event.getMessage();
        String[] args=input.split(" ");
        if (args.length!=1){
            MessageUtil.sendMessageTo(player, MessageYaml.INSTANCE.getCHAT_HOW_TO_CREATE_PARTY());
        }
        if (args[0].equalsIgnoreCase(MessageYaml.INSTANCE.getINPUT_CANCEL())){
            List<String> list= MessageYaml.INSTANCE.getCHAT_SUCCESS_CANCEL_CREATE_PARTY();
            MessageUtil.sendMessageTo(player,list);
            backGui();
            unregisterSelf();
            return;
        }

        for (Party p: PartyManager.PARTY_MANAGER.getPartyList()){
            if (p.getPartyName().equals(args[0])){
                List<String> list= MessageYaml.INSTANCE.getCHAT_FAILURE_CREATE_PARTY_BECAUSE_DUPLICATE_PARTY_NAME();
                if (list!=null) {
                    ReplaceUtil.replace(list, Collections.singletonMap("{party}", args[0]));
                }
                MessageUtil.sendMessageTo(player,list);
                return;
            }
        }
        //????????????????????????????????????
        if (gamer.hasParty()) {
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY();
            if (list!=null) {

                ReplaceUtil.replace(list, Collections.singletonMap("{party}", gamer.getParty().getPartyName()));
            }
            MessageUtil.sendMessageTo(player, list);
            backGui();
            unregisterSelf();
            return;
        }

        if (gamer.getStats().equals(GamerStatsEnum.WATCHING)) {
            List<String> list= MessageYaml.INSTANCE
                    .getCHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING();
            MessageUtil.sendMessageTo(player, list);
            backGui();
            unregisterSelf();
            return;
        }


        //????????????
        gamer.createParty(args[0]);

        List<String> list= MessageYaml.INSTANCE
                .getCHAT_SUCCESS_CREATE_PARTY();

        RefreshUtil.refreshAllPartyPage();

        if (list!=null) {
            ReplaceUtil.replace(list, Collections.singletonMap("{party}", args[0]));
        }
        MessageUtil.sendMessageTo(player, list);
        //???????????????????????????
        RefreshUtil.refreshAllPartyPage();
        //??????
        backGui();
        unregisterSelf();


    }
    private void backGui(){

        //??????????????????0???
        String title= GuiYaml.INSTANCE.getTITLE_ALL_PARTY_PAGE();
        AllPartyPage allPartyPage=new AllPartyPage(title);
        allPartyPage.init(PageUtil.pageParty(0,45, PartyManager.PARTY_MANAGER.getPartyList()),0);
        allPartyPage.send(gamer.getPlayer());
    }

    private void unregisterSelf(){
        PlayerChatEvent.getHandlerList().unregister(this);
        PlayerQuitEvent.getHandlerList().unregister(this);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        if (!event.getPlayer().equals(gamer.getPlayer())){return;}
        unregisterSelf();

    }


}
