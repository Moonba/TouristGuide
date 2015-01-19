package com.myproject.medina;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainMapFragment extends MapFragment {
	
	public Marker placeMarker(MarkersInfo mInfo) {
			  Marker m  = getMap().addMarker(new MarkerOptions()
			   .position(mInfo.getLatLong())
			   .title(mInfo.getName()));
			  return m;
			 
		 }
}