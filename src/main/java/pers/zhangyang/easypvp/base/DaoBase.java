package pers.zhangyang.easypvp.base;


import pers.zhangyang.easypvp.util.DatabaseUtil;

import javax.annotation.Nonnull;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoBase {
    @Nonnull
    public Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }
    public DaoBase() throws SQLException {
        init();
    }
    public abstract void init() throws SQLException;

}
