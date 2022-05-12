package pers.zhangyang.easypvp.manager;

import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;

import java.util.HashMap;

public class RaceManager {
    public static final RaceManager RACE_MANAGER =new RaceManager();
    private RaceManager(){
        partyGamerMap=new HashMap<>();
    }


    private final HashMap<Party,Race> partyGamerMap;

    public Race getRace(Party party){
        if (!partyGamerMap.containsKey(party)){
            return null;
        }
        return partyGamerMap.get(party);
    }

    public HashMap<Party, Race> getPartyGamerMap() {
        return new HashMap<>(partyGamerMap);
    }
    public void put(Party party, Race race){
        partyGamerMap.put(party,race);
    }
    public void remove(Party party){
        partyGamerMap.remove(party);
    }

}
