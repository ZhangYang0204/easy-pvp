package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.manager.PartyManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Gamer  {

    protected final Player player;
    protected GamerStatsEnum stats;
    protected Party party;
    protected Race racingRace;
    protected Race watchingRace;
    /**
     * new出来的对象不注册是没有作用的,请使用GamerManager.getGamer(Player)方法
     * @param player
     */
    public Gamer(Player player) {
        this.player = player;
        this.stats = GamerStatsEnum.FREEING;
    }

    /**
     * 如果有队伍什么也不做
     * 如果正在观战中什么也不做
     * @return
     */
    @Nonnull
    public void createParty(String name){
        //首先离开自身的队伍
        if (party!=null){return ;}
        if (stats.equals(GamerStatsEnum.WATCHING)){return;}

        this.party=new Party(this,name);
        PartyManager.PARTY_MANAGER.add(this.party);
        this.stats=GamerStatsEnum.READING;
    }

    /**
     * 离开比赛
     * 如果本身不在比赛,什么也不做
     * 有可能触发比赛结束
     */
    public void leaveRace(){
        //如果没有比赛什么也不做
        if (racingRace ==null){return;}

        //比赛中移除自己
        racingRace.redAlive.remove(this);
        racingRace.blueAlive.remove(this);

        //如果比赛结束条件符合,结束比赛
        if (racingRace.redAlive.isEmpty()|| racingRace.blueAlive.isEmpty()){
            racingRace.stop();
            return;
        }

        //不符合结束条件的话

        //离开比赛
        if (player.isDead()){
            player.spigot().respawn();
        }
        if (racingRace.locationBefore.get(this).getWorld()==null){
            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        }else {
            player.teleport(racingRace.locationBefore.get(this));
        }
        racingRace.locationBefore.remove(this);

        player.setHealth(racingRace.healthBefore.get(this));
        racingRace.healthBefore.remove(this);

        player.addPotionEffects(racingRace.potionEffectBefore.get(this));
        racingRace.potionEffectBefore.remove(this);

        player.setExp(racingRace.expBefore.get(this));
        racingRace.expBefore.remove(this);

        player.setFoodLevel(racingRace.foodLevelBefore.get(this));
        racingRace.foodLevelBefore.remove(this);

        player.setGameMode(racingRace.gameModeBefore.get(this));
        racingRace.gameModeBefore.remove(this);


        player.getInventory().clear();
        player.getInventory().setContents(racingRace.inventorySave.get(this));
        racingRace.inventorySave.remove(this);

        this.stats=GamerStatsEnum.READING;

        this.racingRace =null;
    }

    /**
     * 加入目标队伍
     * 如果有队伍或者正在观战,什么也不做
     * 如果队伍正在比赛什么也不做
     * 如果队伍正在匹配中什么也不做
     *
     * @param party 要加入的队伍
     */
    public void joinParty(@Nonnull Party party){
        if (hasParty()){return;}
        if (party.stats.equals(PartyStatsEnum.GAMING)){return;}
        if (party.stats.equals(PartyStatsEnum.MATCHING)){return;}
        if (stats.equals(GamerStatsEnum.WATCHING)){return;}
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
     * 如果队伍正在匹配什么也不做,
     * 如果队伍正在比赛什么也不做
     * 如果离开后队伍是空的,则队伍销毁
     */
    public void leaveParty(){
        //如果没有队伍,什么也不做
        if (party==null){return;}
        //离开比赛
        if (party.stats.equals(PartyStatsEnum.GAMING)){return;}

        if (party.stats.equals(PartyStatsEnum.MATCHING)){return;}

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
    public Race getRacingRace() {
        return racingRace;
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


    /**
     * 如果在队伍里什么也不做
     * 如果比赛不在进行什么也不干
     * 如果已经在观战,什么也不做
     * @param race
     */
    public void watchRace(Race race){
        if (!race.stats.equals(RaceStatsEnum.GAMING)){return;}
        if (stats.equals(GamerStatsEnum.WATCHING)){return;}
        if (party!=null){return;}


        this.stats=GamerStatsEnum.WATCHING;
        this.watchingRace=race;
        //加入比赛
        race.watcherLocationBefore.put(this,player.getLocation());
        race.watcherGameModeBefore.put(this,player.getGameMode());
        player.teleport(race.redLoc);
        player.setGameMode(GameMode.SPECTATOR);
        race.watcher.add(this);

    }

    /**
     * 不是观战模式不做
     */
    public void unwatchRace(){
        if (!stats.equals(GamerStatsEnum.WATCHING)){return;}
        this.stats=GamerStatsEnum.FREEING;
        player.setGameMode(watchingRace.watcherGameModeBefore.get(this));
        player.teleport(watchingRace.watcherLocationBefore.get(this));
        watchingRace.watcherGameModeBefore.remove(this);
        watchingRace.watcherLocationBefore.remove(this);
        //离开观战
        watchingRace.watcher.remove(this);
        this.watchingRace=null;
    }


    public Race getWatchingRace() {
        return watchingRace;
    }
}
