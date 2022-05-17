package pers.zhangyang.easypvp.manager;

import pers.zhangyang.easypvp.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    public static final RaceManager RACE_MANAGER =new RaceManager();
    private RaceManager(){
        raceList=new ArrayList<>();
    }



    private final List<Race> raceList;


    public List<Race> getRaceList() {
        return new ArrayList<>(raceList);
    }


    public void add(Race race){
        raceList.add(race);
    }
    public void remove(Race race){
        raceList.remove(race);
    }


}
