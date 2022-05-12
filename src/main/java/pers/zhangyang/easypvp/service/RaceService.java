package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.meta.BlockMeta;
import pers.zhangyang.easypvp.meta.ItemMeta;
import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.RecordMeta;

import java.sql.SQLException;
import java.util.List;

public interface RaceService {


    List<BlockMeta> getBlockMeta(String mapUuid) throws SQLException;
    void recordWin(String playerUuid) throws SQLException;
    void recordLose(String playerUuid) throws SQLException;
    void recordDraw(String playerUuid) throws SQLException;
    List<ItemMeta> getItemMeta(String kitUuid) throws SQLException;
    List<KitMeta> getKitMetaByMapUuid(String mapUuid) throws SQLException;
}
