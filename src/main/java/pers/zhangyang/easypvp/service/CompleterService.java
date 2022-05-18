package pers.zhangyang.easypvp.service;

import pers.zhangyang.easypvp.meta.KitMeta;
import pers.zhangyang.easypvp.meta.MapMeta;

import java.sql.SQLException;
import java.util.List;

public interface CompleterService {
    List<MapMeta> getMapMetaList() throws SQLException;
    List<KitMeta> getKitMetaList() throws SQLException;
    List<KitMeta> getKitMetaList(String mapName) throws SQLException;
    MapMeta getMapMeta(String string) throws SQLException;
    KitMeta getKitMeta(String string) throws SQLException;
}
