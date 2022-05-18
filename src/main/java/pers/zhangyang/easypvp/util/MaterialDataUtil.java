package pers.zhangyang.easypvp.util;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

import javax.annotation.Nonnull;

public class MaterialDataUtil {

    @Nonnull
    public static MaterialData deserializeMaterialData(@Nonnull String data){
        if (data==null){throw new NullPointerException();}
        Material material=Material.matchMaterial(data.split(",")[0]);
        try {
            Byte.valueOf(data.split(",")[1]);

        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if (material==null){throw new IllegalArgumentException();}
     return new MaterialData(material,Byte.valueOf(data.split(",")[1]));
    }

    @Nonnull
    public static String serializeMaterialData(@Nonnull MaterialData materialData){
        if (materialData==null){throw new NullPointerException();}
        return materialData.getItemType().name()+","+materialData.getData();
    }
}
