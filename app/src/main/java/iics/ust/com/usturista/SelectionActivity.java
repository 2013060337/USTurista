package iics.ust.com.usturista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class SelectionActivity extends Activity{


    ListView myListView;
    TextView progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        final String[] landmarkNames = {"Albertus Magnus", "UST Chapel", "Arch of the Centuries", "Miguel de Benavides Library",
                "Botanical Garden", "Quadricentennial Park Fountain"};
        int[] landmarkImages = {R.drawable.albertus_image, R.drawable.ust_chapel_image, R.drawable.arch_image,
                R.drawable.miguel_library_image, R.drawable.botanical_image, R.drawable.quadri_image};

        ArrayList<LandmarkBaseAdapter> arrayOfLandmarkBaseAdapter = new ArrayList<LandmarkBaseAdapter>();
        LandmarkAdapter adapter = new LandmarkAdapter(getApplicationContext(), arrayOfLandmarkBaseAdapter);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        for (int i = 0; i < landmarkNames.length; i++) {
            LandmarkBaseAdapter addLandmark = new LandmarkBaseAdapter(landmarkImages[i], landmarkNames[i]);
            adapter.add(addLandmark);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String landid = Integer.toString(position);
                Intent intent = new Intent(SelectionActivity.this, SpecificActivity.class);
                intent.putExtra("LandmarkId", landid);
                startActivity(intent);
            }
        });


        if(getIntent() != null){
            Intent intent = getIntent();
            ProgressTracker pt = (ProgressTracker) intent.getSerializableExtra("myProgress");
            progress = (TextView)findViewById(R.id.progress);
            progress.setText(pt.getProgress()+ "% Complete");
        }




    }


}
