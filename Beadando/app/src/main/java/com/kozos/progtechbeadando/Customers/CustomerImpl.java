package com.kozos.progtechbeadando.Customers;

public class CustomerImpl implements Customer{

    public CustomerImpl(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    String id;
    String name;
    String address;

    @Override
    public String getId() {
        return id;
    }
    void setId(String id){
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}
