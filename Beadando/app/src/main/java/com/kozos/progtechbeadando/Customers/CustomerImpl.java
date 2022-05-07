package com.kozos.progtechbeadando.Customers;

import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooShortException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerIdCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameFormatNotAcceptabbleException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooShortException;

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
    void setId(String id) throws CustomerIdCannotBeEmptyException {
        if(id == null || id.equals(" "))
            throw new CustomerIdCannotBeEmptyException();
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) throws CustomerNameCannotBeEmptyException, CustomerNameFormatNotAcceptabbleException, CustomerNameTooShortException, CustomerNameTooLongException {
        if(name == null || name.equals(" "))
            throw new CustomerNameCannotBeEmptyException();
        if(!name.contains(" "))
            throw new CustomerNameFormatNotAcceptabbleException();
        if(name.length() < 3)
            throw new CustomerNameTooShortException();
        if(name.length() > 50)
            throw  new CustomerNameTooLongException();
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public void setAddress(String address) throws CustomerAddressCannotBeEmptyException, CustomerAddressTooShortException, CustomerAddressTooLongException {
        if(address == null || address.equals(" "))
            throw new CustomerAddressCannotBeEmptyException();
        if(address.length() < 13)
            throw new CustomerAddressTooShortException();
        if(address.length() > 100)
            throw new CustomerAddressTooLongException();
        this.address = address;
    }
}
