package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

public class SystemPopWindowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system_pop_window);
	}
	
	public void popdismiss(View v){
		View contentView = LayoutInflater.from(this).inflate(R.layout.pop_system,null);
		PopupWindow popupWindow = new PopupWindow(contentView,200,300);
		popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAsDropDown(contentView);
		
	}
	public void pop(View v){
		View contentView = LayoutInflater.from(this).inflate(R.layout.pop_system,null);
		PopupWindow popupWindow = new PopupWindow(contentView,200,300);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAsDropDown(contentView);
		
	}
}
