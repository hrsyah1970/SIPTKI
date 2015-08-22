
	package org.linphone;
	 
	import android.os.Bundle;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.Toast;
	import android.app.Activity;
	import android.content.Context;
	import android.content.Intent;
	import android.graphics.Color;
	 

import org.linphone.R;

	 
public class voucher extends Activity {
	    private EditText phone;
	    private Button display;
	    private Context context;
	     
	    //@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.voucher);
	         
	        context = this.getApplicationContext();
	         
	        phone = (EditText) findViewById(R.id.editPhone);
	        phone.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Toast msg = Toast.makeText(getBaseContext(), "Only 10 numbers",
	                        Toast.LENGTH_LONG);
	                msg.show();
	            }
	        });
	         
	         
	        display = (Button) findViewById(R.id.display);
	         
	        display.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                phone.setTextColor(Color.RED);
	                String displayString = "You typed '" + phone.getText().toString() ;
	                Toast msg = Toast.makeText(getBaseContext(), displayString,
	                        Toast.LENGTH_LONG);
	                msg.show();
	            }
	        });
	    }
	 
	}
