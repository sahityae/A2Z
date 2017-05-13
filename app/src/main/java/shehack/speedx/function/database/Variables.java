package shehack.speedx.function.database;

import java.util.HashMap;

import shehack.speedx.function.database.manual.createCustomerList;
import shehack.speedx.function.database.manual.createDriverList;


public class Variables {
    private static Variables self;
    private HashMap<String, Customer> customerList;

    //Create local database for drivers
    private HashMap<String, Driver> driverList;


    public Variables() {
        createDriverList dummydriverList = new createDriverList();
        this.driverList = dummydriverList.getDriverList();
        createCustomerList dummycustomerList = new createCustomerList();
        this.customerList = dummycustomerList.getCustomerList();
    }

    //Creating a singleton class to act like a database
    public static Variables instance() {
        if (null == self) {
            self = new Variables();
        }
        return self;
    }

    public HashMap<String, Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(HashMap<String, Customer> customerList) {
        this.customerList = customerList;
    }

    public HashMap<String, Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(HashMap<String, Driver> driverList) {
        this.driverList = driverList;
    }
}
