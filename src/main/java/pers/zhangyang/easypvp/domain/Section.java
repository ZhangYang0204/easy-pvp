package pers.zhangyang.easypvp.domain;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.util.LocationUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Section {
    private Location first;
    private Location second;
    private Location red;
    private Location blue;
    private final Player player;

    public Section(@NotNull Player player) {
        if (player==null){throw new NullPointerException();}
        this.player = player;
    }
    public boolean isFour(){
        return red != null && blue != null && first != null && second != null;
    }

    public boolean isValid(){
        return LocationUtil.blockIsIn(first, second, red) && LocationUtil.blockIsIn(first, second, blue);
    }

    @Nullable
    public Location getFirst() {
        return first;
    }

    public void setFirst(Location first) {
        this.first = first;
    }

    @Nullable
    public Location getSecond() {
        return second;
    }

    public void setSecond(Location second) {
        this.second = second;
    }

    @Nullable
    public Location getRed() {
        return red;
    }

    public void setRed(Location red) {
        this.red = red;
    }

    @Nullable
    public Location getBlue() {
        return blue;
    }

    public void setBlue(Location blue) {
        this.blue = blue;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

}
