package pers.zhangyang.easypvp.util;

import java.util.UUID;

public class UuidUtil {

    public static String getUUID(){
            return UUID.randomUUID().toString().replaceAll("-","");
        }




}
