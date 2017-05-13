package shehack.speedx.function.database.manual;

import java.util.HashMap;

import shehack.speedx.function.database.Customer;
import shehack.speedx.function.database.Vehicle;


public class createCustomerList {


    private HashMap<String, Customer> customerList;

    public createCustomerList() {
        this.customerList = new HashMap<String, Customer>();
        createCustomerList("A", "A_1", 12.0, 11.0, "9560942231");
        createCustomerList("B", "B_1", 12.0, 11.0, "9560942231");
        createCustomerList("C", "C_1", 12.0, 11.0, "9560942231");
        createCustomerList("D", "D_1", 12.0, 11.0, "9560942231");
        createCustomerList("E", "E_1", 12.0, 11.0, "9560942231");
        createCustomerList("F", "F_1", 12.0, 11.0, "9560942231");
        createCustomerList("G", "G_1", 12.0, 11.0, "9560942231");
        createCustomerList("H", "H_1", 12.0, 11.0, "9560942231");
        createCustomerList("I", "I_1", 12.0, 11.0, "9560942231");
        createCustomerList("J", "J_1", 12.0, 11.0, "9560942231");
    }

    public HashMap<String, Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(HashMap<String, Customer> customerList) {
        this.customerList = customerList;
    }

    private void createCustomerList(String name, String email, double coordX, double coordY, String mobile)
    {
        Customer newCustomer = new Customer(email);
        newCustomer.setFirstName(name);
        newCustomer.setLastName("_1");
        newCustomer.setCoordY(coordY);
        newCustomer.setCoordX(coordX);
        newCustomer.setEmail(email);
        newCustomer.setMobile(mobile);
        String vehicleId1 = "v1";
        String vehicleId2 = "v2";
        String vehicleId3 = "v3";
        HashMap<String, Vehicle> vehicleDetails = new HashMap<String, Vehicle>();
        vehicleDetails.put(vehicleId1, new Vehicle(vehicleId1));
        vehicleDetails.put(vehicleId2, new Vehicle(vehicleId2));
        vehicleDetails.put(vehicleId3, new Vehicle(vehicleId3));
        newCustomer.setVehicleDetails(vehicleDetails);
        customerList.put(email,newCustomer);
    }

}
