package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;

public class OrderImplBuilder extends OrderBuilderImpl{
    @Override
    public SimpleOrder getOrder() {
        return new SimpleOrder("O-0000", this.getCustomer(), this.getProducts());
    }

    @Override
    public Order getOrder(String id) {
        return new SimpleOrder(id, this.getCustomer(), this.getProducts());
    }
}