package shehack.speedx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.List;

import shehack.speedx.function.SessionDetails;


public class RouteItenary1 extends AppCompatActivity {

    private LinearLayout layout;
    private int maxDriverCount = 8;
    TextView tDriver1, tDriver2, tDriver3, tDriver4, tDriver5;
    TextView tNo1, tNo2, tNo3, tNo4, tNo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_itenary1);

        layout = (LinearLayout)findViewById(R.id.itenaryList);
        tDriver1 = (TextView)findViewById(R.id.view1);
        tDriver2 = (TextView)findViewById(R.id.view2);
        tDriver3 = (TextView)findViewById(R.id.view3);
        tDriver4 = (TextView)findViewById(R.id.view4);
        tDriver5 = (TextView)findViewById(R.id.view5);


        tNo1 = (TextView)findViewById(R.id.viewNo1);
        tNo2 = (TextView)findViewById(R.id.viewNo2);
        tNo3 = (TextView)findViewById(R.id.viewNo3);
        tNo4 = (TextView)findViewById(R.id.viewNo4);
        tNo5 = (TextView)findViewById(R.id.viewNo5);

        SessionDetails.instance().chooseDrivers();
        addItenaryDetails();
    }

    private void addItenaryDetails() {

        List<String> driverList = SessionDetails.instance().getDrivers();
        List<LatLng> changePoints = SessionDetails.instance().getChangePoints();
        LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        int numDrivers = driverList.size();

        for (int i = 0; i < numDrivers; i++) {
            /*TextView driverDetails = new TextView(this);
            //   LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            driverDetails.setLayoutParams(dim);
            driverDetails.setText("Driver:" + driverList.get(i)+System.getProperty("line.separator")+"Latlng: "+ changePoints.get(i).toString() );
            layout.addView(driverDetails);*/

            switch(i) {
                case 0 :
                    tDriver1.setText("Driver:" + driverList.get(i) + System.getProperty("line.separator") + "Latlng: " + changePoints.get(i).toString());
                    break;

                case 1 :
                    tDriver2.setText("Driver:" + driverList.get(i) + System.getProperty("line.separator") + "Latlng: " + changePoints.get(i).toString());

                    break; // optional

                case 2 :
                    tDriver3.setText("Driver:" + driverList.get(i) + System.getProperty("line.separator") + "Latlng: " + changePoints.get(i).toString());
                    break; // optional

                case 3 :
                    tDriver4.setText("Driver:" + driverList.get(i) + System.getProperty("line.separator") + "Latlng: " + changePoints.get(i).toString());
                    break; // optional
                case 4 :
                    tDriver5.setText("Driver:" + driverList.get(i) + System.getProperty("line.separator") + "Latlng: " + changePoints.get(i).toString());
                    break; // optional


            }
        }

        if(numDrivers < 4)
        {
            int NumRedundantViews = 4-numDrivers;

            switch(NumRedundantViews) {
                case 0 :
                    // Do nothing
                    break;

                case 1 :
                    tDriver5.setVisibility(View.GONE);
                    tNo5.setVisibility(View.GONE);
                    break; // optional

                case 2 :
                    tDriver5.setVisibility(View.GONE);
                    tNo5.setVisibility(View.GONE);

                    tDriver4.setVisibility(View.GONE);
                    tNo4.setVisibility(View.GONE);
                    break; // optional

                case 3 :

                    break; // optional
                case 4 :

                    break; // optional
                case 5 :

                    break; // optional

            }

        }


        /*TextView driverDetails1 = new TextView(this);
        //   LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        driverDetails1.setLayoutParams(dim);
        driverDetails1.setText("size:" + driverList.size() );
        layout.addView(driverDetails1);*/


            /*for (int i = 0; i < driverList.size(); i++) {
                TextView driverDetails = new TextView(this);
             //   LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                driverDetails.setLayoutParams(dim);
                driverDetails.setText("Driver:" + driverList.get(i)+System.getProperty("line.separator")+"Latlng: "+ changePoints.get(i).toString() );
                layout.addView(driverDetails);
            }*/

      /*  TextView driverDetails1 = new TextView(this);
        LinearLayout.LayoutParams dim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        driverDetails1.setLayoutParams(dim);
        List<List<HashMap<String,String>>> requestedRoute = SessionDetails.instance().getRequestedRoute();
        double lastLat = SessionDetails.instance().getLatitude();
        double lastLng = SessionDetails.instance().getLongitude();
        double destLat = SessionDetails.instance().getDestLatitude();
        double destLng = SessionDetails.instance().getDestLongitude();
        float[] distance1 = new float[1];
        Location.distanceBetween(lastLat, lastLng,
                destLat, destLng,
                distance1);
        float distTravelled1 = distance1[0];
        driverDetails1.setText("size " + SessionDetails.instance().getRequestedRoute().size()+System.getProperty("line.separator")+"tot dist: "+(distTravelled1/1000)+
                System.getProperty("line.separator")+"strt latlng: "+lastLat +" "+lastLng );
        layout.addView(driverDetails1);



        if(SessionDetails.instance().getRequestedRoute() != null || SessionDetails.instance().getRequestedRoute().isEmpty()==false) {

            double lat =0;
            double lng =0;
            for(int i=0;i<requestedRoute.size();i++) {

                List<HashMap<String, String>> listSteps = requestedRoute.get(i);
                for(int j=0; j<listSteps.size(); j++)
                {
                    lat = Double.parseDouble(listSteps.get(j).get("lat"));
                    lng = Double.parseDouble(listSteps.get(j).get("lng"));
           //         content += "LatLng: " + lat +"   "+lng+"\n\r";
                    float[] distance = new float[1];
                    Location.distanceBetween(lastLat, lastLng,
                            lat, lng,
                            distance);
                    float distTravelled = distance[0];
                    if((distTravelled/1000)>500)
                    {
                        TextView driverDetails2 = new TextView(this);
                        // LinearLayout.LayoutParams dim1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        driverDetails2.setLayoutParams(dim);
                        driverDetails2.setText("latlng: " + lat + " " + lng + System.getProperty("line.separator") + "distance:" + distTravelled);
                        layout.addView(driverDetails2);
                    //   content += "changePoint: " +lat+"   "+lng+"\n\r";
                        //   selectNewDriver(lat, lng);
                        lastLat= lat;
                        lastLng=lng;
                    }

                }

                TextView driverDetails3 = new TextView(this);
                // LinearLayout.LayoutParams dim1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                driverDetails3.setLayoutParams(dim);
                float[] distance2 = new float[1];
                Location.distanceBetween(lastLat, lastLng,
                        lat, lng,
                        distance2);
                float distTravelled2 = distance2[0];
                driverDetails3.setText("last dist: "+(distTravelled2/1000)+
                        System.getProperty("line.separator")+"end latlng: "+lat +" "+lng +"dest latlng: "+destLat+" "+destLng );
                layout.addView(driverDetails3);


            }
        }


        else{
            TextView driverDetails2 = new TextView(this);
           // LinearLayout.LayoutParams dim1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            driverDetails2.setLayoutParams(dim);
            driverDetails2.setText("nothing inside " );
            layout.addView(driverDetails2);
        }*/

    }
}