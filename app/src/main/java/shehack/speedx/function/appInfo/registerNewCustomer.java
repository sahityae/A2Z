package shehack.speedx.function.appInfo;

import java.util.HashMap;

import shehack.speedx.function.database.Customer;
import shehack.speedx.function.database.Variables;

public class registerNewCustomer {
    private String customerId;
    private Customer newlyRegistered;

    public registerNewCustomer(String customerId, Customer newlyRegistered) {
        this.customerId = customerId;
        this.newlyRegistered = newlyRegistered;
    }

    private void addCustomerToDB()
    {
        HashMap<String, Customer> customerList = Variables.instance().getCustomerList();
        customerList.put(customerId, newlyRegistered);
        Variables.instance().setCustomerList(customerList);
    }
}
