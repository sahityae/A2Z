package shehack.speedx.function.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Customer {

    private String firstName;
    private String lastName;
    private double coordX;
    private double coordY;
    private String email;
    private String mobile;
    private String password;
    private List<List<HashMap<String, String>>> requestedRoute = new ArrayList<>();
    private HashMap<String, Vehicle> vehicleDetails = new HashMap<String, Vehicle>();

    public Customer(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Vehicle> getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(HashMap<String, Vehicle> vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}
