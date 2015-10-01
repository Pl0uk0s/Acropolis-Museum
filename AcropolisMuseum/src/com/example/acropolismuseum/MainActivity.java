package com.example.acropolismuseum;

import java.util.Locale;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		
		Button btnQR, btnNFC;
		
		btnQR = (Button) findViewById(R.id.btnQR);
		btnNFC = (Button) findViewById(R.id.btnNFC);
		
		btnQR.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(ACTION_SCAN);
					intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
					startActivityForResult(intent, 0);
				} catch (ActivityNotFoundException anfe) {
					showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
				}
			}
			
		});
		
		btnNFC.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(MainActivity.this, NfcActivity.class);
					intent.putExtra("SCAN_MODE", "NFC");
					startActivityForResult(intent, 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.info) {
			openInfo();
		} else if (id == R.id.quiz) {
			Intent i = new Intent(MainActivity.this, Quiz.class);
            startActivity(i);
            //finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void openInfo() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
		
		alertDialogBuilder.setTitle("Info");
		LayoutInflater inflater = this.getLayoutInflater();
		alertDialogBuilder.setView(inflater.inflate(R.layout.dialog_info, null));
		alertDialogBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show(); 
	}
	
	private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
		AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
		downloadDialog.setTitle(title);
		downloadDialog.setMessage(message);
		downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialogInterface, int i) {
				Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				try {
					act.startActivity(intent);
				} catch (ActivityNotFoundException anfe) {

				}
			}
		});
		downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialogInterface, int i) {
			}
		});
		return downloadDialog.show();
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

				//Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
				//toast.show();
				
				getInfo(contents);
			}
		} else if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				
				//Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
				//toast.show();
				
				getInfo(contents);
			}
		}
	}
	
	public void getInfo(String code) {
		
		String url = "http://52.88.14.185/acropolis/getInfo.php";
		try {
			
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
			//Toast.makeText(this, sharedPreferences.getString("level", "N/A") + " " + Locale.getDefault().getLanguage(), Toast.LENGTH_LONG).show();
			url = url + "?artifact=" + code + "&mode=" + sharedPreferences.getString("level", "N/A") + "&lang=" + Locale.getDefault().getLanguage();
	        //Toast.makeText(this, url, Toast.LENGTH_LONG).show();
	        HttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(url);
	        
	        ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpClient.execute(httpPost, responseHandler);
            JSONObject json = new JSONObject(responseBody);
            String info = (String) json.get("info");
            
            //Toast.makeText(this, info, Toast.LENGTH_LONG).show();

        	Intent intent = new Intent(MainActivity.this, ArtifactInfo.class);
			intent.putExtra("info", info);
			startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
