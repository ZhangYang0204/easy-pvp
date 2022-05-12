package pers.zhangyang.easypvp.runnable;

import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Matcher;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.MatcherManager;
import pers.zhangyang.easypvp.meta.BlockMeta;
import pers.zhangyang.easypvp.meta.ItemMeta;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MatchRunnable extends BukkitRunnable {
    private Matcher matcher;

    public MatchRunnable(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public void run() {
        if (!matcher.getParty().getStats().equals(PartyStatsEnum.MATCHING)) {
            cancel();
            return;
        }


        Matcher tar =null;
        for (Matcher m:MatcherManager.MATCHER_MANAGER.getSpecificMatcherList()){

            MapMeta ma=matcher.getMapMeta();
            MapMeta ta=m.getMapMeta();
            if (ma==null||ta==null){
                tar=m;
                break;
            }else {
                if (ma.getUuid().equals(ta.getUuid())){
                    tar=m;
                    break;
                }
            }


        }
        if (tar == null) {
            return;
        }
        if (tar.equals(matcher)) {
            return;
        }

        MapMeta mapMeta= tar.getMapMeta();

        if (mapMeta==null){
            List<MapMeta> mapMetaList;
            try {
                CommandService commandService = (CommandService) InvocationUtil.getService(new CommandServiceImpl());
                mapMetaList = commandService.getMapByScale(matcher.getParty().getMemberList().size());
            } catch (SQLException e) {
                throw new RuntimeException();
            }
            mapMeta= mapMetaList.get(new Random().nextInt(mapMetaList.size()));
        }


        Party red = matcher.getParty();
        Party blue = tar.getParty();

        try {
            RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            List<BlockMeta> blockMetaList=raceService.getBlockMeta(mapMeta.getUuid());
            HashMap<KitMeta,List<ItemMeta>> kitItemMap=new HashMap<>();
            for (KitMeta k:raceService.getKitMetaByMapUuid(mapMeta.getUuid())){
                List<ItemMeta> itemMetaList=raceService.getItemMeta(k.getUuid());
                kitItemMap.put(k,itemMetaList);
            }

            //比赛开始
            Race race=new Race(mapMeta,blockMetaList,kitItemMap);

            race.start(red,blue);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        //玩家发生消息，告知对手
        List<CommandSender> playerList = new ArrayList<>();
        for (Gamer g : red.getMemberList()) {
            playerList.add(g.getPlayer());
        }
        List<String> list = MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_RACE_START();
        HashMap<String, String> rep = new HashMap<>();
        rep.put("{captain}", blue.getCaptain().getPlayer().getName());
        rep.put("{party}", blue.getPartyName());
        rep.put("{tick}", String.valueOf(mapMeta.getChooseTick()));
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(playerList, list);

        playerList = new ArrayList<>();
        for (Gamer g : blue.getMemberList()) {
            playerList.add(g.getPlayer());
        }
        list = MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_RACE_START();
        rep = new HashMap<>();
        rep.put("{captain}", red.getCaptain().getPlayer().getName());
        rep.put("{tick}", String.valueOf(mapMeta.getChooseTick()));
        rep.put("{party}", red.getPartyName());
        ReplaceUtil.replace(list, rep);
        MessageUtil.sendMessageTo(playerList, list);


    }
}
