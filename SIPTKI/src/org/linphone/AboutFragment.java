package org.linphone;
/*
AboutFragment.java
Copyright (C) 2012  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

import org.linphone.mediastream.Log;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.linphone.getGeocoding;
import android.widget.Toast;
import org.linphone.voucher;

/**
 * @author Sylvain Berfini
 */
public class AboutFragment extends Fragment implements OnClickListener {
	private FragmentsAvailable about = FragmentsAvailable.ABOUT_INSTEAD_OF_CHAT;

	TextView saldoo;
	String balance;
	String nbr,x_nbr;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (getArguments() != null && getArguments().getSerializable("About") != null) {
			about = (FragmentsAvailable) getArguments().getSerializable("About");
		}
		
		View view = inflater.inflate(R.layout.about, container, false);
		
		//TextView aboutText = (TextView) view.findViewById(R.id.AboutText);
		//try {
			//aboutText.setText(String.format(getString(R.string.about_text), getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName));
		//} catch (NameNotFoundException e) {
			//Log.e(e, "cannot get version name");
		//}


		//View issue = view.findViewById(R.id.exit);

		//issue.setOnClickListener(this);
		//issue.setVisibility(View.VISIBLE);
	
	
    		saldoo = (TextView) view.findViewById(R.id.saldoo);
		SharedPreferences usrDetails = getActivity().getSharedPreferences("saldo_details", 0);
		String sld  = usrDetails.getString("saldo", "");
		saldoo.setText(sld);

		Button tambahsaldo = (Button) view.findViewById(R.id.tambahsaldo);
    		tambahsaldo.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			Toast.makeText(getActivity(), "isi voucher", 5000).show();
		    	Intent vou = new Intent(getActivity(), voucher.class);
			startActivity(vou);

		}	
		});
		Button transferuang = (Button) view.findViewById(R.id.transferuang);
    		transferuang.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			Toast.makeText(getActivity(), "Transfer Uang Mudah dan Murah. Kami akan segera hadir setelah bekerjasama dengan Bank", 5000).show();
		}	
		});
/*
		Button smsbantuan = (Button) view.findViewById(R.id.smsbantuan);
    		smsbantuan.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			Toast.makeText(getActivity(), "SMS ", 5000).show();
		    	Intent smsv = new Intent(getActivity(), SMSActivity.class);
			startActivity(smsv);

		}	
		});
*/

/*
		Button beritabaru = (Button) view.findViewById(R.id.beritabaru);
    		beritabaru.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			Toast.makeText(getActivity(), "BeritaCall", 5000).show();
		    	Intent berita = new Intent(getActivity(), gcmActivity.class);
			startActivity(berita);

		}
		});
*/
/*
		Button forwardcall = (Button) view.findViewById(R.id.forwardcall);
    		forwardcall.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			Toast.makeText(getActivity(), "ForwardCall", 5000).show();
		    	Intent forw = new Intent(getActivity(), forwardcall.class);
			startActivity(forw);

		}
		});
*/
		Button lihatlokasi = (Button) view.findViewById(R.id.lihatlokasi);
    		lihatlokasi.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			//Toast.makeText(getActivity(), "getGeocoding", 5000).show();

		    	Intent geo = new Intent(getActivity(), getGeocoding.class);
			startActivity(geo);
		}
		});


		Button checksaldo = (Button) view.findViewById(R.id.checksaldo);
    		checksaldo.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
		
		    	String serverURL = "http://202.51.30.163/nomorvirtual/android_connect/get_token.php";
		    	//String serverURL = "http://202.152.203.2/nomorvirtual/android_connect/get_token.php";
		        
			SharedPreferences usrDetails = getActivity().getSharedPreferences("userdetails", 0);
 			nbr  = usrDetails.getString("virtualnumber", "");
			try {
		           x_nbr = URLEncoder.encode(nbr,"UTF-8");
            		} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			new getSaldo().execute(serverURL);

			SharedPreferences userDetails = getActivity().getSharedPreferences("saldo_details", 0);
 			balance  = userDetails.getString("saldo", "");
			//Toast.makeText(getActivity(), "GETSALDO"+balance, 5000).show();
			saldoo.setText("");
			saldoo.setText("Saldo: "+balance);

		}

		}
		);

	
		Button kedutaanText = (Button) view.findViewById(R.id.kedutaan);
    		kedutaanText.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
		    try {
			String url="waze://?ll=-6.24408,106.84722&navigate=yes";
			//String url="waze://?ll=3.17177,101.69616&navigate=yes";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
			Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.waze"));
			startActivity(intent);
	
			}
		  }
		}
		);
/*
		Button menubantuan = (Button) view.findViewById(R.id.menubantuan);
    		menubantuan.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    	Intent mtlp = new Intent(getActivity(), bantuan.class);
			startActivity(mtlp);
		}
		} );
*/


