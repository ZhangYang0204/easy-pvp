package pers.zhangyang.easypvp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pers.zhangyang.easypvp.bstats.Metrics;
import pers.zhangyang.easypvp.completer.*;
import pers.zhangyang.easypvp.domain.*;
import pers.zhangyang.easypvp.expansion.papi.RecordExpansion;
import pers.zhangyang.easypvp.listener.*;
import pers.zhangyang.easypvp.command.*;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.yaml.MessageYaml;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.yaml.SettingYaml;
import pers.zhangyang.easypvp.service.PluginService;
import pers.zhangyang.easypvp.service.impl.PluginServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.UpdateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EasyPvp extends JavaPlugin {
    private static EasyPvp instance;

    public static EasyPvp getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance=this;
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            RecordExpansion.recordExpansion.register();
        }

        //初始化setting.yml
        try {
            SettingYaml.SETTING_YAML_MANAGER.init();
            MessageYaml.MESSAGE_YAML_MANAGER.init();
            GuiYaml.GUI_MANAGER.init();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return;
        }

        //初始化数据库
        try {
            PluginService pluginService= (PluginService) InvocationUtil.getService(new PluginServiceImpl());
            pluginService.initDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        //更新数据库
        try {
            PluginService pluginService= (PluginService) InvocationUtil.getService(new PluginServiceImpl());
            //先查看版本  然后更新操作

            pluginService.setVersion(getDescription().getVersion());
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }


        //注册事件的处理者
        getServer().getPluginManager().registerEvents(new PlayerClickCreateParty(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickParty(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickMyParty(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickMember(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickLeaveParty(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInAllMemberPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickChooseMap(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllMember(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickMap(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickCancelMatch(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickRandomMatch(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickKit(),this);
        getServer().getPluginManager().registerEvents(new PlayerQuitGame(),this);
        getServer().getPluginManager().registerEvents(new PlayerMoveWhenChooseKit(),this);
        getServer().getPluginManager().registerEvents(new PlayerDeadInRacing(),this);
        getServer().getPluginManager().registerEvents(new PlayerDestroyBlockInRacing(),this);
        getServer().getPluginManager().registerEvents(new PlayerMoveOutRaceMapInRacing(),this);
        getServer().getPluginManager().registerEvents(new PlayerOpenEnderChestInRacing(),this);
        getServer().getPluginManager().registerEvents(new PlayerProcessCommandInRacing(),this);
        getServer().getPluginManager().registerEvents(new PlayerJoinGame(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllPartyPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllMemberPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllMapPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextAllKitPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllPartyPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllMemberPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllMapPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousAllKitPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerDamageWhenChooseKit(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickRankPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickNextRankPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInRankPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickRecord(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousRankPage(),this);
        getServer().getPluginManager().registerEvents(new PlayerForceTeleportOtherWorldInRacing(),this);
        getServer().getPluginManager().registerEvents(new PlayerForceTeleportRaceWorldNotInRacingAntNotInWatching(),this);


        getServer().getPluginManager().registerEvents(new PlayerClickShowAllRacePage(),this);


        getServer().getPluginManager().registerEvents(new PlayerClickNextAllRacePage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickPreviousRacePage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickBackAllPartyPageInAllRacePage(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickWatchRace(),this);
        getServer().getPluginManager().registerEvents(new PlayerForceTeleportOtherWorldInWatching(),this);
        getServer().getPluginManager().registerEvents(new PlayerDeadInWatching(),this);
        getServer().getPluginManager().registerEvents(new PlayerClickUnwatchRace(),this);


        Bukkit.getConsoleSender().sendMessage("§a╭━━━┳━━━┳━━━┳╮╱╱╭┳━━━┳╮╱╱╭┳━━━╮");
       Bukkit.getConsoleSender().sendMessage("§a┃╭━━┫╭━╮┃╭━╮┃╰╮╭╯┃╭━╮┃╰╮╭╯┃╭━╮┃");
       Bukkit.getConsoleSender().sendMessage("§a┃╰━━┫┃╱┃┃╰━━╋╮╰╯╭┫╰━╯┣╮┃┃╭┫╰━╯┃");
       Bukkit.getConsoleSender().sendMessage("§a┃╭━━┫╰━╯┣━━╮┃╰╮╭╯┃╭━━╯┃╰╯┃┃╭━━╯");
       Bukkit.getConsoleSender().sendMessage("§a┃╰━━┫╭━╮┃╰━╯┃╱┃┃╱┃┃╱╱╱╰╮╭╯┃┃");
       Bukkit.getConsoleSender().sendMessage("§a╰━━━┻╯╱╰┻━━━╯╱╰╯╱╰╯╱╱╱╱╰╯╱╰╯");

        UpdateUtil.updateNotify(Bukkit.getConsoleSender());

        new Metrics(this,15185);

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length==1&&args[0].equalsIgnoreCase("help")){
            new CommandHelp(sender,false,args).process();
            return true;
        }
        if (args.length==1&&args[0].equalsIgnoreCase("reload")){
            new CommandReload(sender,false,args).process();
            return true;
        }
        if (args.length==1&&args[0].equalsIgnoreCase("correctYaml")){
            new CommandCorrectYaml(sender,false,args).process();
            return true;
        }
        if (args.length==2&&args[0].equalsIgnoreCase("sectionSet")){
            new CommandSectionSet(sender,true,args).process();
            return true;
        }
        if (args.length==2&&args[0].equalsIgnoreCase("mapCreate")){
            new CommandMapCreate(sender,true,args).process();
            return true;
        }
        if (args.length==2&&args[0].equalsIgnoreCase("mapDelete")){
            new CommandMapDelete(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapDescriptionAdd")){
            new CommandMapDescriptionAdd(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapDescriptionRemove")){
            new CommandMapDescriptionRemove(sender,false,args).process();
            return true;
        }
        if (args.length==4&&args[0].equalsIgnoreCase("mapDescriptionSet")){
            new CommandMapDescriptionSet(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapBuildSet")){
            new CommandMapBuildSet(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapScaleSet")){
            new CommandMapScaleSet(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapDropSet")){
            new CommandMapDropSet(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapFairSet")){
            new CommandMapFairSet(sender,false,args).process();
            return true;
        }
        if (args.length==2&&args[0].equalsIgnoreCase("kitCreate")){
            new CommandKitCreate(sender,true,args).process();
            return true;
        }
        if (args.length==2&&args[0].equalsIgnoreCase("kitDelete")){
            new CommandKitDelete(sender,false,args).process();
            return true;
        }
        if (args.length==2&&args[0].equalsIgnoreCase("kitSet")){
            new CommandKitSet(sender,true,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapKitAdd")){
            new CommandMapKitAdd(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapKitRemove")){
            new CommandMapKitRemove(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("kitDescriptionAdd")){
            new CommandKitDescriptionAdd(sender,false,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("kitDescriptionRemove")){
            new CommandKitDescriptionRemove(sender,false,args).process();
            return true;
        }
        if (args.length==4&&args[0].equalsIgnoreCase("kitDescriptionSet")){
            new CommandKitDescriptionSet(sender,false,args).process();
            return true;
        }
        if (args.length==1&&args[0].equalsIgnoreCase("gui")){
            new CommandGui(sender,true,args).process();
            return true;
        }
        if (args.length==3&&args[0].equalsIgnoreCase("mapChooseTickSet")){
            new CommandMapChooseTickSet(sender,false,args).process();
            return true;
        }if (args.length==1&&args[0].equalsIgnoreCase("recordReset")){
            new CommandRecordReset(sender,false,args).process();
            return true;
        }
        return true;

    }

    @Override
    public void onDisable() {

        for (Player player:Bukkit.getOnlinePlayers()){
            Inventory top=player.getOpenInventory().getTopInventory();
            if (!(top.getHolder() instanceof AllPartyPage)&&!(top.getHolder() instanceof AllMemberPage)
                &&!(top.getHolder() instanceof AllMapPage)&&!(top.getHolder() instanceof AllKitPage)){
                continue;
            }
            player.closeInventory();

        }

        for (Race race: RaceManager.RACE_MANAGER.getRaceList()){
            race.stop();

            try {

                RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
                if (race.getWinner()==null) {
                    for (Gamer g : race.getRedParty().getMemberList()) {
                        raceService.recordDraw(g.getPlayer().getUniqueId().toString());
                    }
                    for (Gamer g : race.getBlueParty().getMemberList()) {
                        raceService.recordDraw(g.getPlayer().getUniqueId().toString());
                    }
                }else {
                    for (Gamer g : race.getWinner().getMemberList()) {
                        raceService.recordWin(g.getPlayer().getUniqueId().toString());
                    }
                    for (Gamer g : race.getLoser().getMemberList()) {
                        raceService.recordLose(g.getPlayer().getUniqueId().toString());
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }


            for (Player p: Bukkit.getOnlinePlayers()){
                if (race.getWinner()!=null) {
                    List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                            .getCHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW();
                    HashMap rep = new HashMap<>();
                    rep.put("{win_party}", race.getWinner().getPartyName());
                    rep.put("{lose_party}", race.getLoser().getPartyName());

                    ReplaceUtil.replace(list, rep);
                    MessageUtil.sendMessageTo(p, list);
                }else {
                    List<String> list = MessageYaml.MESSAGE_YAML_MANAGER
                            .getCHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW();
                    HashMap rep = new HashMap<>();
                    rep.put("{red_party}", race.getRedParty().getPartyName());
                    rep.put("{blue_party}", race.getBlueParty().getPartyName());
                    ReplaceUtil.replace(list, rep);
                    MessageUtil.sendMessageTo(p, list);
                }

            }
        }







        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            RecordExpansion.recordExpansion.unregister();
        }

        Bukkit.getConsoleSender().sendMessage("§c╭━━━┳━━━┳━━━┳╮╱╱╭┳━━━┳╮╱╱╭┳━━━╮");
        Bukkit.getConsoleSender().sendMessage("§c┃╭━━┫╭━╮┃╭━╮┃╰╮╭╯┃╭━╮┃╰╮╭╯┃╭━╮┃");
        Bukkit.getConsoleSender().sendMessage("§c┃╰━━┫┃╱┃┃╰━━╋╮╰╯╭┫╰━╯┣╮┃┃╭┫╰━╯┃");
        Bukkit.getConsoleSender().sendMessage("§c┃╭━━┫╰━╯┣━━╮┃╰╮╭╯┃╭━━╯┃╰╯┃┃╭━━╯");
        Bukkit.getConsoleSender().sendMessage("§c┃╰━━┫╭━╮┃╰━╯┃╱┃┃╱┃┃╱╱╱╰╮╭╯┃┃");
        Bukkit.getConsoleSender().sendMessage("§c╰━━━┻╯╱╰┻━━━╯╱╰╯╱╰╯╱╱╱╱╰╯╱╰╯");
    }


    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> list=new ArrayList<>();
        if (args.length==1){
            list= MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP();
            if (args[0]==null||list==null){
                return  new ArrayList<>();
         }
            String ll = args[0].toLowerCase();
            list.removeIf(k -> !k.toLowerCase().startsWith(ll));
            return list;
        }
        if (args[0].equalsIgnoreCase("kitCreate")){
            return new CompleterKitCreate().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("kitDelete")){
            return new CompleterKitDelete().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("kitDescriptionAdd")){
            return new CompleterKitDescriptionAdd().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("kitDescriptionRemove")){
            return new CompleterKitDescriptionRemove().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("kitDescriptionSet")){
            return new CompleterKitDescriptionSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("kitSet")){
            return new CompleterKitSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapBuildSet")){
            return new CompleterMapBuildSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapChooseTickSet")){
            return new CompleterMapChooseTickSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapCreate")){
            return new CompleterMapCreate().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapDelete")){
            return new CompleterMapDelete().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapDescriptionAdd")){
            return new CompleterMapDescriptionAdd().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapDescriptionRemove")){
            return new CompleterMapDescriptionRemove().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapDescriptionSet")){
            return new CompleterMapDescriptionSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapDropSet")){
            return new CompleterMapDropSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapFairSet")){
            return new CompleterMapFairSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapKitAdd")){
            return new CompleterMapKitAdd().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapKitRemove")){
            return new CompleterMapKitRemove().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("MapScaleSet")){
            return new CompleterMapScaleSet().complete(sender,command,alias,args);
        }
        if (args[0].equalsIgnoreCase("SectionSet")){
            return new CompleterSectionSet().complete(sender,command,alias,args);
        }



        return list;
    }
}
