package iics.ust.com.usturista;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SpecificLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        final LatLng albertusmagnus = new LatLng(14.610504, 120.991258);
        final LatLng ustChapel = new LatLng(14.609207, 120.988353);
        final LatLng archCenturies = new LatLng(14.608452, 120.990905);
        final LatLng benavidesLib = new LatLng(14.610810, 120.988441);
        final LatLng botanical = new LatLng(14.610119, 120.988531);
        final LatLng quadriPark = new LatLng(14.610594, 120.988813);

        TextView imHere = (TextView) findViewById(R.id.imHere);
        final Bundle bundle = getIntent().getExtras();

        if(bundle.getString("loc")!= null)
        {
            Toast.makeText(this, bundle.getString("loc"), Toast.LENGTH_SHORT).show();
        }




        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);

        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);

            switch(bundle.getString("loc")){
                case "Albertus Magnus":
                    mMap.addMarker(new MarkerOptions().position(albertusmagnus).title("Albertus Magnus"));
                    break;
                case "UST Chapel":
                    mMap.addMarker(new MarkerOptions().position(ustChapel).title("UST Chapel"));
                    break;
                case "Arch of the Centuries":
                    mMap.addMarker(new MarkerOptions().position(archCenturies).title("Arch of the Centuries"));
                    break;
                case "Miguel de Benavides Library":
                    mMap.addMarker(new MarkerOptions().position(benavidesLib).title("Miguel de Benavides Library"));
                    break;
                case "Botanical Garden":
                    mMap.addMarker(new MarkerOptions().position(botanical).title("Botanical Garden"));
                    break;
                case "Quadricentennial Park Fountain":
                    mMap.addMarker(new MarkerOptions().position(quadriPark).title("Quadricentennial Park Fountain"));
                    break;
            }

            imHere.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgressTracker pt = new ProgressTracker();
                    pt.changeStatus(bundle.getString("loc"));
                    Intent intent = new Intent(SpecificLocation.this, SelectionActivity.class);
                    //Intent intent = new Intent(FirstActivity.this, OrderScreen.class);
                    intent.putExtra("myProgress", pt);
                    startActivity(intent);
                    Toast.makeText(getApplication().getApplicationContext(), bundle.getString("loc") + " has been visited",
                            Toast.LENGTH_LONG).show();
                }
            });


            GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
                @Override
                public void onMyLocationChange (Location location) {
                    Bundle bundle = getIntent().getExtras();
                    LatLng loc = new LatLng (location.getLatitude(), location.getLongitude());

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16.0f));
                    mMap.addMarker(new MarkerOptions().position(loc).title("Your are here"));
//                    PolylineOptions poption;
//                    switch(bundle.getString("loc")){
//                        case "Albertus Magnus":
//                            poption = new PolylineOptions().add(loc).add(albertusmagnus).width(5).color(Color.BLUE).geodesic(true);
//                            googleMap.addPolyline(poption);
////                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(albertusmagnus, 18));
//                            break;
//                        case "UST Chapel":
//                            poption = new PolylineOptions().add(loc).add(ustChapel).width(5).color(Color.BLUE).geodesic(true);
//                            googleMap.addPolyline(poption);
////                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ustChapel, 18));
//                            break;
//                        case "Arch of the Centuries":
//                            poption = new PolylineOptions().add(loc).add(archCenturies).width(5).color(Color.BLUE).geodesic(true);
//                            googleMap.addPolyline(poption);
////                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(archCenturies, 18));
//                            break;
//                        case "Miguel de Benavides Library":
//                            poption = new PolylineOptions().add(loc).add(benavidesLib).width(5).color(Color.BLUE).geodesic(true);
//                            googleMap.addPolyline(poption);
////                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(benavidesLib, 18));
//                            break;
//                        case "Botanical Garden":
//                            poption = new PolylineOptions().add(loc).add(botanical).width(5).color(Color.BLUE).geodesic(true);
//                            googleMap.addPolyline(poption);
////                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(botanical, 18));
//                            break;
//                        case "Quadricentennial Park Fountain":
//                            poption = new PolylineOptions().add(loc).add(quadriPark).width(5).color(Color.BLUE).geodesic(true);
//                            googleMap.addPolyline(poption);
////                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(quadriPark, 18));
//                            break;
//                    }
                }
            };
            mMap.setOnMyLocationChangeListener(myLocationChangeListener);



        }


    }


}
