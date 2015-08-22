package org.linphone;
/*
DialerFragment.java
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
import org.linphone.core.LinphoneCore;
import org.linphone.mediastream.Log;
import org.linphone.ui.AddressAware;
import org.linphone.ui.AddressText;
import org.linphone.ui.CallButton;
import org.linphone.ui.EraseButton;

import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

import android.telephony.SmsManager;
import android.os.SystemClock;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.os.IBinder;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import java.util.ArrayList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.TelephonyManager;
import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import java.util.List;
import android.content.Context;




/**
 * @author Sylvain Berfini
 */
public class DialerFragment extends Fragment {
	private static DialerFragment instance;
	private static boolean isCallTransferOngoing = false;
	
	public boolean mVisible;
	private AddressText mAddress;
	private CallButton mCall;
	private ImageView mAddContact;
	//private ImageView profile;
	private OnClickListener addContactListener, cancelListener, transferListener;
	private boolean shouldEmptyAddressField = true;
		private ImageView mWazzapp;
		private ImageView telakses;
		private ImageView bnp2tki;
		private ImageView esia;
		private ImageView facebook;
		private ImageView twitter;
		private ImageView panicbutton;
		double latitude,longitude;
		private long mlastclicktime=0;
		private int cntclick=0;
		private long timer=0;
		private long mlastclicktime2=0;
		private int cntclick2=0;
		private long timer2=0;
		private String virtualnumber,imei,imsi,Slatitude,Slongitude;
		private String lac,cid;	
		JSONParser jsonMYSQLParser = new JSONParser();
		private String urlText="http://202.51.30.163/nomorvirtual/gps/gps_tki.php?";
		private static String url_insert_gps = "http://202.51.30.163/nomorvirtual/android_connect/insert_lokasi.php";
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		instance = this;
        View view = inflater.inflate(R.layout.dialer, container, false);
			mWazzapp = (ImageView) view.findViewById(R.id.Wazzapp);
			mWazzapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Uri mUri = Uri.parse("smsto: +62811181156");
				Intent mIntent = new Intent(Intent.ACTION_SEND, mUri);
				mIntent.setPackage("com.whatsapp");
				mIntent.setType("text/plain");
				mIntent.putExtra(mIntent.EXTRA_TEXT, "Saya memerlukan bantuan BNP2TKI");
				startActivity(mIntent);
	
			}});
    		telakses = (ImageView) view.findViewById(R.id.telakses);
    		telakses.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {

			Uri location = Uri.parse("http://tel-access.biz");
			Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
    			startActivity(mapIntent);

		}});
    		bnp2tki = (ImageView) view.findViewById(R.id.bnptki);
    		bnp2tki.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {

			Uri location = Uri.parse("http://bnp2tki.go.id");
			Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
    			startActivity(mapIntent);

		}});

    		/*esia = (ImageView) view.findViewById(R.id.esia);
    		esia.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {

			Uri location = Uri.parse("http://myesia.com");
			Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
    			startActivity(mapIntent);

		}});*/

    		facebook = (ImageView) view.findViewById(R.id.facebook);
    		facebook.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {

			Uri location = Uri.parse("http://m.facebook.com");
			Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
    			startActivity(mapIntent);

		}});
    		twitter = (ImageView) view.findViewById(R.id.twitter);
    		twitter.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {

			Uri location = Uri.parse("http://mobile.twitter.com");
			Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
    			startActivity(mapIntent);

		}});

		mlastclicktime=0;
		cntclick=0;
		timer=0;
    		panicbutton = (ImageView) view.findViewById(R.id.panicbutton);
    		panicbutton.setOnClickListener(new View.OnClickListener() {
      		@Override
      		public void onClick(View v) {
			if (cntclick==0) Toast.makeText(getActivity(), "Anda Dalam bahaya klik 2x lagi", 5000).show();
			else if (cntclick==1) Toast.makeText(getActivity(), "Anda Dalam bahaya klik sekali lagi", 5000).show();
	
			cntclick++;
			//mlastclicktime=SystemClock.elapsedRealtime();
			timer=SystemClock.elapsedRealtime()-mlastclicktime;
			//Toast.makeText(getActivity(), "timer"+timer+"lasttime"+mlastclicktime, 5000).show();
			if (cntclick<3) {
			   mlastclicktime=SystemClock.elapsedRealtime();
			   return;
			}
			   if (timer>5000) {
			      timer=0;
			      cntclick=0;
			 Toast.makeText(getActivity(), "Maaf anda melewati batas waktu silahkan tekan 3x klik kembali jika anda dalam bahaya", 5000).show();
			      return;
			   }
			cntclick=0;
			timer=0;
			mlastclicktime=0;
			SharedPreferences usrDetails = getActivity().getSharedPreferences("userdetails", 0);
 			String virtualnumber  ="03192049246";// usrDetails.getString("virtualnumber", "");
 			//imsi  = usrDetails.getString("imsi", "");
 			//imei  = usrDetails.getString("imei", "");
			TelephonyManager tm = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE );
			imei = tm.getDeviceId();
			imsi = tm.getSubscriberId();
			//imei = tm.getDeviceId();
			//imsi = tm.getSubscriberId();
			//Slatitude=Double.toString(latitude);
			//Slongitude=Double.toString(longitude);
			if (tm.getPhoneType() == tm.PHONE_TYPE_GSM) {
				GsmCellLocation gLoc=(GsmCellLocation)tm.getCellLocation();
				if (gLoc != null)  {
			    		cid =Integer.toString(gLoc.getCid());	
			    		lac =Integer.toString(gLoc.getLac());
						   
				}
			}		
			
			//new insLokasi().execute();

			posisiPanic gps  = new posisiPanic(getActivity());
			Slatitude=Double.toString(latitude);
			Slongitude=Double.toString(longitude);
			String phoneNumber = "+6281212298022";
    			String message = "Saya "+virtualnumber+" dalam masalah di:"+"("+lac+","+cid+")"+ 
        	" http://maps.google.com/?q="+latitude+"%2c"+longitude;
			//String message="test";
			Toast.makeText(getActivity(), "SMS anda akan segera kami followup. Mohon tunggu", 5000).show();

    			SmsManager smsMgr = SmsManager.getDefault();
    			ArrayList<String> parts = smsMgr.divideMessage(message); 
    			smsMgr.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
 			//imsi  = usrDetails.getString("imsi", "");
 			//imei  = usrDetails.getString("imei", "");
			new SelfHostedGPSTrackerRequest().execute(urlText + "lat=" + latitude + "&lon=" + longitude+"&login="+virtualnumber+"&lac="+lac+"&cid="+cid );
			new insLokasi().execute();

		    try {
			String url="tel:911";
			Uri location = Uri.parse(url);
			Intent mapIntent = new Intent(Intent.ACTION_CALL, location);
			mapIntent.setPackage("com.tki");
    			startActivity(mapIntent);
			}
		   catch (Exception ex ) 
		   {
						
			}	

		}});
		
		mAddress = (AddressText) view.findViewById(R.id.Adress); 
		mAddress.setDialerFragment(this);
		
		EraseButton erase = (EraseButton) view.findViewById(R.id.Erase);
		erase.setAddressWidget(mAddress);
		
		mCall = (CallButton) view.findViewById(R.id.Call);
		mCall.setAddressWidget(mAddress);
		if (LinphoneActivity.isInstanciated() && LinphoneManager.getLc().getCallsNb() > 0) {
			if (isCallTransferOngoing) {
				mCall.setImageResource(R.drawable.transfer_call);
			} else {
				mCall.setImageResource(R.drawable.add_call);
			}
		} else {
			mCall.setImageResource(R.drawable.call);
		}
		
		AddressAware numpad = (AddressAware) view.findViewById(R.id.Dialer);
		if (numpad != null) {
			numpad.setAddressWidget(mAddress);
		}
		
			//String nomor="03192049243";
			//new DownloadImageTask((ImageView) view.findViewById(R.id.profile))
            			//.execute("http://202.51.30.163/nomorvirtual/profile/"+nomor+"/country/0.png");
    		//profile.setOnClickListener(new View.OnClickListener() {
      		//@Override
      		//public void onClick(View v) {
			//String nomor="03192049243";
			//new DownloadImageTask((ImageView) findViewById(R.id.country))
            			//.execute("http://202.51.30.163/nomorvirtual/profile/"+nomor+"/country/0.png");

		//}});

		mAddContact = (ImageView) view.findViewById(R.id.addContact);

		addContactListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				LinphoneActivity.instance().displayContactsForEdition(mAddress.getText().toString());
			}
		};
		cancelListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				LinphoneActivity.instance().resetClassicMenuLayoutAndGoBackToCallIfStillRunning();
			}
		};
		transferListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				LinphoneCore lc = LinphoneManager.getLc();
				if (lc.getCurrentCall() == null) {
					return;
				}
				lc.transferCall(lc.getCurrentCall(), mAddress.getText().toString());
				isCallTransferOngoing = false;
				LinphoneActivity.instance().resetClassicMenuLayoutAndGoBackToCallIfStillRunning();
			}
		};
		
		mAddContact.setEnabled(!(LinphoneActivity.isInstanciated() && LinphoneManager.getLc().getCallsNb() > 0));
		resetLayout(isCallTransferOngoing);
		
		if (getArguments() != null) {
			shouldEmptyAddressField = false;
			String number = getArguments().getString("SipUri");
			String displayName = getArguments().getString("DisplayName");
			String photo = getArguments().getString("PhotoUri");
			mAddress.setText(number);
			if (displayName != null) {
				mAddress.setDisplayedName(displayName);
			}
			if (photo != null) {
				mAddress.setPictureUri(Uri.parse(photo));
			}
		}
		
		return view;
    }

	/**
	 * @return null if not ready yet
	 */
	public static DialerFragment instance() { 
		return instance;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		if (LinphoneActivity.isInstanciated()) {
			LinphoneActivity.instance().selectMenu(FragmentsAvailable.DIALER);
			LinphoneActivity.instance().updateDialerFragment(this);
			LinphoneActivity.instance().showStatusBar();
		}
		
		if (shouldEmptyAddressField) {
			mAddress.setText("");
		} else {
			shouldEmptyAddressField = true;
		}
		resetLayout(isCallTransferOngoing);
	}
	
	public void resetLayout(boolean callTransfer) {
		isCallTransferOngoing = callTransfer;
		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc == null) {
			return;
		}
		
		if (lc.getCallsNb() > 0) {
			if (isCallTransferOngoing) {
				mCall.setImageResource(R.drawable.transfer_call);
				mCall.setExternalClickListener(transferListener);
			} else {
				mCall.setImageResource(R.drawable.add_call);
				mCall.resetClickListener();
			}
			mAddContact.setEnabled(true);
			mAddContact.setImageResource(R.drawable.cancel);
			mAddContact.setOnClickListener(cancelListener);
		} else {
			mCall.setImageResource(R.drawable.call);
			mAddContact.setEnabled(true);
			mAddContact.setImageResource(R.drawable.add_contact);
			mAddContact.setOnClickListener(addContactListener);
			enableDisableAddContact();
		}
	}
	
	public void enableDisableAddContact() {
		mAddContact.setEnabled(LinphoneManager.getLc().getCallsNb() > 0 || !mAddress.getText().toString().equals(""));	
	}
	
	public void displayTextInAddressBar(String numberOrSipAddress) {
		shouldEmptyAddressField = false;
		mAddress.setText(numberOrSipAddress);
	}
	
	public void newOutgoingCall(String numberOrSipAddress) {
		displayTextInAddressBar(numberOrSipAddress);
		LinphoneManager.getInstance().newOutgoingCall(mAddress);
	}
	
	public void newOutgoingCall(Intent intent) {
		if (intent != null && intent.getData() != null) {
			String scheme = intent.getData().getScheme();
			if (scheme.startsWith("imto")) {
				mAddress.setText("sip:" + intent.getData().getLastPathSegment());
			} else if (scheme.startsWith("call") || scheme.startsWith("sip")) {
				mAddress.setText(intent.getData().getSchemeSpecificPart());
			} else {
				Uri contactUri = intent.getData();
				String address = ContactsManager.getInstance().queryAddressOrNumber(LinphoneService.instance().getContentResolver(),contactUri);
				if(address != null) {
					mAddress.setText(address);
				} else {
					Log.e("Unknown scheme: ", scheme);
					mAddress.setText(intent.getData().getSchemeSpecificPart());
				}
			}
	
			mAddress.clearDisplayedName();
			intent.setData(null);
	
			LinphoneManager.getInstance().newOutgoingCall(mAddress);
		}
	}
