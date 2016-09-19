package br.upis.ext.javaweb.loja.rest;

import java.util.Objects;

/**
 * Created by franciscovneto on 03/09/16.
 */
public class RestGridData {

    Object data;
    int itemsCount;

    public RestGridData() {
    }

    public RestGridData(Object data, int itemsCount) {
        this.data = data;
        this.itemsCount = itemsCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestGridData)) return false;
        RestGridData that = (RestGridData) o;
        return itemsCount == that.itemsCount &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, itemsCount);
    }

    @Override
    public String toString() {
        return "RestGridData{" +
                "data=" + data +
                ", itemsCount=" + itemsCount +
                '}';
    }
}
