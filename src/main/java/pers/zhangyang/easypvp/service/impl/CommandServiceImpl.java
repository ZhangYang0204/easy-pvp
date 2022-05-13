package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.exception.*;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.service.CommandService;

import java.sql.SQLException;
import java.util.List;

public class CommandServiceImpl implements CommandService {
    private final MapDao mapDao=new MapDao();
    private final MapBlockDao mapBlockDao =new MapBlockDao();
    private final KitDao kitDao=new KitDao();
    private final KitItemStackDao kitItemStackDao =new KitItemStackDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();
    private final MapContainerInventoryItemStackDao mapContainerInventoryItemStackDao=new MapContainerInventoryItemStackDao();
    public CommandServiceImpl() throws SQLException {
    }

    @Override
    public void recordReset() throws SQLException {
        recordDao.delete();
    }

    @Override
    public void mapCreate(MapMeta meta, List<MapBlockMeta> mapBlockMetaList,List<MapContainerInventoryItemStackMeta>
            mapContainerInventoryItemStackMetaList) throws SQLException, DuplicateMapNameException {
        //检查名字
        if (mapDao.selectByName(meta.getName())!=null){
            throw new DuplicateMapNameException();
        }


        mapDao.insert(meta);
        for (MapBlockMeta mapBlockMeta : mapBlockMetaList){
            mapBlockDao.insert(mapBlockMeta);
        }

        //插入Container
        for (MapContainerInventoryItemStackMeta m:mapContainerInventoryItemStackMetaList){
            mapContainerInventoryItemStackDao.insert(m);
        }


    }

    @Override
    public void mapDelete(String mapName) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapBlockDao.deleteByMapUuid(mapMeta.getUuid());
        mapKitDao.deleteByMapUuid(mapMeta.getUuid());
    }

    @Override
    public void mapChooseTickSet(String mapName, long chooseTick) throws NotExistMapNameException, SQLException {
        if (chooseTick<0){throw new IllegalArgumentException();}
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setChooseTick(chooseTick);
        mapDao.insert(mapMeta);
    }

    @Override
    public void mapBuildSet(String mapName, boolean build) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setBuild(build);
        mapDao.insert(mapMeta);
    }

    @Override
    public void mapFairSet(String mapName, boolean fair) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setFair(fair);
        mapDao.insert(mapMeta);
    }

    @Override
    public void mapDropSet(String mapName, boolean drop) throws NotExistMapNameException, SQLException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setDrop(drop);
        mapDao.insert(mapMeta);
    }

    @Override
    public void mapScaleSet(String mapName, int scale) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setScale(scale);
        mapDao.insert(mapMeta);
    }

    @Override
    public void mapDescriptionSet(String maoName, List<String> description) throws NotExistMapNameException, SQLException {
        MapMeta mapMeta=mapDao.selectByName(maoName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        String r=null;
        for (int i=0;i<description.size();i++){
            if (i==0){
                r=description.get(i);
                continue;
            }
            r+=" "+description.get(i);
        }
        mapMeta.setDescription(r);
        mapDao.insert(mapMeta);
    }

    @Override
    public MapMeta getMapMeta(String mapName) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        return mapMeta;
    }

    @Override
    public void kitCreate(KitMeta kitMeta, List<KitItemStackMeta> kitItemStackMetaList) throws DuplicateKitNameException, SQLException {
        if (kitDao.selectByName(kitMeta.getName())!=null){
            throw new DuplicateKitNameException();
        }

        kitDao.insert(kitMeta);
        for (KitItemStackMeta kitItemStackMeta : kitItemStackMetaList) {
            kitItemStackDao.insert(kitItemStackMeta);
        }
    }

    @Override
    public void kitDelete(String kitName) throws SQLException, NotExistKitNameException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        kitDao.deleteByUuid(kitMeta.getUuid());
        kitItemStackDao.deleteByKitUuid(kitMeta.getUuid());
        mapKitDao.deleteByKitUuid(kitMeta.getUuid());
    }

    @Override
    public void kitSet(String kitName, List<KitItemStackMeta> kitItemStackMetaList) throws SQLException, NotExistKitNameException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        kitItemStackDao.deleteByKitUuid(kitMeta.getUuid());
        for (KitItemStackMeta kitItemStackMeta : kitItemStackMetaList) {
            kitItemStackDao.insert(kitItemStackMeta);
        }
    }

    @Override
    public void kitDescriptionSet(String kitName, List<String> description) throws NotExistKitNameException, SQLException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }

        //先删除再插入
        kitDao.deleteByUuid(kitMeta.getUuid());
        String r=null;
        for (int i=0;i<description.size();i++){
            if (i==0){
                r=description.get(i);
                continue;
            }
            r+=" "+description.get(i);
        }
        kitMeta.setDescription(r);
        kitDao.insert(kitMeta);
    }

    @Override
    public void mapKitAdd(MapKitMeta mapKitMeta) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapAlreadyAddKitException {
            MapKitMeta m=mapKitDao.selectByKitUuidAndMapUuid(mapKitMeta.getKitUuid(),mapKitMeta.getMapUuid());
            if (m!=null){
                throw  new MapAlreadyAddKitException();
            }

        KitMeta kitMeta=kitDao.selectByUuid(mapKitMeta.getKitUuid());
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        MapMeta mapMeta=mapDao.selectByUuid(mapKitMeta.getMapUuid());
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        mapKitDao.insert(mapKitMeta);
    }

    @Override
    public void mapKitRemove(String mapName, String kitName) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapNotAddKitException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        MapMeta mapMeta=mapDao.selectByName(mapName);
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }

        MapKitMeta m=mapKitDao.selectByKitUuidAndMapUuid(kitMeta.getUuid(),mapMeta.getUuid());
        if (m==null){
            throw  new MapNotAddKitException();
        }

        mapKitDao.deleteByKitUuidAndMapUuid(kitMeta.getUuid(),mapMeta.getUuid());

    }

    @Override
    public KitMeta getKitMeta(String kitName) throws SQLException, NotExistKitNameException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        return kitMeta;
    }

    @Override
    public List<MapMeta> getMapByScale(int scale) throws SQLException {
        return mapDao.selectByScale(scale);
    }
}
