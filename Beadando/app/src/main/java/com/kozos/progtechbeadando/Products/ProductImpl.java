package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Products.Exceptions.IdCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.NameCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.NameTooLongException;
import com.kozos.progtechbeadando.Products.Exceptions.NameTooShortException;
import com.kozos.progtechbeadando.Products.Exceptions.PriceIsTooLowException;
import com.kozos.progtechbeadando.Warranty.Warranty;

public abstract class ProductImpl implements Product{

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
    public String getId(){
        return this.id;
    }

    void setId(String id) throws IdCannotBeEmptyException {
        if(id == null || id == " ")
            throw new IdCannotBeEmptyException();
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) throws NameCannotBeEmptyException, NameTooShortException, NameTooLongException {
        if(name == null ||name == " ")
            throw new NameCannotBeEmptyException();
        if(name.length() < 3)
            throw new NameTooShortException();
        if(name.length() > 50)
            throw new NameTooLongException();
        this.name = name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) throws PriceIsTooLowException {
        if(price < 0)
            throw new PriceIsTooLowException();
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
