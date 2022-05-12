package pers.zhangyang.easypvp.domain;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.manager.GuiYamlManager;
import pers.zhangyang.easypvp.manager.MatcherManager;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.meta.BlockMeta;
import pers.zhangyang.easypvp.meta.ItemMeta;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.runnable.StopChooseKitRunnable;
import pers.zhangyang.easypvp.util.*;

import javax.annotation.Nullable;
import java.util.*;

public class Race {
    protected final List<Gamer> redAlive;
    protected final List<Gamer> blueAlive;
    protected final boolean fair;
    protected final boolean build;
    protected final boolean drop;
    protected final Long chooseTick;
    protected final HashMap<Gamer, ItemStack[]> inventorySave;
    protected final HashMap<Gamer, Location> locationBefore;
    protected final HashMap<Gamer, GameMode> gameModeBefore;
    protected final HashMap<Gamer, Collection<PotionEffect>> potionEffectBefore;
    protected final HashMap<Gamer, Integer> foodLevelBefore;
    protected final HashMap<Gamer, Double> healthBefore;
    protected final HashMap<Gamer, Float> expBefore;
    protected final List<BlockMeta> blockMetaList;
    protected final MapMeta mapMeta;
    protected final HashMap<KitMeta,List<ItemMeta>> kitItemMap;
    protected Party winner;
    protected Party loser;
    protected Party redParty;
    protected Party blueParty;
    protected Long startTime;
    protected World world;
    protected Location redLoc;
    protected Location blueLoc;
    protected Location firstLoc;
    protected Location secondLoc;
    protected RaceStatsEnum stats;


    /**
     * 强行使玩家出局
     * 如果玩家不在该比赛中,什么也不做
     * 如果玩家已经出局,什么也不做
     * 玩家会像正常出局一样出局，出局可能会触发stop
     *
     * @param gamer
     */
    public void out(Gamer gamer) {
        if (!gamer.race.equals(this)) {
            return;
        }
        if (gamer.stats.equals(GamerStatsEnum.OUTING)) {
            return;
        }

        Player p = gamer.getPlayer();
        p.setGameMode(GameMode.SPECTATOR);
        redAlive.remove(gamer);
        blueAlive.remove(gamer);
        gamer.stats = GamerStatsEnum.OUTING;
        if (redAlive.isEmpty() || blueAlive.isEmpty()) {
            stop();
        }
    }

    private void initWorld() {

        WorldCreator worldCreator = new WorldCreator("/plugins/EasyPvp/world/" + System.currentTimeMillis());
        worldCreator.type(WorldType.FLAT);
        worldCreator.generateStructures(false);
        this.world = worldCreator.createWorld();
        for (BlockMeta b : blockMetaList) {
            Block block = world.getBlockAt(b.getX(), b.getY(), b.getZ());
            if (MinecraftVersionUtil.getBigVersion() == 1 && MinecraftVersionUtil.getMiddleVersion() < 14) {
                MaterialData materialData = BlockUtil.deserializeBlockMaterialData(b.getData());
                block.setType(materialData.getItemType());
            } else {
                block.setBlockData(Bukkit.createBlockData(b.getData()));
            }
        }
    }

