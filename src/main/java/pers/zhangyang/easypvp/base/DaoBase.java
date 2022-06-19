package pers.zhangyang.easypvp.base;


import pers.zhangyang.easypvp.util.DatabaseUtil;

import org.jetbrains.annotations.NotNull;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoBase {
    @NotNull
    public Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }
    public DaoBase() throws SQLException {
        init();
    }
    public abstract void init() throws SQLException;

}
