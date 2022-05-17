package pers.zhangyang.easypvp.domain;

import org.bukkit.Location;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.manager.MatcherManager;
import pers.zhangyang.easypvp.manager.PartyManager;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.runnable.MatchRunnable;
import pers.zhangyang.easypvp.util.MessageUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Party {

    protected final List<Gamer> memberList;
    protected final String partyName;
    protected PartyStatsEnum stats;
    protected Race race;

    public String getPartyName() {
        return partyName;
    }

    /**
     * 仅仅是new出来,没注册不会有效果的
     * @param captain
     */
    public Party(@Nonnull Gamer captain,String partyName) {
        if (captain==null){throw new IllegalArgumentException();}
        memberList=new ArrayList<>();
        stats=PartyStatsEnum.FREEING;
        memberList.add(captain);
        this.partyName=partyName;
    }

    /**
     * 返回队伍所处比赛
     * 如果队伍不处于比赛中,返回null
     * @return
     */
    @Nullable
    public Race getRace() {
        return race;
    }


    /**
     * 开启匹配指定地图
     * 如果已经在匹配中了 什么也不做
     * @param mapMeta
     */
    public void startMatch(MapMeta mapMeta){
        if (stats.equals(PartyStatsEnum.MATCHING)){return;}

        this.stats=PartyStatsEnum.MATCHING;
        Matcher matcher = new Matcher(this, mapMeta);
        MatcherManager.MATCHER_MANAGER.add(matcher);
        //开始匹配
        new MatchRunnable(matcher).runTaskTimer(EasyPvp.getInstance(),1,20);

    }
    /**
     * 取消匹配地图
     * 如果已经不在匹配了,则什么也不做
     * @param
     */
    public void cancelMatch(){

        if (!this.stats.equals(PartyStatsEnum.MATCHING)){return;}

        this.stats=PartyStatsEnum.FREEING;
        MatcherManager.MATCHER_MANAGER.remove(this);
    }
    /**
     * 开启匹配地图
     * 如果已经在匹配中了 什么也不做
     * @param
     */
    public void startMatch(){

        if (stats.equals(PartyStatsEnum.MATCHING)){return;}
        this.stats=PartyStatsEnum.MATCHING;
        Matcher matcher = new Matcher(this);
        MatcherManager.MATCHER_MANAGER.add(matcher);
        new MatchRunnable(matcher).runTaskTimer(EasyPvp.getInstance(),1,20);
    }
    public void sendTitleToAll(String title,String subtitle){

        for (Gamer g:memberList){
            MessageUtil.sendTitleTo(g.getPlayer(),title,subtitle);
        }
    }

    /**
     * 踢出玩家
     * 如果目标gamer不是成员,什么也不做
     * @param gamer
     */
    public void kickGamer(Gamer gamer){
        if (!memberList.contains(gamer)){
            return;
        }

     //离开队伍
        this.memberList.remove(this);
        gamer.stats=GamerStatsEnum.FREEING;

        //如果队伍是空的销毁队伍
        if (this.memberList.isEmpty()){
            PartyManager.PARTY_MANAGER.remove(this);
            this.stats=PartyStatsEnum.FREEING;
            this.cancelMatch();
        }
        gamer.party=null;
    }

    /**
     * 判断是否包含该成员
     * @param gamer
     * @return
     */
    public boolean contains(Gamer gamer){
        return memberList.contains(gamer);
    }

    @Nullable
    public Gamer getCaptain(){
        if (memberList.isEmpty()){return null;}
        return memberList.get(0);
    }

    @Nonnull
    public List<Gamer> getMemberList() {
        return new ArrayList<>(memberList);
    }
    @Nonnull
    public PartyStatsEnum getStats() {
        return stats;
    }


    public void setMemberStats(GamerStatsEnum gamerStats){
        for (Gamer g:memberList){
            g.stats=gamerStats;
        }
    }

    public void teleport(Location location){
        for (Gamer g:memberList){
            g.getPlayer().teleport(location);
        }
    }

    public void sendMessageToAll(List<String> list){
        for (Gamer g:memberList){
            MessageUtil.sendMessageTo(g.getPlayer(),list);
        }
    }

}
