package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Warranty.Warranty;

public class Electronics extends ProductImpl{

    public Electronics(String id, String name, Warranty warranty, int price, int quantity) {
        super(id, name, warranty, price, quantity);
    }
}
