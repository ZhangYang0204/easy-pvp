package pers.zhangyang.easypvp.base;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import pers.zhangyang.easypvp.EasyPvp;
import pers.zhangyang.easypvp.exception.FailureMakeMultipleDirectorException;
import pers.zhangyang.easypvp.yaml.SettingYaml;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public abstract class YamlManagerBase {

    protected YamlConfiguration yamlConfiguration;

    protected String filePath;

    protected YamlConfiguration backUpConfiguration;

    /**
     * @param filePath 在resource下的文件路径
     */
    protected YamlManagerBase(@NotNull String filePath) {
        this.filePath = filePath;
        this.yamlConfiguration = new YamlConfiguration();
        this.backUpConfiguration = new YamlConfiguration();
    }

    @Nullable
    protected List<String> copy(List<String> list) {
        if (list == null){
            return null;
        }
        return new ArrayList<>(list);
    }

    /**
     * 会把对应的文件保存到PluginEasyGuiShop下
     * @throws IOException IO异常
     * @throws InvalidConfigurationException Yml文件格式不对
     */
    public void init( ) throws IOException, InvalidConfigurationException, FailureMakeMultipleDirectorException {
        File file = new File(EasyPvp.getInstance().getDataFolder(), filePath);
        // 如果文件不存在就创建
        if (!file.exists()){
            File dir = file.getParentFile();
            //先创建目录文件夹
            if (!dir.exists()){
                if (!dir.mkdirs()){
                    throw new FailureMakeMultipleDirectorException();
                }
            }
            //输出数据
            InputStream in = SettingYaml.class.getClassLoader().getResourceAsStream(filePath);
            if (in == null){
                throw new IOException();
            }
            OutputStream out = Files.newOutputStream(file.toPath());
            byte[] buf = new byte[1024];
            int len;
            while((len = in.read(buf)) > 0) {out.write(buf, 0, len);}
            out.close();
            in.close();
        }
        //加载Yaml
        this.yamlConfiguration.load(file);
        InputStream in=YamlManagerBase.class.getClassLoader().getResourceAsStream(filePath);
        if (in == null){
            throw new IOException();
        }
        InputStreamReader inputStreamReader=new InputStreamReader(in, StandardCharsets.UTF_8);
        this.backUpConfiguration.load(inputStreamReader);
        check();
    }

    protected abstract void check() ;

    /**
     * 修正配置文件内容
     * @throws IOException io异常
     */
    public void correct() throws IOException {
        //删除多余的
        for (String path : yamlConfiguration.getKeys(true)){
            if (!backUpConfiguration.getKeys(true).contains(path)){
                Object ob=yamlConfiguration.get(path);
                yamlConfiguration.set(path,null);
                try {
                    yamlConfiguration.save(EasyPvp.getInstance().getDataFolder().getAbsoluteFile()+"/"+filePath);
                } catch (IOException e) {
                    yamlConfiguration.set(path,ob);
                    throw e;
                }
            }
        }
        //补充缺失的
        for (String pathBase:backUpConfiguration.getKeys(true)){
            if (!yamlConfiguration.getKeys(true).contains(pathBase)){
                Object ob = yamlConfiguration.get(pathBase);
                yamlConfiguration.set(pathBase,backUpConfiguration.get(pathBase));
                try {
                    yamlConfiguration.save(EasyPvp.getInstance().getDataFolder().getAbsoluteFile()+"/"+filePath);
                } catch (IOException e) {
                    yamlConfiguration.set(pathBase,ob);
                    throw e;
                }
            }
        }
    }


    @Nullable
    public Boolean getBoolean(@NotNull String path, boolean isDef){
        if (!yamlConfiguration.isBoolean(path)){
            if (!isDef){
                return null;
            }
            return backUpConfiguration.getBoolean(path);
        }
        return yamlConfiguration.getBoolean(path);
    }
    @Nullable
    public String getString(@NotNull String path, boolean isDef){
        if (!yamlConfiguration.isString(path)) {
            if (!isDef){
                return null;
            }
            return backUpConfiguration.getString(path);
        }
        return yamlConfiguration.getString(path);
    }
    @Nullable
    public Integer getInteger(@NotNull String path, boolean isDef){
        if (!yamlConfiguration.isInt(path)) {
            if (!isDef){
                return null;
            }
            return backUpConfiguration.getInt(path);
        }
        return  yamlConfiguration.getInt(path);
    }

    @Nullable
    public Long getLong(@NotNull String path,boolean isDef){
        if (!yamlConfiguration.isLong(path)) {
            if (!isDef){
                return null;
            }
            return backUpConfiguration.getLong(path);
        }
        return  yamlConfiguration.getLong(path);
    }

    @Nullable
    public Double getDouble(@NotNull String path,boolean isDef){
        if (!yamlConfiguration.isDouble(path)) {
            if (!isDef){
                return null;
            }
            return backUpConfiguration.getDouble(path);
        }
        return  yamlConfiguration.getDouble(path);
    }

    @Nullable
    public List<String> getStringList(@NotNull String path, boolean isDef){
        if (!yamlConfiguration.isList(path)){
            if (!isDef){
                return null;
            }
            return backUpConfiguration.getStringList(path);
        }
        return  yamlConfiguration.getStringList(path);
    }

}
