package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.exception.*;
import pers.zhangyang.easypvp.meta.*;

import java.sql.SQLException;
import java.util.List;

public interface CommandService {


    void resetSeason() throws SQLException;
    void createMap(MapMeta meta, List<MapBlockMeta> mapBlockMetaList,List<MapBlockInventoryItemStackMeta> metaList) throws SQLException, DuplicateMapNameException ;
    void deleteMap(String mapName) throws SQLException, NotExistMapNameException;
    void setMapChooseTime(String mapName, int chooseTick) throws NotExistMapNameException, SQLException;
    void setMapBuild(String mapName, boolean build) throws SQLException, NotExistMapNameException;


    void setMapBlueSpawnInterval(String mapName, int b) throws SQLException, NotExistMapNameException;
    void setMapRedSpawnInterval(String mapName, int b) throws SQLException, NotExistMapNameException;
    void setMapCelebrateTime(String mapName, int b) throws SQLException, NotExistMapNameException;
    void setMapForbiddenEnderChest(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapIgnorePartyDamage(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapRaceStartReadyTime(String mapName, int b) throws SQLException, NotExistMapNameException;
    void setMapRaceTime(String mapName, int b) throws SQLException, NotExistMapNameException;


    void setMapIsolateFood(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapIsolateExperience(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapIsolateHealth(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapIsolateFly(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapIsolatePotionEffect(String mapName, boolean b) throws SQLException, NotExistMapNameException;
    void setMapIsolateInventory(String mapName, boolean b) throws SQLException, NotExistMapNameException;


    void setMapDrop(String mapName, boolean drop) throws NotExistMapNameException, SQLException;
    void setMapScale(String mapName, int scale) throws SQLException, NotExistMapNameException;
    void addMapDescription(String maoName, String des) throws NotExistMapNameException, SQLException;
    void removeMapDescription(String maoName, int line) throws NotExistMapNameException, SQLException, NotExistDesciptionRowException;
    void setMapDescription(String maoName, int line,String des) throws NotExistMapNameException, SQLException, NotExistDesciptionRowException;

    void createKit(KitMeta kitMeta,List<KitItemStackMeta> kitItemStackMetaList) throws SQLException, DuplicateKitNameException;
    void setKit(String kitName, List<KitItemStackMeta> kitItemStackMetaList) throws SQLException, NotExistKitNameException;

    void deleteKit(String kitName) throws SQLException, NotExistKitNameException;
    void setMapKeepExperience(String mapName, boolean keepLevel) throws SQLException, NotExistMapNameException;
    void addKitDescription(String kitName, String des) throws NotExistKitNameException, SQLException;
    void removeKitDescription(String kitName,int ind) throws NotExistKitNameException, SQLException, NotExistDesciptionRowException;
    void setKitDescription(String kitName,int ind,String des) throws NotExistKitNameException, SQLException, NotExistDesciptionRowException;
    void addMapKit(String mapName, String kitName) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapAlreadyAddKitException;
    void removeMapKit(String mapName, String kitName) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapNotAddKitException;

    void subtractCumulativeStar(String playerUuid, int subAmount) throws SQLException, NotEnoughStarException;
    void plusCumulativeStar(String playerUuid, int plusAmount) throws SQLException;
    void setCumulativeStar(String playerUuid, int plusAmount) throws SQLException;


}
