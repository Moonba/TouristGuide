package com.myproject.medina;

import com.myproject.medina.R;
import android.content.Intent;
import com.myproject.medina.Welcome;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Welcome extends Activity{
MediaPlayer ourSong ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ourSong = MediaPlayer.create(Welcome.this,R.raw.aslema) ;
		ourSong.start() ;
		setContentView(R.layout.welcome);
	

		
	 Thread timer = new Thread() {
			public void run() {
				try{
					sleep(5000) ; // app sleep for 5 sec
						}
				catch (InterruptedException e){
				e.printStackTrace() ;	
				}
			finally {
				Intent  openMenu = new Intent("com.myproject.medina.MENU") ;
				startActivity(openMenu);
				}
			}
		} ;
		timer.start() ;
}

@Override
protected void onPause() {
	
	super.onPause() ;
	ourSong.release() ;
	finish() ; 
	
}
}


