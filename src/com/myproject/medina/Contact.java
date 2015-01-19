package com.myproject.medina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contact extends Activity implements View.OnClickListener {

	EditText personsEmail,personsName, Message;
	String emailAdd, name , message ;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		/*personsEmail = (EditText) findViewById(R.id.etEmails);*/
		
		personsName = (EditText) findViewById(R.id.etName);
	
		Message = (EditText) findViewById(R.id.etOutro);
	
		sendEmail = (Button) findViewById(R.id.bSentEmail);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		converttexts();
		String emailaddress[] = { emailAdd };
		
		
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND) ;
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress ) ;
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT ,"About Medina app") ;
		emailIntent.setType("plain/Text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,message) ;
      
		startActivity(emailIntent);
	}
	
	private void converttexts() {
		
		emailAdd= "amani.mounaa@hotmail.com";
		
		name = personsName.getText().toString();
	
		message = Message.getText().toString();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}