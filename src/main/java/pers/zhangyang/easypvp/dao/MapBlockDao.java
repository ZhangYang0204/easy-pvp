package pers.zhangyang.easypvp.dao;




import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.MapBlockMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapBlockDao extends DaoBase {


    public MapBlockDao() throws SQLException {
    }

    public void init() throws SQLException {

        PreparedStatement ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists map_block_table (" +
                "  'data' STRING NOT NULL  ," +
                "  'mapUuid' STRING NOT NULL  ," +
                "  'x'INT NOT NULL ," +
                "  'y'INT NOT NULL ," +
                "  'z'INT NOT NULL ," +
                "  PRIMARY KEY  (mapUuid ,x,y,z)" +
                ")");
        ps.executeUpdate();
    }

    public int insert(MapBlockMeta mapBlockMeta) throws SQLException {
        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into map_block_table (data,mapUuid"+
                ",x,y,z) values (?,?,?,?,?)");
        ps.setString(1, mapBlockMeta.getData());
        ps.setString(2, mapBlockMeta.getMapUuid());
        ps.setInt(3, mapBlockMeta.getX());
        ps.setInt(4, mapBlockMeta.getY());
        ps.setInt(5, mapBlockMeta.getZ());

        return ps.executeUpdate();
    }
    public List<MapBlockMeta> selectByMapUuid(String mapUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_block_table where mapUuid=?");
        ps.setString(1,mapUuid);
        ResultSet rs=ps.executeQuery();
        List<MapBlockMeta> mapBlockMetaList =new ArrayList<>();
        while (rs.next()){
            mapBlockMetaList.add(changeFromResultSet(rs));
        }
        return mapBlockMetaList;
    }
    private MapBlockMeta changeFromResultSet(ResultSet rs) throws SQLException {
        MapBlockMeta mapBlockMeta =new MapBlockMeta();
        mapBlockMeta.setData(rs.getString("data"));
        mapBlockMeta.setMapUuid(rs.getString("mapUuid"));
        mapBlockMeta.setX(rs.getInt("x"));
        mapBlockMeta.setZ(rs.getInt("z"));
        mapBlockMeta.setY(rs.getInt("y"));
        return mapBlockMeta;
    }

    public int deleteByMapUuid(String mapUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from map_block_table where mapUuid=?");
        ps.setString(1,mapUuid);
        return ps.executeUpdate();
    }
}
