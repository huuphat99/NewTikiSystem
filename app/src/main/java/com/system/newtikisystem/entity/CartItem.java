package com.system.newtikisystem.entity;

public class CartItem {
    private int id;
    private String name;
    private int imageId;
    private int quantity;
    private int price;
    private int sale;

    public CartItem(int id, String name, int imageId, int quantity, int price, int sale) {
        this.id = id;
        this.name = name;
        this.imageId = imageId;
        this.quantity = quantity;
        this.price = price;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageId=" + imageId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", sale=" + sale +
                '}';
    }
}
