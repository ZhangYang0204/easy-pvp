package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class RecordMeta {
    private String playerUuid;
    private int seasonAll;
    private int seasonWin;
    private int seasonLose;
    private int seasonDraw;
    private int seasonStar;
    private int totalAll;
    private int totalWin;
    private int totalLose;
    private int totalDraw;
    private int totalStreak;

    public int getTotalStreak() {
        return totalStreak;
    }



    public RecordMeta clone(){
        RecordMeta recordMeta=new RecordMeta();
        recordMeta.setPlayerUuid(this.playerUuid);
        recordMeta.setSeasonLose(this.seasonLose);
        recordMeta.setSeasonWin(this.seasonWin);
        recordMeta.setSeasonDraw(this.seasonDraw);
        recordMeta.setSeasonAll(this.seasonAll);
        recordMeta.setSeasonStar(this.seasonStar);
        recordMeta.setTotalLose(this.totalLose);
        recordMeta.setTotalWin(this.totalWin);
        recordMeta.setTotalDraw(this.totalDraw);
        recordMeta.setTotalAll(this.totalAll);

        recordMeta.setTotalStreak(this.totalStreak);

        return recordMeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordMeta that = (RecordMeta) o;
        return seasonAll == that.seasonAll && seasonWin == that.seasonWin && seasonLose == that.seasonLose && seasonDraw == that.seasonDraw && seasonStar == that.seasonStar && totalAll == that.totalAll && totalWin == that.totalWin && totalLose == that.totalLose && totalDraw == that.totalDraw && totalStreak == that.totalStreak && Objects.equals(playerUuid, that.playerUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerUuid, seasonAll, seasonWin, seasonLose, seasonDraw, seasonStar, totalAll, totalWin, totalLose, totalDraw, totalStreak);
    }

    public void setTotalStreak(int totalStreak) {
        this.totalStreak = totalStreak;
    }
    public int getSeasonStar() {
        return seasonStar;
    }

    public void setSeasonStar(int seasonStar) {
        this.seasonStar = seasonStar;
    }

    public int getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(int totalAll) {
        this.totalAll = totalAll;
    }

    public int getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(int totalWin) {
        this.totalWin = totalWin;
    }

    public int getTotalLose() {
        return totalLose;
    }

    public void setTotalLose(int totalLose) {
        this.totalLose = totalLose;
    }

    public int getTotalDraw() {
        return totalDraw;
    }

    public void setTotalDraw(int totalDraw) {
        this.totalDraw = totalDraw;
    }



    public int getSeasonDraw() {
        return seasonDraw;
    }

    public void setSeasonDraw(int seasonDraw) {
        this.seasonDraw = seasonDraw;
    }

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    public int getSeasonAll() {
        return seasonAll;
    }

    public void setSeasonAll(int seasonAll) {
        this.seasonAll = seasonAll;
    }

    public int getSeasonWin() {
        return seasonWin;
    }

    public void setSeasonWin(int seasonWin) {
        this.seasonWin = seasonWin;
    }

    public int getSeasonLose() {
        return seasonLose;
    }

    public void setSeasonLose(int seasonLose) {
        this.seasonLose = seasonLose;
    }


}
