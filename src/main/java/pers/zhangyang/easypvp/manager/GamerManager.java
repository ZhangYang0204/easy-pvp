package pers.zhangyang.easypvp.manager;

import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.domain.Gamer;

import java.util.HashMap;

public class GamerManager {
    public static final GamerManager GAMER_MANAGER =new GamerManager();
    private GamerManager(){
        playerGamerMap=new HashMap<>();
    }


    private final HashMap<Player, Gamer> playerGamerMap;

    public Gamer getGamer(Player player){
        if (!playerGamerMap.containsKey(player)){
            playerGamerMap.put(player,new Gamer(player));
        }
        return playerGamerMap.get(player);
    }


    public void remove(Player player){
        playerGamerMap.remove(player);
    }

}
