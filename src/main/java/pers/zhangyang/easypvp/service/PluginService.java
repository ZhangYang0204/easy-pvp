package pers.zhangyang.easypvp.service;

import java.sql.SQLException;

public interface PluginService {
    public String getVersion() throws SQLException;

    public void setVersion(String updateInfo) throws SQLException;

    public void initDatabase() throws SQLException;
}

