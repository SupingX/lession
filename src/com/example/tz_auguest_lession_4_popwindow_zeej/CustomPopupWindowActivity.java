package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

public class CustomPopupWindowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom);
	}
	
	public void custom_pop(View v){
		View contentView = LayoutInflater.from(this).inflate(R.layout.pop_system,null);
		CustomPopupWindow popupWindow = new CustomPopupWindow(this,contentView);
		popupWindow.show(v);
	}
	
}
