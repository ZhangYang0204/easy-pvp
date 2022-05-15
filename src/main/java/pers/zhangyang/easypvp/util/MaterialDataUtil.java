package pers.zhangyang.easypvp.util;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class MaterialDataUtil {
    public static MaterialData deserializeMaterialData(String data){
     return new MaterialData(Material.matchMaterial(data.split(",")[0]),Byte.parseByte(data.split(",")[1]));
    }
    public static String serializeMaterialData(MaterialData materialData){
        return materialData.getItemType().name()+","+materialData.getData();
    }
}
