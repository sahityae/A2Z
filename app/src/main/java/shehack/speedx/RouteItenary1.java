package shehack.speedx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shehack.speedx.function.Constants;
import shehack.speedx.function.ItenaryAdapter;
import shehack.speedx.function.ItenaryItem;
import shehack.speedx.function.SessionDetails;
import shehack.speedx.function.database.Driver;
import shehack.speedx.function.database.Variables;

import static shehack.speedx.R.id.itenaryList;


public class RouteItenary1 extends AppCompatActivity {
    private List<ItenaryItem> itenaryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItenaryAdapter mAdapter;
    private LinearLayout layout;
    private int maxDriverCount = 8;
    TextView tDriver1, tDriver2, tDriver3, tDriver4, tDriver5;
    TextView tNo1, tNo2, tNo3, tNo4, tNo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_itenary1);

//        layout = (LinearLayout)findViewById(itenaryList);
//        tDriver1 = (TextView)findViewById(R.id.view1);
//        tDriver2 = (TextView)findViewById(R.id.view2);
//        tDriver3 = (TextView)findViewById(R.id.view3);
//        tDriver4 = (TextView)findViewById(R.id.view4);
//        tDriver5 = (TextView)findViewById(R.id.view5);
//
//
//        tNo1 = (TextView)findViewById(R.id.viewNo1);
//        tNo2 = (TextView)findViewById(R.id.viewNo2);
//        tNo3 = (TextView)findViewById(R.id.viewNo3);
//        tNo4 = (TextView)findViewById(R.id.viewNo4);
//        tNo5 = (TextView)findViewById(R.id.viewNo5);

        SessionDetails.instance().chooseDrivers();
        TextView from = (TextView) findViewById(R.id.textView1);
        from.setText(Constants.from);
        TextView to = (TextView) findViewById(R.id.textView3);
        to.setText(Constants.to);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        addItenaryDetails();
        mAdapter = new ItenaryAdapter(itenaryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
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
            HashMap<String, Driver> drivers = Variables.instance().getDriverList();
            Driver driver = drivers.get(driverList.get(i));

            String driverName = driver.getName();
            String acencyName = driver.getAgency();
            String num = driver.getMobile();
            String address = driver.getAddress();
            ItenaryItem item = new ItenaryItem(driverName, acencyName, address, num);
            itenaryList.add(item);
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
