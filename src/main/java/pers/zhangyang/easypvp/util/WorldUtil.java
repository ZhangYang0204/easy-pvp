package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.generator.ChunkGenerator;
import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easypvp.exception.FailureCreateWorldException;

import javax.annotation.Nonnull;
import java.util.Random;

public class WorldUtil {
    public static World getVoidWorld(@Nonnull String worldName) throws FailureCreateWorldException {

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
        World world=worldCreator.createWorld();
        if (world==null){
            throw new FailureCreateWorldException();
        }return world;
    }
}
