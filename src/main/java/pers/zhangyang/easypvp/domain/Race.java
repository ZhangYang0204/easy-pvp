package pers.zhangyang.easypvp.domain;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import pers.zhangyang.easypvp.enumration.GamerStatsEnum;
import pers.zhangyang.easypvp.enumration.PartyStatsEnum;
import pers.zhangyang.easypvp.enumration.RaceStatsEnum;
import pers.zhangyang.easypvp.exception.*;
import pers.zhangyang.easypvp.yaml.GuiYaml;
import pers.zhangyang.easypvp.manager.MatcherManager;
import pers.zhangyang.easypvp.manager.RaceManager;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.util.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.*;

public class Race {
    protected final List<Gamer> redAlive;
    protected final List<Gamer> blueAlive;

    protected final HashMap<Gamer, ItemStack[]> inventorySave;
    protected final HashMap<Gamer, Location> locationBefore;
    protected final HashMap<Gamer, GameMode> gameModeBefore;
    protected final HashMap<Gamer, Collection<PotionEffect>> potionEffectBefore;
    protected final HashMap<Gamer, Integer> foodLevelBefore;
    protected final HashMap<Gamer, Double> healthBefore;
    protected final HashMap<Gamer, Float> expBefore;
    protected final HashMap<Gamer, Integer> levelBefore;
    protected final HashMap<Gamer, Boolean> flyBefore;
    protected final List<MapBlockMeta> mapBlockMetaList;
    protected final List<MapBlockInventoryItemStackMeta> mapContainerInventoryItemStackMetaList;
    protected final MapMeta mapMeta;
    protected final HashMap<KitMeta,List<KitItemStackMeta>> kitItemMap;
    protected final List<Gamer> watcher;
    protected final HashMap<Gamer, Location> watcherLocationBefore;
    protected final HashMap<Gamer, GameMode> watcherGameModeBefore;
    protected Party winner;
    protected Party loser;
    protected Party redParty;
    protected Party blueParty;

    protected Long startTimeMillis;
    protected World world;
    protected Location redLoc;
    protected Location blueLoc;
    protected Location firstLoc;
    protected Location secondLoc;
    protected RaceStatsEnum stats;

    @NotNull
    public MapMeta getMapMeta() {
        return mapMeta.clone();
    }

    /**
     * ?????????????????????
     * ??????????????????????????????,???????????????
     * ????????????????????????,???????????????
     * ????????????????????????????????????????????????????????????stop
     *
     * @param gamer
     */
    public void out(@NotNull Gamer gamer) throws FailureDeleteWorldException, FailureUnloadWorldException, FailureTeleportException {
        if (gamer==null){throw  new NullPointerException();}
        if (!gamer.playingRace.equals(this)) {
            throw new NotInThisRaceException("Gamer is not in this race");
        }
        if (gamer.stats.equals(GamerStatsEnum.OUTING)) {
            throw new IllegalGamerStatsException("Gamer is outing");
        }

        Player p = gamer.getPlayer();
        if (p.isDead()){
            Location l=p.getLocation();
            p.spigot().respawn();
            p.teleport(l);
        }
        p.setGameMode(GameMode.SPECTATOR);
        redAlive.remove(gamer);
        blueAlive.remove(gamer);
        gamer.stats = GamerStatsEnum.OUTING;

    }

