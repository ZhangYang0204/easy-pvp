package pers.zhangyang.easypvp.domain;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.exception.*;
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
    public Gamer(@Nonnull Player player) {
        if (player==null) {throw new NullPointerException();}
        this.player = player;
        this.stats = GamerStatsEnum.FREEING;
    }

    /**
     *
     * @return
     * @exception IllegalGamerStatsException 如果状态不是FREEING
     */
    public void createParty(@Nonnull String name){
        if (name==null){throw new NullPointerException();}
        if(!stats.equals(GamerStatsEnum.FREEING)){
            throw new IllegalGamerStatsException("Gamer stats is not freeing");
        }
        this.party=new Party(this,name);
        PartyManager.PARTY_MANAGER.add(this.party);
        this.stats=GamerStatsEnum.READING;
    }

    /**
     * 离开比赛  如果符合条件触发比赛结束
     * @exception IllegalGamerStatsException 当不在比赛中
     */
    public void leaveRace() throws FailureDeleteWorldException, FailureUnloadWorldException, FailureTeleportException {
        //如果没有比赛什么也不做
        if (racingRace ==null){return;}

        if(!stats.equals(GamerStatsEnum.RACING)&&!stats.equals(GamerStatsEnum.OUTING)){
            throw new IllegalGamerStatsException("Gamer stats is not racing and is not outing");
        }


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

        player.setLevel(racingRace.levelBefore.get(this));
        racingRace.levelBefore.remove(this);

        player.setExp(racingRace.expBefore.get(this));
        racingRace.expBefore.remove(this);

        player.setAllowFlight(racingRace.flyBefore.get(this));
        racingRace.flyBefore.remove(this);


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
     * @param party 要加入的队伍
     * @exception IllegalGamerStatsException 不是freeing状态
     */
    public void joinParty(@Nonnull Party party){
        if (party==null){throw new NullPointerException();}

        if(!stats.equals(GamerStatsEnum.FREEING)){
            throw new IllegalGamerStatsException("Gamer stats is not freeing");
        }
        party.memberList.add(this);
        this.party=party;
        this.stats=GamerStatsEnum.READING;
        if (party.stats.equals(PartyStatsEnum.MATCHING)){
            this.stats=GamerStatsEnum.MATCHING;
        }
    }

    /**
     * 离开队伍  如果离开后队伍是空的,则队伍销毁
     * @exception  IllegalGamerStatsException 当不是reading状态
     */
    public void leaveParty(){

        if(!stats.equals(GamerStatsEnum.READING)){
            throw new IllegalGamerStatsException("Gamer stats is not reading");
        }

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
        if (race==null){throw new NullPointerException();}

        if (!race.stats.equals(RaceStatsEnum.RACING)){
            throw new IllegalRaceStatsException("Race is not racing");
        }

        if (!stats.equals(GamerStatsEnum.FREEING)){
            throw new IllegalGamerStatsException("Gamer is not freeing");
        }

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
     * @exception IllegalGamerStatsException 如果不在观战
     */
    public void unwatchRace(){
        if (!stats.equals(GamerStatsEnum.WATCHING)){
            throw new IllegalGamerStatsException("Gamer is not watching");
        }
        this.stats=GamerStatsEnum.FREEING;
        player.setGameMode(watchingRace.watcherGameModeBefore.get(this));
        player.teleport(watchingRace.watcherLocationBefore.get(this));
        watchingRace.watcherGameModeBefore.remove(this);
        watchingRace.watcherLocationBefore.remove(this);
        //离开观战
        watchingRace.watcher.remove(this);
        this.watchingRace=null;
    }

@Nullable
    public Race getWatchingRace() {
        return watchingRace;
    }
}
