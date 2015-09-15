package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class RadarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rarar);
		//获得雷达控件
		final RadarView radar = (RadarView) findViewById(R.id.radar);
		radar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (radar.isRotationing()) {
					radar.stopRotation();
				}else{
					radar.startRotation();
				}
			}
		});
	}
	
	
}
