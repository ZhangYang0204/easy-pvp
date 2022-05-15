package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.meta.*;

import java.sql.SQLException;
import java.util.List;

public interface RaceService {


    List<MapBlockMeta> getBlockMeta(String mapUuid) throws SQLException;
    void recordWin(String playerUuid) throws SQLException;
    void recordLose(String playerUuid) throws SQLException;
    void recordDraw(String playerUuid) throws SQLException;
    List<KitItemStackMeta> getItemMeta(String kitUuid) throws SQLException;
    List<KitMeta> getKitMetaByMapUuid(String mapUuid) throws SQLException;
    List<MapBlockInventoryItemStackMeta> getContainerInventoryItemStackMeta(String mapUuid) throws SQLException;
    RecordMeta getRecord(String playerUuid) throws SQLException;
    List<RecordMeta> getRecord() throws SQLException;
}
