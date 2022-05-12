package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.service.RaceService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceServiceImpl implements RaceService {
    private final MapDao mapDao=new MapDao();
    private final BlockDao blockDao=new BlockDao();
    private final KitDao kitDao=new KitDao();
    private final ItemDao itemDao=new ItemDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();

    public RaceServiceImpl() throws SQLException {
    }

    @Override
    public List<BlockMeta> getBlockMeta(String mapUuid) throws SQLException {
        return blockDao.selectByMapUuid(mapUuid);
    }

    @Override
    public void recordWin(String playerUuid) throws SQLException {
        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);
        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setAll(0);
            recordMeta.setDraw(0);
            recordMeta.setWin(0);
            recordMeta.setLose(0);
            recordMeta.setPlayerUuid(playerUuid);
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setAll(recordMeta.getAll()+1);
        recordMeta.setWin(recordMeta.getWin()+1);
        recordDao.insert(recordMeta);
    }

    @Override
    public void recordLose(String playerUuid) throws SQLException {
        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);
        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setAll(0);
            recordMeta.setDraw(0);
            recordMeta.setWin(0);
            recordMeta.setLose(0);
            recordMeta.setPlayerUuid(playerUuid);
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setAll(recordMeta.getAll()+1);
        recordMeta.setLose(recordMeta.getLose()+1);
        recordDao.insert(recordMeta);
    }

    @Override
    public void recordDraw(String playerUuid) throws SQLException {
        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);
        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setAll(0);
            recordMeta.setDraw(0);
            recordMeta.setWin(0);
            recordMeta.setLose(0);
            recordMeta.setPlayerUuid(playerUuid);
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setAll(recordMeta.getAll()+1);
        recordMeta.setDraw(recordMeta.getDraw()+1);
        recordDao.insert(recordMeta);
    }

    @Override
    public List<ItemMeta> getItemMeta(String kitUuid) throws SQLException {

        return itemDao.selectByKitUuid(kitUuid);
    }

    @Override
    public List<KitMeta> getKitMetaByMapUuid(String mapUuid) throws SQLException {
       List<MapKitMeta> mapKitMetaList= mapKitDao.selectByMapUuid(mapUuid);
       List<KitMeta> kitMetaList=new ArrayList<>();
       for (MapKitMeta mapKitMeta:mapKitMetaList){
            kitMetaList.add(kitDao.selectByUuid(mapKitMeta.getKitUuid()));
        }

       return kitMetaList;
    }
}
