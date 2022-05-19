package pers.zhangyang.easypvp.yaml;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopYaml extends YamlManagerBase {
    public static final ShopYaml SETTING_YAML_MANAGER =new ShopYaml();

    private ShopYaml(){
        super("shop.yml");
    }


    private List<String> CONTENT_$_MATERIAL;
    private List<String> CONTENT_$_DISPLAY_NAME;
    private List<Integer> CONTENT_$_COST;
    private List<List<String>> CONTENT_$_LORE;
    private List<List<String>> CONTENT_$_COMMAND;
    private List<List<String>> CONTENT_$_NOT_ENOUGH;

    public List<Integer> getCONTENT_$_COST() {
        return new ArrayList<>(CONTENT_$_COST);
    }

    public List<String> getCONTENT_$_MATERIAL() {
        return new ArrayList<>(CONTENT_$_MATERIAL);
    }

    public List<String> getCONTENT_$_DISPLAY_NAME() {
        return new ArrayList<>(CONTENT_$_DISPLAY_NAME);
    }

    public List<List<String>> getCONTENT_$_LORE() {
        List<List<String>> list= new ArrayList<>(CONTENT_$_LORE);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        return list;

    }

    public List<List<String>> getCONTENT_$_COMMAND() {
        List<List<String>> list= new ArrayList<>(CONTENT_$_COMMAND);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        return list;
    }


    public List<List<String>> getCONTENT_$_NOT_ENOUGH() {
        List<List<String>> list= new ArrayList<>(CONTENT_$_NOT_ENOUGH);
        for (int i=0;i<list.size();i++){
            list.set(i,new ArrayList<>(list.get(i)));
        }
        return list;
    }

    protected void check()  {

        CONTENT_$_NOT_ENOUGH=new ArrayList<>();
        CONTENT_$_MATERIAL=new ArrayList<>();
        CONTENT_$_COST=new ArrayList<>();
        CONTENT_$_LORE=new ArrayList<>();
        CONTENT_$_COMMAND=new ArrayList<>();
        CONTENT_$_DISPLAY_NAME=new ArrayList<>();
        for (String key:yamlConfiguration.getConfigurationSection("shop.content").getKeys(false)){
            System.out.println(key);
            String materialName=getString("shop.content."+key+".material",false);
            String displayName=getString("shop.content."+key+".displayName",false);
            Integer cost=getInteger("shop.content."+key+".cost",false);
            if (cost==null){
                continue;
            }
            List<String> lore=getStringList("shop.content."+key+".lore",false);
            List<String> notEnought=getStringList("shop.content."+key+".notEnough",false);
            List<String> command=getStringList("shop.content."+key+".command",false);
            if (materialName==null|| Material.matchMaterial(materialName)==null){
                continue;
            }
            CONTENT_$_COMMAND.add(command);
            CONTENT_$_DISPLAY_NAME.add(displayName);
            CONTENT_$_LORE.add(lore);
            CONTENT_$_MATERIAL.add(materialName);
            CONTENT_$_COST.add(cost);
            CONTENT_$_NOT_ENOUGH.add(notEnought);
        }



    }


}
