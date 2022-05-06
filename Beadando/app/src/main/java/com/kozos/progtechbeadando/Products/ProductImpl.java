package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Warranty.Warranty;

public class ProductImpl implements Product{

    public ProductImpl(String id, String name, Warranty warranty, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.warranty = warranty;
        this.price = price;
        this.quantity = quantity;
    }

    String id;
    String name;
    Warranty warranty;
    int price;
    int quantity;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Warranty getWarranty() {
        return warranty;
    }

    @Override
    public void applyWarranty(){

    }
}
