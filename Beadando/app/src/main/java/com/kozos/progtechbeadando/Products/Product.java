package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Products.Exceptions.IdCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.NameCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.NameTooLongException;
import com.kozos.progtechbeadando.Products.Exceptions.NameTooShortException;
import com.kozos.progtechbeadando.Products.Exceptions.PriceIsTooLowException;
import com.kozos.progtechbeadando.Warranty.Warranty;

public interface Product {

    String getId() throws IdCannotBeEmptyException;

    String getName();
    void setName(String name) throws NameCannotBeEmptyException, NameTooShortException, NameTooLongException;

    int getPrice();
    void setPrice(int price) throws PriceIsTooLowException;

    int getQuantity();
    void changeQuantity(int quantity);

    Warranty getWarranty();
    void applyWarranty();

}
