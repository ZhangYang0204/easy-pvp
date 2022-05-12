package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class KitMeta {
    private String uuid;
    private String name;
    private String description;


    public KitMeta clone(){
        KitMeta kitMeta=new KitMeta();
        kitMeta.setUuid(this.uuid);
        kitMeta.setDescription(this.description);
        kitMeta.setName(this.name);
        return kitMeta;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KitMeta kitMeta = (KitMeta) o;
        return Objects.equals(uuid, kitMeta.uuid) && Objects.equals(name, kitMeta.name) && Objects.equals(description, kitMeta.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, description);
    }
}
