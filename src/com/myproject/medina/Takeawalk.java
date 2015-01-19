package com.myproject.medina;

import java.util.HashMap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.myproject.medina.MainMapFragment;
import com.myproject.medina.MarkersInfo;
import com.myproject.medina.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Takeawalk extends Activity {
	 
    // Google Map
    private GoogleMap myMap;
    
    private HashMap<Marker, MarkersInfo> eventMarkerMap;
    
    private MainMapFragment myMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take);
 
        myMapFragment = new MainMapFragment(); 
        
        FragmentTransaction ft = getFragmentManager().beginTransaction();
	   	 ft.add(R.id.my_container,myMapFragment);
	   	 ft.commit();
	   	 
        try {
       initilizeMap();
        	     
        	 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        initilizeMap();
        
	}

	/*protected void onResume() {
	  Intent  intent = new Intent(getBaseContext() , Dialogue.class);
        startActivity(intent);
		super.onResume() ;

	}
*/	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    //Handle the back button
	    if(keyCode == KeyEvent.KEYCODE_BACK) {
	        //Ask the user if they want to quit
	        new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle(R.string.quit)
	        .setMessage(R.string.really_quit)
	        .setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {

	            @Override
	            public void onClick(DialogInterface dialog, int which) {

	                //Stop the activity
	                Takeawalk.this.finish();    
	            }

	        })
	        .setNegativeButton(R.string.yes,new DialogInterface.OnClickListener() {

	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	            	
	                  setContentView(R.layout.dweb);
	                  String url = "http://www.medinatunis.com";
	                  Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
	                  startActivity(intent);	                  
	            }

	        }) 
	        .show() ;
	        

	        return true;
	    }
	    else {
	        return super.onKeyDown(keyCode, event);
	    }

	}
	
	private void initilizeMap() {
       
          myMap =myMapFragment.getMap();
          
          myMap.getUiSettings().setZoomControlsEnabled(true);
         
          myMap.getUiSettings().setMyLocationButtonEnabled(true);
          
          myMap.getUiSettings().setRotateGesturesEnabled(true);
          
          CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    new LatLng(36.7992137,10.1758718)).zoom(19).bearing(-90).build();
         
 
          myMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

   setUpMarkersSpots();
       
            // check if map is created successfully or not
            if (myMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    
    private void setUpMarkersSpots() {

  	  // I'm going to make 2 MarkersInfo objects and place them on the map

  	  MarkersInfo firstMarkerInfo = new MarkersInfo(1,new LatLng(36.799138,10.1756197), "Beb Bhar", "Named the Door of The Sea Its one of the main entrances to the Medina which was a castle surrounded by walls as the same height as this door " +
  			  		"The legend says the door used to open on the sea directly but georaphically  the door is 4km far from the lake" );
  	  
      MarkersInfo secondMarkerInfo = new MarkersInfo(2,new LatLng(36.797309,10.172350), "Girls-Accessory Souk","Shopping for Girls for modern accessories");
     
      MarkersInfo thirdMarkerInfo = new MarkersInfo(3,new LatLng(36.7973135,10.1710698), "Zitouna Mosque : ‘olive tree’ Mosque","The present mosque dates from ....the reign of the Aghlabid Abu Ibrahim Ahmed. In the midst of completing the Great Mosque in Kairouan, he set about the construction of the Zitouna, symbolically making Tunis’ mosque a third the size of that in his capital");
   
  	  Marker firstMarker = myMapFragment.placeMarker(firstMarkerInfo);
  	  Marker secondMarker = myMapFragment.placeMarker(secondMarkerInfo);
  	  Marker thirdMarker = myMapFragment.placeMarker(thirdMarkerInfo);
  	  
  	  firstMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
      secondMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
      thirdMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mosquicon));
      
      eventMarkerMap = new HashMap<Marker, MarkersInfo>();
        
  	  eventMarkerMap.put(firstMarker, firstMarkerInfo);
  	  eventMarkerMap.put(secondMarker, secondMarkerInfo);
   	 eventMarkerMap.put(thirdMarker, thirdMarkerInfo);

  	  

  	  //add the onClickInfoWindowListener

        myMapFragment.getMap().setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
  	   
  		  @Override
  		  public void onInfoWindowClick(Marker marker) {

  			  MarkersInfo eventInfo = eventMarkerMap.get(marker);
  			  
  			View toastView = getLayoutInflater().inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toastLayout));
  			
			  ImageView taswira = (ImageView)toastView.findViewById(R.id.image);
			switch (eventInfo.getIdentite()) {
	  		  case 1 :
 		    	taswira.setImageResource(R.drawable.bebbhar);
 		    	break ;
 		    
 		    case 2 :

 		    	taswira.setImageResource(R.drawable.asfoto);
		    	break ;
 		    
 		    case 3 :
 		    	taswira.setImageResource(R.drawable.mosque);
 		    	
			
			}

            //imageView.setBackgroundDrawable(bitmapDrawable);

			/*TextView textView = (TextView)toastView.findViewById(R.id.text);

			textView.setText(eventInfo.getDescription()); */
			
			Toast toast = new Toast(getBaseContext());

			toast.setGravity(Gravity.FILL_VERTICAL|Gravity.FILL_HORIZONTAL, 0, 0);
			toast.setDuration(Toast.LENGTH_LONG);
			toast.setView(toastView);

			toast.show(); 
			
  			  

  	   }

  	  });
  	  

        myMapFragment.getMap().setInfoWindowAdapter(new InfoWindowAdapter() {
  		  
  		  private final View contents = getLayoutInflater().inflate(R.layout.content, null);
   		   @Override
 		   public View getInfoWindow(Marker marker) {

  		    return null;

  		   }
  		   @Override

  		   public View getInfoContents(Marker marker) {  		
  			   
  		    MarkersInfo eventInfo = eventMarkerMap.get(marker);
  		    String title = marker.getTitle();
  
  		    TextView txtTitle = ((TextView) contents.findViewById(R.id.txtInfoWindowTitlee));

  		             if (title != null) {
                        // Spannable string allows us to edit the formatting of the text.
  		            	 SpannableString titleText = new SpannableString(title);

  		                 titleText.setSpan(new ForegroundColorSpan(Color.RED), 0, titleText.length(), 0);

  		                 txtTitle.setText(titleText);

  		             } else {

  		                 txtTitle.setText("");

  		             }

  		            
  		             TextView txtType = ((TextView) contents.findViewById(R.id.txtInfoWindowEventType));

  		             txtType.setText(eventInfo.getPetitext()) ;
  		             
  		    return contents;

  		   }

  		  });
  	  

    } 
}



