package pers.zhangyang.easypvp.util;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class BlockUtil {

    public static String serializeBlockMaterialData(MaterialData materialData){
        String materialName=materialData.getItemType().name();
        String dt= String.valueOf(materialData.getData());
        String r=materialName+","+dt;
        return r;
    }
    public static MaterialData deserializeBlockMaterialData(String data){
        String typeName=data.split(",")[0];
        String dt=data.split(",")[1];
        return new MaterialData(Material.valueOf(typeName),Byte.valueOf(dt));
    }

}
