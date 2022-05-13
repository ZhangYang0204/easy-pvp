package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class MapBlockMeta {

    public MapBlockMeta clone(){
        MapBlockMeta mapBlockMeta =new MapBlockMeta();
        mapBlockMeta.setData(this.data);
        mapBlockMeta.setX(this.x);
        mapBlockMeta.setY(this.y);
        mapBlockMeta.setZ(this.z);
        mapBlockMeta.setMapUuid(this.mapUuid);
        return mapBlockMeta;
    }

    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapBlockMeta mapBlockMeta = (MapBlockMeta) o;
        return x == mapBlockMeta.x && y == mapBlockMeta.y && z == mapBlockMeta.z && Objects.equals(data, mapBlockMeta.data) && Objects.equals(mapUuid, mapBlockMeta.mapUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, mapUuid, x, y, z);
    }

    private String mapUuid;


    private int x;
    private int y;
    private int z;


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
}
