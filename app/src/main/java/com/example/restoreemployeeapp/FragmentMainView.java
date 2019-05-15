package com.example.restoreemployeeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentMainView extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "SEA_Log";
    //TODO MAYBE
    private Button btnCallManager;
    private Intent callIntent;
    //TODO ABOVE MAYBE

  //  SupportMapFragment supportMapFragment;

/*    private MapView mMapView;
    private GoogleMap googleMap;*/

    private SupportMapFragment fragment;
    private GoogleMap map;

  /*  private GoogleMap mGoogleMap;
    MapView mapView;
    View view;*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

         View view = inflater.inflate(R.layout.fragment_mainview, container, false);


         try{
          /*   FragmentManager fm = getChildFragmentManager();
             fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
             if (fragment == null) {
                 fragment = SupportMapFragment.newInstance();
                 fm.beginTransaction().replace(R.id.map, fragment).commit();
             }*/
             SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                     .findFragmentById(R.id.map);
             mapFragment.getMapAsync(this);

         }catch (Exception e)
         {
             Log.d(TAG, "onCreateView: Exception " + e);
         }

      /*  try {
            supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            supportMapFragment.getMapAsync(this);

            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Map Exception  " + e);
        }*/

  /*      try {
            supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (supportMapFragment == null )
        {
            Log.d(TAG, "onCreateView: supportMapFragment is null");
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            supportMapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, supportMapFragment).commit();
        }

            supportMapFragment.getMapAsync(this);
        } catch (Exception e) {
            Log.d(TAG, "onCreateView: Exception " + e);
        }*/

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


    /*  map = googleMap;
        // Default Will Show Current Location
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            Log.d(TAG, "onMapReady: PERMISSION YES");

        }*/

 /*       MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.689247, -74.044582)).title("Title").snippet("Snippet"));*/
    }
}
