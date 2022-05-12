package pers.zhangyang.easypvp.domain;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.util.LocationUtil;


public class Section {
    private Location first;
    private Location second;
    private Location red;
    private Location blue;
    private Player player;

    public Section(Player player) {
        this.player = player;
    }
    public boolean isFour(){
        return red != null && blue != null && first != null && second != null;
    }

    public boolean isValid(){
        return LocationUtil.blockIsIn(first, second, red) && LocationUtil.blockIsIn(first, second, blue);
    }

    public Location getFirst() {
        return first;
    }

    public void setFirst(Location first) {
        this.first = first;
    }

    public Location getSecond() {
        return second;
    }

    public void setSecond(Location second) {
        this.second = second;
    }

    public Location getRed() {
        return red;
    }

    public void setRed(Location red) {
        this.red = red;
    }

    public Location getBlue() {
        return blue;
    }

    public void setBlue(Location blue) {
        this.blue = blue;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
