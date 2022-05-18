package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import pers.zhangyang.easypvp.domain.Gamer;
import pers.zhangyang.easypvp.domain.Party;
import pers.zhangyang.easypvp.domain.Race;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.meta.RecordMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    @Nonnull
    //返回第x页的内容,
    public static List<Party> pageParty(int pageIndex, int capacity, @Nonnull List<Party> partyList){
        if (partyList==null){throw new NullPointerException();}
        List<Party> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (partyList.size()<=i){break;}
            rl.add(partyList.get(i));
        }

        return rl;
    }@Nonnull
    public static List<Gamer> pageGamer(int pageIndex, int capacity,@Nonnull  List<Gamer> gamerList){
        if (gamerList==null){throw new NullPointerException();}
        List<Gamer> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (gamerList.size()<=i){break;}
            rl.add(gamerList.get(i));
        }
        return rl;
    }@Nonnull
    public static List<MapMeta> pageMapMeta(int pageIndex, int capacity, @Nonnull List<MapMeta> mapMetaList){
        if (mapMetaList==null){throw new NullPointerException();}
        List<MapMeta> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (mapMetaList.size()<=i){break;}
            rl.add(mapMetaList.get(i));
        }
        return rl;
    }@Nonnull
    public static List<KitMeta> pageKitMeta(int pageIndex, int capacity,@Nonnull  List<KitMeta> kitMetaList){
        if (kitMetaList==null){throw new NullPointerException();}
        List<KitMeta> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (kitMetaList.size()<=i){break;}
            rl.add(kitMetaList.get(i));
        }
        return rl;
    }@Nonnull
    public static List<RecordMeta> pageRecordMeta(int pageIndex, int capacity,@Nonnull  List<RecordMeta> recordMetaList){
        if (recordMetaList==null){throw new NullPointerException();}
        List<RecordMeta> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (recordMetaList.size()<=i){break;}
            rl.add(recordMetaList.get(i));
        }
        return rl;
    }
    @Nonnull
    public static List<Race> pageRace(int pageIndex, int capacity,@Nonnull  List<Race> raceList){
        if (raceList==null){throw new NullPointerException();}
        List<Race> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (raceList.size()<=i){break;}
            rl.add(raceList.get(i));
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
