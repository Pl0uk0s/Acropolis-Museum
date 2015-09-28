package com.example.acropolismuseum;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class ArtifactInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_artifact_info);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		Intent intent = getIntent();
		String info = intent.getStringExtra("info");
		
		String title = info.split("#")[0];
		String[] infos = info.split("#");
		
		LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.linearLayout);
		linearLayout.setOrientation(LinearLayout.VERTICAL); 
		
		TextView txtTitle = (TextView) findViewById(R.id.txtArtifactTitle);	
		txtTitle.setText(title);
		
		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    llp.setMargins(0, 0, 0, 20); // llp.setMargins(left, top, right, bottom);
	    
		for (int i = 1; i < infos.length; i++) {
			TextView textView = new TextView(this);
			textView.setLayoutParams(llp);
		    textView.setText(infos[i]);
		    linearLayout.addView(textView);
		}
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
		if (id == android.R.id.home) { 
			this.finish();
			return true;
		}else if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
