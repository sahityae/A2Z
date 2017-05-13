package shehack.speedx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ServiceSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_selection);

        Button outstation = (Button) findViewById(R.id.outstation);
        outstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(ServiceSelection.this, MapsActivity.class);
                startActivity(nextScreen);
            }
        });
        Button incity = (Button) findViewById(R.id.incity);
        incity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(ServiceSelection.this, MapsActivity.class);
                startActivity(nextScreen);
            }
        });
    }
}
