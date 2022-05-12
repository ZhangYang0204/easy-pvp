package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.service.PluginService;

import java.sql.SQLException;

public class PluginServiceImpl implements PluginService {

    private final UpdateDao updateDao=new UpdateDao();
    private final MapDao mapDao=new MapDao();
    private final BlockDao blockDao=new BlockDao();
    private final KitDao kitDao=new KitDao();
    private final ItemDao itemDao=new ItemDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();
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
        blockDao.init();
        kitDao.init();
        itemDao.init();
        mapKitDao.init();
        recordDao.init();
        if (updateDao.select()==null){
            updateDao.insert(EasyPvp.getInstance().getDescription().getVersion());
        }
    }
}
