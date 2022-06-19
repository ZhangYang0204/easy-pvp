package pers.zhangyang.easypvp.util;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ReplaceUtil {

    //吧list中pattern的换成replaceTo
    public static void format(@NotNull List<String> list, @NotNull String pattern, @Nullable List<String> replaceTo) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains(pattern)) {
                integerList.add(i);
            }
        }
        for (int i = integerList.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            list.remove(i);
            if (replaceTo != null) {
                for (int j = replaceTo.size() - 1; j >= 0; j--) {
                    list.add(i, ReplaceUtil.replace(s, Collections.singletonMap(pattern, replaceTo.get(j))));
                }
            }
        }
    }

    @NotNull
    public static String replace(@NotNull String s, @NotNull Map<String, String> rep) {
        for (String key : rep.keySet()) {
            s = s.replace(key, rep.get(key));
        }
        return s;
    }

    public static void replace(@NotNull List<String> s, @NotNull Map<String, String> rep) {
        for (String key : rep.keySet()) {
            for (int i = 0; i < s.size(); i++) {
                s.set(i, s.get(i).replace(key, rep.get(key)));
            }
        }
    }

}

