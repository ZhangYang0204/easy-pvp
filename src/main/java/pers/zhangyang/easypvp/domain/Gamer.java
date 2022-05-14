package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.manager.PartyManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Gamer  {

    protected final Player player;
    protected GamerStatsEnum stats;
    protected Party party;
    protected Race race;

    /**
     * new出来的对象不注册是没有作用的,请使用GamerManager.getGamer(Player)方法
     * @param player
     */
    public Gamer(Player player) {
        this.player = player;
        this.stats = GamerStatsEnum.FREEING;
    }

    /**
     * 创建一个Party
     * 会先调用leaveParty
     * @return
     */
    @Nonnull
    public Party createParty(String name){
        //首先离开自身的队伍
        leaveParty();

        this.party=new Party(this,name);
        PartyManager.PARTY_MANAGER.add(this.party);
        this.stats=GamerStatsEnum.READING;
        return this.party;
    }

    /**
     * 离开比赛
     * 如果本身不在比赛,什么也不做
     * 有可能触发比赛结束
     */
    public void leaveRace(){
        //如果没有比赛什么也不做
        if (race==null){return;}

        //比赛中移除自己
        race.redAlive.remove(this);
        race.blueAlive.remove(this);

        //如果比赛结束条件符合,结束比赛
        if (race.redAlive.isEmpty()||race.blueAlive.isEmpty()){
            race.stop();
            return;
        }

        //不符合结束条件的话

        //离开比赛
        if (player.isDead()){
            player.spigot().respawn();
        }

        race.locationBefore.remove(this);

        player.setHealth(race.healthBefore.get(this));
        race.healthBefore.remove(this);

        player.addPotionEffects(race.potionEffectBefore.get(this));
        race.potionEffectBefore.remove(this);

        player.setExp(race.expBefore.get(this));
        race.expBefore.remove(this);

        player.setFoodLevel(race.foodLevelBefore.get(this));
        race.foodLevelBefore.remove(this);

        player.setGameMode(race.gameModeBefore.get(this));
        race.gameModeBefore.remove(this);


        player.getInventory().clear();
        player.getInventory().setContents(race.inventorySave.get(this));
        race.inventorySave.remove(this);

        this.stats=GamerStatsEnum.READING;
        this.race=null;
        if (race.locationBefore.get(this).getWorld()==null){
            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        }else {
            player.teleport(race.locationBefore.get(this));
        }
    }

    /**
     * 加入目标队伍
     * 会先调用leaveParty,再加入
     * 如果队伍在游戏中不会加入游戏
     * 如果队伍正在随机匹配中,队伍匹配的地图会因此人的加入而改变，当匹配结束后.玩家会加入游戏
     * 如果队伍正在指定地图的匹配中,匹配的地图不会因此人的加入而改变，当匹配结束后.玩家会加入游戏
     *
     * @param party 要加入的队伍
     */
    public void joinParty(@Nonnull Party party){
        leaveParty();
        party.memberList.add(this);
        this.party=party;
        this.stats=GamerStatsEnum.READING;
        if (party.stats.equals(PartyStatsEnum.MATCHING)){
            this.stats=GamerStatsEnum.MATCHING;
        }
    }

    /**
     * 离开队伍
     * 如果原本没有队伍,不做任何事
     * 如果队伍正在比赛那么也会调用leaveRace
     * 如果队伍正在匹配不会终止匹配
     * 如果离开后队伍是空的,则队伍销毁
     */
    public void leaveParty(){
        //如果没有队伍,什么也不做
        if (party==null){return;}
        //离开比赛
        leaveRace();

        //离开队伍
        party.memberList.remove(this);
        this.stats=GamerStatsEnum.FREEING;

        //如果队伍是空的销毁队伍
        if (party.memberList.isEmpty()){
            PartyManager.PARTY_MANAGER.remove(party);
            party.stats=PartyStatsEnum.FREEING;
            party.cancelMatch();
        }
        this.party=null;
    }

    /**
     * 获得玩家正处于的队伍,如果没有队伍,返回null
     * @return
     */
    @Nullable
    public Party getParty() {
        return party;
    }

    @Nullable
    public Race getRace() {
        return race;
    }

    public boolean hasParty(){
        return party!=null;
    }


    /**
     * @return 返回Gamer对应的玩家
     */
    @Nonnull
    public Player getPlayer() {
        return player;
    }

    /**
     * @return 返回Gamer的状态
     */
    @Nonnull
    public GamerStatsEnum getStats() {
        return stats;
    }


}
