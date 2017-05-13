package shehack.speedx.function;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import shehack.speedx.function.database.Driver;
import shehack.speedx.function.database.Variables;



public class SessionDetails {
    private static SessionDetails self;

    private double latitude;
    private double longitude;
    private double destLatitude;
    private double destLongitude;
    private String custEmail;
    private String custPassword;
    private List<List<HashMap<String, String>>> requestedRoute = new ArrayList<>();
    private double lastLat;
    private double lastLng;


    List<String> drivers = new ArrayList<>();
    List<LatLng> changePoints = new ArrayList<>();
    float totalDist;


    public SessionDetails()
    {
        populateCustomerDetails();
    }


    public static SessionDetails instance() {
        if (null == self) {
            self = new SessionDetails();
        }
        return self;
    }


    public void calcRideDist()
    {

        float[] distance = new float[1];
        Location.distanceBetween(latitude, longitude,
                destLatitude, destLongitude,
                distance);
        totalDist = (distance[0])/1000;
    }

    public void chooseDrivers()
    {
        selectNewDriver(lastLat,lastLng);
        if(requestedRoute != null || requestedRoute.isEmpty()==false) {
            double lat =0;
            double lng =0;
            for(int i=0;i<requestedRoute.size();i++) {

                List<HashMap<String, String>> listSteps = requestedRoute.get(i);
                for(int j=0; j<listSteps.size(); j++)
                {
                    lat = Double.parseDouble(listSteps.get(j).get("lat"));
                    lng = Double.parseDouble(listSteps.get(j).get("lng"));

                    float[] distance = new float[1];
                    Location.distanceBetween(lastLat, lastLng,
                            lat, lng,
                            distance);
                    float distTravelled = (distance[0])/1000;
                    if(distTravelled>500)
                    {
                       selectNewDriver(lat,lng);
                       /* drivers.add("AAA");
                        changePoints.add(new LatLng(lat, lng));
                        lastLat = lat;
                        lastLng = lng;*/

                    }

                }

            }
        }


    }

    private void selectNewDriver(double lat, double lng) {

        HashMap<String, Driver> driverList = Variables.instance().getDriverList();

        for (Entry<String, Driver> entry : driverList.entrySet())
        {
            double driverLat = entry.getValue().getLatitude();
            double driverLng = entry.getValue().getLongitude();
            float[] distance = new float[1];
            Location.distanceBetween(lat, lng,
                    driverLat, driverLng,
                    distance);
            float distTravelled = (distance[0])/1000;
            if(distTravelled<50)
            {
                drivers.add(entry.getValue().getDriverId());
                changePoints.add(new LatLng(lat, lng));
                lastLat = lat;
                lastLng = lng;
                return;
            }


        }
    }

    private void populateCustomerDetails() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
        this.lastLat = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
        this.lastLng = longitude;
    }

    public double getDestLongitude() {
        return destLongitude;
    }

    public void setDestLongitude(double destLongitude) {
        this.destLongitude = destLongitude;
    }

    public double getDestLatitude() {
        return destLatitude;
    }

    public void setDestLatitude(double destLatitude) {
        this.destLatitude = destLatitude;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public List<List<HashMap<String, String>>> getRequestedRoute() {
        return requestedRoute;
    }

    public void setRequestedRoute(List<List<HashMap<String, String>>> requestedRoute) {
        this.requestedRoute = requestedRoute;
    }

    public List<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
    }

    public List<LatLng> getChangePoints() {
        return changePoints;
    }

    public void setChangePoints(List<LatLng> changePoints) {
        this.changePoints = changePoints;
    }


    public float getTotalDist() {
        return totalDist;
    }

    public void setTotalDist(float totalDist) {
        this.totalDist = totalDist;
    }


}
