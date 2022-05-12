package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class ItemMeta {

    private String data;
    private String kitUuid;
    private int slot;


    public ItemMeta clone(){
        ItemMeta itemMeta=new ItemMeta();
        itemMeta.setData(this.data);
        itemMeta.setSlot(this.slot);
        itemMeta.setKitUuid(this.kitUuid);
        return itemMeta;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKitUuid() {
        return kitUuid;
    }

    public void setKitUuid(String kitUuid) {
        this.kitUuid = kitUuid;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemMeta itemMeta = (ItemMeta) o;
        return slot == itemMeta.slot && Objects.equals(data, itemMeta.data) && Objects.equals(kitUuid, itemMeta.kitUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, kitUuid, slot);
    }
}
