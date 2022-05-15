package pers.zhangyang.easypvp.dao;

import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.MapBlockInventoryItemStackMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapBlockInventoryItemStackDao extends DaoBase {
    public MapBlockInventoryItemStackDao() throws SQLException {
    }
    @Override
    public void init() throws SQLException {
        PreparedStatement ps;
        ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists map_block_inventory_item_stack_table (" +
                "  'data' STRING NOT NULL  ," +
                "  'mapUuid' STRING NOT NULL  ," +
                "  'slot'INT NOT NULL ," +
                "  'x'INT NOT NULL ," +
                "  'y'INT NOT NULL ," +
                "  'z'INT NOT NULL ," +
                "  PRIMARY KEY (x,y,z,slot,mapUuid)" +
                ")");
        ps.executeUpdate();
    }
    public int insert(MapBlockInventoryItemStackMeta meta) throws SQLException {
        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into map_block_inventory_item_stack_table (data,mapUuid,x,y,z,slot) values (?,?,?,?,?,?)");
        ps.setString(1, meta.getData());
        ps.setString(2, meta.getMapUuid());
        ps.setInt(3, meta.getX());
        ps.setInt(4, meta.getY());
        ps.setInt(5, meta.getZ());
        ps.setInt(6, meta.getSlot());
        return ps.executeUpdate();
    }

    public List<MapBlockInventoryItemStackMeta> selectByMapUuid(String mapUuid) throws SQLException {
        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_block_inventory_item_stack_table where mapUuid=?");
        ps.setString(1,mapUuid);
        List<MapBlockInventoryItemStackMeta> metaList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            metaList.add(changeFromResultSet(rs));
        }
        return metaList;
    }
    private MapBlockInventoryItemStackMeta changeFromResultSet(ResultSet rs) throws SQLException {
        MapBlockInventoryItemStackMeta meta=new MapBlockInventoryItemStackMeta();
        meta.setMapUuid(rs.getString("mapUuid"));
        meta.setData(rs.getString("data"));
        meta.setX(rs.getInt("x"));
        meta.setY(rs.getInt("y"));
        meta.setZ(rs.getInt("z"));
        meta.setSlot(rs.getInt("slot"));
        return meta;

    }

}
