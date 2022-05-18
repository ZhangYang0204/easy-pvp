package pers.zhangyang.easypvp.service.impl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Container;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.dao.*;
import pers.zhangyang.easypvp.exception.*;
import pers.zhangyang.easypvp.meta.*;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.util.ItemStackUtil;
import pers.zhangyang.easypvp.util.MaterialDataUtil;
import pers.zhangyang.easypvp.util.MinecraftVersionUtil;

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
    public void resetRecord() throws SQLException {
        recordDao.delete();
    }

    @Override
    public void createMap(MapMeta mapMeta, List<BlockState> blockStateList) throws SQLException, DuplicateMapNameException {


        //检查名字
        if (mapDao.selectByName(mapMeta.getName())!=null){
            throw new DuplicateMapNameException();
        }


        mapDao.insert(mapMeta);

        for (BlockState blockState:blockStateList){

            if (blockState.getType().equals(Material.AIR)){
                continue;
            }


            if (MinecraftVersionUtil.getBigVersion()==1&&MinecraftVersionUtil.getMiddleVersion()<13){
                if (blockState instanceof Container){
                    ItemStack[] invContents=((Container) blockState).getInventory().getContents();
                    for (int i=0;i<invContents.length;i++){
                        if (invContents[i]==null||invContents[i].getType().equals(Material.AIR)){
                            continue;
                        }
                        MapBlockInventoryItemStackMeta meta=new MapBlockInventoryItemStackMeta();
                        meta.setMapUuid(mapMeta.getUuid());
                        meta.setX(blockState.getX());
                        meta.setY(blockState.getY());
                        meta.setZ(blockState.getZ());
                        meta.setSlot(i);
                        meta.setData(ItemStackUtil.itemStackSerialize(invContents[i]));
                        mapBlockInventoryItemStackDao.insert(meta);
                    }
                }
            }else {
                if (blockState instanceof BlockInventoryHolder){
                    ItemStack[] invContents=((BlockInventoryHolder) blockState).getInventory().getContents();
                    for (int i=0;i<invContents.length;i++){
                        if (invContents[i]==null||invContents[i].getType().equals(Material.AIR)){
                            continue;
                        }
                        MapBlockInventoryItemStackMeta meta=new MapBlockInventoryItemStackMeta();
                        meta.setMapUuid(mapMeta.getUuid());
                        meta.setX(blockState.getX());
                        meta.setY(blockState.getY());
                        meta.setZ(blockState.getZ());
                        meta.setSlot(i);
                        meta.setData(ItemStackUtil.itemStackSerialize(invContents[i]));
                        mapBlockInventoryItemStackDao.insert(meta);
                    }
                }
            }


            MapBlockMeta blockInfo=new MapBlockMeta();
            blockInfo.setX(blockState.getX());
            blockInfo.setY(blockState.getY());
            blockInfo.setZ(blockState.getZ());
            blockInfo.setMapUuid(mapMeta.getUuid());

            if (MinecraftVersionUtil.getBigVersion()==1&&MinecraftVersionUtil.getMiddleVersion()<13){
                blockInfo.setData(MaterialDataUtil.serializeMaterialData(blockState.getData()));
            }else {
                blockInfo.setData(blockState.getBlockData().getAsString());
            }
            mapBlockDao.insert(blockInfo);
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
    public void setMapFair(String mapName, boolean fair) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setFair(fair);
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
    public void createKit(KitMeta kitMeta, ItemStack[] itemStacks) throws SQLException, DuplicateKitNameException {

        if (kitDao.selectByName(kitMeta.getName())!=null){
            throw new DuplicateKitNameException();
        }
        kitDao.insert(kitMeta);
        for (int i=0;i<itemStacks.length;i++){
            if (itemStacks[i]==null){continue;}
            KitItemStackMeta kitItemStackMeta =new KitItemStackMeta();
            kitItemStackMeta.setKitUuid(kitMeta.getUuid());
            kitItemStackMeta.setData(ItemStackUtil.itemStackSerialize(itemStacks[i]));
            kitItemStackMeta.setSlot(i);
            kitItemStackDao.insert(kitItemStackMeta);
        }
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
    public void setKit(String kitName, ItemStack[] itemStacks) throws SQLException, NotExistKitNameException {
        KitMeta kitMeta=kitDao.selectByName(kitName);


        if (kitMeta==null){
            throw new NotExistKitNameException();
        }

        kitItemStackDao.deleteByKitUuid(kitMeta.getUuid());
        for (int i=0;i<itemStacks.length;i++){
            if (itemStacks[i]==null){continue;}
            KitItemStackMeta kitItemStackMeta =new KitItemStackMeta();
            kitItemStackMeta.setKitUuid(kitMeta.getUuid());
            kitItemStackMeta.setData(ItemStackUtil.itemStackSerialize(itemStacks[i]));
            kitItemStackMeta.setSlot(i);
            kitItemStackDao.insert(kitItemStackMeta);
        }
    }

    @Override
    public void setMapKeepLevel(String mapName, boolean keepLevel) throws SQLException, NotExistMapNameException {
        MapMeta mapMeta=mapDao.selectByName(mapName);
        //检查名字
        if (mapMeta==null){
            throw new NotExistMapNameException();
        }
        //先删除再插入
        mapDao.deleteByUuid(mapMeta.getUuid());
        mapMeta.setKeepLevel(keepLevel);
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




}
