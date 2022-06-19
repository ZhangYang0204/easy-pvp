package pers.zhangyang.easypvp.completer;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
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

public class CompleterSetMapIsolateFly extends CompleterBase {
    public CompleterSetMapIsolateFly(@NotNull CommandSender sender, boolean forcePlayer, @NotNull String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public List<String> complete() {
        if (args.length==2){     List<String> list= MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_SET_MAP_ISOLATE_FLY();
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
            return removeStartWith(args[2], MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_SET_MAP_ISOLATE_FLY_$()
                    ==null?new ArrayList<>():MessageYaml.INSTANCE.getCOMPLETER_EASY_PVP_SET_MAP_ISOLATE_FLY_$()
            );
        }

        return new ArrayList<>();
    }
}
