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

public class CompleterDeleteMap extends CompleterBase {
    public CompleterDeleteMap(CommandSender sender, boolean forcePlayer, String[] args) {
        super(sender, forcePlayer, args);
    }

    @Override
    public List<String> complete() {
        if (args.length==2){

            List<String> list=MessageYaml.MESSAGE_YAML_MANAGER.getCOMPLETER_EASY_PVP_DELETE_MAP();
            List<String> mapName=new ArrayList<>();
            try {
                CompleterService completerService= (CompleterService) InvocationUtil.getService(new CompleterServiceImpl());
                for (MapMeta mm:completerService.getMapMetaList()){
                    mapName.add(mm.getName());
                }
            } catch (SQLException e) {
                e.printStackTrace();

                return removeStartWith(args[1], list);
            }
            if (list!=null){
                ReplaceUtil.format(list,"{[$]}",mapName);
            }
            return removeStartWith(args[1],list );
        }
        return new ArrayList<>();
    }
}
