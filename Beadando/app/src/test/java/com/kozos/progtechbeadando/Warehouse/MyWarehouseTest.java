package com.kozos.progtechbeadando.Warehouse;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Customers.SimpleCustomer;
import com.kozos.progtechbeadando.Order.Order;
import com.kozos.progtechbeadando.Order.SimpleOrder;
import com.kozos.progtechbeadando.Products.Electronics;
import com.kozos.progtechbeadando.Products.Toys;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseNotContainsProductException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseNotContainsOrderException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseNotContainsCustomerException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseAlreadyHasCustomerException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseAlreadyHasOrderException;
import com.kozos.progtechbeadando.Warranty.NoWarranty;

import org.junit.Assert;
import org.junit.Test;

public class MyWarehouseTest {

    Warehouse myWarehouse = MyWarehouse.getInstance();
    Electronics testElectronicsProduct = new Electronics("testId1", "testName1", new NoWarranty(), 1200, 10);
    Toys testToysProduct = new Toys("testId2", "testName2", new NoWarranty(), 1200, 10);
    Customer testCustomer = new SimpleCustomer("testId3", "test Name", "testAddressTest");
    Order testOrder = new SimpleOrder("testId4", testCustomer, myWarehouse.getProducts());

    @Test
    public void testAddElectronicsProduct() {
        myWarehouse.addProduct(testElectronicsProduct);
        Assert.assertEquals(testElectronicsProduct, myWarehouse.getProduct("testId1"));
    }

    @Test
    public void testAddToysProduct() {
        myWarehouse.addProduct(testToysProduct);
        Assert.assertEquals(testToysProduct, myWarehouse.getProduct("testId2"));
    }

    @Test
    public void testAddNewCustomer() {
        myWarehouse.addNewCustomer(testCustomer);
        Assert.assertEquals(testCustomer, myWarehouse.getCustomer("testId3"));
    }

    @Test
    public void testAddNewOrder() {
        myWarehouse.addNewOrder(testOrder);
        Assert.assertEquals(testOrder, myWarehouse.getOrder("testId4"));

    }

    @Test
    public void WarehouseNotContainsProductException(){
         Assert.assertThrows(WarehouseNotContainsProductException.class, () -> {
             myWarehouse.getProduct("Blank");
         });
     }

    @Test
    public void WarehouseNotContainsOrderException(){
        Assert.assertThrows(WarehouseNotContainsOrderException.class, () -> {
            myWarehouse.getOrder("Blank");
        });
    }

    @Test
    public void WarehouseNotContainsCustomerException(){
        Assert.assertThrows(WarehouseNotContainsCustomerException.class, () -> {
            myWarehouse.getCustomer("Blank");
        });
    }

    @Test
    public void WarehouseAlreadyHasCustomerException(){
        Assert.assertThrows(WarehouseAlreadyHasCustomerException.class, () -> {
            myWarehouse.addNewCustomer(testCustomer);
            myWarehouse.addNewCustomer(testCustomer);
        });
    }

    @Test
    public void WarehouseAlreadyHasOrderException(){
        Assert.assertThrows(WarehouseAlreadyHasOrderException.class, () -> {
            myWarehouse.addNewOrder(testOrder);
            myWarehouse.addNewOrder(testOrder);
        });
    }


}