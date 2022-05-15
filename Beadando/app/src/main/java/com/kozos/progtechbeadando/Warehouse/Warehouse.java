package com.kozos.progtechbeadando.Warehouse;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Order.Order;
import com.kozos.progtechbeadando.Order.OrderBuilder;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public interface Warehouse {

    void addProduct(Product product);
    Product getProduct(String id);
    List<Product> getProducts();
    void addNewOrder(Order order);
    void addNewOrder(OrderBuilder orderBuilder);
    Order getOrder(String id);
    List<Order> getOrders();
    void addNewCustomer(Customer customer);
    Customer getCustomer(String id);
    List<Customer> getCustomers();
    void applyWarranty(String orderId, String productId);

}
