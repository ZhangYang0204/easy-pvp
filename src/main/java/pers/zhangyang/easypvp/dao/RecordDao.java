package pers.zhangyang.easypvp.dao;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pers.zhangyang.easypvp.base.DaoBase;
import pers.zhangyang.easypvp.meta.*;
public class RecordDao   extends DaoBase{

    public RecordDao() throws SQLException {
    }
    public void init() throws SQLException {

        PreparedStatement ps;

        ps =  getConnection().prepareStatement("" +
                "CREATE TABLE if not exists record_table (" +
                "  'playerUuid' STRING NOT NULL  ," +
                "  'draw' INT NOT NULL  ," +
                "  'all' INT NOT NULL  ," +
                "  'win' INT NOT NULL  ," +
                "  'lose' INT NOT NULL  ," +
                "  PRIMARY KEY (playerUuid)" +
                ")");

        ps.executeUpdate();
    }
    public int delete() throws SQLException {
        PreparedStatement ps=getConnection().prepareStatement("delete from record_table ");
        return ps.executeUpdate();
    }
    public int insert(RecordMeta recordMeta) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("insert into record_table " +
                "(playerUuid,draw,'all',win,'lose') values (?,?,?,?,?)");
        ps.setString(1, recordMeta.getPlayerUuid());
        ps.setInt(2, recordMeta.getDraw());
        ps.setInt(3, recordMeta.getAll());
        ps.setInt(4, recordMeta.getWin());
        ps.setInt(5, recordMeta.getLose());
        return ps.executeUpdate();
    }
    public int deleteByPlayerUuid(String playerUuid ) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("delete from record_table where playerUuid=? ");
        ps.setString(1,playerUuid);
        return ps.executeUpdate();
    }
    public RecordMeta selectByPlayerUuid(String playerUuid ) throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("select * from record_table where playerUuid=? ");
        ps.setString(1,playerUuid);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            return changeFromResultSet(rs);
        }else {
            return null;
        }
    }
    private RecordMeta changeFromResultSet(ResultSet rs) throws SQLException {
        RecordMeta recordMeta =new RecordMeta();
        recordMeta.setDraw(rs.getInt("draw"));
        recordMeta.setPlayerUuid(rs.getString("playerUuid"));
        recordMeta.setAll(rs.getInt("all"));
        recordMeta.setLose(rs.getInt("lose"));
        recordMeta.setWin(rs.getInt("win"));
        return recordMeta;
    }
}
