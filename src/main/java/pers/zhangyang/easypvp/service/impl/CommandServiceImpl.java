package pers.zhangyang.easypvp.service.impl;

import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.exception.*;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.service.CommandService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandServiceImpl implements CommandService {
    private final MapDao mapDao=new MapDao();
    private final MapBlockDao mapBlockDao =new MapBlockDao();
    private final KitDao kitDao=new KitDao();
    private final KitItemStackDao kitItemStackDao =new KitItemStackDao();
    private final MapKitDao mapKitDao=new MapKitDao();
    private final RecordDao recordDao=new RecordDao();
    private final MapBlockInventoryItemStackDao mapBlockInventoryItemStackDao =new MapBlockInventoryItemStackDao();
    public CommandServiceImpl() throws SQLException {
    }

    @Override
    public void resetSeason() throws SQLException {
        List<RecordMeta> recordMetaList=recordDao.select();

        recordDao.delete();
        for (RecordMeta r:recordMetaList){
            r.setSeasonStreak(0);
            r.setCumulativeStar(r.getCumulativeStar()+r.getSeasonStar());
            r.setSeasonStar(0);
            r.setSeasonAll(0);
            r.setSeasonDraw(0);
            r.setSeasonLose(0);
            r.setSeasonAll(0);
            recordDao.insert(r);
        }


    }

    @Override
    public void createMap(MapMeta meta, List<MapBlockMeta> mapBlockMetaList,List<MapBlockInventoryItemStackMeta> metaList) throws SQLException, DuplicateMapNameException {
        //检查名字
        if (mapDao.selectByName(meta.getName())!=null){
            throw new DuplicateMapNameException();
        }

        mapDao.insert(meta);
        for (MapBlockMeta mb:mapBlockMetaList){
            mapBlockDao.insert(mb);
        }

        for (MapBlockInventoryItemStackMeta mapBlockInventoryItemStackMeta:metaList){
            mapBlockInventoryItemStackDao.insert(mapBlockInventoryItemStackMeta);
        }

    }

    @Override
    public void deleteMap(String mapName) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapBlockDao.deleteByMapUuid(mapMeta.getUuid());
        mapKitDao.deleteByMapUuid(mapMeta.getUuid());
    }

    @Override
    public void setMapChooseTime(String mapName, int chooseTick) throws NotExistMapNameException, SQLException {
        if (chooseTick<0){throw new IllegalArgumentException();}
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setChooseKitTime(chooseTick);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapBuild(String mapName, boolean build) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setBuild(build);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapBlueSpawnInterval(String mapName, int b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setBlueSpawnInterval(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapRedSpawnInterval(String mapName, int b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setRedSpawnInterval(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapCelebrateTime(String mapName, int b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setCelebrateTime(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapForbiddenEnderChest(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setForbiddenEnderChest(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapIgnorePartyDamage(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIgnorePartyDamage(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapRaceStartReadyTime(String mapName, int b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setRaceStartReadyTime(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapRaceTime(String mapName, int b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setRaceTime(b);
        mapDao.insert(mapMeta);
    }


    @Override
    public void setMapIsolateFood(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIsolateFood(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapIsolateExperience(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIsolateExperience(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapIsolateHealth(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIsolateHealth(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapIsolateFly(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIsolateFly(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapIsolatePotionEffect(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIsolatePotionEffect(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapIsolateInventory(String mapName, boolean b) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setIsolateInventory(b);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapDrop(String mapName, boolean drop) throws NotExistMapNameException, SQLException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setKeepInventory(drop);
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapScale(String mapName, int scale) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setScale(scale);
        mapDao.insert(mapMeta);
    }

    @Override
    public void addMapDescription(String maoName, String des) throws NotExistMapNameException, SQLException {
        MapMeta mapMeta=mapDao.selectByName(maoName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }

        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        if (mapMeta.getDescription()==null){
            mapMeta.setDescription(des);
        }else {
            String[] descriptions = mapMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            descriptionList.add(des);
            String r=null;
            for (int i=0;i<descriptionList.size();i++){
                if (i==0){
                    r=descriptionList.get(i);
                    continue;
                }
                r+=" "+descriptionList.get(i);
            }
            mapMeta.setDescription(r);
        }
        mapDao.insert(mapMeta);
    }

    @Override
    public void removeMapDescription(String maoName, int ind) throws NotExistMapNameException, SQLException, NotExistDesciptionRowException {
        MapMeta mapMeta=mapDao.selectByName(maoName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        if (mapMeta.getDescription()==null){
            throw new NotExistDesciptionRowException();
        }else {
            String[] descriptions = mapMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            if (descriptionList.size()<ind+1){
                throw new NotExistDesciptionRowException();
            }
            //先删除再插入
            mapDao.deleteByUuid(mapMeta.getUuid());
            descriptionList.remove(ind);
            String r=null;
            for (int i=0;i<descriptionList.size();i++){
                if (i==0){
                    r=descriptionList.get(i);
                    continue;
                }
                r+=" "+descriptionList.get(i);
            }
            mapMeta.setDescription(r);
        }
        mapDao.insert(mapMeta);
    }

    @Override
    public void setMapDescription(String maoName, int ind, String des) throws NotExistMapNameException, SQLException, NotExistDesciptionRowException {
        MapMeta mapMeta=mapDao.selectByName(maoName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        if (mapMeta.getDescription()==null){
            throw new NotExistDesciptionRowException();
        }else {
            String[] descriptions = mapMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));

            if (descriptionList.size()<ind+1){
                throw new NotExistDesciptionRowException();
            }
            //先删除再插入
            mapDao.deleteByUuid(mapMeta.getUuid());
            descriptionList.set(ind,des);
            String r=null;
            for (int i=0;i<descriptionList.size();i++){
                if (i==0){
                    r=descriptionList.get(i);
                    continue;
                }
                r+=" "+descriptionList.get(i);
            }
            mapMeta.setDescription(r);
        }
        mapDao.insert(mapMeta);
    }


    @Override
    public void deleteKit(String kitName) throws SQLException, NotExistKitNameException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        kitDao.deleteByUuid(kitMeta.getUuid());
        kitItemStackDao.deleteByKitUuid(kitMeta.getUuid());
        mapKitDao.deleteByKitUuid(kitMeta.getUuid());
    }

    @Override
    public void createKit(KitMeta kitMeta, List<KitItemStackMeta> kitItemStackMetaList) throws SQLException, DuplicateKitNameException {
        if (kitDao.selectByName(kitMeta.getName())!=null){
            throw new DuplicateKitNameException();
        }
        kitDao.insert(kitMeta);
       for (KitItemStackMeta k:kitItemStackMetaList){
           kitItemStackDao.insert(k);
       }

    }

    @Override
    public void setKit(String kitName, List<KitItemStackMeta> kitItemStackMetaList) throws SQLException, NotExistKitNameException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        String oldU=kitMeta.getUuid();

        //更新装备包内物品
        kitItemStackDao.deleteByKitUuid(kitMeta.getUuid());
        for (KitItemStackMeta k:kitItemStackMetaList){
            kitItemStackDao.insert(k);
        }

        //更新装备包
        if (!kitItemStackMetaList.isEmpty()) {
            kitDao.deleteByUuid(oldU);
            kitMeta.setUuid(kitItemStackMetaList.get(0).getKitUuid());
            kitDao.insert(kitMeta);

            //更新地图和装备包映射
            List<MapKitMeta> mapKitMeta=mapKitDao.selectByKitUuid(oldU);
            mapKitDao.deleteByKitUuid(oldU);
            for (MapKitMeta m:mapKitMeta){
                m.setKitUuid(kitMeta.getUuid());
                mapKitDao.insert(m);
            }
        }




    }

    @Override
    public void setMapKeepExperience(String mapName, boolean keepLevel) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setKeepExperience(keepLevel);
        mapDao.insert(mapMeta);
    }


    @Override
    public void addKitDescription(String kitName, String des) throws NotExistKitNameException, SQLException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        //检查名字
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }

        //先删除再插入
        kitDao.deleteByUuid(kitMeta.getUuid());
        if (kitMeta.getDescription()==null){
            kitMeta.setDescription(des);
        }else {
            String[] descriptions = kitMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            descriptionList.add(des);
            String r=null;
            for (int i=0;i<descriptionList.size();i++){
                if (i==0){
                    r=descriptionList.get(i);
                    continue;
                }
                r+=" "+descriptionList.get(i);
            }
            kitMeta.setDescription(r);
        }
        kitDao.insert(kitMeta);
    }

    @Override
    public void removeKitDescription(String kitName, int ind) throws NotExistKitNameException, SQLException, NotExistDesciptionRowException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        //检查名字
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        if (kitMeta.getDescription()==null){
            throw new NotExistDesciptionRowException();
        }else {
            String[] descriptions = kitMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));
            if (descriptionList.size()<ind+1){
                throw new NotExistDesciptionRowException();
            }
            //先删除再插入
            kitDao.deleteByUuid(kitMeta.getUuid());
            descriptionList.remove(ind);
            String r=null;
            for (int i=0;i<descriptionList.size();i++){
                if (i==0){
                    r=descriptionList.get(i);
                    continue;
                }
                r+=" "+descriptionList.get(i);
            }
            kitMeta.setDescription(r);
        }
        kitDao.insert(kitMeta);
    }

    @Override
    public void setKitDescription(String maoName, int ind, String des) throws SQLException, NotExistKitNameException, NotExistDesciptionRowException {
        KitMeta kitMeta=kitDao.selectByName(maoName);
        //检查名字
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        if (kitMeta.getDescription()==null){
            throw new NotExistDesciptionRowException();
        }else {
            String[] descriptions = kitMeta.getDescription().split(" ");
            List<String> descriptionList=new ArrayList<>(Arrays.asList(descriptions));

            if (descriptionList.size()<ind+1){
                throw new NotExistDesciptionRowException();
            }
            //先删除再插入
            kitDao.deleteByUuid(kitMeta.getUuid());
            descriptionList.set(ind,des);
            String r=null;
            for (int i=0;i<descriptionList.size();i++){
                if (i==0){
                    r=descriptionList.get(i);
                    continue;
                }
                r+=" "+descriptionList.get(i);
            }
            kitMeta.setDescription(r);
        }
        kitDao.insert(kitMeta);
    }



    @Override
    public void addMapKit(String mapName, String kitName) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapAlreadyAddKitException {
       MapMeta mapMeta=mapDao.selectByName(mapName);
       KitMeta kitMeta=kitDao.selectByName(kitName);
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }

        MapKitMeta m=mapKitDao.selectByKitUuidAndMapUuid
                (kitMeta.getUuid(),mapMeta.getUuid()
                );

        if (m!=null){
            throw  new MapAlreadyAddKitException();
        }
        m=new MapKitMeta();
        m.setMapUuid(mapMeta.getUuid());
        m.setKitUuid(kitMeta.getUuid());
        mapKitDao.insert(m);
    }

    @Override
    public void removeMapKit(String mapName, String kitName) throws SQLException, NotExistKitNameException, NotExistMapNameException, MapNotAddKitException {
        KitMeta kitMeta=kitDao.selectByName(kitName);
        if (kitMeta==null){
            throw new NotExistKitNameException();
        }
        MapMeta mapMeta=mapDao.selectByName(mapName);
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }

        MapKitMeta m=mapKitDao.selectByKitUuidAndMapUuid(kitMeta.getUuid(),mapMeta.getUuid());
        if (m==null){
            throw  new MapNotAddKitException();
        }

        mapKitDao.deleteByKitUuidAndMapUuid(kitMeta.getUuid(),mapMeta.getUuid());

    }

    @Override
    public void subtractCumulativeStar(String playerUuid, int subAmount) throws SQLException, NotEnoughStarException {
        if (subAmount<0){throw  new IllegalArgumentException();}
        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);

        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setSeasonAll(0);
            recordMeta.setSeasonDraw(0);
            recordMeta.setSeasonWin(0);
            recordMeta.setSeasonLose(0);
            recordMeta.setTotalAll(0);
            recordMeta.setTotalWin(0);
            recordMeta.setTotalLose(0);
            recordMeta.setTotalDraw(0);
            recordMeta.setSeasonStar(0);
            recordMeta.setTotalStreak(0);
            recordMeta.setPlayerUuid(playerUuid);

            recordMeta.setSeasonStreak(0);
            recordMeta.setCumulativeStar(0);
        }


        if (recordMeta.getCumulativeStar()<subAmount){
            throw new NotEnoughStarException();
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setCumulativeStar(recordMeta.getCumulativeStar()-subAmount);
        recordDao.insert(recordMeta);
    }

    @Override
    public void plusCumulativeStar(String playerUuid, int plusAmount) throws SQLException {
        if (plusAmount<0){throw  new IllegalArgumentException();}
        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);
        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setSeasonAll(0);
            recordMeta.setSeasonDraw(0);
            recordMeta.setSeasonWin(0);
            recordMeta.setSeasonLose(0);
            recordMeta.setTotalAll(0);
            recordMeta.setTotalWin(0);
            recordMeta.setTotalLose(0);
            recordMeta.setTotalDraw(0);
            recordMeta.setSeasonStar(0);
            recordMeta.setTotalStreak(0);
            recordMeta.setPlayerUuid(playerUuid);

            recordMeta.setSeasonStreak(0);
            recordMeta.setCumulativeStar(0);
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setCumulativeStar(recordMeta.getCumulativeStar()+plusAmount);
        recordDao.insert(recordMeta);
    }

    @Override
    public void setCumulativeStar(String playerUuid, int plusAmount) throws SQLException {
        if (plusAmount<0){throw  new IllegalArgumentException();}


        RecordMeta recordMeta=recordDao.selectByPlayerUuid(playerUuid);
        if (recordMeta==null){
            recordMeta=new RecordMeta();
            recordMeta.setSeasonAll(0);
            recordMeta.setSeasonDraw(0);
            recordMeta.setSeasonWin(0);
            recordMeta.setSeasonLose(0);
            recordMeta.setTotalAll(0);
            recordMeta.setTotalWin(0);
            recordMeta.setTotalLose(0);
            recordMeta.setTotalDraw(0);
            recordMeta.setSeasonStar(0);
            recordMeta.setTotalStreak(0);
            recordMeta.setPlayerUuid(playerUuid);

            recordMeta.setSeasonStreak(0);
            recordMeta.setCumulativeStar(0);
        }
        recordDao.deleteByPlayerUuid(playerUuid);
        recordMeta.setCumulativeStar(plusAmount);
        recordDao.insert(recordMeta);
    }


}
