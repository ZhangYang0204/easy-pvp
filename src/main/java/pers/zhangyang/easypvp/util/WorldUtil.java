package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.generator.ChunkGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class WorldUtil {
    public static World getVoidWorld(String worldName){

        WorldCreator worldCreator = new WorldCreator(worldName);


        if (MinecraftVersionUtil.getBigVersion()==1&&MinecraftVersionUtil.getMiddleVersion()<13){
            worldCreator.type(WorldType.FLAT);
            worldCreator.generatorSettings("2;0;1;"); //This is what makes the world empty (void)
            worldCreator.createWorld();
        }else {
            worldCreator.generator(

                    new ChunkGenerator() {
                    });
        }

        return worldCreator.createWorld();
    }
}
