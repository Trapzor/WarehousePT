package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public interface Order {

    String getId();

    List<Product> getProducts();
    Customer getCustomer();

}
