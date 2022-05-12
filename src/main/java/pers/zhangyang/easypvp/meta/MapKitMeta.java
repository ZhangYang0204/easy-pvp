package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class MapKitMeta {
    private String mapUuid;
    private String kitUuid;

    public String getMapUuid() {

        return mapUuid;
    }

    public MapKitMeta clone(){
        MapKitMeta mapKitMeta=new MapKitMeta();
        mapKitMeta.setKitUuid(this.kitUuid);
        mapKitMeta.setMapUuid(this.mapUuid);
        return mapKitMeta;
    }

    public void setMapUuid(String mapUuid) {
        this.mapUuid = mapUuid;
    }

    public String getKitUuid() {
        return kitUuid;
    }

    public void setKitUuid(String kitUuid) {
        this.kitUuid = kitUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapKitMeta that = (MapKitMeta) o;
        return Objects.equals(mapUuid, that.mapUuid) && Objects.equals(kitUuid, that.kitUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapUuid, kitUuid);
    }
}
