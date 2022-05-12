package pers.zhangyang.easypvp.manager;

import org.bukkit.entity.Player;
import pers.zhangyang.easypvp.domain.Section;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SectionManager {
    public static final SectionManager SECTION_MANAGER =new SectionManager();


    private final HashMap<Player, Section> playerSectionHashMap;

    private SectionManager(){
        playerSectionHashMap=new HashMap<>();
    }

    @Nonnull
    public Section getPlayerSection(Player player){
        if (!playerSectionHashMap.containsKey(player)){
            playerSectionHashMap.put(player,new Section(player));
        }
        return playerSectionHashMap.get(player);
    }



}
