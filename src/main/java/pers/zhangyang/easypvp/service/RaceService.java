package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.meta.*;

import java.sql.SQLException;
import java.util.List;

public interface RaceService {


    List<MapBlockMeta> getMapBlockMetaList(String mapUuid) throws SQLException;
    void gamerWin(String playerUuid) throws SQLException;
    void gamerLose(String playerUuid) throws SQLException;
    void gamerDraw(String playerUuid) throws SQLException;
    List<KitItemStackMeta> getKitItemStackMetaList(String kitUuid) throws SQLException;
    List<KitMeta> getKitMetaList(String mapUuid) throws SQLException;
    List<MapBlockInventoryItemStackMeta> getContainerInventoryItemStackMetaList(String mapUuid) throws SQLException;
    RecordMeta getRecordMetaList(String playerUuid) throws SQLException;
    List<RecordMeta> getRecordMetaList() throws SQLException;
    List<MapMeta> getMapMeta(int scale) throws SQLException;
}
