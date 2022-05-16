package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Order.Exceptions.ProductNotFoundException;
import com.kozos.progtechbeadando.Products.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class OrderBuilderImpl implements OrderBuilder{

    List<Product> products;
    Customer customer;

    public OrderBuilderImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public abstract Order getOrder();

    @Override
    public abstract Order getOrder(String id);

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product getProduct(String id) {
        for(Product p : products){
            if(p.getId().equals(id))
                return p;
        }
        throw new ProductNotFoundException();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
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
