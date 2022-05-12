package pers.zhangyang.easypvp.manager;

import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;

import java.util.ArrayList;
import java.util.List;

public class PartyManager {
    public static final PartyManager PARTY_MANAGER =new PartyManager();
    private PartyManager(){
        partyList =new ArrayList<>();
    }


    private final List<Party> partyList;



    public List<Party> getPartyList() {
        return new ArrayList<>(partyList);
    }

    public void add(Party party){
        partyList.add(party);
    }

    public void remove(Party party){
        partyList.remove(party);
    }

}
