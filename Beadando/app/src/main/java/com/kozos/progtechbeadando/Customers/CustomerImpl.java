package com.kozos.progtechbeadando.Customers;

import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooShortException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerIdCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameFormatNotAcceptableException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooShortException;

public abstract class CustomerImpl implements Customer{

    public CustomerImpl(String id, String name, String address) {
        setId(id);
        setName(name);
        setAddress(address);
    }

    String id;
    String name;
    String address;

    @Override
    public String getId() {
        return id;
    }
    void setId(String id) throws CustomerIdCannotBeEmptyException {
        if(id == null || id.equals(" ") ||id.equals(""))
            throw new CustomerIdCannotBeEmptyException();
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) throws CustomerNameCannotBeEmptyException, CustomerNameFormatNotAcceptableException, CustomerNameTooShortException, CustomerNameTooLongException {
        if(name == null || name.equals(" ") || name.equals(""))
            throw new CustomerNameCannotBeEmptyException();
        if(!name.contains(" "))
            throw new CustomerNameFormatNotAcceptableException();
        if(name.length() < 4)
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
        if(address == null || address.equals(" ") || address.equals(""))
            throw new CustomerAddressCannotBeEmptyException();
        if(address.length() < 13)
            throw new CustomerAddressTooShortException();
        if(address.length() > 100)
            throw new CustomerAddressTooLongException();
        this.address = address;
    }
}