    private void initWorld() throws FailureCreateWorldException {
        this.world = WorldUtil.getVoidWorld("/plugins/EasyPvp/world/" + System.currentTimeMillis());
        this.world.setAutoSave(false);

        List<MapBlockMeta> torL=new ArrayList<>();

        for (MapBlockMeta b : mapBlockMetaList) {
            Block block = world.getBlockAt(b.getX(), b.getY(), b.getZ());

            if (MinecraftVersionUtil.getBigVersion()==1&&MinecraftVersionUtil.getMiddleVersion()<13){
                if (b.getData().contains("TORCH")){
                    torL.add(b);
                    continue;
                }
                MaterialData materialData=MaterialDataUtil.deserializeMaterialData(b.getData());
                BlockState blockState=block.getState();
               blockState.setType(materialData.getItemType());
               blockState.setRawData(materialData.getData());
                blockState.update(true,false);
            }else {
                block.setBlockData(Bukkit.createBlockData(b.getData()));
                block.getState().update(true,false);
            }
        }

        if (MinecraftVersionUtil.getBigVersion()==1&&MinecraftVersionUtil.getMiddleVersion()<13) {
            for (MapBlockMeta b : torL) {
                Block block = world.getBlockAt(b.getX(), b.getY(), b.getZ());
                MaterialData materialData=MaterialDataUtil.deserializeMaterialData(b.getData());
                BlockState blockState=block.getState();
                blockState.setType(materialData.getItemType());
                blockState.setRawData(materialData.getData());
                blockState.update(true,false);
            }
        }






        for (MapBlockInventoryItemStackMeta m: mapContainerInventoryItemStackMetaList){
            Block block = world.getBlockAt(m.getX(), m.getY(), m.getZ());
            Inventory inv;
            if (MinecraftVersionUtil.getBigVersion()==1&&MinecraftVersionUtil.getMiddleVersion()<13) {
                inv = ((Container) block.getState()).getInventory();
            }else {
                inv = ((BlockInventoryHolder) block.getState()).getInventory();
            }
            ItemStack i=ItemStackUtil.itemStackDeserialize(m.getData());
            inv.setItem(m.getSlot(),i);
        }

    }

    //?????????????????????
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

    //?????????????????????????????????
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

