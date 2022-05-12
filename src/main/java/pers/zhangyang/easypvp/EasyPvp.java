package pers.zhangyang.easypvp;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import pers.zhangyang.easypvp.domain.*;
import pers.zhangyang.easypvp.listener.*;
import pers.zhangyang.easypvp.command.*;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.manager.SettingYamlManager;
import pers.zhangyang.easypvp.service.PluginService;
import pers.zhangyang.easypvp.service.impl.PluginServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.UpdateUtil;

import java.io.IOException;
import java.sql.SQLException;

public class EasyPvp extends JavaPlugin {
    private static EasyPvp instance;

    public static EasyPvp getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance=this;

        //初始化setting.yml
        try {
            SettingYamlManager.SETTING_YAML_MANAGER.init();
            MessageYamlManager.MESSAGE_YAML_MANAGER.init();
            GuiYamlManager.GUI_MANAGER.init();
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

        getServer().getPluginManager().registerEvents(new GamerClickCreateParty(),this);
        getServer().getPluginManager().registerEvents(new GamerClickParty(),this);
        getServer().getPluginManager().registerEvents(new GamerClickMyParty(),this);
        getServer().getPluginManager().registerEvents(new GamerClickMember(),this);
        getServer().getPluginManager().registerEvents(new GamerClickLeaveParty(),this);
        getServer().getPluginManager().registerEvents(new GamerClickBackAllPartyPage(),this);
        getServer().getPluginManager().registerEvents(new GamerClickChooseMap(),this);
        getServer().getPluginManager().registerEvents(new GamerClickBackAllMember(),this);
        getServer().getPluginManager().registerEvents(new GamerClickMap(),this);
        getServer().getPluginManager().registerEvents(new GamerClickCancelMatch(),this);
        getServer().getPluginManager().registerEvents(new GamerClickRandomMatch(),this);
        getServer().getPluginManager().registerEvents(new GamerClickKit(),this);
        getServer().getPluginManager().registerEvents(new GamerQuitGame(),this);
        getServer().getPluginManager().registerEvents(new GamerMoveWhenChooseKit(),this);
        getServer().getPluginManager().registerEvents(new GamerDeadInRace(),this);
        getServer().getPluginManager().registerEvents(new GamerDestroyBlockInRace(),this);
        getServer().getPluginManager().registerEvents(new GamerMoveOutRaceMap(),this);
        getServer().getPluginManager().registerEvents(new GamerOpenEnderChestInRace(),this);
        getServer().getPluginManager().registerEvents(new GamerProcessCommandInRace(),this);
        getServer().getPluginManager().registerEvents(new GamerReceiveUpdateNotifyWhenJoin(),this);



        Bukkit.getConsoleSender().sendMessage("§a╭━━━┳━━━┳━━━┳╮╱╱╭┳━━━┳╮╱╱╭┳━━━╮");
       Bukkit.getConsoleSender().sendMessage("§a┃╭━━┫╭━╮┃╭━╮┃╰╮╭╯┃╭━╮┃╰╮╭╯┃╭━╮┃");
       Bukkit.getConsoleSender().sendMessage("§a┃╰━━┫┃╱┃┃╰━━╋╮╰╯╭┫╰━╯┣╮┃┃╭┫╰━╯┃");
       Bukkit.getConsoleSender().sendMessage("§a┃╭━━┫╰━╯┣━━╮┃╰╮╭╯┃╭━━╯┃╰╯┃┃╭━━╯");
       Bukkit.getConsoleSender().sendMessage("§a┃╰━━┫╭━╮┃╰━╯┃╱┃┃╱┃┃╱╱╱╰╮╭╯┃┃");
       Bukkit.getConsoleSender().sendMessage("§a╰━━━┻╯╱╰┻━━━╯╱╰╯╱╰╯╱╱╱╱╰╯╱╰╯");

        UpdateUtil.updateNotify(Bukkit.getConsoleSender());

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
                return;
            }
            player.closeInventory();

        }

        for (Race r: RaceManager.RACE_MANAGER.getPartyGamerMap().values()){
            r.stop();
        }

        Bukkit.getConsoleSender().sendMessage("§c╭━━━┳━━━┳━━━┳╮╱╱╭┳━━━┳╮╱╱╭┳━━━╮");
        Bukkit.getConsoleSender().sendMessage("§c┃╭━━┫╭━╮┃╭━╮┃╰╮╭╯┃╭━╮┃╰╮╭╯┃╭━╮┃");
        Bukkit.getConsoleSender().sendMessage("§c┃╰━━┫┃╱┃┃╰━━╋╮╰╯╭┫╰━╯┣╮┃┃╭┫╰━╯┃");
        Bukkit.getConsoleSender().sendMessage("§c┃╭━━┫╰━╯┣━━╮┃╰╮╭╯┃╭━━╯┃╰╯┃┃╭━━╯");
        Bukkit.getConsoleSender().sendMessage("§c┃╰━━┫╭━╮┃╰━╯┃╱┃┃╱┃┃╱╱╱╰╮╭╯┃┃");
        Bukkit.getConsoleSender().sendMessage("§c╰━━━┻╯╱╰┻━━━╯╱╰╯╱╰╯╱╱╱╱╰╯╱╰╯");
    }
}
