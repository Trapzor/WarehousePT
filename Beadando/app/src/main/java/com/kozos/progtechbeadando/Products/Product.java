package com.kozos.progtechbeadando.Products;

import com.kozos.progtechbeadando.Products.Exceptions.ProductIdCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooLongException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooShortException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductPriceIsTooLowException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooHighException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooLowException;
import com.kozos.progtechbeadando.Warranty.Warranty;

public interface Product {

    String getId() throws ProductIdCannotBeEmptyException;

    String getName();
    void setName(String name) throws ProductNameCannotBeEmptyException, ProductNameTooShortException, ProductNameTooLongException;

    int getPrice();
    void setPrice(int price) throws ProductPriceIsTooLowException;

    int getQuantity();
    void changeQuantity(int quantity) throws ProductDesiredQuantityIsTooLowException, ProductDesiredQuantityIsTooHighException;

    Warranty getWarranty();
    void applyWarranty();

}
