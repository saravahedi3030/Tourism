package com.example.avestafani.tourism;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,CompoundButton.OnCheckedChangeListener {

    private GoogleMap mMap;
    private Marker marker;
    RadioButton rbtnnormal,rbtntran,rbtnsatellite,rbtnhybrid,rbtnnon;
    SearchView sv_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkPlayservices()){


        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
            findview();

            mapFragment.getMapAsync(this);
    }
    }
    private void findview() {

        rbtnnormal= (RadioButton) findViewById(R.id.rbtnnormal);
        rbtntran= (RadioButton) findViewById(R.id.rbtntran);
        rbtnsatellite= (RadioButton) findViewById(R.id.rbtnsatellite);
        rbtnhybrid= (RadioButton) findViewById(R.id.rbtnhybrid);
        rbtnnon= (RadioButton) findViewById(R.id.rbtnnon);
        sv_location= (SearchView) findViewById(R.id.sv_location);

    }

   private void setListeners(){
       rbtnnormal.setOnCheckedChangeListener(this);
       rbtntran.setOnCheckedChangeListener(this);
       rbtnsatellite.setOnCheckedChangeListener(this);
       rbtnhybrid.setOnCheckedChangeListener(this);
       rbtnnon.setOnCheckedChangeListener(this);
       sv_location.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               String location=sv_location.getQuery().toString();
               List<Address> addressList=null;
               if (location!=null||!location.equals("")){
                   Geocoder geocoder=new Geocoder(MapsActivity
                           .this);

                   try {
                       addressList = geocoder.getFromLocationName(location, 1);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                   Address address = addressList.get(0);
                   LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                   mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                   mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

               }

               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               return false;
           }
       });

   }


   private void setDefaltData(){
     rbtnnormal.setChecked(true);
     rbtntran.setChecked(false);
     rbtnsatellite.setChecked(false);
     rbtnhybrid.setChecked(false);
     rbtnnon.setChecked(false);

       }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        setListeners();
        setDefaltData();
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {

                Geocoder gc=new Geocoder(MapsActivity.this);
                List<Address>list=null;
                try {
                    list=gc.getFromLocation(latLng.longitude,latLng.longitude,1);
                    if (list.size()>0){
                        Address add=list.get(0);
                        if (marker!=null)
                            marker.remove();
                        addmarker(add);

                    }

                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view=getLayoutInflater().inflate(R.layout.info_window,null);
                TextView txtlocaliy= (TextView) view.findViewById(R.id.txtlocaliy);
                TextView txtlat= (TextView) view.findViewById(R.id.txtlat);
                TextView txtlon= (TextView) view.findViewById(R.id.txtlon);
                TextView txtsnippet= (TextView) view.findViewById(R.id.txtsnippet);

                txtlocaliy.setText(marker.getTitle());
                txtlat.setText("latitude:"+marker.getPosition().latitude);
                txtlon.setText("longitude"+marker.getPosition().longitude);
                txtsnippet.setText(marker.getSnippet());
                return view;

            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String msg=marker.getTitle()+"("+
                        marker.getPosition().latitude+","+
                        marker.getPosition().longitude+")";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Geocoder gc=new Geocoder(MapsActivity.this);
                List<Address>list=null;
                try {
                    list=gc.getFromLocation(marker.getPosition().latitude,marker.getPosition().longitude,1);

                    if (list.size()>0){
                        Address add=list.get(0);
                        marker.setTitle(add.getLocality());
                        marker.setSnippet(add.getCountryName());
                        marker.showInfoWindow();
                    }

                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

       mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(getApplicationContext(),"on click",Toast.LENGTH_SHORT).show();

    }
});
        mMap.setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() {
            @Override
            public void onInfoWindowLongClick(Marker marker) {
                Toast.makeText(getApplicationContext()," on long click",Toast.LENGTH_SHORT).show();

            }
        });
        mMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
            @Override
            public void onInfoWindowClose(Marker marker) {
                Toast.makeText(getApplicationContext()," Info window is close",Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void addmarker(Address address){
        MarkerOptions markerOptions=new MarkerOptions()
                .position(new LatLng(address.getLatitude(),address.getLongitude()))
                .title(address.getLocality())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                .rotation(0);


        String contry=address.getCountryName();
        if (contry!=null&&contry.length()>0)
            markerOptions.snippet(contry);

        marker=mMap.addMarker(markerOptions);


    }



    private boolean checkPlayservices(){
        GoogleApiAvailability googleAPI=GoogleApiAvailability.getInstance();
        int result=googleAPI.isGooglePlayServicesAvailable(this);
        if (result== ConnectionResult.SUCCESS)
            return true;
        else {
            if (googleAPI.isUserResolvableError(result))
                googleAPI.getErrorDialog(this,result,9000).show();
            return false;
        }
    }

    private boolean checkMapIsReady(){
        if (mMap==null) {
            Toast.makeText(getApplicationContext(), "Map Is Not Ready Tet", Toast.LENGTH_SHORT).show();
            return false;
        }
            else
            return true;

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (rbtnnormal.isChecked())
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        else if (rbtntran.isChecked())
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        else if (rbtnsatellite.isChecked())
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        else if (rbtnhybrid.isChecked())
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        else if (rbtnnon.isChecked())
            mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
    }
}
