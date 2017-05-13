package shehack.speedx.function.database;

import java.io.File;


public class Vehicle {

    private String customerId;
    private String customerName;
    private String vehicleId;
    private String vehicleType;
    private File rc;
    private int rc_num;
    private File noc;
    private int kmTravelled;

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    private String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private String getCustomerName() {
        return customerName;
    }

    private void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String getVehicleId() {
        return vehicleId;
    }

    private void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    private String getVehicleType() {
        return vehicleType;
    }

    private void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    private File getRc() {
        return rc;
    }

    private void setRc(File rc) {
        this.rc = rc;
    }

    private int getRc_num() {
        return rc_num;
    }

    private void setRc_num(int rc_num) {
        this.rc_num = rc_num;
    }

    private File getNoc() {
        return noc;
    }

    private void setNoc(File noc) {
        this.noc = noc;
    }

    private int getKmTravelled() {
        return kmTravelled;
    }

    private void setKmTravelled(int kmTravelled) {
        this.kmTravelled = kmTravelled;
    }
}
