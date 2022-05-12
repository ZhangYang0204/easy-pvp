package pers.zhangyang.easypvp.domain;

import pers.zhangyang.easypvp.meta.MapMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Matcher {
    private final Party party;
    private final MapMeta mapMeta;

    public Matcher(Party party, MapMeta mapMeta) {
        this.party = party;
        this.mapMeta = mapMeta;
    }
    public Matcher(Party party) {
        this.party = party;
        mapMeta=null;
    }

    @Nonnull
    public Party getParty() {
        return party;
    }

    @Nullable
    public MapMeta getMapMeta() {
        return mapMeta;
    }
}
