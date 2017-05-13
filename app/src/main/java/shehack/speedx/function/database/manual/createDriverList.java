package shehack.speedx.function.database.manual;

import java.util.HashMap;

import shehack.speedx.function.database.Driver;


public class createDriverList {

    private HashMap<String, Driver> driverList;

    public createDriverList() {
        this.driverList = new HashMap<String, Driver>();
        createNewDriver("ABCD", "ABCD", 28.6618976, 77.2273958, "9560942231", "AAA");
        createNewDriver("EFGH", "EFGH", 24.30286, 78.52592, "9560942231", "BBB");
        createNewDriver("IJKL", "IJKL", 19.78744, 78.5652, "9560942231","CCC");
        createNewDriver("MNOP", "MNOP", 15.49298, 80.02957, "9560942231", "DDD");
        createNewDriver("QRST", "QRST", 12.0, 11.0, "9560942231", "E");
        createNewDriver("F", "F_1", 12.0, 11.0, "9560942231", "E");
        createNewDriver("G", "G_1", 12.0, 11.0, "9560942231", "E");
        createNewDriver("H", "H_1", 12.0, 11.0, "9560942231", "E");
        createNewDriver("I", "I_1", 12.0, 11.0, "9560942231", "E");
        createNewDriver("J", "J_1", 12.0, 11.0, "9560942231", "E");
    }

    public HashMap<String, Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(HashMap<String, Driver> driverList) {
        this.driverList = driverList;
    }

    /*   private Driver populateDefaultFields() {
        Driver newDriver = new Driver(driverId);
        newDriver.setName(name);
        newDriver.setAddress("address" + driverId);
        newDriver.setAgency("agency" + driverId);
        newDriver.setCoordX(coordX);
        newDriver.setCoordY(coordY);
        newDriver.setDriverId(driverId);
        newDriver.setEmail(name + driverId + "@bookmychauffeur.com");
        newDriver.setLicenseNo("license"+driverId);
        newDriver.setMobile(mobile);
        return(newDriver);
    }*/

    private void createNewDriver(String name, String driverId, double latitude, double longitude, String mobile, String agency)
    {
        Driver newDriver = new Driver(driverId);
        newDriver.setName(name);
        newDriver.setAddress("address" + driverId);
        newDriver.setAgency(agency);
        newDriver.setLatitude(latitude);
        newDriver.setLongitude(longitude);
        newDriver.setDriverId(driverId);
        newDriver.setEmail(name + driverId + "@speedx.com");
        newDriver.setLicenseNo("license"+driverId);
        newDriver.setMobile(mobile);
        driverList.put(driverId, newDriver);
    }







}
