package pers.zhangyang.easypvp.dao;


import org.bukkit.Bukkit;
import pers.zhangyang.easypvp.base.DaoBase;

import pers.zhangyang.easypvp.meta.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao   extends DaoBase {

    public ItemDao() throws SQLException {
    }
    public void init() throws SQLException {
        PreparedStatement ps;

             ps =  getConnection().prepareStatement("" +
                    "CREATE TABLE if not exists item_table (" +
                    "  'data' STRING NOT NULL  ," +
                    "  'kitUuid' STRING NOT NULL  ," +
                    "  'slot'INT NOT NULL ," +
                    "  PRIMARY KEY (slot ,kitUuid)" +
                    ")");

        ps.executeUpdate();
    }


    public int insert(ItemMeta itemMeta) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into item_table (data,kitUuid,slot) values (?,?,?)");
        ps.setString(1, itemMeta.getData());
        ps.setString(2, itemMeta.getKitUuid());
        ps.setInt(3, itemMeta.getSlot());

        return ps.executeUpdate();
    }

    public int deleteByKitUuid(String kitUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from item_table where kitUuid=?");
        ps.setString(1,kitUuid);
        return ps.executeUpdate();
    }
    public List<ItemMeta> selectByKitUuid(String kitUuid) throws SQLException {


        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from item_table where kitUuid=?");
        ps.setString(1,kitUuid);
        ResultSet rs=ps.executeQuery();
        List<ItemMeta> itemMetaList =new ArrayList<>();
        while (rs.next()) {
            itemMetaList.add(changeFromResultSet(rs));
        }
        return itemMetaList;
    }
    private ItemMeta changeFromResultSet(ResultSet rs) throws SQLException {
        ItemMeta itemMeta =new ItemMeta();
        itemMeta.setData(rs.getString("data"));
        itemMeta.setKitUuid(rs.getString("kitUuid"));
        itemMeta.setSlot(rs.getInt("slot"));
        return itemMeta;
    }

}
