package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.exception.NotEnoughStarException;

import java.sql.SQLException;

public interface ShopService {
    void subtractCumulativeStar(String playerUuid, int subAmount) throws SQLException, NotEnoughStarException;
}
