package pers.zhangyang.easypvp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.*;
public class KitDao   extends DaoBase{

    public KitDao() throws SQLException {
    }

    public void init() throws SQLException {
        PreparedStatement ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists kit_table (" +
                "  'uuid' STRING NOT NULL ," +
                "  'name' STRING NOT NULL  UNIQUE ," +
                "  'description'STRING  ," +
                "  PRIMARY KEY (uuid)" +
                ")");
        ps.executeUpdate();
    }
    public KitMeta selectByName(String name) throws SQLException {
        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from kit_table where name=?");
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            return changeFromResultSet(rs);
        }else {
            return null;
        }
    }


    public KitMeta selectByUuid(String uuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from kit_table where uuid=?");
        ps.setString(1,uuid);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){

            return changeFromResultSet(rs);
        }else {
            return null;
        }
    }
    public int deleteByUuid(String uuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from kit_table where uuid=?");
        ps.setString(1,uuid);
        return ps.executeUpdate();
    }
    private KitMeta changeFromResultSet(ResultSet rs) throws SQLException {

        KitMeta kitMeta =new KitMeta();
            kitMeta.setUuid(rs.getString("uuid"));
            kitMeta.setName(rs.getString("name"));
            kitMeta.setDescription(rs.getString("description"));

        return kitMeta;
    }

    public int insert(KitMeta kitMeta) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into kit_table (uuid,name,description) values (?,?,?)");
        ps.setString(1, kitMeta.getUuid());
        ps.setString(2, kitMeta.getName());
        ps.setString(3, kitMeta.getDescription());
        return ps.executeUpdate();
    }

}
