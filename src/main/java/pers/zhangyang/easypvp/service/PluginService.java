package pers.zhangyang.easypvp.service;

import java.sql.SQLException;

public interface PluginService {
     String getVersion() throws SQLException;

     void setVersion(String updateInfo) throws SQLException;

     void initDatabase() throws SQLException;


}