    //???????????? ???????????????
    private void foodLevelHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            foodLevelBefore.put(g, p.getFoodLevel());
            p.setFoodLevel(20);
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            foodLevelBefore.put(g, p.getFoodLevel());
            p.setFoodLevel(20);
        }
    }

    //???????????? ?????????0
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

    //???????????? ?????????0
    private void levelHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            levelBefore.put(g, p.getLevel());
            p.setLevel(0);
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            levelBefore.put(g, p.getLevel());
            p.setLevel(0);
        }
    }

    //???????????? ?????????0
    private void flyHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            flyBefore.put(g, p.getAllowFlight());
            p.setAllowFlight(false);
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            flyBefore.put(g, p.getAllowFlight());
            p.setAllowFlight(false);
        }
    }

    //?????????????????? ????????????
    private void potionEffectHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            potionEffectBefore.put(g, p.getActivePotionEffects());
            for (PotionEffect potionEffect:p.getActivePotionEffects()){
                p.removePotionEffect(potionEffect.getType());
            }
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            potionEffectBefore.put(g, p.getActivePotionEffects());
            for (PotionEffect potionEffect:p.getActivePotionEffects()){
                p.removePotionEffect(potionEffect.getType());
            }
        }
    }

    //???????????? ???????????????
    private void heathHandleBefore() {
        for (Gamer g : redParty.memberList) {
            Player p = g.player;
            healthBefore.put(g, p.getHealth());
            p.setHealth(20);
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.player;
            healthBefore.put(g, p.getHealth());
            p.setHealth(20);
        }
    }

    public List<Gamer> getWatcher() {
        return watcher;
    }

    //??????
    private void locationHandleBefore() throws FailureTeleportException {
        int rC=0;
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            locationBefore.put(g, p.getLocation());
            rC++;
            int fang=rC%4;
            int fangP=rC/4;

            Location redTarLoc=redLoc.clone();

            //X+
            if (fang==0){
                redTarLoc.add(fangP+mapMeta.getRedSpawnInterval(),0,0);
            }
            //X-
            if (fang==1){
                redTarLoc.add(fangP-mapMeta.getRedSpawnInterval(),0,0);
            }
            //Z+
            if (fang==2){
                redTarLoc.add(0,0,fangP+mapMeta.getRedSpawnInterval());
            }
            //Z-
            if (fang==3){
                redTarLoc.add(0,0,fangP-mapMeta.getRedSpawnInterval());
            }

            if (!p.teleport(redTarLoc)){
               throw new FailureTeleportException();
           }

        }

        int bC=0;
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            locationBefore.put(g, p.getLocation());
            bC++;
            int fang=bC%4;
            int fangP=bC/4;

            Location blueTarLoc=blueLoc.clone();

            //X+
            if (fang==0){
                blueTarLoc.add(fangP+mapMeta.getBlueSpawnInterval(),0,0);
            }
            //X-
            if (fang==1){
                blueTarLoc.add(fangP-mapMeta.getBlueSpawnInterval(),0,0);
            }
            //Z+
            if (fang==2){
                blueTarLoc.add(0,0,fangP+mapMeta.getBlueSpawnInterval());
            }
            //Z-
            if (fang==3){
                blueTarLoc.add(0,0,fangP-mapMeta.getBlueSpawnInterval());
            }
            if (!p.teleport(blueTarLoc)) {
                throw new FailureTeleportException();
            }
        }


    }

    //?????????????????????
    public void startChooseKit() {
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            AllKitPage allKitPage = new AllKitPage(GuiYaml.getINSTANCE().getTITLE_ALL_KIT_PAGE());
            allKitPage.init(0, PageUtil.pageKitMeta(0,45,new ArrayList<>(kitItemMap.keySet())));
            allKitPage.send(p);

        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            AllKitPage allKitPage = new AllKitPage(GuiYaml.getINSTANCE().getTITLE_ALL_KIT_PAGE());
            allKitPage.init(0, PageUtil.pageKitMeta(0,45,new ArrayList<>(kitItemMap.keySet())));
            allKitPage.send(p);
        }
    }

    //?????????????????????
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


    private void locationHandleAfter() throws FailureTeleportException {
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            if (locationBefore.get(g).getWorld() == null) {
               if (!p.teleport(Bukkit.getWorld("world").getSpawnLocation())){
                   throw new FailureTeleportException();
               }
            } else {
                if(!p.teleport(locationBefore.get(g))){
                    throw new FailureTeleportException();
                }

            }
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            if (locationBefore.get(g).getWorld() == null) {
                if (!p.teleport(Bukkit.getWorld("world").getSpawnLocation())){

                    throw new FailureTeleportException();
                }
            } else {
                if(!p.teleport(locationBefore.get(g))){

                    throw new FailureTeleportException();
                }
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

    private void levelHandleAfter() {
        for (Gamer g : levelBefore.keySet()) {
            Player p = g.getPlayer();
            p.setLevel(levelBefore.get(g));

        }
    }
    private void flyHandleAfter() {
        for (Gamer g : flyBefore.keySet()) {
            Player p = g.getPlayer();
            p.setAllowFlight(flyBefore.get(g));

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
    public void sendKit(@NotNull KitMeta kitMeta,@NotNull Gamer gamer){
        if (kitMeta==null||gamer==null){throw  new NullPointerException();}
        for (KitItemStackMeta i:kitItemMap.get(kitMeta)){
            ItemStack it= ItemStackUtil.itemStackDeserialize(i.getData());
            gamer.getPlayer().getInventory().setItem(i.getSlot(),it);
        }
    }
    /**
     * ????????????????????????????????????
     * @param mapMeta ?????????????????????
     * @param mapBlockMetaList ???????????????????????????
     * @param kitItemMap ??????????????????????????????????????????
     */
    public Race(@NotNull MapMeta mapMeta,@NotNull  List<MapBlockMeta> mapBlockMetaList,@NotNull  HashMap<KitMeta,List<KitItemStackMeta>> kitItemMap,
                @NotNull  List<MapBlockInventoryItemStackMeta> mapContainerInventoryItemStackMetaList) {
        if (mapMeta==null||mapBlockMetaList==null||kitItemMap==null||mapContainerInventoryItemStackMetaList==null){
            throw new NullPointerException();
        }
        stats=RaceStatsEnum.FREEING;
        inventorySave = new HashMap<>();
        locationBefore = new HashMap<>();
        gameModeBefore = new HashMap<>();
        potionEffectBefore = new HashMap<>();
        foodLevelBefore = new HashMap<>();
        healthBefore = new HashMap<>();
        flyBefore=new HashMap<>();
        expBefore = new HashMap<>();
        levelBefore=new HashMap<>();
        this.kitItemMap = new HashMap<>();
        for (KitMeta b:kitItemMap.keySet()){
            List<KitItemStackMeta> il=new ArrayList<>();
            for (KitItemStackMeta i:kitItemMap.get(b)){
                il.add(i.clone());
            }
            this.kitItemMap.put(b.clone(),il);
        }
        this.redAlive = new ArrayList<>();
        this.blueAlive = new ArrayList<>();
        this.startTimeMillis = System.currentTimeMillis();
        this.mapBlockMetaList = new ArrayList<>();
        for (MapBlockMeta b: mapBlockMetaList){this.mapBlockMetaList.add(b.clone());}
        this.mapContainerInventoryItemStackMetaList = new ArrayList<>();
        for (MapBlockInventoryItemStackMeta m: mapContainerInventoryItemStackMetaList){
            this.mapContainerInventoryItemStackMetaList.add(m.clone());
        }
        this.mapMeta = mapMeta.clone();
        watcher = new ArrayList<>();
        watcherGameModeBefore = new HashMap<>();
        watcherLocationBefore=new HashMap<>();
    }

    public Long getStartTimeMillis() {
        return startTimeMillis;
    }

    public RaceStatsEnum getStats() {
        return stats;
    }

    /**
     * ????????????????????????
     * ???????????????????????????????????????
     * ?????????race??????????????????,??????????????????
     * @param redParty
     * @param blueParty
     * @exception IllegalRaceStatsException ??????????????????freeing
     * @exception IllegalPartyStatsException ??????????????????
     */
    public void start(@NotNull Party redParty,@NotNull Party blueParty) throws FailureCreateWorldException, FailureTeleportException {
        if (redParty==null||blueParty==null){throw new NullPointerException();}
        if (stats.equals(RaceStatsEnum.RACING)){
            throw new IllegalRaceStatsException("This race is not freeing");
        }
            if (redParty.getStats().equals(PartyStatsEnum.RACING)){
            throw new IllegalPartyStatsException("Party "+redParty.partyName+" is  racing");
        }
        if (blueParty.getStats().equals(PartyStatsEnum.RACING)){
            throw new IllegalPartyStatsException("Party "+blueParty.partyName+" is  racing");
        }
        initWorld();
        this.stats=RaceStatsEnum.RACING;
        this.redParty = redParty;
        this.blueParty = blueParty;
        this.redLoc = new Location(world, mapMeta.getRedPointX(), mapMeta.getRedPointY(), mapMeta.getRedPointZ(),mapMeta.getRedPointYaw(),mapMeta.getRedPointPitch());
        this.blueLoc = new Location(world, mapMeta.getBluePointX(), mapMeta.getBluePointY(), mapMeta.getRedPointZ(),mapMeta.getBluePointYaw(),mapMeta.getBluePointPitch());
        this.firstLoc = new Location(world, mapMeta.getFirstPointX(), mapMeta.getFirstPointY(), mapMeta.getFirstPointZ());
        this.secondLoc = new Location(world, mapMeta.getSecondPointX(), mapMeta.getSecondPointY(), mapMeta.getSecondPointZ());
        this.redAlive.addAll(redParty.memberList);
        this.blueAlive.addAll(blueParty.memberList);
        this.startTimeMillis = System.currentTimeMillis();
        redParty.stats = PartyStatsEnum.RACING;
        blueParty.stats = PartyStatsEnum.RACING;
        redParty.race = this;
        blueParty.race = this;
        RaceManager.RACE_MANAGER.add( this);
        RefreshUtil.refreshAllRacePage();
        MatcherManager.MATCHER_MANAGER.remove(redParty);
        MatcherManager.MATCHER_MANAGER.remove(blueParty);
        for (Gamer g:redParty.memberList){
            g.stats=GamerStatsEnum.RACING;
            g.playingRace = this;
        }for (Gamer g:blueParty.memberList){
            g.stats=GamerStatsEnum.RACING;
            g.playingRace = this;
        }



        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
        }
        locationHandleBefore();
        gameModeHandleBefore();


        if (mapMeta.isIsolateFood()){
            foodLevelHandleBefore();
        }
        if (mapMeta.isIsolateExperience()){
            expHandleBefore();
            levelHandleBefore();
        }if (mapMeta.isIsolatePotionEffect()){
            potionEffectHandleBefore();
        }if (mapMeta.isIsolateHealth() ){
            heathHandleBefore();
        }if (mapMeta.isIsolateInventory()){
            inventoryHandleBefore();
        }if (mapMeta.isIsolateFly()){
            flyHandleBefore();
        }


        startChooseKit();
    }

    @Nullable
    public Party getWinner() {
        return winner;
    }

    public void afterStop() throws FailureTeleportException, FailureUnloadWorldException, FailureDeleteFileException {
        if (!stats.equals(RaceStatsEnum.CELEBRATING)){
            throw new IllegalRaceStatsException("Race is not ending");
        }
        for (Gamer g:redParty.memberList){
            g.stats=GamerStatsEnum.READING;
        }for (Gamer g:blueParty.memberList){
            g.stats=GamerStatsEnum.READING;
        }
        redParty.race = null;
        blueParty.race = null;
        redParty.stats = PartyStatsEnum.FREEING;
        blueParty.stats = PartyStatsEnum.FREEING;
        for (Gamer g : redParty.memberList) {
            g.playingRace = null;
        }
        for (Gamer g : blueParty.memberList) {
            g.playingRace = null;
        }
        for (Gamer g : redParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
        }
        for (Gamer g : blueParty.memberList) {
            Player p = g.getPlayer();
            if (p.isDead()) {
                p.spigot().respawn();
            }
        }
        locationHandleAfter();
        if (mapMeta.isIsolateInventory()){
            inventoryHandleAfter();
        }
        if (mapMeta.isIsolateHealth() ){
            heathHandlerAfter();
        }
        if (mapMeta.isIsolatePotionEffect()){
            potionEffectHandleAfter();
        }
        if (mapMeta.isIsolateExperience()){
            levelHandleAfter();
            expHandleAfter();
        }
        if (mapMeta.isIsolateFood()){
            foodLevelHandleAfter();
        }
        if (mapMeta.isIsolateFly()){
            flyHandleAfter();
        }




        gameModeHandleAfter();

        //?????????
        for (int i=0;i<watcher.size();i++){
            Gamer g=watcher.get(i);
            Player p= g.getPlayer();
            //????????????
            p.setGameMode(this.watcherGameModeBefore.get(g));
            p.teleport(this.watcherLocationBefore.get(g));
            this.watcherGameModeBefore.remove(g);
            this.watcherLocationBefore.remove(g);
            this.watcher.remove(g);
            g.stats=GamerStatsEnum.FREEING;
            g.watchingRace=null;

        }



        destroyWorld();
    }

    /**
     * ?????????????????????????????????????????????
     * @exception IllegalRaceStatsException ????????????racing
     */
    public void stop()  {
        if (!stats.equals(RaceStatsEnum.RACING)){
            throw new IllegalRaceStatsException("Race is not racing");
        }
        stats=RaceStatsEnum.CELEBRATING;
        RaceManager.RACE_MANAGER.remove(this);
        RefreshUtil.refreshAllRacePage();
        for (Gamer g:redParty.memberList){
            g.stats=GamerStatsEnum.CELEBRATING;
        }for (Gamer g:blueParty.memberList){
            g.stats=GamerStatsEnum.CELEBRATING;
        }
        redParty.stats = PartyStatsEnum.CELEBRATING;
        blueParty.stats = PartyStatsEnum.CELEBRATING;

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

    }

    @Nullable
    public Party getLoser() {
        return loser;
    }

    private void destroyWorld() throws FailureUnloadWorldException, FailureDeleteFileException {

        //????????????
        for (Player p:world.getPlayers()){
            if (p.isDead()){
                p.spigot().respawn();
            }
            p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        }

        //????????????
        if (!Bukkit.unloadWorld(this.world, false)) {
            throw new FailureUnloadWorldException("??cCouldn't unload an race world");
        } else {

            ResourceUtil.deleteFile(world.getWorldFolder());

        }
    }



    @NotNull
    public Party getRedParty() {
        return redParty;
    }
    @NotNull
    public Party getBlueParty() {
        return blueParty;
    }

    public boolean isInMap(@NotNull Gamer g){
        if (g==null){throw new NullPointerException();}
       return LocationUtil.blockIsIn(firstLoc,secondLoc,g.getPlayer().getLocation());
    }


    @NotNull
    public List<Gamer> getRedAlive() {
        return new ArrayList<>(redAlive);
    }
    @NotNull
    public List<Gamer> getBlueAlive() {
        return new ArrayList<>(blueAlive);
    }
    @NotNull
    public HashMap<KitMeta, List<KitItemStackMeta>> getKitItemMap() {
        return new HashMap<>(kitItemMap);
    }

    @Nullable
    public World getWorld() {
        return world;
    }
    public void sendTitleToAll(@Nullable String title,@Nullable String subtitle){
     List<Gamer> gamerList=new ArrayList<>();
     gamerList.addAll(redParty.getMemberList());
        gamerList.addAll(blueParty.getMemberList());
        for (Gamer g:gamerList){
            MessageUtil.sendTitleTo(g.getPlayer(),title,subtitle);
        }
    }
}
