package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public interface OrderBuilder {

    Order getOrder();
    Order getOrder(String id);

    void addProduct(Product product);
    Product getProduct(String id);
    List<Product> getProducts();

    void setCustomer(Customer customer);
    Customer getCustomer();

}
