package iics.ust.com.usturista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginActivity(View v)
    {
        Intent intent = new Intent(getApplicationContext(), SelectionActivity.class);
        startActivity(intent);
    }


}
