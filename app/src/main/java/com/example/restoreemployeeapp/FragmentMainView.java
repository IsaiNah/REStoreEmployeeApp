package com.example.restoreemployeeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class FragmentMainView extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "SEA_Log";
    //TODO MAYBE
    private Button btnCallManager;
    private Intent callIntent;
    //TODO ABOVE MAYBE


    private SupportMapFragment supportMapFragment;
    private GoogleMap map;

    String homeAddress;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

         View view = inflater.inflate(R.layout.fragment_mainview, container, false);

         //Activating Drawer
        try {
            ((DrawerLocker) getActivity()).setDrawerEnabled(true);
        }catch(Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }
         // Getting Bundle Data for Nav
         Bundle bundle = this.getArguments();

      if (bundle != null)
      {
          Log.d(TAG, "onCreateView: bundle not NULL, data in bundle : " + bundle.getString("Address"));
          homeAddress = bundle.getString("Address");
      }

        Log.d(TAG, "onCreateView: HomeAddress " + homeAddress);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        try {
            supportMapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
            supportMapFragment.getMapAsync(this);
        }catch(Exception e)
        {
            Log.d(TAG, "onViewCreated: Exception " + e);
        }
        try {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        }catch (Exception e)
        {
            Log.d(TAG, "onViewCreated: Exception : " + e);
        }
 /*       try{
           *//*  FragmentManager fm = getChildFragmentManager();
             fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
             if (fragment == null) {
                 fragment = SupportMapFragment.newInstance();
                 fm.beginTransaction().replace(R.id.map, fragment).commit();
             }*//*
            SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        map = googleMap;

//        LatLng pp  = new LatLng(-33.852, 151.211);
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
 /*       LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        if (homeAddress != null)
        {
            Log.d(TAG, "onMapReady: homneaddress not null" + homeAddress);
            String latlng = getLocationFromAddress(homeAddress);

            Log.d(TAG, "onMapReady: Lat Lng = " + latlng);

            //Separating string from latng to get lat and lng
            String [] latlngString =  latlng.split(",");
            Log.d(TAG, "onMapReady: Lat Lng independently = " + latlngString[0] + " and " + latlngString[1]);
            // Parsing extracted strings to doubles
            double lat = Double.parseDouble(latlngString[0]);
            double lng = Double.parseDouble(latlngString[1]);

            //Setting map to home address
            LatLng homeAddress = new LatLng(lat,lng);
           // googleMap.addMarker(new MarkerOptions().snippet("Home Address"));
            googleMap.addMarker(new MarkerOptions().position(homeAddress).title("Home Address"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(homeAddress));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15),2000,null);

        }
else {
            map = googleMap;
            // Default Will Show Current Location
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                googleMap.setMyLocationEnabled(true);


                /*googleMap.moveCamera();*/
                Log.d(TAG, "onMapReady: PERMISSION YES");

            } else {
                Log.d(TAG, "onMapReady: PERMISSION NO");
            }
        }
 /*       MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.689247, -74.044582)).title("Title").snippet("Snippet"));*/
    }


    /**
     * to get latitude and longitude of an address
     *
     * @param strAddress address string
     * @return lat and lng in comma separated string
     */
    public String getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(getContext());
        List<Address> address;

        try {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            double lat = location.getLatitude();
            double lng = location.getLongitude();

            return lat + "," + lng;
        } catch (Exception e) {
            return null;
        }
    }
}
