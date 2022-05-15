package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.service.PluginService;

import java.sql.SQLException;

public class PluginServiceImpl implements PluginService {

    private final UpdateDao updateDao=new UpdateDao();
    private final MapDao mapDao=new MapDao();
    private final MapBlockDao mapBlockDao =new MapBlockDao();
    private final KitDao kitDao=new KitDao();
    private final KitItemStackDao kitItemStackDao =new KitItemStackDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();
    private final MapBlockInventoryItemStackDao mapBlockInventoryItemStackDao =new MapBlockInventoryItemStackDao();
    public PluginServiceImpl() throws SQLException {

    }


    public String getVersion() throws SQLException {
        return updateDao.select();
    }
    public void setVersion(String version) throws SQLException {
        updateDao.delete();
        updateDao.insert(version);
    }
    public void initDatabase() throws SQLException {
        updateDao.init();
        mapDao.init();
        mapBlockDao.init();
        kitDao.init();
        kitItemStackDao.init();
        mapKitDao.init();
        recordDao.init();
        mapBlockInventoryItemStackDao.init();
        if (updateDao.select()==null){
            updateDao.insert(EasyPvp.getInstance().getDescription().getVersion());
        }
    }
}