    //保存装备并清理
    private void inventoryHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            inventorySave.put(g, p.getInventory().getContents());
            p.getInventory().clear();
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            inventorySave.put(g, p.getInventory().getContents());
            p.getInventory().clear();
        }
    }

    //保存游戏模式并设置生存
    private void gameModeHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            gameModeBefore.put(g, p.getGameMode());
            p.setGameMode(GameMode.SURVIVAL);
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            gameModeBefore.put(g, p.getGameMode());
            p.setGameMode(GameMode.SURVIVAL);
        }
    }

    //保存食物 设置为最大
    private void foodLevelHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            foodLevelBefore.put(g, p.getFoodLevel());
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            foodLevelBefore.put(g, p.getFoodLevel());
        }
    }

    private void expHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            expBefore.put(g, p.getExp());
            p.setExp(0);
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            expBefore.put(g, p.getExp());
            p.setExp(0);
        }
    }

    private void potionEffectHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            potionEffectBefore.put(g, p.getActivePotionEffects());
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            potionEffectBefore.put(g, p.getActivePotionEffects());
        }
    }

    //保存血量并设置为最大
    private void heathHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            healthBefore.put(g, p.getHealth());
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            healthBefore.put(g, p.getHealth());
        }
    }

    //重生并传送
    private void locationHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
            p.setHealth(20);
            locationBefore.put(g, p.getLocation());
            p.teleport(redLoc);

        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
            p.setHealth(20);

            locationBefore.put(g, p.getLocation());
            p.teleport(blueLoc);
        }


    }

    //全部人打开选择
    public void startChooseKit() {
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            AllKitPage allKitPage = new AllKitPage(GuiYamlManager.getGuiManager().getTITLE_ALL_KIT_PAGE());
            allKitPage.init(0, new ArrayList<>(kitItemMap.keySet()));
            allKitPage.send(p);

        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            AllKitPage allKitPage = new AllKitPage(GuiYamlManager.getGuiManager().getTITLE_ALL_KIT_PAGE());
            allKitPage.init(0, new ArrayList<>(kitItemMap.keySet()));
            allKitPage.send(p);
        }
    }

    //全部人关闭选择
    public void stopChooseKit() {
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllKitPage) {
                p.closeInventory();
            }

        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            if (p.getOpenInventory().getTopInventory().getHolder() instanceof AllKitPage) {
                p.closeInventory();
            }
        }
    }

    private void locationHandleAfter() {
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
            if (locationBefore.get(g).getWorld() == null) {
                p.teleport(Bukkit.getWorld("world").getSpawnLocation());
            } else {
                p.teleport(locationBefore.get(g));
            }

        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
            if (locationBefore.get(g).getWorld() == null) {
                p.teleport(Bukkit.getWorld("world").getSpawnLocation());
            } else {
                p.teleport(locationBefore.get(g));
            }
        }
    }

    private void heathHandlerAfter() {
        for (Gamer g : healthBefore.keySet()) {
            Player p = g.getPlayer();

            p.setHealth(healthBefore.get(g));

        }
    }

    private void potionEffectHandleAfter() {
        for (Gamer g : potionEffectBefore.keySet()) {
            Player p = g.getPlayer();

            p.addPotionEffects(potionEffectBefore.get(g));

        }
    }

    private void expHandleAfter() {
        for (Gamer g : expBefore.keySet()) {
            Player p = g.getPlayer();

            p.setExp(expBefore.get(g));

        }
    }

    private void foodLevelHandleAfter() {
        for (Gamer g : foodLevelBefore.keySet()) {
            Player p = g.getPlayer();

            p.setFoodLevel(foodLevelBefore.get(g));

        }
    }

    public void gameModeHandleAfter() {
        for (Gamer g : gameModeBefore.keySet()) {
            Player p = g.getPlayer();

            p.setGameMode(gameModeBefore.get(g));


        }
    }

    public void inventoryHandleAfter() {
        for (Gamer g : inventorySave.keySet()) {
            Player p = g.getPlayer();

            p.getInventory().clear();
            p.getInventory().setContents(inventorySave.get(g));


        }
    }

    public void sendKit(KitMeta kitMeta,Gamer gamer){
        for (ItemMeta i:kitItemMap.get(kitMeta)){
            ItemStack it= ItemStackUtil.itemStackDeserialize(i.getData());
            gamer.getPlayer().getInventory().setItem(i.getSlot(),it);
        }
    }

    /**
     * 初始化一个比赛的基本信息
     * @param mapMeta 比赛的地图数据
     * @param blockMetaList 比赛地图的方块数据
     * @param kitItemMap 比赛可选的礼包和礼包里的物品
     */
    public Race(MapMeta mapMeta, List<BlockMeta> blockMetaList, HashMap<KitMeta,List<ItemMeta>> kitItemMap) {
        stats=RaceStatsEnum.FREEING;
        inventorySave = new HashMap<>();
        locationBefore = new HashMap<>();
        gameModeBefore = new HashMap<>();
        potionEffectBefore = new HashMap<>();
        foodLevelBefore = new HashMap<>();
        healthBefore = new HashMap<>();
        expBefore = new HashMap<>();
        this.kitItemMap = new HashMap<>();
        for (KitMeta b:kitItemMap.keySet()){
            List<ItemMeta> il=new ArrayList<>();
            for (ItemMeta i:kitItemMap.get(b)){
                il.add(i.clone());
            }
            this.kitItemMap.put(b.clone(),il);
        }
        this.redAlive = new ArrayList<>();
        this.blueAlive = new ArrayList<>();
        this.drop = mapMeta.isDrop();
        this.fair = mapMeta.isFair();
        this.build = mapMeta.isBuild();
        this.chooseTick = mapMeta.getChooseTick();
        this.startTime = System.currentTimeMillis();
        this.blockMetaList = new ArrayList<>();
        for (BlockMeta b:blockMetaList){this.blockMetaList.add(b.clone());}
        this.mapMeta = mapMeta;
    }

    public Long getStartTime() {
        return startTime;
    }

    public RaceStatsEnum getStats() {
        return stats;
    }

    /**
     * 给俩队伍开启比赛
     * 如果员原队伍有比赛会先终止
     * 如果本race已经在游戏中,则不会有效果
     * @param redParty
     * @param blueParty
     */
    public void start(Party redParty, Party blueParty) {
        if (stats.equals(RaceStatsEnum.GAMING)){return;}
        stats=RaceStatsEnum.GAMING;
        initWorld();
        this.redLoc = new Location(world, mapMeta.getRedPointX(), mapMeta.getRedPointY(), mapMeta.getRedPointZ());
        this.blueLoc = new Location(world, mapMeta.getBluePointX(), mapMeta.getBluePointY(), mapMeta.getBluePointZ());
        this.firstLoc = new Location(world, mapMeta.getFirstPointX(), mapMeta.getFirstPointY(), mapMeta.getFirstPointZ());
        this.secondLoc = new Location(world, mapMeta.getSecondPointX(), mapMeta.getSecondPointY(), mapMeta.getSecondPointZ());
        this.redParty = redParty;
        this.blueParty = blueParty;
        this.redAlive.addAll(redParty.memberList);
        this.blueAlive.addAll(blueParty.memberList);
        startTime = System.currentTimeMillis();
        redParty.stats = PartyStatsEnum.GAMING;
        blueParty.stats = PartyStatsEnum.GAMING;
        redParty.setMemberStats(GamerStatsEnum.GAMING);
        blueParty.setMemberStats(GamerStatsEnum.GAMING);

        for (Gamer g : redParty.memberList) {
            g.race = this;
        }
        for (Gamer g : blueParty.memberList) {
            g.race = this;
        }

        if (redParty.getRace()!=null){
            redParty.getRace().stop();
        }
        if (blueParty.getRace()!=null){
            blueParty.getRace().stop();
        }
        redParty.race = this;
        blueParty.race = this;

        RaceManager.RACE_MANAGER.put(redParty, this);
        RaceManager.RACE_MANAGER.put(blueParty, this);

        MatcherManager.MATCHER_MANAGER.remove(redParty);
        MatcherManager.MATCHER_MANAGER.remove(blueParty);

        locationHandleBefore();
        gameModeHandleBefore();
        foodLevelHandleBefore();
        expHandleBefore();
        potionEffectHandleBefore();
        heathHandleBefore();
        if (fair) {
            inventoryHandleBefore();
        }
        startChooseKit();
        //几秒后关闭gui
        new StopChooseKitRunnable(this).runTaskLater(EasyPvp.getInstance(), getChooseTick());
    }

    @Nullable
    public Party getWinner() {
        return winner;
    }

    /**
     * 只有在比赛中的比赛结束才有效果
     */
    public void stop() {
        if (!stats.equals(RaceStatsEnum.GAMING)){return;}
        stats=RaceStatsEnum.ENDING;
        RaceManager.RACE_MANAGER.remove(redParty);
        RaceManager.RACE_MANAGER.remove(blueParty);
        blueParty.setMemberStats(GamerStatsEnum.FREEING);
        redParty.setMemberStats(GamerStatsEnum.FREEING);
        redParty.race = null;
        blueParty.race = null;
        redParty.stats = PartyStatsEnum.FREEING;
        blueParty.stats = PartyStatsEnum.FREEING;
        for (Gamer g : redParty.memberList) {
            g.race = null;
        }
        for (Gamer g : blueParty.memberList) {
            g.race = null;
        }
        locationHandleAfter();
        if (fair) {
            inventoryHandleAfter();
        }
        heathHandlerAfter();
        potionEffectHandleAfter();
        expHandleAfter();
        foodLevelHandleAfter();
        gameModeHandleAfter();


        if (redAlive.isEmpty() && !blueAlive.isEmpty()) {
            winner = blueParty;
            loser = redParty;
        } else if (!redAlive.isEmpty() && blueAlive.isEmpty()) {
            loser = blueParty;
            winner = redParty;
        } else {
            winner = null;
            loser = null;
        }

        destroyWorld();

    }

    @Nullable
    public Party getLoser() {
        return loser;
    }

    private void destroyWorld() {

        //移除玩家
        for (Player p:world.getPlayers()){
            if (p.isDead()){
                p.spigot().respawn();
            }
            p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        }

        //删除地图
        if (!Bukkit.unloadWorld(this.world, false)) {
            Bukkit.getConsoleSender().sendMessage("&4有一个地图卸载失败,无法删除");
        } else {

            if (!ResourceUtil.deleteFile(world.getWorldFolder())) {
                Bukkit.getConsoleSender().sendMessage("&4有一个地图卸载成功,但无法删除");
            }
        }
    }

    public boolean isFair() {
        return fair;
    }

    public boolean isBuild() {
        return build;
    }

    public boolean isDrop() {
        return drop;
    }

    public Party getRedParty() {
        return redParty;
    }

    public Party getBlueParty() {
        return blueParty;
    }

    public boolean isInMap(Gamer g){
       return LocationUtil.blockIsIn(firstLoc,secondLoc,g.getPlayer().getLocation());
    }

    public Long getChooseTick() {
        return chooseTick;
    }


    public List<Gamer> getRedAlive() {
        return new ArrayList<>(redAlive);
    }

    public List<Gamer> getBlueAlive() {
        return new ArrayList<>(blueAlive);
    }
}