/*
		Button telponkedutaan = (Button) view.findViewById(R.id.telponkedutaan);
    		telponkedutaan.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    try {
			String url="tel:+622129244800";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.android.phone");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
				
			}
		}
		} );
		Button telponpolisi = (Button) view.findViewById(R.id.telponpolisi);
    		telponpolisi.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    try {
			String url="tel:+6221500669";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.android.phone");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
				
			}
		}
		} );
		Button telponbnp2tki = (Button) view.findViewById(R.id.telponbnp2tki);
    		telponbnp2tki.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    try {
			String url="tel:+622129244800";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.android.phone");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
				
			}
		}
		} );
*/
		Button telponkedutaanfree = (Button) view.findViewById(R.id.telponkedutaanfree);
    		telponkedutaanfree.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    try {
			String url="tel:02129244800";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.tki");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
				
			}
		}
		} );


		Button telponpolisifree = (Button) view.findViewById(R.id.telponpolisifree);
    		telponpolisifree.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    try {
			String url="tel:021500669";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.tki");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
				
			}
		}
		} );

		Button telponbnp2tkifree = (Button) view.findViewById(R.id.telponbnp2tkifree);
    		telponbnp2tkifree.setOnClickListener(new View.OnClickListener() 
		{
      		@Override
      		public void onClick(View v) {
		    try {
			String url="tel:02129244800";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.tki");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
				
			}
		}
		} );


		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		
		if (LinphoneActivity.isInstanciated()) {
			LinphoneActivity.instance().selectMenu(about);
		}
	}
	
	@Override
	public void onClick(View v) {
		if (LinphoneActivity.isInstanciated()) {
			LinphoneActivity.instance().exit();
		}
	}

    private class getSaldo  extends AsyncTask<String, Void, Void> {
         
    	// Required initialization
    	
        //private final HttpClient Client = new DefaultHttpClient();
        private String Content;
        private String Error = null;
        private ProgressDialog Dialog = new ProgressDialog(getActivity());
        String data ="";
        int sizeData = 0;  
        
        
        protected void onPreExecute() {
           
            Dialog.setMessage("Mohon tunggu sebentar..");
            Dialog.show();
            
            try{
            	// Set Request parameter
                //data ="&"+URLEncoder.encode("imsi", "UTF-8")+"="+x_imsi+"&"+URLEncoder.encode("imei","UTF-8")+"="+x_imei+"&"+URLEncoder.encode("nama","UTF-8")+ "="+x_nama+"&"+URLEncoder.encode("phone","UTF-8")+"="+x_phone+"&"+URLEncoder.encode("lac","UTF-8")+"="+x_lac+"&"+URLEncoder.encode("cid","UTF-8")+"="+x_cid+"&"+URLEncoder.encode("virtual","UTF-8")+"="+x_virtu;
		//data = "&"+URLEncoder.encode("pid","UTF-8")+"="+Elogin.getText().toString();
		data = "&"+URLEncoder.encode("virtualnumber","UTF-8")+"="+x_nbr;
	            	
            } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            
        }
 
        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {
        	
        	/************ Make Post Call To Web Server ***********/
        	BufferedReader reader=null;
   
	             // Send data 
	            try
	            { 
	              
	               // Defined URL  where to send data
	               URL url = new URL(urls[0]);
	                 
	              // Send POST data request
	   
	              URLConnection conn = url.openConnection(); 
	              conn.setDoOutput(true); 
	              OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream()); 
	              wr.write( data ); 
	              wr.flush(); 
	          
	              // Get the server response 
	               
	              reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	              StringBuilder sb = new StringBuilder();
	              String line = null;
	            
		            // Read Server Response
		            while((line = reader.readLine()) != null)
		                {
		                       // Append server response in string
		                       sb.append(line + "\n");
		                }
	                
	                // Append Server Response To Content String 
	               Content = sb.toString();
	            }
	            catch(Exception ex)
	            {
	            	Error = ex.getMessage();
	            }
	            finally
	            {
	                try
	                {
	     
	                    reader.close();
	                }
	   
	                catch(Exception ex) {}
	            }
        	
            /*****************************************************/
            return null;
        }
         
        protected void onPostExecute(Void unused) {
            // NOTE: You can call UI Element here.
             
            // Close progress dialog
            Dialog.dismiss();
             
            if (Error != null) {
                 
                //uiUpdate.setText("Output : "+Error);
                 
            } else {
              
            	// Show Response Json On Screen (activity)
            	//uiUpdate.setText( Content );
            	
             /****************** Start Parse Response JSON Data *************/
            	
            	String OutputData = "";
                JSONObject jsonResponse;
                      
                try {
                      
                     /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                     jsonResponse = new JSONObject(Content);
                      
                     /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                     /*******  Returns null otherwise.  *******/
                     JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");
                      
                     /*********** Process each JSON Node ************/
  
                     int lengthJsonArr = jsonMainNode.length();  
  
                     for(int i=0; i < lengthJsonArr; i++) 
                     {
                         /****** Get Object for each JSON node.***********/
                         JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                          
                         /******* Fetch node values **********/
                         balance = jsonChildNode.optString("balance").toString();
			SharedPreferences userDetails = getActivity().getSharedPreferences("saldo_details", 0);
			Editor edit = userDetails.edit();
			edit.clear();
			edit.putString("saldo", balance);
			edit.commit();
			//Toast.makeText(getActivity(), "SALDO"+balance, 3000).show();
			 //View view = inflater.inflate(R.layout.dialer, container, false);
    			 //saldoo = (TextView) view.findViewById(R.id.saldo);
			 saldoo.setText(balance);
                         //password     = jsonChildNode.optString("password").toString();
                        
                         //Log.i("JSON parse", song_name);
                    }
                 /****************** End Parse Response JSON Data *************/     
                     
                     //Show Parsed Output on screen (activity)
                     //jsonParsed.setText( OutputData );
                  
			//Elogin.setText(login);
/*
SharedPreferences userDetails = getActivity().getSharedPreferences("userdetails", MODE_PRIVATE);
Editor edit = userDetails.edit();
edit.clear();
edit.putString("virtualnumber", login);
edit.putString("virtualpassword", password);
edit.commit();
*/
//Toast.makeText(getActivity(), "Login details are saved..", 3000).show();
			 
	     //Toast.makeText(getActivity(), "Resp SALDO:" + balance,  Toast.LENGTH_LONG).show();
                      
                 } catch (JSONException e) {
          
                     e.printStackTrace();
                 }
  
                 
             }

        }
         
    }



}
