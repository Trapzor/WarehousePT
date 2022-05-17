package com.kozos.progtechbeadando.Warehouse;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Customers.SimpleCustomer;
import com.kozos.progtechbeadando.Order.Order;
import com.kozos.progtechbeadando.Order.OrderBuilder;
import com.kozos.progtechbeadando.Order.SimpleOrder;
import com.kozos.progtechbeadando.Products.Electronics;
import com.kozos.progtechbeadando.Products.Product;
import com.kozos.progtechbeadando.Products.Toys;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseAlreadyHasCustomerException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseAlreadyHasOrderException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseNotContainsCustomerException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseNotContainsOrderException;
import com.kozos.progtechbeadando.Warehouse.Exceptions.WarehouseNotContainsProductException;
import com.kozos.progtechbeadando.Warranty.Warranty;

import java.util.ArrayList;
import java.util.List;

public class MyWarehouse implements Warehouse{

    private List<Product> products;
    private List<Order> orders;
    private List<Customer> customers;

    private static MyWarehouse instance = null;
    private MyWarehouse(){
        products = new ArrayList<>();
        orders = new ArrayList<>();
        customers = new ArrayList<>();
    }

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

        boolean exist = false;
        for (Product p : products) {
            if (product.getId().equals(p.getId())) {
                p.changeQuantity(product.getQuantity());
                exist = true;
                break;
            }
        }
        if(!exist)
            products.add(product);
    }

    public void addElectronicsProduct(String name, Warranty warranty, int price, int quantity){
            addProduct(new Electronics(generateNewProductId(), name, warranty, price, quantity));
    }

    public void addToysProduct(String name, Warranty warranty, int price, int quantity){
            addProduct(new Toys(generateNewProductId(), name, warranty, price, quantity));
    }

    public String generateNewProductId(){
        if(products.size() == 0){
            return "P-0001";
        }
        else{
            StringBuilder sb = new StringBuilder();

            String id = (products.get(products.size() - 1).getId());

            sb.append(id.substring(0, id.length() - 4));

            id = id.substring(id.length() - 4);
            int nextId = Integer.parseInt(id) + 1;
            sb.append(String.format("%04d", nextId));

            return sb.toString();
        }
    }

    @Override
    public Product getProduct(String id) {
        for(Product p : products)
        {
            if(p.getId().equals(id))
                return p;
        }
        throw new WarehouseNotContainsProductException();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void addNewOrder(Order order) {
        for(Order o : orders){
            if(o.getId().equals(order.getId())){
                throw new WarehouseAlreadyHasOrderException();
            }
        }
        orders.add(order);
    }

    @Override
    public void addNewOrder(OrderBuilder orderBuilder){
        String id = generateNewOrderId();
        orders.add(orderBuilder.getOrder(id));
    }

    public String generateNewOrderId(){
        if(orders.size() == 0){
            return "O-0001";
        }
        else{
            StringBuilder sb = new StringBuilder();

            String id = (orders.get(orders.size() - 1).getId());

            sb.append(id.substring(0, id.length() - 4));

            id = id.substring(id.length() - 4);
            int nextId = Integer.parseInt(id) + 1;
            sb.append(String.format("%04d", nextId));

            return sb.toString();
        }
    }

    @Override
    public Order getOrder(String id) {
        for(Order o : orders)
        {
            if(o.getId().equals(id))
                return o;
        }
        throw new WarehouseNotContainsOrderException();
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        for(Customer c : customers){
            if(c.getId().equals(customer.getId())){
                throw new WarehouseAlreadyHasCustomerException();
            }
        }
        customers.add(customer);
    }

    public void addNewCustomer(String name, String address){
        addNewCustomer(new SimpleCustomer(generateNewCustomerId(), name, address));
    }

    public String generateNewCustomerId(){
        if(customers.size() == 0){
            return "C-0001";
        }
        else{
            StringBuilder sb = new StringBuilder();

            String id = (customers.get(customers.size() - 1).getId());

            sb.append(id.substring(0, id.length() - 4));

            id = id.substring(id.length() - 4);
            int nextId = Integer.parseInt(id) + 1;
            sb.append(String.format("%04d", nextId));

            return sb.toString();
        }
    }

    @Override
    public Customer getCustomer(String id) {
        for(Customer c : customers)
        {
            if(c.getId().equals(id))
                return c;
        }
        throw new WarehouseNotContainsCustomerException();
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public void applyWarranty(String orderId, String productId)
    {
        //TODO get product from order
        Order order = this.getOrder(orderId);
        List<Product> ordersProducts = order.getProducts();
        for (Product p : ordersProducts) {
            if(p.getId().equals(productId)){
                p.applyWarranty();
                break;
            }
        }
    }
}
