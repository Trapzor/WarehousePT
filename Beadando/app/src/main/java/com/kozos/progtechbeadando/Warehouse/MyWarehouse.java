package com.kozos.progtechbeadando.Warehouse;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Order.Order;
import com.kozos.progtechbeadando.Products.Product;

import java.util.List;

public class MyWarehouse implements Warehouse{

    private List<Product> products;
    private List<Order> orders;
    private List<Customer> customers;

    private static MyWarehouse instance = null;
    private MyWarehouse(){ }

    public static MyWarehouse getInstance(){
        if(instance == null)
            createInstance();
        return instance;
    }

    private static void createInstance() {
        instance = new MyWarehouse();

        //TODO get data from database to products list
    }

    @Override
    public void addProduct(Product product) {
        //TODO add object to database and add to list in case of success
        products.add(product);
    }

    @Override
    public Product getProduct(String id) {
        for(Product p : products)
        {
            if(p.getId().equals(id))
                return p;
        }
        return null;

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addNewOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Order getOrder(String id) {
        for(Order o : orders)
        {
            if(o.getId().equals(id))
                return o;
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer getCustomer(String id) {
        for(Customer c : customers)
        {
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void applyWarranty(String orderId, String productId)
    {
        //to-do
    }
}
