package com.kozos.progtechbeadando.Products;

import static org.junit.Assert.*;

import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooHighException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooLowException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductIdCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooShortException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductPriceIsTooLowException;
import com.kozos.progtechbeadando.Warranty.NoWarranty;
import com.kozos.progtechbeadando.Warranty.Warranty;

import org.junit.Assert;
import org.junit.Test;

public class ProductImplTest {

    @Test
    public void ProductGetId() throws ProductIdCannotBeEmptyException {
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 10);
        Assert.assertEquals("testId", testProduct.getId());
    }

    @Test
    public void ProductIdCannotBeEmptyException() {
        Exception exception = Assert.assertThrows(ProductIdCannotBeEmptyException.class, () -> {
            Product testProduct = new Electronics("", "testName", new NoWarranty(), 1200, 10);
        });
    }

    @Test
    public void ProductGetName() {
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 10);
        Assert.assertEquals("testName", testProduct.getName());
    }

    @Test
    public void ProductNameEmptyException() {
        Exception exceptionEmpty = Assert.assertThrows(ProductNameCannotBeEmptyException.class, () -> {
            Product testProduct = new Electronics("testId", "", new NoWarranty(), 1200, 10);
        });
    }

    @Test
    public void ProductNameTooShortException(){
        Exception exception = Assert.assertThrows(ProductNameTooShortException.class, () -> {
            Product testProduct = new Electronics("testId", "te", new NoWarranty(), 1200, 10);
        });
    }

    @Test
    public void ProductGetPrice() {
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 10);
        Assert.assertEquals(1200, testProduct.getPrice());
    }

    @Test
    public void ProductPriceIsTooLowException() {
        Exception exception = Assert.assertThrows(ProductPriceIsTooLowException.class, () ->{
            Product testProduct = new Electronics("testId", "testName", new NoWarranty(), -2, 10);
        });
    }

    @Test
    public void ProductGetQuantity() {
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 10);
        Assert.assertEquals(10, testProduct.getQuantity());
    }

    @Test
    public void ProductSetQuantity(){
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 10);
        Assert.assertEquals(10, testProduct.getQuantity());
    }

    @Test
    public void ProductAddQuantity(){
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 5);
        testProduct.changeQuantity(5);
        Assert.assertEquals(10, testProduct.getQuantity());

    }

    @Test
    public void ProductChangeQuantityLow(){
        Exception exception = Assert.assertThrows(ProductDesiredQuantityIsTooLowException.class, () ->{
            Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, -5);
        });

    }

    @Test
    public void ProductChangeQuantityHigh(){
        Exception exception = Assert.assertThrows(ProductDesiredQuantityIsTooHighException.class, () ->{
            Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 300001);
        });
    }

    @Test
    public void getWarranty() {
        Product testProduct = new Electronics("testId", "testName", new NoWarranty(), 1200, 10);

        Assert.assertEquals(NoWarranty.class, testProduct.getWarranty().getClass());
    }
}