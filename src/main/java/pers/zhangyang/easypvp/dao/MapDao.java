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
                "  'isolateExperience' BOOLEAN NOT NULL ," +
                "  'isolateFood' BOOLEAN NOT NULL ," +
                "  'isolateHealth' BOOLEAN NOT NULL ," +
                "  'isolatePotionEffect' BOOLEAN NOT NULL ," +
                "  'isolateInventory' BOOLEAN NOT NULL ," +
                "  'isolateFly' BOOLEAN NOT NULL ," +
                "  'keepInventory' BOOLEAN NOT NULL ," +
                "  'keepExperience' BOOLEAN NOT NULL ," +
                "  'chooseKitTime' INT NOT NULL ," +
                "  'redPointPitch' FLOAT NOT NULL ," +
                "  'redPointYaw' FLOAT NOT NULL ," +
                "  'bluePointPitch' FLOAT NOT NULL ," +
                "  'bluePointYaw' FLOAT NOT NULL ," +
                "  'redSpawnInterval' INT NOT NULL ," +
                "  'blueSpawnInterval' INT NOT NULL ," +
                "  'raceStartReadyTime' INT NOT NULL ," +
                "  'ignorePartyDamage' BOOLEAN NOT NULL ," +
                "  'forbiddenEnderChest' BOOLEAN NOT NULL ," +
                "  'celebrateTime' INT NOT NULL ," +
                "  'raceTime' INT NOT NULL ," +
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
                ",build,'scale',description,'keepInventory',chooseKitTime,keepExperience" +
                ",isolateExperience,isolateFood,isolateHealth,isolatePotionEffect,isolateInventory,isolateFly" +
                ",redPointPitch,redPointYaw,bluePointPitch,bluePointYaw,redSpawnInterval,blueSpawnInterval" +
                ",raceStartReadyTime,ignorePartyDamage,forbiddenEnderChest,celebrateTime,raceTime) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
        ps.setString(17, mapMeta.getDescription());
        ps.setBoolean(18, mapMeta.isKeepInventory());
        ps.setLong(19, mapMeta.getChooseKitTime());
        ps.setBoolean(20, mapMeta.isKeepExperience());
        ps.setBoolean(21, mapMeta.isIsolateExperience());
        ps.setBoolean(22, mapMeta.isIsolateFood());
        ps.setBoolean(23, mapMeta.isIsolateHealth());
        ps.setBoolean(24, mapMeta.isIsolatePotionEffect());
        ps.setBoolean(25, mapMeta.isIsolateInventory());
        ps.setBoolean(26, mapMeta.isIsolateFly());

        ps.setFloat(27, mapMeta.getRedPointPitch());
        ps.setFloat(28, mapMeta.getRedPointYaw());
        ps.setFloat(29, mapMeta.getBluePointPitch());
        ps.setFloat(30, mapMeta.getBluePointYaw());
        ps.setInt(31, mapMeta.getRedSpawnInterval());
        ps.setInt(32, mapMeta.getBlueSpawnInterval());
        ps.setInt(33, mapMeta.getRaceStartReadyTime());
        ps.setBoolean(34, mapMeta.isIgnorePartyDamage());
        ps.setBoolean(35, mapMeta.isForbiddenEnderChest());
        ps.setInt(36, mapMeta.getCelebrateTime());
        ps.setInt(37, mapMeta.getRaceTime());

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
    public List<MapMeta> select( ) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from map_table ");
        ResultSet rs=ps.executeQuery();
        List<MapMeta> mapMetaList=new ArrayList<>();
        while (rs.next()) {
            mapMetaList.add(changeFromResultSet(rs));
        }
        return mapMetaList;
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
            mapMeta.setDescription(rs.getString("description"));
        mapMeta.setChooseKitTime(rs.getInt("chooseKitTime"));
        mapMeta.setKeepExperience(rs.getBoolean("keepExperience"));
        mapMeta.setKeepInventory(rs.getBoolean("keepInventory"));

        mapMeta.setIsolateExperience(rs.getBoolean("isolateExperience"));
        mapMeta.setIsolateFood(rs.getBoolean("isolateFood"));
        mapMeta.setIsolateHealth(rs.getBoolean("isolateHealth"));
        mapMeta.setIsolateInventory(rs.getBoolean("isolateInventory"));
        mapMeta.setIsolatePotionEffect(rs.getBoolean("isolatePotionEffect"));
        mapMeta.setIsolateFly(rs.getBoolean("isolateFly"));

        mapMeta.setRedPointPitch(rs.getFloat("redPointPitch"));
        mapMeta.setRedPointYaw(rs.getFloat("redPointYaw"));
        mapMeta.setBluePointPitch(rs.getFloat("bluePointPitch"));
        mapMeta.setBluePointYaw(rs.getFloat("bluePointYaw"));
        mapMeta.setRedSpawnInterval(rs.getInt("redSpawnInterval"));
        mapMeta.setBlueSpawnInterval(rs.getInt("blueSpawnInterval"));
        mapMeta.setRaceStartReadyTime(rs.getInt("raceStartReadyTime"));

        mapMeta.setIgnorePartyDamage(rs.getBoolean("ignorePartyDamage"));
        mapMeta.setForbiddenEnderChest(rs.getBoolean("forbiddenEnderChest"));

        mapMeta.setCelebrateTime(rs.getInt("celebrateTime"));
        mapMeta.setRaceTime(rs.getInt("raceTime"));


        return mapMeta;
    }


}
