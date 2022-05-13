package pers.zhangyang.easypvp.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pers.zhangyang.easypvp.base.CommandBase;
import pers.zhangyang.easypvp.domain.Section;
import pers.zhangyang.easypvp.exception.DuplicateMapNameException;
import pers.zhangyang.easypvp.exception.InvalidFourPointException;
import pers.zhangyang.easypvp.exception.NotFourPointException;
import pers.zhangyang.easypvp.manager.MessageYamlManager;
import pers.zhangyang.easypvp.manager.SectionManager;
import pers.zhangyang.easypvp.meta.MapBlockMeta;
import pers.zhangyang.easypvp.meta.MapContainerInventoryItemStackMeta;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CommandService;
import pers.zhangyang.easypvp.service.impl.CommandServiceImpl;
import pers.zhangyang.easypvp.util.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandMapCreate extends CommandBase {
    public CommandMapCreate(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    protected boolean run() {
        Player player= (Player) sender;
        try {
            Section section= SectionManager.SECTION_MANAGER.getPlayerSection(player);
            if (!section.isFour()){
                throw  new NotFourPointException();
            }
            if (!section.isValid()){
                throw new InvalidFourPointException();
            }



            MapMeta mapInfo=new MapMeta();
            mapInfo.setUuid(UuidUtil.getUUID());
            mapInfo.setName(args[1]);
            mapInfo.setBuild(true);
            mapInfo.setFair(true);
            mapInfo.setScale(1);

            mapInfo.setDrop(true);
            mapInfo.setFirstPointX(section.getFirst().getBlockX());
            mapInfo.setFirstPointY(section.getFirst().getBlockY());
            mapInfo.setFirstPointZ(section.getFirst().getBlockZ());
            mapInfo.setSecondPointX(section.getSecond().getBlockX());
            mapInfo.setSecondPointY(section.getSecond().getBlockY());
            mapInfo.setSecondPointZ(section.getSecond().getBlockZ());
            mapInfo.setRedPointX(section.getRed().getBlockX());
            mapInfo.setRedPointY(section.getRed().getBlockY());
            mapInfo.setRedPointZ(section.getRed().getBlockZ());
            mapInfo.setBluePointX(section.getBlue().getBlockX());
            mapInfo.setBluePointY(section.getBlue().getBlockY());
            mapInfo.setBluePointZ(section.getBlue().getBlockZ());
            mapInfo.setChooseTick(100);

            List<MapContainerInventoryItemStackMeta> mapContainerInventoryItemStackMetaList=new ArrayList<>();

            List<MapBlockMeta> mapBlockMetaList =new ArrayList<>();
            //保存方块数据
            int x1=section.getFirst().getBlockX();
            int x2=section.getSecond().getBlockX();
            int z1=section.getFirst().getBlockZ();
            int z2=section.getSecond().getBlockZ();
            int y1=section.getFirst().getBlockY();
            int y2=section.getSecond().getBlockY();
            int xFrom=Math.min(x1,x2);
            int xTo=Math.max(x1,x2);
            int yFrom=Math.min(y1,y2);
            int yTo=Math.max(y1,y2);
            int zFrom=Math.min(z1,z2);
            int zTo=Math.max(z1,z2);
            //所有方块遍历保存数据
            for (int x=xFrom;x<=xTo;x++){
                for (int y=yFrom;y<=yTo;y++){
                    for (int z=zFrom;z<=zTo;z++){

                        Block block=new Location(section.getFirst().getWorld(),x,y,z).getBlock();
                        if (block.getType().equals(Material.AIR)){
                            continue;
                        }

                        if (block.getState() instanceof BlockInventoryHolder){

                            ItemStack[] invContents=((BlockInventoryHolder) block.getState()).getInventory().getContents();
                            for (int i=0;i<invContents.length;i++){
                                if (invContents[i]==null||invContents[i].getType().equals(Material.AIR)){
                                    continue;
                                }
                                MapContainerInventoryItemStackMeta meta=new MapContainerInventoryItemStackMeta();
                                meta.setMapUuid(mapInfo.getUuid());
                                meta.setX(x);
                                meta.setY(y);
                                meta.setZ(z);
                                meta.setSlot(i);
                                meta.setData(ItemStackUtil.itemStackSerialize(invContents[i]));
                                mapContainerInventoryItemStackMetaList.add(meta);
                            }
                        }
                        MapBlockMeta blockInfo=new MapBlockMeta();
                        blockInfo.setX(x);
                        blockInfo.setY(y);
                        blockInfo.setZ(z);
                        blockInfo.setMapUuid(mapInfo.getUuid());


                        blockInfo.setData(block.getBlockData().getAsString());

                        mapBlockMetaList.add(blockInfo);
                    }
                }
            }

            CommandService commandService= (CommandService) InvocationUtil.getService(new CommandServiceImpl());
            commandService.mapCreate(mapInfo, mapBlockMetaList,mapContainerInventoryItemStackMetaList);

            RefreshUtil.refreshAllMapPage();



        } catch (  SQLException e) {
            e.printStackTrace();
            return true;
        } catch (NotFourPointException e) {
            List<String> list=MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT();
            ReplaceUtil.replace(list, Collections.singletonMap("{map}",args[1]));
            MessageUtil.sendMessageTo(sender, list);

            return true;
        } catch (InvalidFourPointException e) {
            List<String> list=MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT();
            ReplaceUtil.replace(list, Collections.singletonMap("{map}",args[1]));
            MessageUtil.sendMessageTo(sender, list);

            return true;
        } catch (DuplicateMapNameException e) {
            List<String> list= MessageYamlManager.MESSAGE_YAML_MANAGER
                    .getCHAT_FAILURE_MAP_CREATE_BECAUSE_DUPLICATE_MAP_NAME();
            ReplaceUtil.replace(list, Collections.singletonMap("{map}",args[1]));
            MessageUtil.sendMessageTo(sender, list);
            return true;
        }

        List<String> list=  MessageYamlManager.MESSAGE_YAML_MANAGER
                .getCHAT_SUCCESS_MAP_CREATE();
        ReplaceUtil.replace(list, Collections.singletonMap("{map}",args[1]));
        MessageUtil.sendMessageTo(sender, list);
        return true;
    }
}
