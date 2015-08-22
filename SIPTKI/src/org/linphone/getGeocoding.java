package org.linphone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.linphone.R;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URL;
import org.apache.http.impl.client.DefaultHttpClient;
	import org.apache.http.client.methods.HttpGet;
	import org.apache.http.client.ClientProtocolException;
	import org.apache.http.client.HttpClient;
import android.os.AsyncTask;
import android.view.View.OnTouchListener;
import org.linphone.TouchImageView.OnTouchImageViewListener;
import java.text.DecimalFormat;
import android.graphics.PointF;
import android.graphics.RectF;

public class getGeocoding extends Activity implements OnClickListener {
	
	Button btn_geocode;
	Button btn_start;
	Button btn_stop;
	Button btn_save;
	Button btn_peta;
	EditText txt_lat;
	EditText txt_lng;
	TextView txt_out;
	EditText keterangan;
	Double Dlatitude,Dlongitude;	
	private TouchImageView picImage;
	private LocationManager locationManager;
	
    /** Called when the activity is first created. */
    //@Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.geocoder_main);
    			showToast("Klik Start->Stop dan Klik Alamat->Peta");
        
        btn_geocode = (Button) findViewById(R.id.btn_geocode);
        btn_geocode.setOnClickListener(this);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(this);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        txt_lat = (EditText) findViewById(R.id.txt_lat);
        txt_lng = (EditText) findViewById(R.id.txt_lng);
        txt_out = (TextView) findViewById(R.id.txt_out);
        keterangan = (EditText) findViewById(R.id.keterangan);
        btn_peta = (Button) findViewById(R.id.btn_peta);
        btn_peta.setOnClickListener(this);
       
