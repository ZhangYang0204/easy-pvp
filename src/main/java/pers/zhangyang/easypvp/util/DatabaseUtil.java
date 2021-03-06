package pers.zhangyang.easypvp.util;

import pers.zhangyang.easypvp.yaml.SettingYaml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static ThreadLocal<Connection> t = new ThreadLocal<>();

    /**
     *
     * return 返回当前线程的Connection对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = t.get();
        if(connection==null||connection.isClosed()){
            SettingYaml settingYamlManager= SettingYaml.INSTANCE;
            connection = DriverManager.getConnection(settingYamlManager.getDATABASE_URL()
                    ,settingYamlManager.getDATABASE_USERNAME(), settingYamlManager.getDATABASE_PASSWORD());
            connection.setAutoCommit(false);
            t.set(connection);
        }
        return connection;
    }
}
