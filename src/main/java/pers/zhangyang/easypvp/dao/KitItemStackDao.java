package pers.zhangyang.easypvp.dao;


import pers.zhangyang.easypvp.base.DaoBase;

import pers.zhangyang.easypvp.meta.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitItemStackDao extends DaoBase {

    public KitItemStackDao() throws SQLException {
    }
    public void init() throws SQLException {
        PreparedStatement ps;

             ps =  getConnection().prepareStatement("" +
                    "CREATE TABLE if not exists kit_item_table (" +
                    "  'data' STRING NOT NULL  ," +
                    "  'kitUuid' STRING NOT NULL  ," +
                    "  'slot'INT NOT NULL ," +
                    "  PRIMARY KEY (slot ,kitUuid)" +
                    ")");

        ps.executeUpdate();
    }


    public int insert(KitItemStackMeta kitItemStackMeta) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into kit_item_table (data,kitUuid,slot) values (?,?,?)");
        ps.setString(1, kitItemStackMeta.getData());
        ps.setString(2, kitItemStackMeta.getKitUuid());
        ps.setInt(3, kitItemStackMeta.getSlot());

        return ps.executeUpdate();
    }

    public int deleteByKitUuid(String kitUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from kit_item_table where kitUuid=?");
        ps.setString(1,kitUuid);
        return ps.executeUpdate();
    }
    public List<KitItemStackMeta> selectByKitUuid(String kitUuid) throws SQLException {


        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from kit_item_table where kitUuid=?");
        ps.setString(1,kitUuid);
        ResultSet rs=ps.executeQuery();
        List<KitItemStackMeta> kitItemStackMetaList =new ArrayList<>();
        while (rs.next()) {
            kitItemStackMetaList.add(changeFromResultSet(rs));
        }
        return kitItemStackMetaList;
    }
    private KitItemStackMeta changeFromResultSet(ResultSet rs) throws SQLException {
        KitItemStackMeta kitItemStackMeta =new KitItemStackMeta();
        kitItemStackMeta.setData(rs.getString("data"));
        kitItemStackMeta.setKitUuid(rs.getString("kitUuid"));
        kitItemStackMeta.setSlot(rs.getInt("slot"));
        return kitItemStackMeta;
    }

}
