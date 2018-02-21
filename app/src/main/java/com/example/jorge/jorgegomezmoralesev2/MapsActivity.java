package com.example.jorge.jorgegomezmoralesev2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Pais pais;
    double latitud;
    double longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        pais = (Pais) getIntent().getExtras().getSerializable("objeto");
        Toast.makeText(getApplicationContext(), pais.getNombreCastellano(), Toast.LENGTH_SHORT).show();

        if (pais.getLongitud().equals("") && pais.getLatitud().equals("")) {
            longitud = 0;
            latitud = 0;
        }
        else {
            latitud = Double.parseDouble(pais.getLatitud());
            longitud = Double.parseDouble(pais.getLongitud());
        }

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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng posicion = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(posicion).title("Capital: " + pais.getCapital() + " Poblacion: " + pais.getPoblacion()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(posicion));


    }
}
