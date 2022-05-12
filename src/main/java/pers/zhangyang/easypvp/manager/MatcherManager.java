package pers.zhangyang.easypvp.manager;

import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Matcher;
import pers.zhangyang.easypvp.meta.MapMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MatcherManager {
    public static final MatcherManager MATCHER_MANAGER =new MatcherManager();
    private MatcherManager(){
        matcherList =new ArrayList<>();
    }

    private final List<Matcher> matcherList;



    public List<Matcher> getSpecificMatcherList() {
        return matcherList;
    }


    /**
     * 仅返回匹配的matcher
     * 不会匹配到自己队伍
     * @param matcher
     * @return
     */
    @Nullable
    public Matcher matchMatcher(Matcher matcher){
        for (int i=0;i<matcherList.size();i++){
            if (matcher.getParty().equals(matcherList.get(i).getParty())){continue;}
            MapMeta ma=matcher.getMapMeta();
            MapMeta ta=matcherList.get(i).getMapMeta();
            if (ma==null||ta==null){
                if (matcher.getParty().getMemberList().size()==matcherList.get(i).getParty().getMemberList().size()) {
                    return matcherList.get(i);
                }
            }else {
                if (ma.getUuid().equals(ta.getUuid())){
                    return matcherList.get(i);
                }
            }
        }
        return null;
    }

    /**
     * 返回第一个该队伍对应的matcher
     * @param party
     * @return
     */
    @Nullable
    public Matcher getMatcher(Party party){
        for (int i = 0; i< matcherList.size(); i++){
            if (matcherList.get(i).getParty().equals(party)){

                return matcherList.get(i);
            }
        }
        return null;
    }

    public boolean contains(Party party){
        for (int i = 0; i< matcherList.size(); i++){
            if (matcherList.get(i).getParty().equals(party)){
                return true;
            }
        }
        return false;
    }

    public void add(Matcher matcher){
        matcherList.add(matcher);
    }


    public void remove(Party party){
        for (int i = 0; i< matcherList.size(); i++){
            if (matcherList.get(i).getParty().equals(party)){
                matcherList.remove(i);
            }
        }
    }
}
