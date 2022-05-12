package pers.zhangyang.easypvp.util;

import org.bukkit.Bukkit;
import pers.zhangyang.easypvp.domain.Party;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {


    public static List<Party> page(int pageIndex,int capacity,List<Party> partyList){
        List<Party> rl=new ArrayList<>();
        for (int i=pageIndex*capacity;i<pageIndex*capacity+capacity;i++){
            if (partyList.size()<=i){break;}
            rl.add(partyList.get(i));
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
