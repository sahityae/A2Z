package shehack.speedx;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookingConfirmation extends AppCompatActivity implements View.OnClickListener {

    private Button browse1, browse2, browse3;
    private EditText fileName1, fileName2, fileName3;
    private int fileSelector=0;
    private String selectedFilePath;
    private static final int PICK_FILE_REQUEST = 1;

    private Spinner vehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        addItemsToVehicles();
        addBookingDetails();

        browse1 = (Button) findViewById(R.id.invoice);
        fileName1 = (EditText) findViewById(R.id.fInvoice);
        browse1.setOnClickListener(this);

        browse2 = (Button) findViewById(R.id.gst);
        fileName2 = (EditText) findViewById(R.id.fGst);
        browse2.setOnClickListener(this);

        browse3 = (Button) findViewById(R.id.insurance);
        fileName3 = (EditText) findViewById(R.id.fInsurance);
        browse3.setOnClickListener(this);

        Button bookingCofirm = (Button) findViewById(R.id.confirmBooking);
        bookingCofirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //               SessionDetails.instance().chooseDrivers();
//                SessionDetails.instance().writeToFile();
//                Intent nextScreen = new Intent(BookingConfirmation.this, RouteItenary.class);
//                startActivity(nextScreen);
            }
        });

    }

    private void addBookingDetails() {
        TextView shipmentDetails = (TextView) findViewById(R.id.shipmentDetails);
        TextView fareDetails = (TextView) findViewById(R.id.fareDetails);
        shipmentDetails.setText("SHIPMENT DETAILS" + System.getProperty("line.separator")+"42 Hr | 2170 Km");
        fareDetails.setText("  ESTIMATED FARE" + System.getProperty("line.separator")+"  Rs. 29,755/-");
    }

    private void addItemsToVehicles() {
        vehicleType = (Spinner) findViewById(R.id.vehicles);
        List<String> vehicleList = new ArrayList<String>();
        vehicleList.add("Lorry");
        vehicleList.add("Trailer");
        vehicleList.add("Pick-Up");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, vehicleList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleType.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View v) {

        if (v == browse1) {
            //on attachment icon click
            fileSelector=1;
            showFileChooser();
        }

        if (v == browse2) {
            //on attachment icon click
            fileSelector=2;
            showFileChooser();
        }

        if (v == browse3) {
            //on attachment icon click
            fileSelector=3;
            showFileChooser();
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        //sets the select file to all types of files
        intent.setType("*/*");
        //allows to select data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //starts new activity to select file and return data
        startActivityForResult(Intent.createChooser(intent, "Choose File to Upload.."), PICK_FILE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == PICK_FILE_REQUEST){
                if(data == null){
                    //no data present
                    return;
                }


                Uri selectedFileUri = data.getData();
                selectedFilePath = selectedFileUri.getPath().toString();
                //FilePath.getPath(this,selectedFileUri);
                if(selectedFilePath != null && !selectedFilePath.equals("")){

                    switch(fileSelector) {
                        case 0 :
                            // Do nothing
                            break;

                        case 1 :
                            fileName1.setText(selectedFilePath);
                            break; // optional

                        case 2 :
                            fileName2.setText(selectedFilePath);
                            break; // optional

                        case 3 :
                            fileName3.setText(selectedFilePath);
                            break; // optional

                    }

                    if(fileSelector==0)
                    {
                        return;
                    }

                }else{
                    Toast.makeText(this, "Please select required files", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}