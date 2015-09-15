package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void system_pop(View v){
		startActivity(new Intent(this,SystemPopWindowActivity.class));
	}
	public void custom_pop_view(View v){
		startActivity(new Intent(this,CustomPopupWindowActivity.class));
	}
	public void custom_view(View v){
		startActivity(new Intent(this,CustomViewActivity.class));
	}
	public void radar(View v){
		startActivity(new Intent(this,RadarActivity.class));
	}
}
