package pers.zhangyang.easypvp.util;

import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.meta.RecordMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PageUtil {


    //返回第x页的内容,
    public static List<Party> pageParty(int pageIndex, int capacity, List<Party> partyList){
        List<Party> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (partyList.size()<=i){break;}
            rl.add(partyList.get(i));
        }

        return rl;
    }
    public static List<Gamer> pageGamer(int pageIndex, int capacity, List<Gamer> gamerList){
        List<Gamer> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (gamerList.size()<=i){break;}
            rl.add(gamerList.get(i));
        }
        return rl;
    }
    public static List<MapMeta> pageMapMeta(int pageIndex, int capacity, List<MapMeta> mapMetaList){
        List<MapMeta> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (mapMetaList.size()<=i){break;}
            rl.add(mapMetaList.get(i));
        }
        return rl;
    }
    public static List<KitMeta> pageKitMeta(int pageIndex, int capacity, List<KitMeta> kitMetaList){
        List<KitMeta> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (kitMetaList.size()<=i){break;}
            rl.add(kitMetaList.get(i));
        }
        return rl;
    }
    public static List<RecordMeta> pageRecordMeta(int pageIndex, int capacity, List<RecordMeta> recordMetaList){
        List<RecordMeta> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (recordMetaList.size()<=i){break;}
            rl.add(recordMetaList.get(i));
        }
        return rl;
    }
    //由所有物品数量和每页能容纳的物品数量，计算出最后一页的下标 最少为0
    public static int computeMaxPageIndex(int allItemSlotAmount,int capacity){
        int maxPage=0;
        if (allItemSlotAmount!=0)
            maxPage=(allItemSlotAmount%capacity==0?allItemSlotAmount/capacity-1:allItemSlotAmount/capacity);
        return maxPage;
    }
}
