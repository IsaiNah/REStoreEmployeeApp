package com.example.restoreemployeeapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class FragmentTestNav extends Fragment implements OnMapReadyCallback
{
    private static final String TAG = "SEA_Log";

    //Google Maps
    private SupportMapFragment supportMapFragment;
    private GoogleMap map;

    private String selectedAddress;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_testnav, container, false);

        Bundle bundle = this.getArguments();

        selectedAddress = bundle.getString("Address");

        Log.d(TAG, "onCreateView: FragmentTestNav , StoreName received " + selectedAddress);


        return  view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      /*  if (savedInstanceState == null) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmenct_container, new FragmentTestNav()).commit();
        }*/
    try {
        supportMapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map1);
        supportMapFragment.getMapAsync(this);
    }catch (Exception e)
    {
        Log.d(TAG, "onViewCreated: Exception " + e);
    }
    }

/*    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        Log.d(TAG, "onMapReady: FragmentTestNav");

        String latlng = getLocationFromAddress(selectedAddress);

        Log.d(TAG, "onMapReady: latlng locationFromAdress " + latlng);

       // Seperating Lat and Lng from String latlng
        String[] latlngString = latlng.split(",");
        // Parsing extracted string to doubles
        double lat = Double.parseDouble(latlngString[0]);
        double lng = Double.parseDouble(latlngString[1]);

        LatLng address = new LatLng(lat,lng);
        googleMap.addMarker(new MarkerOptions().position(address).title("Selected Address"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(address));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);


        /*LatLng sydney = new LatLng(-33.867, 151.206);

       // googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
        googleMap.addMarker(new MarkerOptions()
                        .title("Sydney")
                        .snippet("The most populous city in Australia.")
                        .position(sydney));*/
     /*   if (selectedAddress != null) {
            map = googleMap;
            if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
            {

            }
        }*/
        //String latlng = getLocationFromAddress()



    }

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
