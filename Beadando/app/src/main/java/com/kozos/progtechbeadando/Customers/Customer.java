package com.kozos.progtechbeadando.Customers;

import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooShortException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameFormatNotAcceptabbleException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooShortException;

public interface Customer {

    String getId();

    String getName();
    void setName(String name) throws CustomerNameCannotBeEmptyException, CustomerNameFormatNotAcceptabbleException, CustomerNameTooShortException, CustomerNameTooLongException;

    String getAddress();
    void setAddress(String address) throws CustomerAddressCannotBeEmptyException, CustomerAddressTooShortException, CustomerAddressTooLongException;

}
