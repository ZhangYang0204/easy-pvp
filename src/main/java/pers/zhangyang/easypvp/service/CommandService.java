package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.exception.*;
import pers.zhangyang.easypvp.meta.*;

import java.sql.SQLException;
import java.util.List;

public interface CommandService {


    void recordReset() throws SQLException;

    void mapCreate(MapMeta meta, List<MapBlockMeta> mapBlockMetaList,List<MapBlockInventoryItemStackMeta>
            mapContainerInventoryItemStackMetaList) throws SQLException, DuplicateMapNameException ;
    void mapDelete(String mapName) throws SQLException, NotExistMapNameException;

    void mapChooseTickSet(String mapName,int chooseTick) throws NotExistMapNameException, SQLException;
    void mapBuildSet(String mapName,boolean build) throws SQLException, NotExistMapNameException;
    void mapFairSet(String mapName,boolean fair) throws SQLException, NotExistMapNameException;
    void mapDropSet(String mapName,boolean drop) throws NotExistMapNameException, SQLException;
    void mapScaleSet(String mapName,int scale) throws SQLException, NotExistMapNameException;
    void mapDescriptionSet(String maoName,List<String> description) throws NotExistMapNameException, SQLException;
    MapMeta getMapMeta(String mapName) throws SQLException, NotExistMapNameException;

    void kitCreate(KitMeta kitMeta, List<KitItemStackMeta> kitItemStackMetaList) throws DuplicateKitNameException, SQLException;
    void kitDelete(String kitName) throws SQLException, NotExistKitNameException;
    void kitSet(String kitName,List<KitItemStackMeta> kitItemStackMetaList) throws SQLException, NotExistKitNameException;
    void setMapKeepLevel(String mapName,boolean keepLevel) throws SQLException, NotExistMapNameException;

    void kitDescriptionSet(String kitName,List<String> description) throws NotExistKitNameException, SQLException;
    void mapKitAdd(MapKitMeta mapKitMeta) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapAlreadyAddKitException;

    void mapKitRemove(String mapName,String kitName) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapNotAddKitException;

    KitMeta getKitMeta(String kitName) throws SQLException, NotExistKitNameException;

    List<MapMeta> getMapByScale(int scale) throws SQLException;

}
