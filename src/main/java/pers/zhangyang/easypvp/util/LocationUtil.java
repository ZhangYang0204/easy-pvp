package pers.zhangyang.easypvp.util;

import org.bukkit.Location;

import javax.annotation.Nonnull;

public class LocationUtil {
    public static boolean isSameWorld(@Nonnull Location location1, @Nonnull Location location2){
        if (location1==null||location2==null){
            throw new IllegalArgumentException();
        }
        if (location1.getWorld()==null||location2.getWorld()==null){
            return false;
        }
        if (location1.getWorld().getUID().equals(location2.getWorld().getUID())){
            return true;
        }else {
            return false;
        }
    }



    //按方块
    public static boolean blockIsIn(@Nonnull Location corner1, @Nonnull Location corner2,@Nonnull Location target){

        if (corner1==null||corner2==null||target==null){
            throw new IllegalArgumentException();
        }

        if (!isSameWorld(corner1,corner2)
                ||!isSameWorld(corner1,target)
                ||!isSameWorld(corner2,target)){
            return false;
        }
        int corner1X=corner1.getBlockX();
        int corner1Y=corner1.getBlockY();
        int corner1Z=corner1.getBlockZ();
        int corner2X=corner2.getBlockX();
        int corner2Y=corner2.getBlockY();
        int corner2Z=corner2.getBlockZ();
        int targetX=target.getBlockX();
        int targetY=target.getBlockY();
        int targetZ=target.getBlockZ();

        if (targetX>=Math.min(corner1X,corner2X)&&targetX<=Math.max(corner1X,corner2X)
                &&targetY>=Math.min(corner1Y,corner2Y)&&targetY<=Math.max(corner1Y,corner2Y)
                &&targetZ>=Math.min(corner1Z,corner2Z)&&targetZ<=Math.max(corner1Z,corner2Z)){
            return true;
        }

        return false;

    }
}
