package pers.zhangyang.easypvp.expansion.papi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.RaceService;
import pers.zhangyang.easypvp.service.impl.RaceServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.yaml.DanYaml;

import java.sql.SQLException;
import java.util.Iterator;

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

        if (params.equalsIgnoreCase("amount_total_win")){

            return recordMeta==null?"0":String.valueOf(recordMeta.getTotalWin());

        }else   if (params.equalsIgnoreCase("amount_total_lose")){

            return recordMeta==null?"0":String.valueOf(recordMeta.getTotalLose());
        }else   if (params.equalsIgnoreCase("amount_total_draw")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getTotalDraw());

        }else   if (params.equalsIgnoreCase("amount_total_all")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getTotalAll());
        }else   if (params.equalsIgnoreCase("amount_season_all")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getSeasonAll());
        }else   if (params.equalsIgnoreCase("amount_season_win")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getSeasonWin());
        }else   if (params.equalsIgnoreCase("amount_season_lose")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getSeasonLose());
        }else   if (params.equalsIgnoreCase("amount_season_draw")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getSeasonDraw());
        }else   if (params.equalsIgnoreCase("amount_season_star")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getSeasonStar());
        }else   if (params.equalsIgnoreCase("amount_season_streak")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getSeasonStreak());
        }else   if (params.equalsIgnoreCase("amount_total_streak")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getTotalStreak());
        }else   if (params.equalsIgnoreCase("amount_cumulative_star")) {

            return recordMeta==null?"0":String.valueOf(recordMeta.getCumulativeStar());
        }

        else   if (params.equalsIgnoreCase("dan")) {
            String dan=null;
            Iterator<Integer> it=DanYaml.SETTING_YAML_MANAGER.getSECTION().keySet().stream().sorted().iterator();
            while (it.hasNext()){
                Integer iii=it.next();
                if (recordMeta.getSeasonStar()>=iii){
                    dan=DanYaml.SETTING_YAML_MANAGER.getSECTION().get(iii);
                }
            }

            return dan;
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
