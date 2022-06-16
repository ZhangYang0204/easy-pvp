package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class MapMeta {
    private String uuid;
    private String name;
    private int firstPointX;
    private int firstPointY;
    private int firstPointZ;
    private int secondPointX;
    private int secondPointY;
    private int secondPointZ;
    private int redPointX;
    private int redPointY;
    private int redPointZ;
    private int bluePointX;
    private int bluePointY;
    private int bluePointZ;
    private boolean build;
    private int scale;
    private int chooseKitTime;
    private boolean keepExperience;
    private float redPointPitch;
    private float redPointYaw;
    private float bluePointPitch;
    private float bluePointYaw;
    private boolean forbiddenEnderChest;
    private int raceStartReadyTime;
    private int redSpawnInterval;
    private int blueSpawnInterval;
    private boolean ignorePartyDamage;
    private int celebrateTime;
    private int raceTime;
    private boolean  isolateExperience;
    private boolean   isolateFood;
    private boolean   isolateHealth;
    private boolean   isolatePotionEffect;
    private boolean   isolateInventory;
    private boolean   isolateFly;
    private String description;
    private boolean keepInventory;

    public float getRedPointPitch() {
        return redPointPitch;
    }

    public void setRedPointPitch(float redPointPitch) {
        this.redPointPitch = redPointPitch;
    }

    public float getRedPointYaw() {
        return redPointYaw;
    }

    public void setRedPointYaw(float redPointYaw) {
        this.redPointYaw = redPointYaw;
    }

    public float getBluePointPitch() {
        return bluePointPitch;
    }

    public void setBluePointPitch(float bluePointPitch) {
        this.bluePointPitch = bluePointPitch;
    }

    public float getBluePointYaw() {
        return bluePointYaw;
    }

    public void setBluePointYaw(float bluePointYaw) {
        this.bluePointYaw = bluePointYaw;
    }

    public int getRedSpawnInterval() {
        return redSpawnInterval;
    }

    public void setRedSpawnInterval(int redSpawnInterval) {
        this.redSpawnInterval = redSpawnInterval;
    }

    public int getBlueSpawnInterval() {
        return blueSpawnInterval;
    }

    public void setBlueSpawnInterval(int blueSpawnInterval) {
        this.blueSpawnInterval = blueSpawnInterval;
    }

    public int getRaceStartReadyTime() {return raceStartReadyTime;}

    public void setRaceStartReadyTime(int raceStartReadyTime) {this.raceStartReadyTime = raceStartReadyTime;}

    public boolean isIgnorePartyDamage() {
        return ignorePartyDamage;
    }

    public void setIgnorePartyDamage(boolean ignorePartyDamage) {
        this.ignorePartyDamage = ignorePartyDamage;
    }

    public boolean isForbiddenEnderChest() {
        return forbiddenEnderChest;
    }

    public void setForbiddenEnderChest(boolean forbiddenEnderChest) {
        this.forbiddenEnderChest = forbiddenEnderChest;
    }

    public int getCelebrateTime() {
        return celebrateTime;
    }

    public void setCelebrateTime(int celebrateTime) {
        this.celebrateTime = celebrateTime;
    }

    public int getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(int raceTime) {
        this.raceTime = raceTime;
    }

    public void setIsolateExperience(boolean isolateExperience) {
        this.isolateExperience = isolateExperience;
    }

    public void setIsolateFood(boolean isolateFood) {
        this.isolateFood = isolateFood;
    }

    public void setIsolateHealth(boolean isolateHealth) {
        this.isolateHealth = isolateHealth;
    }

    public void setIsolatePotionEffect(boolean isolatePotionEffect) {
        this.isolatePotionEffect = isolatePotionEffect;
    }

    public void setIsolateInventory(boolean isolateInventory) {
        this.isolateInventory = isolateInventory;
    }

    public void setIsolateFly(boolean isolateFly) {
        this.isolateFly = isolateFly;
    }

    public boolean isIsolateExperience() {
        return isolateExperience;
    }

    public boolean isIsolateFood() {
        return isolateFood;
    }

    public boolean isIsolateHealth() {
        return isolateHealth;
    }

    public boolean isIsolatePotionEffect() {
        return isolatePotionEffect;
    }

    public boolean isIsolateInventory() {
        return isolateInventory;
    }

    public boolean isIsolateFly() {
        return isolateFly;
    }

    public boolean isKeepExperience() {
        return keepExperience;
    }

    public void setKeepExperience(boolean keepExperience) {
        this.keepExperience = keepExperience;
    }

    public MapMeta clone(){
        MapMeta mapMeta=new MapMeta();
        mapMeta.setUuid(this.uuid);
        mapMeta.setName(this.name);
        mapMeta.setFirstPointX(this.firstPointX);
        mapMeta.setFirstPointY(this.firstPointY);
        mapMeta.setFirstPointZ(this.firstPointZ);
        mapMeta.setSecondPointX(secondPointX);
        mapMeta.setSecondPointY(secondPointY);
        mapMeta.setSecondPointZ(secondPointZ);
        mapMeta.setRedPointX(redPointX);
        mapMeta.setRedPointY(redPointY);
        mapMeta.setRedPointZ(redPointZ);
        mapMeta.setBluePointX(bluePointX);
        mapMeta.setBluePointY(bluePointY);
        mapMeta.setBluePointZ(bluePointZ);
        mapMeta.setBuild(build);
        mapMeta.setScale(scale);
        mapMeta.setChooseKitTime(chooseKitTime);
        mapMeta.setDescription(description);
        mapMeta.setKeepInventory(keepInventory);
        mapMeta.setKeepExperience(keepExperience);
        mapMeta.setIsolateExperience(isolateExperience);
        mapMeta.setIsolateFood(isolateFood);
        mapMeta.setIsolateHealth(isolateHealth);
        mapMeta.setIsolateInventory(isolateInventory);
        mapMeta.setIsolatePotionEffect(isolatePotionEffect);
        mapMeta.setIsolateFly(isolateFly);
        mapMeta.setRedPointPitch(redPointPitch);
        mapMeta.setRedPointYaw(redPointYaw);
        mapMeta.setBluePointPitch(bluePointPitch);
        mapMeta.setBluePointYaw(bluePointYaw);
        mapMeta.setRedSpawnInterval(redSpawnInterval);
        mapMeta.setBlueSpawnInterval(blueSpawnInterval);
        mapMeta.setIgnorePartyDamage(ignorePartyDamage);
        mapMeta.setForbiddenEnderChest(forbiddenEnderChest);
        mapMeta.setCelebrateTime(celebrateTime);
        mapMeta.setRaceTime(raceTime);
        mapMeta.setRaceStartReadyTime(raceStartReadyTime);
        return mapMeta;

    }


    public void setChooseKitTime(int chooseKitTime) {
        this.chooseKitTime = chooseKitTime;
    }

    public int getChooseKitTime() {
        return chooseKitTime;
    }



    public boolean isKeepInventory() {
        return keepInventory;
    }

    public void setKeepInventory(boolean keepInventory) {
        this.keepInventory = keepInventory;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public boolean isBuild() {
        return build;
    }

    public void setBuild(boolean build) {
        this.build = build;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFirstPointX() {
        return firstPointX;
    }

    public void setFirstPointX(int firstPointX) {
        this.firstPointX = firstPointX;
    }

    public int getFirstPointY() {
        return firstPointY;
    }

    public void setFirstPointY(int firstPointY) {
        this.firstPointY = firstPointY;
    }

    public int getFirstPointZ() {
        return firstPointZ;
    }

    public void setFirstPointZ(int firstPointZ) {
        this.firstPointZ = firstPointZ;
    }

    public int getSecondPointX() {
        return secondPointX;
    }

    public void setSecondPointX(int secondPointX) {
        this.secondPointX = secondPointX;
    }

    public int getSecondPointY() {
        return secondPointY;
    }

    public void setSecondPointY(int secondPointY) {
        this.secondPointY = secondPointY;
    }

    public int getSecondPointZ() {
        return secondPointZ;
    }

    public void setSecondPointZ(int secondPointZ) {
        this.secondPointZ = secondPointZ;
    }

    public int getRedPointX() {
        return redPointX;
    }

    public void setRedPointX(int RedPointX) {
        this.redPointX = RedPointX;
    }

    public int getRedPointY() {
        return redPointY;
    }

    public void setRedPointY(int RedPointY) {
        this.redPointY = RedPointY;
    }

    public int getRedPointZ() {
        return redPointZ;
    }

    public void setRedPointZ(int RedPointZ) {
        this.redPointZ = RedPointZ;
    }

    public int getBluePointX() {
        return bluePointX;
    }

    public void setBluePointX(int BluePointX) {
        this.bluePointX = BluePointX;
    }

    public int getBluePointY() {
        return bluePointY;
    }

    public void setBluePointY(int BluePointY) {
        this.bluePointY = BluePointY;
    }

    public int getBluePointZ() {
        return bluePointZ;
    }

    public void setBluePointZ(int BluePointZ) {
        this.bluePointZ = BluePointZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapMeta mapMeta = (MapMeta) o;
        return firstPointX == mapMeta.firstPointX && firstPointY == mapMeta.firstPointY && firstPointZ == mapMeta.firstPointZ && secondPointX == mapMeta.secondPointX && secondPointY == mapMeta.secondPointY && secondPointZ == mapMeta.secondPointZ && redPointX == mapMeta.redPointX && redPointY == mapMeta.redPointY && redPointZ == mapMeta.redPointZ && bluePointX == mapMeta.bluePointX && bluePointY == mapMeta.bluePointY && bluePointZ == mapMeta.bluePointZ && build == mapMeta.build && scale == mapMeta.scale && chooseKitTime == mapMeta.chooseKitTime && keepExperience == mapMeta.keepExperience && Float.compare(mapMeta.redPointPitch, redPointPitch) == 0 && Float.compare(mapMeta.redPointYaw, redPointYaw) == 0 && Float.compare(mapMeta.bluePointPitch, bluePointPitch) == 0 && Float.compare(mapMeta.bluePointYaw, bluePointYaw) == 0 && redSpawnInterval == mapMeta.redSpawnInterval && blueSpawnInterval == mapMeta.blueSpawnInterval && raceStartReadyTime == mapMeta.raceStartReadyTime && ignorePartyDamage == mapMeta.ignorePartyDamage && forbiddenEnderChest == mapMeta.forbiddenEnderChest && celebrateTime == mapMeta.celebrateTime && raceTime == mapMeta.raceTime && isolateExperience == mapMeta.isolateExperience && isolateFood == mapMeta.isolateFood && isolateHealth == mapMeta.isolateHealth && isolatePotionEffect == mapMeta.isolatePotionEffect && isolateInventory == mapMeta.isolateInventory && isolateFly == mapMeta.isolateFly && keepInventory == mapMeta.keepInventory && Objects.equals(uuid, mapMeta.uuid) && Objects.equals(name, mapMeta.name) && Objects.equals(description, mapMeta.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, firstPointX, firstPointY, firstPointZ, secondPointX, secondPointY, secondPointZ, redPointX, redPointY, redPointZ, bluePointX, bluePointY, bluePointZ, build, scale, chooseKitTime, keepExperience, redPointPitch, redPointYaw, bluePointPitch, bluePointYaw, redSpawnInterval, blueSpawnInterval, raceStartReadyTime, ignorePartyDamage, forbiddenEnderChest, celebrateTime, raceTime, isolateExperience, isolateFood, isolateHealth, isolatePotionEffect, isolateInventory, isolateFly, description, keepInventory);
    }
}
