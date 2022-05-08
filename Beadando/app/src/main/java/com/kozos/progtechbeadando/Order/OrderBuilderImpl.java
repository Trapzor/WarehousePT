package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public abstract class OrderBuilderImpl implements OrderBuilder{

    List<Product> products;
    Customer customer;


    public void setBuilder(OrderBuilder orderBuilder){
        //to-do
    }

    @Override
    public Order getOrder() {
        return null;//flag
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }
}
