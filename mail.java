package com.thinking.mail;
//what ever your package name
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//importing all the required packages shrtcut(ctrl+shift+o)
public class Email extends Activity {
	EditText personsEmail,intro,personsName,outro;
    String emailAdd,name,beginning,out,subject;
    Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		personsEmail=(EditText) findViewById(R.id.editText1);
 		intro=(EditText) findViewById(R.id.editText2);
 		personsName=(EditText) findViewById(R.id.editText3);
 		outro=(EditText) findViewById(R.id.editText6);
 		sendEmail=(Button) findViewById(R.id.button1);
 		sendEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 ConversionEditTexttoString();
					String emailAddress[]={emailAdd};
					String subject=beginning;
					String Message="This is"+name+beginning+outro;
					Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Message);
					startActivity(emailIntent);	
			}

			private void ConversionEditTexttoString() {
				// TODO Auto-generated method stub
				emailAdd=personsEmail.getText().toString();
				name=personsName.getText().toString();
				beginning=intro.getText().toString();
				out=outro.getText().toString();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem menuItem)
	{
		
		int id=menuItem.getItemId();
		if(id==R.id.action_settings)
		{
			Intent open=new Intent(getApplicationContext(),com.thinking.mail.About.class);
		    startActivity(open);
		}
	 return true;     	
	}

}
