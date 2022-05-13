package pers.zhangyang.easypvp.meta;


import java.util.Objects;

public class MapContainerInventoryItemStackMeta {
    private String data;
    private String mapUuid;
    private int x;
    private int y;
    private int z;
    private int slot;


    public MapContainerInventoryItemStackMeta clone(){
        MapContainerInventoryItemStackMeta meta=new MapContainerInventoryItemStackMeta();
        meta.setData(this.data);
        meta.setMapUuid(this.mapUuid);
        meta.setX(this.x);
        meta.setY(this.y);
        meta.setZ(this.z);
        meta.setSlot(this.slot);
        return meta;

    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapContainerInventoryItemStackMeta that = (MapContainerInventoryItemStackMeta) o;
        return x == that.x && y == that.y && z == that.z && slot == that.slot && Objects.equals(data, that.data) && Objects.equals(mapUuid, that.mapUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, mapUuid, x, y, z, slot);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMapUuid() {
        return mapUuid;
    }

    public void setMapUuid(String mapUuid) {
        this.mapUuid = mapUuid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
