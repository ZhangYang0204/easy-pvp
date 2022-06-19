package pers.zhangyang.easypvp.completer;

import org.bukkit.command.CommandSender;
import pers.zhangyang.easypvp.base.CompleterBase;
import pers.zhangyang.easypvp.meta.MapMeta;
import pers.zhangyang.easypvp.service.CompleterService;
import pers.zhangyang.easypvp.service.impl.CompleterServiceImpl;
import pers.zhangyang.easypvp.util.InvocationUtil;
import pers.zhangyang.easypvp.util.ReplaceUtil;
import pers.zhangyang.easypvp.yaml.MessageYaml;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompleterRemoveMapDescription extends CompleterBase {
    public CompleterRemoveMapDescription(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public List<String> complete() {
        if (args.length==2){
            List<String> list=MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION();
            List<String> mapName=new ArrayList<>();
            try {
                CompleterService completerService= (CompleterService) InvocationUtil.getService(new CompleterServiceImpl());
                for (MapMeta mm:completerService.getMapMetaList()){
                    mapName.add(mm.getName());
                }
            } catch (SQLException e) {
                e.printStackTrace();

                return removeStartWith(args[1], list==null?new ArrayList<>():list);
            }
            if (list!=null){
                ReplaceUtil.format(list,"{[$]}",mapName);
            }
            return removeStartWith(args[1],list==null?new ArrayList<>():list );

        }
        if (args.length==3){
            List<String> list=MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION_$();

            List<String> mapName=new ArrayList<>();
            try {
                CompleterService completerService= (CompleterService) InvocationUtil.getService(new CompleterServiceImpl());
                MapMeta kitMeta=completerService.getMapMeta(args[1]);
                if (kitMeta.getDescription()!=null) {
                    for (int i = 0; i < kitMeta.getDescription().split(" ").length; i++) {
                        mapName.add(String.valueOf(i+1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

                return removeStartWith(args[2],list==null?new ArrayList<>():list );
            }
            if (list!=null){
                ReplaceUtil.format(list,"{[$]}",mapName);
            }

            return removeStartWith(args[2],list==null?new ArrayList<>():list );

        }
        return new ArrayList<>();
    }
}
