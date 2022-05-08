package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public abstract class OrderImpl implements Order{
    OrderBuilder builder;
    String id;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String setId() {
        return null;//flag
    }

    @Override
    public List<Product> getProducts() {
        return this.builder.getOrder().getProducts();
    }

    @Override
    public Customer getCustomer() {
        return this.builder.getCustomer();
    }
}
