package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapKitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CompleterService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompleterServiceImpl implements CompleterService {
    private final MapDao mapDao=new MapDao();
    private final MapBlockDao mapBlockDao =new MapBlockDao();
    private final KitDao kitDao=new KitDao();
    private final KitItemStackDao kitItemStackDao =new KitItemStackDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();
    private final MapBlockInventoryItemStackDao mapBlockInventoryItemStackDao =new MapBlockInventoryItemStackDao();

    public CompleterServiceImpl() throws SQLException {
    }

    @Override
    public List<MapMeta> getMapMetaList() throws SQLException {
        return mapDao.select();
    }

    @Override
    public List<KitMeta> getKitMetaList() throws SQLException {
        return kitDao.select();
    }

    @Override
    public List<KitMeta> getKitMetaList(String mapName) throws SQLException {

        MapMeta mapMeta=mapDao.selectByName(mapName);

        List<MapKitMeta> mapKitMetaList=mapKitDao.selectByMapUuid(mapMeta.getUuid());

        List<KitMeta> kitMetaList=new ArrayList<>();
        for (MapKitMeta mkm:mapKitMetaList){

            kitMetaList.add(kitDao.selectByUuid(mkm.getKitUuid()));
        }
        return kitMetaList;

    }

    @Override
    public MapMeta getMapMeta(String name) throws SQLException {
        return mapDao.selectByName(name);
    }

    @Override
    public KitMeta getKitMeta(String name) throws SQLException {
        return kitDao.selectByName(name);
    }
}
