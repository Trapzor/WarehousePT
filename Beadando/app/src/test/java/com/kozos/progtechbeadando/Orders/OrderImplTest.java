package com.kozos.progtechbeadando.Orders;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Customers.SimpleCustomer;
import com.kozos.progtechbeadando.Order.Order;
import com.kozos.progtechbeadando.Order.SimpleOrder;
import com.kozos.progtechbeadando.Products.Electronics;
import com.kozos.progtechbeadando.Products.Product;
import com.kozos.progtechbeadando.Warehouse.MyWarehouse;
import com.kozos.progtechbeadando.Warehouse.Warehouse;
import com.kozos.progtechbeadando.Warranty.NoWarranty;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderImplTest {

    Warehouse myWarehouse = MyWarehouse.getInstance();
    Electronics testElectronicsProduct = new Electronics("testId1", "testName1", new NoWarranty(), 1200, 10);
    Customer testCustomer = new SimpleCustomer("testId3", "test Name", "testAddressTest");
    Order testOrder = new SimpleOrder("testId4", testCustomer, myWarehouse.getProducts());

    @Test
    public void testGetId() {
        Assert.assertEquals("testId4", testOrder.getId());
    }

    @Test
    public void testGetProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(testElectronicsProduct);
        myWarehouse.addProduct(testElectronicsProduct);
        Assert.assertEquals(productList, testOrder.getProducts());
    }

    @Test
    public void testGetCustomer() {
        Assert.assertEquals(testCustomer, testOrder.getCustomer());
    }


}
