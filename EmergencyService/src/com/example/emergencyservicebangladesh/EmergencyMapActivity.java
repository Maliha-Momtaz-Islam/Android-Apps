package com.example.emergencyservicebangladesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import location.GPSTracker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class EmergencyMapActivity extends FragmentActivity {

	private static LatLng Destination ;
	private static LatLng Start ;
	private GoogleMap map;
	private SupportMapFragment fragment;
	private LatLngBounds latlngBounds;
	private Button bNavigation;
	private Polyline newPolyline;
	private boolean isTravelingToParis = false;
	
	private int width, height;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity);
		Intent i=getIntent();
		getSreenDimanstions();
	    fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
		map = fragment.getMap(); 
		map.addMarker(new MarkerOptions().position(new LatLng(i.getDoubleExtra("latitude",0.0),i.getDoubleExtra("longitude",0.0))).title("Destination"));
		Destination = new LatLng(i.getDoubleExtra("latitude",0.0),i.getDoubleExtra("longitude",0.0));
		Start = getCurrentLocation();
		findDirections( Destination.latitude, Destination.longitude,Start.latitude, Start.longitude, GMapV2Direction.MODE_DRIVING );
	}
	private LatLng getCurrentLocation() {
		GPSTracker gps = new GPSTracker(EmergencyMapActivity.this);
		 
        // check if GPS enabled     
        if(gps.canGetLocation()){
             
            double lat = gps.getLatitude();
            double lon = gps.getLongitude();
            Log.i("loc",lat+" "+lon);
            MarkerOptions markerUser = new MarkerOptions().position(
    				new LatLng(lat, lon)).title("I am here ");
    		// adding marker
    		map.addMarker(markerUser);
    		
           // moveToCurrentLocation(new LatLng(lat, lon));
            return new LatLng(lat,lon);
    		  }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
            return null;
            
    		  }
        }
	
	@Override
	protected void onResume() {
		
		super.onResume();
    	latlngBounds = createLatLngBoundsObject(Destination, Start);
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));

	}

	public void handleGetDirectionsResult(ArrayList<LatLng> directionPoints) {
		PolylineOptions rectLine = new PolylineOptions().width(5).color(Color.RED);

		for(int i = 0 ; i < directionPoints.size() ; i++) 
		{          
			rectLine.add(directionPoints.get(i));
		}
		if (newPolyline != null)
		{
			newPolyline.remove();
		}
		newPolyline = map.addPolyline(rectLine);
		
	        map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));
		
		
	}
	
	private void getSreenDimanstions()
	{
		Display display = getWindowManager().getDefaultDisplay();
		width = display.getWidth(); 
		height = display.getHeight(); 
	}
	
	private LatLngBounds createLatLngBoundsObject(LatLng firstLocation, LatLng secondLocation)
	{
		if (firstLocation != null && secondLocation != null)
		{
			LatLngBounds.Builder builder = new LatLngBounds.Builder();    
			builder.include(firstLocation).include(secondLocation);
			
			return builder.build();
		}
		return null;
	}
	
	public void findDirections(double fromPositionDoubleLat, double fromPositionDoubleLong, double toPositionDoubleLat, double toPositionDoubleLong, String mode)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LAT, String.valueOf(fromPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LONG, String.valueOf(fromPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DESTINATION_LAT, String.valueOf(toPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.DESTINATION_LONG, String.valueOf(toPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DIRECTIONS_MODE, mode);
		
		GetDirectionsAsyncTask asyncTask = new GetDirectionsAsyncTask(this);
		asyncTask.execute(map);	
	}
}
