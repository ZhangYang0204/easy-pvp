package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.dao.RecordDao;
import pers.zhangyang.easypvp.exception.NotEnoughStarException;
import pers.zhangyang.easypvp.meta.RecordMeta;
import pers.zhangyang.easypvp.service.ShopService;

import java.sql.SQLException;

public class ShopServiceImpl implements ShopService {
    private RecordDao recordDao=new RecordDao();

    public ShopServiceImpl() throws SQLException {
    }

    @Override
    public void subtractCumulativeStar(String playerUuid, int subAmount) throws SQLException, NotEnoughStarException {
        if (subAmount<0){throw  new IllegalArgumentException();}
        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);

        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setSeasonAll(0);
            recordMeta.setSeasonDraw(0);
            recordMeta.setSeasonWin(0);
            recordMeta.setSeasonLose(0);
            recordMeta.setTotalAll(0);
            recordMeta.setTotalWin(0);
            recordMeta.setTotalLose(0);
            recordMeta.setTotalDraw(0);
            recordMeta.setSeasonStar(0);
            recordMeta.setTotalStreak(0);
            recordMeta.setPlayerUuid(playerUuid);
            recordMeta.setSeasonStreak(0);
            recordMeta.setCumulativeStar(0);
        }

        if (recordMeta.getCumulativeStar()<subAmount){
            throw new NotEnoughStarException();
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setCumulativeStar(recordMeta.getCumulativeStar()-subAmount);
        recordDao.insert(recordMeta);
    }
}
