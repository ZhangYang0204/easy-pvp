package pers.zhangyang.easypvp.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.*;
public class MapDao   extends DaoBase{

    public MapDao() throws SQLException {
    }
    public void init() throws SQLException {


        PreparedStatement ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists map_table (" +
                "  'uuid' STRING NOT NULL ," +
                "  'description' STRING ," +
                "  'name' STRING NOT NULL UNIQUE ," +
                "  'firstPointX'INT NOT NULL ," +
                "  'firstPointY'INT NOT NULL ," +
                "  'firstPointZ'INT NOT NULL ," +
                "  'secondPointX' INT NOT NULL ," +
                "  'secondPointY' INT NOT NULL ," +
                "  'secondPointZ' INT NOT NULL ," +
                "  'redPointX'INT NOT NULL ," +
                "  'redPointY'INT NOT NULL ," +
                "  'redPointZ'INT NOT NULL ," +
                "  'bluePointX' INT NOT NULL ," +
                "  'bluePointY' INT NOT NULL ," +
                "  'bluePointZ' INT NOT NULL ," +
                "  'build' BOOLEAN NOT NULL ," +
                "  'scale' INT NOT NULL ," +
                "  'fair' BOOLEAN NOT NULL ," +
                "  'keepInventory' BOOLEAN NOT NULL ," +
                "  'keepLevel' BOOLEAN NOT NULL ," +
                "  'chooseKitTime' INT NOT NULL ," +
                "  PRIMARY KEY (uuid)" +
                ")");
          ps.executeUpdate();
    }

    public int insert(MapMeta mapMeta) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into map_table (uuid,'name',firstPointX,firstPointY,firstPointZ" +
                ",secondPointX,secondPointY,secondPointZ" +
                ",redPointX,redPointY,redPointZ" +
                ",bluePointX,bluePointY,bluePointZ" +
                ",build,'scale',fair,description,'keepInventory',chooseKitTime,keepLevel) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, mapMeta.getUuid());
        ps.setString(2, mapMeta.getName());
        ps.setInt(3, mapMeta.getFirstPointX());
        ps.setInt(4, mapMeta.getFirstPointY());
        ps.setInt(5, mapMeta.getFirstPointZ());
        ps.setInt(6, mapMeta.getSecondPointX());
        ps.setInt(7, mapMeta.getSecondPointY());
        ps.setInt(8, mapMeta.getSecondPointZ());
        ps.setInt(9, mapMeta.getRedPointX());
        ps.setInt(10, mapMeta.getRedPointY());
        ps.setInt(11, mapMeta.getRedPointZ());
        ps.setInt(12, mapMeta.getBluePointX());
        ps.setInt(13, mapMeta.getBluePointY());
        ps.setInt(14, mapMeta.getBluePointZ());
        ps.setBoolean(15, mapMeta.isBuild());
        ps.setInt(16, mapMeta.getScale());
        ps.setBoolean(17, mapMeta.isFair());

        ps.setString(18, mapMeta.getDescription());

        ps.setBoolean(19, mapMeta.isKeepInventory());

        ps.setLong(20, mapMeta.getChooseKitTime());

        ps.setBoolean(21, mapMeta.isKeepLevel());
        return ps.executeUpdate();
    }

    public MapMeta selectByName(String name) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_table where name=?");
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            return changeFromResultSet(rs);
        }else {
            return null;
        }
    }
    public MapMeta selectByUuid(String uuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_table where uuid=?");
        ps.setString(1,uuid);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            return changeFromResultSet(rs);
        }else {
            return null;
        }
    }
    public List<MapMeta> selectByScale(int scale) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_table where scale=?");
        ps.setInt(1,scale);
        ResultSet rs=ps.executeQuery();
        List<MapMeta> mapMetaList =new ArrayList<>();
        while (rs.next()){
            mapMetaList.add(changeFromResultSet(rs));
        }
        return mapMetaList;
    }
    public int deleteByUuid(String uuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from map_table where uuid=?");
        ps.setString(1,uuid);
        return ps.executeUpdate();
    }


    private MapMeta changeFromResultSet(ResultSet rs) throws SQLException {


            MapMeta mapMeta =new MapMeta();
            mapMeta.setUuid(rs.getString("uuid"));
            mapMeta.setName(rs.getString("name"));
            mapMeta.setScale(rs.getInt("scale"));
            mapMeta.setFirstPointX(rs.getInt("firstPointX"));
            mapMeta.setFirstPointY(rs.getInt("firstPointY"));
            mapMeta.setFirstPointZ(rs.getInt("firstPointZ"));
            mapMeta.setSecondPointX(rs.getInt("secondPointX"));
            mapMeta.setSecondPointY(rs.getInt("secondPointY"));
            mapMeta.setSecondPointZ(rs.getInt("secondPointZ"));
            mapMeta.setRedPointX(rs.getInt("redPointX"));
            mapMeta.setRedPointY(rs.getInt("redPointY"));
            mapMeta.setRedPointZ(rs.getInt("redPointZ"));
            mapMeta.setBluePointX(rs.getInt("bluePointX"));
            mapMeta.setBluePointY(rs.getInt("bluePointY"));
            mapMeta.setBluePointZ(rs.getInt("bluePointZ"));
            mapMeta.setBuild(rs.getBoolean("build"));
            mapMeta.setFair(rs.getBoolean("fair"));
            mapMeta.setDescription(rs.getString("description"));

        mapMeta.setChooseKitTime(rs.getInt("chooseKitTime"));

        mapMeta.setKeepLevel(rs.getBoolean("keepLevel"));
        mapMeta.setKeepInventory(rs.getBoolean("keepInventory"));

        return mapMeta;
    }


}
