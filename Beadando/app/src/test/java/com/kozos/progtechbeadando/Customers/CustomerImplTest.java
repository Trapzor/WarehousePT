package com.kozos.progtechbeadando.Customers;

import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooShortException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerIdCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameFormatNotAcceptableException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooShortException;

import org.junit.Assert;
import org.junit.Test;

public class CustomerImplTest {

    static String acceptableId = "testId";
    static String acceptableName = "test Name";
    static String acceptableAddress ="testAddressTest";

    @Test
    public void CustomerGetId() {
        Customer testCustomer = new SimpleCustomer(acceptableId, acceptableName, acceptableAddress);
        Assert.assertSame("testId", testCustomer.getId());
    }

    @Test
    public void CustomerIdCannotBeEmptyException() {
        Assert.assertThrows(CustomerIdCannotBeEmptyException.class, () -> {
            new SimpleCustomer("", acceptableName, acceptableAddress);
        });
    }

    @Test
    public void CustomerGetName() {
        Customer testCustomer = new SimpleCustomer(acceptableId, acceptableName, acceptableAddress);
        Assert.assertEquals("test Name", testCustomer.getName());
    }

    @Test
    public void CustomerNameCannotBeEmptyException() {
        Assert.assertThrows(CustomerNameCannotBeEmptyException.class, () -> {
            new SimpleCustomer(acceptableId, "", acceptableAddress);
        });
    }

    @Test
    public void CustomerNameTooShortException(){
        Assert.assertThrows(CustomerNameTooShortException.class, () -> {
            new SimpleCustomer(acceptableId, "t e", acceptableAddress);
        });
    }

    @Test
    public void CustomerNameFormatNotAcceptableException(){
        Assert.assertThrows(CustomerNameFormatNotAcceptableException.class, () -> {
            new SimpleCustomer(acceptableId, "testName", acceptableAddress);
        });
    }

    @Test
    public void CustomerGetAddress() {
        Customer testCustomer = new SimpleCustomer(acceptableId,acceptableName,acceptableAddress);
        Assert.assertEquals("testAddressTest", testCustomer.getAddress());
    }

    @Test
    public void CustomerAddressCannotBeEmptyException() {
        Assert.assertThrows(CustomerAddressCannotBeEmptyException.class, () -> {
            new SimpleCustomer(acceptableId, acceptableName, "");
        });
    }

    @Test
    public void CustomerAddressTooShortException(){
        Assert.assertThrows(CustomerAddressTooShortException.class, () -> {
            new SimpleCustomer(acceptableId,acceptableName,"testAdr");
        });
    }
}