        btn_start.setEnabled(true);
		btn_stop.setEnabled(false);
        
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        picImage = (TouchImageView) findViewById(R.id.picImage);
    }
    
    private void startLocationListerner(){
	    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
	}
    
    private void stopLocationListener(){
    	locationManager.removeUpdates(locationListener);
    }
    
    
    LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {

			Dlatitude = location.getLatitude();
			Dlongitude = location.getLatitude();
			txt_lat.setText("" + location.getLatitude());
			txt_lng.setText("" + location.getLongitude());
		}
		public void onStatusChanged(String provider, int status, Bundle extras) {}
		public void onProviderEnabled(String provider) {
		}
		public void onProviderDisabled(String provider) {
		}
	};
    
    
    //@Override
	public void onClick(View v) {
    	if(v==btn_start){
    		startLocationListerner();
    		btn_start.setEnabled(false);
    		btn_stop.setEnabled(true);
    	}
    	else if(v==btn_stop){
    		stopLocationListener();
    		btn_start.setEnabled(true);
    		btn_stop.setEnabled(false);
    	}
	else if (v==btn_peta) {
	    //new petaTask().execute();
	    //if (Dlatitude!=null) {
            	//Bitmap bm = gGoogleMapThumbnail(Dlatitude,Dlongitude);
                //picImage.setImageBitmap(bm);
	    //}
				Dlatitude = Double.parseDouble(txt_lat.getText().toString());
				Dlongitude = Double.parseDouble(txt_lng.getText().toString());
		new petaTask().execute();
	}
    	else if(v==btn_geocode){
			txt_out.setText("");
			try{
				StringBuilder sb = new StringBuilder();
				double lat = Double.parseDouble(txt_lat.getText().toString());
				double lng = Double.parseDouble(txt_lng.getText().toString());
				Log.v("hmazter", lat + "," + lng);
				Geocoder myLocation = new Geocoder(getApplicationContext(), Locale.getDefault());
				Log.v("hmazter", "Locale: " + Locale.getDefault().toString());
				List<Address> geo_adresses = myLocation.getFromLocation(lat, lng, 1);
				if(geo_adresses.size()>0){
					Address add = geo_adresses.get(0);
					for(int i = 0; i <= add.getMaxAddressLineIndex(); ++i){
						sb.append("Alamat " + i + ": " + add.getAddressLine(i)+ "\n");
					}
					sb.append("Propinsi"+ add.getAdminArea()+ "\n");
					sb.append("Negara: "+ add.getCountryName()+ "\n");
					//sb.append("Premises: "+ add.getPremises()+ "\n");
					sb.append("Wilayah: "+ add.getSubAdminArea()+ "\n");
					//sb.append("Area: "+ add.getSubLocality()+ "\n");
					//sb.append("Jalan: "+ add.getThoroughfare()+ "\n");
					//sb.append("Sub "+ add.getSubThoroughfare()+ "\n");
					
					txt_out.setText(sb.toString());
				}
				else{
					txt_out.setText("No addresses");
				}
			}
			catch (Exception e) {
				txt_out.setText("Exception");
			}
		}
    	else if(v==btn_save){
    		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
    			File app_dir_path = new File(Environment.getExternalStorageDirectory() + "/hmazter/");
				String timestamp = ""+(new Date()).getTime();
				if(!app_dir_path.exists()){
					app_dir_path.mkdirs();
				}
				File save_file = new File(app_dir_path, "geocode"+timestamp+".txt");
				Log.v("hmazter", "Filename: " + save_file.getAbsolutePath());
				FileWriter fw;
				try {
					fw = new FileWriter(save_file);
					StringBuilder sb = new StringBuilder();
					sb.append("lat: " + txt_lat.getText().toString()+ "\n");
					sb.append("lng: " + txt_lng.getText().toString()+ "\n");
					sb.append("Address:\n");
					sb.append(txt_out.getText());
					fw.write(sb.toString());
					fw.flush();
					fw.close();
					showToast("File saved to: " + save_file.getAbsolutePath());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					showToast("FileNotFoundException");
				} catch (IOException e) {
					e.printStackTrace();
					showToast("IOException");
				}
    		}
    		else{
    			showToast("No SD card");
    		}
    	}
    }
  
 
    private void showToast(String msg){
    	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


    private class petaTask extends AsyncTask<Bitmap, String, Bitmap>{
 
        @Override
        protected void onPostExecute(Bitmap bmp){
            	picImage.setImageBitmap(bmp);
      		picImage.setOnTouchImageViewListener(new OnTouchImageViewListener() {
			@Override
			public void onMove() {
				PointF point = picImage.getScrollPosition();
				RectF rect = picImage.getZoomedRect();
				float currentZoom = picImage.getCurrentZoom();
				boolean isZoomed = picImage.isZoomed();
			}
		});
  
        }
 
        @Override
        protected Bitmap doInBackground(Bitmap... params) {
            // TODO Auto-generated method stub
            Bitmap bm = gGoogleMapThumbnail(Dlatitude,Dlongitude);
            //Bitmap bm = getGoogleMapThumbnail(longUrl);
	    return bm;
        }  
         
    };

 
    public static Bitmap gGoogleMapThumbnail(Double xxlatitude,Double xxlongitude){
         
        //String UURL = "http://maps.google.com/maps/api/staticmap?center=" +xxlatitude + "," + xxlongitude + "&zoom=15&size=600x600&sensor=false";
        		     
	//String UURL ="http://maps.google.com/maps/api/staticmap?center=" +xxlatitude + "," +xxlongitude+"&markers=color:red|"+xxlatitude+","+xxlongitude+"&zoom=15&size=600x600&sensor=false";
        		     
	//String UURL ="http://maps.google.com/maps/api/staticmap?center=" +xxlatitude + "," +xxlongitude+"&zoom=17&size=600x600&sensor=false";
			     
	String UURL="http://maps.googleapis.com/maps/api/staticmap?center="+xxlatitude+","+xxlongitude+"&zoom=13&scale=false&size=600x600&maptype=roadmap&format=png&visual_refresh=true&markers=size:mid%7Ccolor:red%7Clabel:X%7C"+xxlatitude+","+xxlongitude;
         
        Bitmap bmp = null;
        HttpClient httpclient = new DefaultHttpClient();  
        HttpGet request = new HttpGet(UURL);
 
        InputStream in = null;
        try {
            in = httpclient.execute(request).getEntity().getContent();
            bmp = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        return bmp;
    }

/*
    public static Bitmap incomingImage(String Urls){
        Bitmap bmp = null;
        HttpClient httpclient = new DefaultHttpClient();  
        HttpGet request = new HttpGet(Urls);
 
        InputStream in = null;
        try {
            in = httpclient.execute(request).getEntity().getContent();
            bmp = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        return bmp;
    }

*/
    
}
