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
    private int RedPointX;
    private int RedPointY;
    private int RedPointZ;
    private int BluePointX;
    private int BluePointY;
    private int BluePointZ;
    private boolean build;
    private int scale;
    private long chooseTick;

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
        mapMeta.setRedPointX(RedPointX);
        mapMeta.setRedPointY(RedPointY);
        mapMeta.setRedPointZ(RedPointZ);
        mapMeta.setBluePointX(BluePointX);
        mapMeta.setBluePointY(BluePointY);
        mapMeta.setBluePointZ(BluePointZ);
        mapMeta.setBuild(build);
        mapMeta.setScale(scale);
        mapMeta.setChooseTick(chooseTick);
        mapMeta.setDescription(this.description);
        mapMeta.setDrop(drop);
        mapMeta.setFair(fair);
        return mapMeta;

    }


    public void setChooseTick(long chooseTick) {
        this.chooseTick = chooseTick;
    }

    public long getChooseTick() {
        return chooseTick;
    }

    private String description;

    private boolean drop;

    public boolean isDrop() {
        return drop;
    }

    public void setDrop(boolean drop) {
        this.drop = drop;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private boolean fair;

    public boolean isFair() {
        return fair;
    }

    public void setFair(boolean fair) {
        this.fair = fair;
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
        return RedPointX;
    }

    public void setRedPointX(int RedPointX) {
        this.RedPointX = RedPointX;
    }

    public int getRedPointY() {
        return RedPointY;
    }

    public void setRedPointY(int RedPointY) {
        this.RedPointY = RedPointY;
    }

    public int getRedPointZ() {
        return RedPointZ;
    }

    public void setRedPointZ(int RedPointZ) {
        this.RedPointZ = RedPointZ;
    }

    public int getBluePointX() {
        return BluePointX;
    }

    public void setBluePointX(int BluePointX) {
        this.BluePointX = BluePointX;
    }

    public int getBluePointY() {
        return BluePointY;
    }

    public void setBluePointY(int BluePointY) {
        this.BluePointY = BluePointY;
    }

    public int getBluePointZ() {
        return BluePointZ;
    }

    public void setBluePointZ(int BluePointZ) {
        this.BluePointZ = BluePointZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapMeta mapMeta = (MapMeta) o;
        return firstPointX == mapMeta.firstPointX && firstPointY == mapMeta.firstPointY && firstPointZ == mapMeta.firstPointZ && secondPointX == mapMeta.secondPointX && secondPointY == mapMeta.secondPointY && secondPointZ == mapMeta.secondPointZ && RedPointX == mapMeta.RedPointX && RedPointY == mapMeta.RedPointY && RedPointZ == mapMeta.RedPointZ && BluePointX == mapMeta.BluePointX && BluePointY == mapMeta.BluePointY && BluePointZ == mapMeta.BluePointZ && build == mapMeta.build && scale == mapMeta.scale && chooseTick == mapMeta.chooseTick && drop == mapMeta.drop && fair == mapMeta.fair && Objects.equals(uuid, mapMeta.uuid) && Objects.equals(name, mapMeta.name) && Objects.equals(description, mapMeta.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, firstPointX, firstPointY, firstPointZ, secondPointX, secondPointY, secondPointZ, RedPointX, RedPointY, RedPointZ, BluePointX, BluePointY, BluePointZ, build, scale, chooseTick, description, drop, fair);
    }
}
