package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class OrderImpl implements Order{

    String id;
    Customer customer;
    List<Product> products;

    public OrderImpl(String id, Customer customer, List<Product> products) {
        this.setId(id);
        this.setCustomer(customer);
        this.setProducts(products);
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    private void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
