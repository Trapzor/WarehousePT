package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public class SimpleOrder extends OrderImpl{

    public SimpleOrder(String id, Customer customer, List<Product> products) {
        super(id, customer, products);
    }
}
