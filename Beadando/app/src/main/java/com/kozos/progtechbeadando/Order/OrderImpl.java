package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public abstract class OrderImpl implements Order{
    OrderBuilder builder;
    String id;

    public OrderImpl(String id) {
        this.setId(id);
    }

    public OrderImpl(OrderBuilder builder, String id) {
        this.builder = builder;
        this.setId(id);
    }

    @Override
    public String getId() {
        return this.id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<Product> getProducts() {
        return this.builder.getOrder().getProducts();
    }

    @Override
    public Customer getCustomer() {
        return this.builder.getCustomer();
    }

    public void setBuilder(OrderBuilder orderBuilder)
    {
        //TO-DO
    }
}
