package pers.zhangyang.easypvp.meta;

import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BlockMeta  {

    public BlockMeta clone(){
        BlockMeta blockMeta=new BlockMeta();
        blockMeta.setData(this.data);
        blockMeta.setX(this.x);
        blockMeta.setY(this.y);
        blockMeta.setZ(this.z);
        blockMeta.setMapUuid(this.mapUuid);
        return blockMeta;
    }

    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockMeta blockMeta = (BlockMeta) o;
        return x == blockMeta.x && y == blockMeta.y && z == blockMeta.z && Objects.equals(data, blockMeta.data) && Objects.equals(mapUuid, blockMeta.mapUuid);
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
