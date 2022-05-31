package pers.zhangyang.easypvp.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.*;
public class MapKitDao   extends DaoBase{

    public MapKitDao() throws SQLException {
    }
    public void init() throws SQLException {

        PreparedStatement ps;

        ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists map_kit_table (" +
                "  'kitUuid' STRING NOT NULL  ," +
                "  'mapUuid' STRING NOT NULL  ," +
                "  PRIMARY KEY (kitUuid,mapUuid)" +
                ")");

        ps.executeUpdate();
    }


    public int insert(MapKitMeta mapKitMeta) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into map_kit_table (kitUuid,mapUuid) values (?,?)");
        ps.setString(1, mapKitMeta.getKitUuid());
        ps.setString(2, mapKitMeta.getMapUuid());

        return ps.executeUpdate();
    }

    public int deleteByKitUuid(String kitUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from map_kit_table where kitUuid=?");
        ps.setString(1,kitUuid);
        return ps.executeUpdate();
    }

    public List<MapKitMeta> selectByMapUuid(String mapUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_kit_table where  mapUuid=?");
        ps.setString(1,mapUuid);
        ResultSet rs=ps.executeQuery();
        List<MapKitMeta> mapKitMetaList=new ArrayList<>();
        while (rs.next()) {

            mapKitMetaList.add(changeFromResultSet(rs));
        }
        return mapKitMetaList;
    }

    public List<MapKitMeta> selectByKitUuid(String kitUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_kit_table where  kitUuid=?");
        ps.setString(1,kitUuid);
        ResultSet rs=ps.executeQuery();
        List<MapKitMeta> mapKitMetaList=new ArrayList<>();
        while (rs.next()) {
mapKitMetaList.add(changeFromResultSet(rs)) ;
        }
        return mapKitMetaList;
    }

    public MapKitMeta selectByKitUuidAndMapUuid(String kitUuid, String mapUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_kit_table where kitUuid=? and mapUuid=?");
        ps.setString(1,kitUuid);
        ps.setString(2,mapUuid);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            return changeFromResultSet(rs);
        }else {
            return null;
        }
    }


    private MapKitMeta changeFromResultSet(ResultSet rs) throws SQLException {
        MapKitMeta
                mapKitMeta =new MapKitMeta();
            mapKitMeta.setMapUuid(rs.getString("mapUuid"));
            mapKitMeta.setKitUuid(rs.getString("kitUuid"));

        return mapKitMeta;
    }
    public int deleteByMapUuid(String mapUuid) throws SQLException {
        init();
        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from map_kit_table where mapUuid=?");
        ps.setString(1,mapUuid);
        return ps.executeUpdate();
    }
    public int deleteByKitUuidAndMapUuid(String kitUuid,String mapUuid) throws SQLException {
        init();
        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from map_kit_table where kitUuid=? and mapUuid=?");
        ps.setString(2,mapUuid);
        ps.setString(1,kitUuid);
        return ps.executeUpdate();
    }
}
