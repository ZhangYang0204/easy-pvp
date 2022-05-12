package pers.zhangyang.easypvp.manager;

import org.bukkit.Bukkit;
import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SettingYamlManager extends YamlManagerBase {
    public static final SettingYamlManager SETTING_YAML_MANAGER =new SettingYamlManager();

    public String getLANGUAGE() {
        return LANGUAGE;
    }

    private SettingYamlManager(){
        super("setting.yml");
    }

    private String DATABASE_URL;
    private String DATABASE_PASSWORD;
    private String DATABASE_USERNAME;
    private  String LANGUAGE;

    public String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public String getDATABASE_PASSWORD() {
        return DATABASE_PASSWORD;
    }

    public String getDATABASE_USERNAME() {
        return DATABASE_USERNAME;
    }

    protected void check()  {

        LANGUAGE =getString("setting.language",true);
        if (!LANGUAGE.equalsIgnoreCase("default")){
            LANGUAGE ="default";
        }
        //检查该填的值填没填，检查值有没有错误 如果有错误，就采用默认值
        DATABASE_URL =getString("setting.database.url",true);
        DATABASE_USERNAME =getString("setting.database.username",false);
        DATABASE_PASSWORD =getString("setting.database.password",false);
        //检查一下数据库连接可行不
        try {
            DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD).close();
        }catch (SQLException e){
            DATABASE_URL ="jdbc:sqlite:plugins/EasyPvp/data.db";
            DATABASE_USERNAME =null;
            DATABASE_PASSWORD =null;
        }




    }


}
