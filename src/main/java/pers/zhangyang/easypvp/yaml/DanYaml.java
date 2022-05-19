package pers.zhangyang.easypvp.yaml;

import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.util.HashMap;

public class DanYaml extends YamlManagerBase {
    public static final DanYaml SETTING_YAML_MANAGER =new DanYaml();

    private DanYaml(){
        super("dan.yml");
    }
    private HashMap<Integer,String> SECTION;



    protected void check()  {
        SECTION =new HashMap<>();
        for (String key:yamlConfiguration.getConfigurationSection("dan.section").getKeys(false)){
            String last=key.split("\\.")[key.split("\\.").length-1];
            int q;
            try {q=Integer.valueOf(last);}catch (NumberFormatException e){continue;}
            if (q<0){continue;}
            if (getString("dan.section."+key,false)==null){continue;}
            SECTION.put(q,getString("dan.section."+key,false));
        }
    }

    public HashMap<Integer, String> getSECTION() {

        return new HashMap<>(SECTION);

    }
}
