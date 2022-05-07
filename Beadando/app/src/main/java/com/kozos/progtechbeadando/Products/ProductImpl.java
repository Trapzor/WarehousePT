package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooHighException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooLowException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductIdCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooLongException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooShortException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductPriceIsTooLowException;
import com.kozos.progtechbeadando.Warranty.Warranty;

public abstract class ProductImpl implements Product{

    public ProductImpl(String id, String name, Warranty warranty, int price, int quantity) throws ProductIdCannotBeEmptyException {
        setId(id);
        setName(name);
        setWarranty(warranty);
        setPrice(price);
        changeQuantity(quantity);
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

    void setId(String id) throws ProductIdCannotBeEmptyException {
        if(id == null || id.equals(" ") || id.equals(""))
            throw new ProductIdCannotBeEmptyException();
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) throws ProductNameCannotBeEmptyException, ProductNameTooShortException, ProductNameTooLongException {
        if(name == null || name.equals(" ") || name.equals(""))
            throw new ProductNameCannotBeEmptyException();
        if(name.length() < 3)
            throw new ProductNameTooShortException();
        if(name.length() > 50)
            throw new ProductNameTooLongException();
        this.name = name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) throws ProductPriceIsTooLowException {
        if(price < 0)
            throw new ProductPriceIsTooLowException();
        this.price = price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void changeQuantity(int quantity) throws ProductDesiredQuantityIsTooLowException, ProductDesiredQuantityIsTooHighException {
        if(quantity < 0)
            throw new ProductDesiredQuantityIsTooLowException();
        if(quantity > 300000)
            throw new ProductDesiredQuantityIsTooHighException();
        this.quantity = quantity;
    }

    @Override
    public Warranty getWarranty() {
        return warranty;
    }

    void setWarranty(Warranty warranty){
        this.warranty = warranty;
    }

    @Override
    public void applyWarranty(){

    }
}
