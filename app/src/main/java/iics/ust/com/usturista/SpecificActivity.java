package iics.ust.com.usturista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SpecificActivity extends AppCompatActivity {

    private int landmarkId;
    final String[] landmarkNames = {"Albertus Magnus", "UST Chapel", "Arch of the Centuries", "Miguel de Benavides Library",
            "Botanical Garden", "Quadricentennial Park Fountain"};
    int[] landmarkImages = {R.drawable.albertus_image, R.drawable.ust_chapel_image, R.drawable.arch_image,
            R.drawable.miguel_library_image, R.drawable.botanical_image, R.drawable.quadri_image};

    TextView landmarkname, landmark_description, back_button, getDirections;
    RelativeLayout landmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);

        landmarkname = (TextView)findViewById(R.id.landmark_name);
        landmark = (RelativeLayout) findViewById(R.id.landmark);
        landmark_description = (TextView) findViewById(R.id.description);
        back_button = (TextView) findViewById(R.id.back_button);
        getDirections = (TextView) findViewById(R.id.getDirections);

        getDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpecificActivity.this, SpecificLocation.class);
                String locName = (String) landmarkname.getText();
                intent.putExtra("loc", locName);
                startActivity(intent);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpecificActivity.this, SelectionActivity.class);

                startActivity(intent);
            }
        });

        Intent receivedIntent = getIntent();

        if(receivedIntent != null) {
            landmarkId = Integer.parseInt(receivedIntent.getStringExtra("LandmarkId"));
            landmarkname.setText(landmarkNames[landmarkId]);
            landmark.setBackgroundResource(landmarkImages[landmarkId]);

            switch(landmarkId){
                case 0:
                    landmark_description.setText(R.string.albertusMagnus);
                    break;
                case 1:
                    landmark_description.setText(R.string.ustChapel);
                    break;
                case 2:
                    landmark_description.setText(R.string.archCenturies);
                    break;
                case 3:
                    landmark_description.setText(R.string.benavidesLibrary);
                    break;
                case 4:
                    landmark_description.setText(R.string.botanicalGarden);
                    break;
                case 5:
                    landmark_description.setText(R.string.quadriPark);
                    break;
                default:
                    break;
            }

        }


    }
}
