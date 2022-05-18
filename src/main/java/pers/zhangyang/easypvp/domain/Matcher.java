package pers.zhangyang.easypvp.domain;

import pers.zhangyang.easypvp.meta.MapMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Matcher {
    private final Party party;
    private final MapMeta mapMeta;

    public Matcher(@Nonnull Party party, @Nonnull MapMeta mapMeta) {

        if (party==null||mapMeta==null){throw new NullPointerException();}
        this.party = party;
        this.mapMeta = mapMeta;
    }

    /**
     * 仅仅是new对象 没注册不会匹配
     * @param party
     */
    public Matcher(@Nonnull Party party) {

        if (party==null){throw new NullPointerException();}
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
