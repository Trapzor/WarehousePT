package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Warranty.Warranty;

public interface Product {

    String getId();

    String getName();
    void setName(String name);

    int getPrice();
    void setPrice(int price);

    int getQuantity();
    void changeQuantity(int quantity);

    Warranty getWarranty();
    void applyWarranty();

}