private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}

public class posisiPanic extends Service implements LocationListener {

	private final Context mContext;

	// flag for GPS status
	boolean isGPSEnabled = false;

	// flag for network status
	boolean isNetworkEnabled = false;

	// flag for GPS status
	boolean canGetLocation = false;

	Location location; // location

	// The minimum distance to change Updates in meters
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

	// The minimum time between updates in milliseconds
	private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

	// Declaring a Location Manager
	protected LocationManager locationManager;

	private posisiPanic(Context context) {
		this.mContext = context;
		getLocation();
	}

	public Location getLocation() {
		try {
			locationManager = (LocationManager) mContext
					.getSystemService(LOCATION_SERVICE);

			// getting GPS status
			isGPSEnabled = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);

			// getting network status
			isNetworkEnabled = locationManager
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (!isGPSEnabled && !isNetworkEnabled) {
				// no network provider is enabled
			} else {
				this.canGetLocation = true;
				if (isNetworkEnabled) {
					locationManager.requestLocationUpdates(
							LocationManager.NETWORK_PROVIDER,
							MIN_TIME_BW_UPDATES,
							MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
					//Log.d("Network", "Network");
					if (locationManager != null) {
						location = locationManager
								.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) {
							latitude = location.getLatitude();
							longitude = location.getLongitude();
							//SharedPreferences userDetails = getActivity().getSharedPreferences("location", 0);
							//Editor edit = userDetails.edit();
							//edit.clear();
							//edit.putString("latitude", Double.toString(latitude));
							//edit.putString("longitude",Double.toString(longitude));
							//edit.commit();
						}
					}
				}
				// if GPS Enabled get lat/long using GPS Services
				if (isGPSEnabled) {
					if (location == null) {
						locationManager.requestLocationUpdates(
								LocationManager.GPS_PROVIDER,
								MIN_TIME_BW_UPDATES,
								MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						//Log.d("GPS Enabled", "GPS Enabled");
						if (locationManager != null) {
							location = locationManager
									.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								latitude = location.getLatitude();
								longitude = location.getLongitude();
								//SharedPreferences userDetails = getActivity().getSharedPreferences("location", 0);
								//Editor edit = userDetails.edit();
								//edit.clear();
								//edit.putString("latitude", Double.toString(latitude));
								//edit.putString("longitude",Double.toString(longitude));
								//edit.commit();
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return location;
	}
	
	/**
	 * Stop using GPS listener
	 * Calling this function will stop using GPS in your app
	 * */
	public void stopUsingGPS(){
		if(locationManager != null){
			locationManager.removeUpdates(posisiPanic.this);
		}		
	}
	
	/**
	 * Function to get latitude
	 * */
	public double getLatitude(){
		if(location != null){
			latitude = location.getLatitude();
		}
		
		// return latitude
		return latitude;
	}
	
	/**
	 * Function to get longitude
	 * */
	public double getLongitude(){
		if(location != null){
			longitude = location.getLongitude();
		}
		
		// return longitude
		return longitude;
	}
	
	/**
	 * Function to check GPS/wifi enabled
	 * @return boolean
	 * */
	public boolean canGetLocation() {
		return this.canGetLocation;
	}
	
	/**
	 * Function to show settings alert dialog
	 * On pressing Settings button will lauch Settings Options
	 * */
	public void showSettingsAlert(){
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
   	 
        // Setting Dialog Title
        alertDialog.setTitle("GPS settings");
 
        // Setting Dialog Message
        alertDialog.setMessage("GPS anda saat ini tidak aktif. Anda harus aktifkan akses GPS anda berikut");
 
        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
            	Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            	mContext.startActivity(intent);
            }
        });
 
        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
	}

	public void onLocationChanged(Location location) {
	}

	public void onProviderDisabled(String provider) {
	}

	public void onProviderEnabled(String provider) {
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	public IBinder onBind(Intent arg0) {
		return null;
	}


 
   }


	class insLokasi extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... args) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("virtualnumber", virtualnumber));
			params.add(new BasicNameValuePair("latitude", Slatitude));
			params.add(new BasicNameValuePair("longitude", Slongitude));
			params.add(new BasicNameValuePair("imei", imei) );


			// getting JSON Object
			// Note that create product url accepts POST method
			JSONObject jsonMYSQL = jsonMYSQLParser.makeHttpRequest(url_insert_gps,
					"POST", params);
			
			// check log cat fro response
			//Log.d("Create Response", jsonMYSQL.toString());

			// check for success tag
			try {
				int success = jsonMYSQL.getInt("success");

				if (success == 1) {
					// successfully created product
					//Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
					//startActivity(i);
				
						
					// closing this screen
				} else {
					// failed to create product
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;

	}

     }

}
