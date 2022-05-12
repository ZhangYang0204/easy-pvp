package pers.zhangyang.easypvp.dao;




import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.BlockMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockDao   extends DaoBase {


    public BlockDao() throws SQLException {
    }

    public void init() throws SQLException {

        PreparedStatement ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists block_table (" +
                "  'data' STRING NOT NULL  ," +
                "  'mapUuid' STRING NOT NULL  ," +
                "  'x'INT NOT NULL ," +
                "  'y'INT NOT NULL ," +
                "  'z'INT NOT NULL ," +
                "  PRIMARY KEY  (mapUuid ,x,y,z)" +
                ")");
        ps.executeUpdate();
    }

    public int insert(BlockMeta blockMeta) throws SQLException {
        PreparedStatement ps=getConnection().prepareStatement("" +
                "insert into block_table (data,mapUuid"+
                ",x,y,z) values (?,?,?,?,?)");
        ps.setString(1, blockMeta.getData());
        ps.setString(2, blockMeta.getMapUuid());
        ps.setInt(3, blockMeta.getX());
        ps.setInt(4, blockMeta.getY());
        ps.setInt(5, blockMeta.getZ());

        return ps.executeUpdate();
    }
    public List<BlockMeta> selectByMapUuid(String mapUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "select * from block_table where mapUuid=?");
        ps.setString(1,mapUuid);
        ResultSet rs=ps.executeQuery();
        List<BlockMeta> blockMetaList =new ArrayList<>();
        while (rs.next()){
            blockMetaList.add(changeFromResultSet(rs));
        }
        return blockMetaList;
    }
    private BlockMeta changeFromResultSet(ResultSet rs) throws SQLException {
        BlockMeta blockMeta =new BlockMeta();
        blockMeta.setData(rs.getString("data"));
        blockMeta.setMapUuid(rs.getString("mapUuid"));
        blockMeta.setX(rs.getInt("x"));
        blockMeta.setZ(rs.getInt("z"));
        blockMeta.setY(rs.getInt("y"));
        return blockMeta;
    }

    public int deleteByMapUuid(String mapUuid) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("" +
                "delete from block_table where mapUuid=?");
        ps.setString(1,mapUuid);
        return ps.executeUpdate();
    }
}
