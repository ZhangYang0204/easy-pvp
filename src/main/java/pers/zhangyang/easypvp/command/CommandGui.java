package pers.zhangyang.easypvp.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.domain.AllPartyPage;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.util.MessageUtil;
import pers.zhangyang.easypvp.util.PageUtil;

public class CommandGui extends CommandBase {

    public CommandGui(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        Player player= (Player) sender;

        //给玩家打开第0页
        String title= GuiYamlManager.GUI_MANAGER.getTITLE_ALL_PARTY_PAGE();
        AllPartyPage allPartyPage=new AllPartyPage(title);
        allPartyPage.init(PageUtil.pageParty(0,45, PartyManager.PARTY_MANAGER.getPartyList()),0);
        allPartyPage.send(player);


        MessageUtil.sendMessageTo(sender, MessageYamlManager.MESSAGE_YAML_MANAGER.getCHAT_SUCCESS_GUI());

        return true;
    }
}
