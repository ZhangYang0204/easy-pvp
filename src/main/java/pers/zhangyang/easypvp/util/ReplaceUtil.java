package pers.zhangyang.easypvp.util;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceUtil {

    //吧list中pattern的换成replaceTo
    public static void format(@Nonnull List<String> list, @Nonnull String pattern,@Nullable List<String> replaceTo){
        if (list==null||pattern==null){throw new NullPointerException();}

        for (int i=0;i<list.size();i++){
            String s=list.get(i);
            if (s.contains(pattern)){
                list.remove(i);
                if (replaceTo!=null) {
                    for (int j = replaceTo.size() - 1; j >= 0; j--) {
                        list.add(i, ReplaceUtil.replace(s, Collections.singletonMap(pattern, replaceTo.get(j))));
                    }
                }

            }

        }
    }
    @Nonnull
    public static String replace( @Nonnull String s,  @Nonnull  Map<String,String> rep){
        if (s==null||rep==null){throw new NullPointerException();}

            for (String key : rep.keySet()) {
                s = s.replace(key, rep.get(key));
            }

        return s;
    }

    public static void replace(@Nonnull List<String> s,@Nonnull  Map<String,String> rep){

        if (s==null||rep==null){throw new NullPointerException();}
        if (s!=null){
        for (String key:rep.keySet()){
            for (int i=0;i<s.size();i++){
                s.set(i,s.get(i).replace(key,rep.get(key)));
            }
        }
        }
    }


}

