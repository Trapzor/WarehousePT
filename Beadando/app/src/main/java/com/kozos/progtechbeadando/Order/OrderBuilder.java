package com.kozos.progtechbeadando.Order;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Products.Product;

public interface OrderBuilder {

    Order getOrder();
    void addProduct(Product product);
    void setCustomer(Customer customer);
    Customer getCustomer();

}
