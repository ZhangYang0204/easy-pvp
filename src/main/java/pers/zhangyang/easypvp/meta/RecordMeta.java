package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class RecordMeta {
    private String playerUuid;
    private int all;
    private int win;
    private int lose;
    private int draw;

    public RecordMeta clone(){
        RecordMeta recordMeta=new RecordMeta();
        recordMeta.setPlayerUuid(this.playerUuid);
        recordMeta.setLose(this.lose);
        recordMeta.setWin(this.win);
        recordMeta.setDraw(this.draw);
        recordMeta.setAll(this.all);
        return recordMeta;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordMeta that = (RecordMeta) o;
        return all == that.all && win == that.win && lose == that.lose && draw == that.draw && Objects.equals(playerUuid, that.playerUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerUuid, all, win, lose, draw);
    }
}
