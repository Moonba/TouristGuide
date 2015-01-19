package com.myproject.medina;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TalkTunisian extends Activity implements View.OnClickListener {

	Button  aslema , chnahwelik , bkadech , labas ,aychek ;
	MediaPlayer ourSong ; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.talk);
		
		declaration();
	    aslema.setOnClickListener(this) ;
	    chnahwelik.setOnClickListener(this) ;
	    bkadech.setOnClickListener(this) ;
	    labas.setOnClickListener(this) ;
	    aychek.setOnClickListener(this) ;
	  
	
	}

	private void declaration() {
		 aslema = (Button) findViewById (R.id.talk1) ;
		 chnahwelik = (Button) findViewById (R.id.talk2) ;
		 bkadech = (Button) findViewById (R.id.talk3) ;
		 labas = (Button) findViewById (R.id.talk4) ;
		 aychek = (Button) findViewById (R.id.talk5) ;
		}

	@Override
	public void onClick(View v) {
		 
		switch(v.getId()) {
		 
		 case R.id.talk1 :
			
			    ourSong = MediaPlayer.create(this,R.raw.staslema) ;
				ourSong.start() ;
				
			 break ;
		 case R.id.talk2 :
				
			    ourSong = MediaPlayer.create(this,R.raw.stchna) ;
				ourSong.start() ;
				
			 break ;
	    case R.id.talk3 :
					
				    ourSong = MediaPlayer.create(this,R.raw.stbka) ;
					ourSong.start() ;
					
				 break ;
		case R.id.talk4 :
						
					    ourSong = MediaPlayer.create(this,R.raw.stlab) ;
						ourSong.start() ;
						
					 break ;
		case R.id.talk5 :
			
		    ourSong = MediaPlayer.create(this,R.raw.staych) ;
			ourSong.start() ;
			
		 break ; }
		
			
	}
	

}
