package pers.zhangyang.easypvp.dao;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                "  'seasonDraw' INT NOT NULL  ," +
                "  'seasonAll' INT NOT NULL  ," +
                "  'seasonWin' INT NOT NULL  ," +
                "  'seasonLose' INT NOT NULL  ," +
                "  'seasonStar' INT NOT NULL  ," +
                "  'totalDraw' INT NOT NULL  ," +
                "  'totalAll' INT NOT NULL  ," +
                "  'totalWin' INT NOT NULL  ," +
                "  'totalLose' INT NOT NULL  ," +
                "  'totalStreak' INT NOT NULL  ," +
                "  'seasonStreak' INT NOT NULL  ," +
                "  'cumulativeStar' INT NOT NULL  ," +
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
                "(playerUuid,seasonDraw,'seasonAll',seasonWin,'seasonLose',totalAll,totalDraw,totalLose,totalWin,seasonStar,totalStreak,seasonStreak,cumulativeStar)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, recordMeta.getPlayerUuid());
        ps.setInt(2, recordMeta.getSeasonDraw());
        ps.setInt(3, recordMeta.getSeasonAll());
        ps.setInt(4, recordMeta.getSeasonWin());
        ps.setInt(5, recordMeta.getSeasonLose());
        ps.setInt(6, recordMeta.getTotalAll());
        ps.setInt(7, recordMeta.getTotalDraw());
        ps.setInt(8, recordMeta.getTotalLose());
        ps.setInt(9, recordMeta.getTotalWin());
        ps.setInt(10, recordMeta.getSeasonStar());
        ps.setInt(11, recordMeta.getTotalStreak());

        ps.setInt(12, recordMeta.getSeasonStreak());
        ps.setInt(13, recordMeta.getCumulativeStar());
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
    public List<RecordMeta> select() throws SQLException {

        PreparedStatement ps=getConnection().prepareStatement("select * from record_table  ");
        ResultSet rs=ps.executeQuery();
        List<RecordMeta> recordMetaList=new ArrayList<>();
        while (rs.next()){
            recordMetaList.add(changeFromResultSet(rs));
        }
        return recordMetaList;
    }


    private RecordMeta changeFromResultSet(ResultSet rs) throws SQLException {
        RecordMeta recordMeta =new RecordMeta();
        recordMeta.setSeasonDraw(rs.getInt("seasonDraw"));
        recordMeta.setPlayerUuid(rs.getString("playerUuid"));
        recordMeta.setSeasonAll(rs.getInt("seasonAll"));
        recordMeta.setSeasonLose(rs.getInt("seasonLose"));
        recordMeta.setSeasonWin(rs.getInt("seasonWin"));
        recordMeta.setTotalAll(rs.getInt("totalAll"));
        recordMeta.setTotalDraw(rs.getInt("totalDraw"));
        recordMeta.setTotalLose(rs.getInt("totalLose"));
        recordMeta.setTotalWin(rs.getInt("totalWin"));
        recordMeta.setSeasonStar(rs.getInt("seasonStar"));
        recordMeta.setTotalStreak(rs.getInt("totalStreak"));

        recordMeta.setSeasonStreak(rs.getInt("seasonStreak"));
        recordMeta.setCumulativeStar(rs.getInt("cumulativeStar"));
        return recordMeta;
    }
}
