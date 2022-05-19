package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.service.RaceService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceServiceImpl implements RaceService {
    private final MapDao mapDao=new MapDao();
    private final MapBlockDao mapBlockDao =new MapBlockDao();
    private final KitDao kitDao=new KitDao();
    private final KitItemStackDao kitItemStackDao =new KitItemStackDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();
    private final MapBlockInventoryItemStackDao mapBlockInventoryItemStackDao =new MapBlockInventoryItemStackDao();
    public RaceServiceImpl() throws SQLException {
    }
    @Override
    public List<MapMeta> getMapMeta(int scale) throws SQLException {
        return mapDao.selectByScale(scale);
    }
    @Override
    public List<MapBlockMeta> getMapBlockMetaList(String mapUuid) throws SQLException {
        return mapBlockDao.selectByMapUuid(mapUuid);
    }

    @Override
    public void gamerWin(String playerUuid) throws SQLException {
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
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setSeasonAll(recordMeta.getSeasonAll()+1);
        recordMeta.setSeasonWin(recordMeta.getSeasonWin()+1);

        recordMeta.setSeasonStreak(recordMeta.getSeasonStreak()+1);
        recordMeta.setTotalAll(recordMeta.getTotalAll()+1);
        recordMeta.setTotalWin(recordMeta.getTotalWin()+1);
        recordMeta.setSeasonStar(recordMeta.getSeasonStar()+1);
        recordMeta.setTotalStreak(recordMeta.getTotalStreak()+1);
        recordDao.insert(recordMeta);
    }

    @Override
    public void gamerLose(String playerUuid) throws SQLException {
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
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setSeasonAll(recordMeta.getSeasonAll()+1);
        recordMeta.setSeasonLose(recordMeta.getSeasonLose()+1);


        recordMeta.setSeasonStreak(0);
        recordMeta.setTotalAll(recordMeta.getTotalAll()+1);
        recordMeta.setTotalLose(recordMeta.getTotalLose()+1);
        recordMeta.setSeasonStar(recordMeta.getSeasonStar()-1);
        if (recordMeta.getSeasonStar()<0){
            recordMeta.setSeasonStar(0);
        }
        recordMeta.setTotalStreak(0);
        recordDao.insert(recordMeta);
    }

    @Override
    public void gamerDraw(String playerUuid) throws SQLException {
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
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setSeasonAll(recordMeta.getSeasonAll()+1);
        recordMeta.setSeasonDraw(recordMeta.getSeasonDraw()+1);

        recordMeta.setTotalAll(recordMeta.getTotalAll()+1);
        recordMeta.setTotalDraw(recordMeta.getTotalDraw()+1);
        recordDao.insert(recordMeta);
    }

    @Override
    public List<KitItemStackMeta> getKitItemStackMetaList(String kitUuid) throws SQLException {

        return kitItemStackDao.selectByKitUuid(kitUuid);
    }

    @Override
    public List<KitMeta> getKitMetaList(String mapUuid) throws SQLException {
       List<MapKitMeta> mapKitMetaList= mapKitDao.selectByMapUuid(mapUuid);
       List<KitMeta> kitMetaList=new ArrayList<>();
       for (MapKitMeta mapKitMeta:mapKitMetaList){
            kitMetaList.add(kitDao.selectByUuid(mapKitMeta.getKitUuid()));
        }

       return kitMetaList;
    }

    @Override
    public List<MapBlockInventoryItemStackMeta> getContainerInventoryItemStackMetaList(String mapUuid) throws SQLException {
        return mapBlockInventoryItemStackDao.selectByMapUuid(mapUuid);
    }

    @Override
    public RecordMeta getRecordMetaList(String playerUuid) throws SQLException {
        return recordDao.selectByPlayerUuid(playerUuid);
    }

    @Override
    public List<RecordMeta> getRecordMetaList() throws SQLException {
        return recordDao.select();
    }
}
