package pers.zhangyang.easypvp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easypvp.bstats.Metrics;
import pers.zhangyang.easypvp.completer.*;
import pers.zhangyang.easypvp.domain.*;
import pers.zhangyang.easypvp.exception.FailureDeleteWorldException;
import pers.zhangyang.easypvp.exception.FailureMakeMultipleDirectorException;
import pers.zhangyang.easypvp.exception.FailureTeleportException;
import pers.zhangyang.easypvp.exception.FailureUnloadWorldException;
import pers.zhangyang.easypvp.expansion.papi.RecordExpansion;
import pers.zhangyang.easypvp.listener.*;
import pers.zhangyang.easypvp.command.*;
import pers.zhangyang.easypvp.util.*;
import pers.zhangyang.easypvp.yaml.*;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.service.PluginService;
import pers.zhangyang.easypvp.service.impl.PluginServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EasyPvp extends JavaPlugin {
    private static EasyPvp instance;
    public static EasyPvp getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        //初始化setting.yml,出错直接关闭插件
        try {
            SettingYaml.INSTANCE.init();
            MessageYaml.INSTANCE.init();
            GuiYaml.INSTANCE.init();
            DanYaml.INSTANCE.init();
            ShopYaml.INSTANCE.init();
        } catch (IOException | InvalidConfigurationException | FailureMakeMultipleDirectorException e) {
            e.printStackTrace();
            setEnabled(false);
            return;
        }

        //初始化数据库,出错直接关闭插件
        try {
            PluginService pluginService = (PluginService) InvocationUtil.getService(new PluginServiceImpl());
            pluginService.initDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
            setEnabled(false);
            return;
        }

        //更新数据库,出错直接关闭插件,暂不需要
        try {
            PluginService pluginService = (PluginService) InvocationUtil.getService(new PluginServiceImpl());
            //String ver=pluginService.getVersion();

            //如果小于xxx版本,就更新下数据库，然后再设置版本
            //if<xxx


            pluginService.setVersion(getDescription().getVersion());

            //重复上述操作


        } catch (SQLException e) {
            e.printStackTrace();
            setEnabled(false);
            return;
        }


        //注册事件
        getServer().getPluginManager().registerEvents(new PlayerClickCreateParty(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickJoinParty(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickShowAllMemberPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickMember(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickLeaveParty(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInAllMemberPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickShowAllMapPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllMember(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickMatchMap(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickCancelMatch(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickMatchRandom(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickChooseKit(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitGame(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveWhenChooseKit(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeadInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerDestroyBlockInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveOutRaceMapInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerOpenEnderChestInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerProcessCommandInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinGame(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllPartyPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllMemberPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllMapPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllKitPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllPartyPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllMemberPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllMapPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllKitPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamageEntityInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickShowRankPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextRankPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInRankPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickRecord(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousRankPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleportOtherWorldInRacing(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleportRaceWorldNotInRacingAntNotInWatching(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickShowAllRacePage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllRacePage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousRacePage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInAllRacePage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickWatchRace(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleportOtherWorldInWatching(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeadInWatching(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickUnwatchRace(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickShowShopPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickBuyGood(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInShopPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextShopPage(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousShopPage(), this);

        //到这里插件已经成功可以使用了,提示插件标志
        MessageUtil.sendMessageTo(Bukkit.getConsoleSender(),MessageYaml.INSTANCE.getCHAT_SUCCESS_ENABLE_PLUGIN());

        //后台更新提示
        UpdateUtil.notifyVersion(Bukkit.getConsoleSender());

        //bStats统计信息
        new Metrics(this, 15185);

        //注册PAPI变量
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            RecordExpansion.INSTANCE.register();
        }

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command, @NotNull String label,@NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            return  new CommandHelp(sender, false, args).process();
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("reloadYaml")) {
            return  new CommandReloadYaml(sender, false, args).process();

        }
        if (args.length == 1 && args[0].equalsIgnoreCase("correctYaml")) {
            return   new CommandCorrectYaml(sender, false, args).process();

        }
        if (args.length == 1 && args[0].equalsIgnoreCase("resetSeason")) {
            return  new CommandResetSeason(sender, false, args).process();

        }
        if (args.length == 1 && args[0].equalsIgnoreCase("openGui")) {
            return  new CommandOpenGui(sender, true, args).process();

        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setSection")) {
            return  new CommandSetSection(sender, true, args).process();

        }
        if (args.length == 2 && args[0].equalsIgnoreCase("createMap")) {
            return  new CommandCreateMap(sender, true, args).process();

        }
        if (args.length == 2 && args[0].equalsIgnoreCase("deleteMap")) {
            return new CommandDeleteMap(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("dddMapDescription")) {
            return  new CommandAddMapDescription(sender, false, args).process();

        }
        if (args.length == 2 && args[0].equalsIgnoreCase("createKit")) {
            return  new CommandCreateKit(sender, true, args).process();

        }
        if (args.length == 2 && args[0].equalsIgnoreCase("deleteKit")) {
            return  new CommandDeleteKit(sender, false, args).process();

        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setKit")) {
            return  new CommandSetKit(sender, true, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("removeMapDescription=")) {
            return  new CommandRemoveMapDescription(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapBuild")) {
            return  new CommandSetMapBuild(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapScale")) {
            return  new CommandSetMapScale(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapKeepInventory")) {
            return  new CommandSetMapKeepInventory(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapKeepExperience")) {
            return  new CommandSetMapKeepExperience(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIsolateExperience")) {
            return  new CommandSetMapIsolateExperience(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIsolateFood")) {
            return  new CommandSetMapIsolateFood(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIsolateHealth")) {
            return  new CommandSetMapIsolateHealth(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIsolateInventory")) {
            return  new CommandSetMapIsolateInventory(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapBlueSpawnInterval")) {
            return  new CommandSetMapBlueSpawnInterval(sender, false, args).process();
        }

        if (args.length == 3 && args[0].equalsIgnoreCase("setMapRedSpawnInterval")) {
            return  new CommandSetMapRedSpawnInterval(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapCelebrateTime")) {
            return  new CommandSetMapCelebrateTime(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapForbiddenEnderChest")) {
            return  new CommandSetMapForbiddenEnderChest(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIgnorePartyDamage")) {
            return  new CommandSetMapIgnorePartyDamage(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapRaceStartReadyTime")) {
            return  new CommandSetMapRaceStartReadyTime(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapRaceTime")) {
            return  new CommandSetMapRaceTime(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIsolatePotionEffect")) {
            return  new CommandSetMapIsolatePotionEffect(sender, false, args).process();
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapIsolateFly")) {
            return  new CommandSetMapIsolateFly(sender, false, args).process();
        }

        if (args.length == 3 && args[0].equalsIgnoreCase("addMapKit")) {
            return  new CommandAddMapKit(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("removeMapKit")) {
            return new CommandRemoveMapKit(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("addKitDescription")) {
            return  new CommandAddKitDescription(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("removeKitDescription")) {
            return   new CommandRemoveKitDescription(sender, false, args).process();

        }

        if (args.length == 3 && args[0].equalsIgnoreCase("plusCumulativeStar")) {
            return   new CommandPlusCumulativeStar(sender, false, args).process();

        } if (args.length == 3 && args[0].equalsIgnoreCase("setCumulativeStar")) {
            return   new CommandSetCumulativeStar(sender, false, args).process();

        } if (args.length == 3 && args[0].equalsIgnoreCase("subtractCumulativeStar")) {
            return   new CommandSubtractCumulativeStar(sender, false, args).process();

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("setMapChooseTime")) {
            return new CommandSetMapChooseTime(sender, false, args).process();

        }
        if (args.length == 4 && args[0].equalsIgnoreCase("setKitDescription")) {
            return  new CommandSetKitDescription(sender, false, args).process();

        }
        if (args.length == 4 && args[0].equalsIgnoreCase("setMapDescription")) {
            return  new CommandSetMapDescription(sender, false, args).process();
        }


        return true;

    }

    @Override
    public void onDisable() {

        //关闭打开的gui
        for (Player player : Bukkit.getOnlinePlayers()) {
            Inventory top = player.getOpenInventory().getTopInventory();
            if (!(top.getHolder() instanceof AllPartyPage) && !(top.getHolder() instanceof AllMemberPage)
                    && !(top.getHolder() instanceof AllMapPage) && !(top.getHolder() instanceof AllKitPage)
                &&!(top.getHolder() instanceof AllRacePage&&!(top.getHolder() instanceof StarRankPage))) {
                continue;
            }
            player.closeInventory();
        }

        //结束游戏并广播
        for (Race race : RaceManager.RACE_MANAGER.getRaceList()) {
            race.stop();
            try {
                race.afterStop();
            } catch (FailureDeleteWorldException | FailureUnloadWorldException | FailureTeleportException e) {
                e.printStackTrace();
                return;
            }
            RaceUtil.AfterRaceStop(race);
        }


        //关闭提示标志
        MessageUtil.sendMessageTo(Bukkit.getConsoleSender(),MessageYaml.INSTANCE.getCHAT_SUCCESS_DISABLE_PLUGIN());


    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list = MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP();
            if (list == null) {
                return new ArrayList<>();
            }
            String ll = args[0].toLowerCase();
            list.removeIf(k -> !k.toLowerCase().startsWith(ll));
            return list;
        }


        if (args[0].equalsIgnoreCase("createKit")) {
            return new CompleterCreateKit(sender,true,args).process();
        }
        if (args[0].equalsIgnoreCase("deleteKit")) {
            return new CompleterDeleteKit(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("addKitDescription")) {
            return new CompleterAddKitDescription(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("removeKitDescription")) {
            return new CompleterRemoveKitDescription(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setKitDescription")) {
            return new CompleterSetKitDescription(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setKit")) {
            return new CompleterSetKit(sender,true,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapBuild")) {
            return new CompleterSetMapBuild(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapChooseTime")) {
            return new CompleterSetMapChooseTime(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("createMap")) {
            return new CompleterCreateMap(sender,true,args).process();
        }
        if (args[0].equalsIgnoreCase("deleteMap")) {
            return new CompleterDeleteMap(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("addMapDescription")) {
            return new CompleterAddMapDescription(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("removeMapDescription")) {
            return new CompleterRemoveMapDescription(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapDescription")) {
            return new CompleterSetMapDescription(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapKeepInventory")) {
            return new CompleterSetMapKeepInventory(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapKeepExperience")) {
            return new CompleterSetMapKeepExperience(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapIsolateExperience")) {
            return  new CompleterSetMapIsolateExperience(sender, false, args).process();

        }
        if ( args[0].equalsIgnoreCase("setMapIsolateFood")) {
            return  new CompleterSetMapIsolateFood(sender, false, args).process();

        }
        if (args[0].equalsIgnoreCase("setMapIsolateHealth")) {
            return  new CompleterSetMapIsolateHealth(sender, false, args).process();

        }
        if (args[0].equalsIgnoreCase("setMapIsolateInventory")) {
            return  new CompleterSetMapIsolateInventory(sender, false, args).process();
        }
        if ( args[0].equalsIgnoreCase("setMapIsolatePotionEffect")) {
            return  new CompleterSetMapIsolatePotionEffect(sender, false, args).process();
        }
        if ( args[0].equalsIgnoreCase("setMapIsolateFly")) {
            return  new CompleterSetMapIsolateFly(sender, false, args).process();
        }
        if ( args[0].equalsIgnoreCase("setMapBlueSpawnInterval")) {
            return  new CompleterSetMapBlueSpawnInterval(sender, false, args).process();
        }

        if (args[0].equalsIgnoreCase("setMapRedSpawnInterval")) {
            return  new CompleterSetMapRedSpawnInterval(sender, false, args).process();
        }
        if ( args[0].equalsIgnoreCase("setMapCelebrateTime")) {
            return  new CompleterSetMapCelebrateTime(sender, false, args).process();
        }
        if (args[0].equalsIgnoreCase("setMapForbiddenEnderChest")) {
            return  new CompleterSetMapForbiddenEnderChest(sender, false, args).process();
        }
        if (args[0].equalsIgnoreCase("setMapIgnorePartyDamage")) {
            return  new CompleterSetMapBlueSpawnInterval(sender, false, args).process();
        }
        if (args[0].equalsIgnoreCase("setMapRaceStartReadyTime")) {
            return  new CompleterSetMapRaceStartReadyTime(sender, false, args).process();
        }
        if (args[0].equalsIgnoreCase("setMapRaceTime")) {
            return  new CompleterSetMapRaceTime(sender, false, args).process();
        }

        if (args[0].equalsIgnoreCase("addMapKit")) {
            return new CompleterAddMapKit(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("removeMapKit")) {
            return new CompleterRemoveMapKit(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setMapScale")) {
            return new CompleterSetMapScale(sender,false,args).process();
        }
        if (args[0].equalsIgnoreCase("setSection")) {
            return new CompleterSectionSet(sender,true,args).process();
        }
        if (args[0].equalsIgnoreCase("setCumulativeStar")) {
            return new CompleterSetCumulativeStar(sender,false,args).process();
        } if (args[0].equalsIgnoreCase("plusCumulativeStar")) {
            return new CompleterPlusCumulativeStar(sender,false,args).process();
        } if (args[0].equalsIgnoreCase("subtractCumulativeStar")) {
            return new CompleterSubtractCumulativeStar(sender,false,args).process();
        }

        return list;
    }
}
