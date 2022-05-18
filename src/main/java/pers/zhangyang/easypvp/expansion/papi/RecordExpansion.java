package pers.zhangyang.easypvp.expansion.papi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;

import java.sql.SQLException;

public class RecordExpansion extends PlaceholderExpansion {
    public static final RecordExpansion recordExpansion=new RecordExpansion();

    private RecordExpansion(){}

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {

        RecordMeta recordMeta;
        try {
            RaceService raceService= (RaceService) InvocationUtil.getService(new RaceServiceImpl());
            recordMeta=raceService.getRecordMetaList(player.getUniqueId().toString());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        if (params.equalsIgnoreCase("amount_win")){

            return recordMeta==null?"0":String.valueOf(recordMeta.getWin());

        }else   if (params.equalsIgnoreCase("amount_lose")){

            return recordMeta==null?"0":String.valueOf(recordMeta.getLose());
        }else   if (params.equalsIgnoreCase("amount_draw")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getDraw());

        }else   if (params.equalsIgnoreCase("amount_all")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getAll());
        }
        return null;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "EasyPvp";
    }

    @Override
    public @NotNull String getAuthor() {
        return "ZhangYang";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }


}
