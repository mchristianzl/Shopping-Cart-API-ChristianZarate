package com.photon.exam.model;

public class CartRequest {

    private int id;
    private Object data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CartRequest{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
