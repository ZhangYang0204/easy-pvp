package pers.zhangyang.easypvp.meta;

import java.util.Objects;

public class KitItemStackMeta {

    private String data;
    private String kitUuid;
    private int slot;


    public KitItemStackMeta clone(){
        KitItemStackMeta kitItemStackMeta =new KitItemStackMeta();
        kitItemStackMeta.setData(this.data);
        kitItemStackMeta.setSlot(this.slot);
        kitItemStackMeta.setKitUuid(this.kitUuid);
        return kitItemStackMeta;
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
        KitItemStackMeta kitItemStackMeta = (KitItemStackMeta) o;
        return slot == kitItemStackMeta.slot && Objects.equals(data, kitItemStackMeta.data) && Objects.equals(kitUuid, kitItemStackMeta.kitUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, kitUuid, slot);
    }
}
