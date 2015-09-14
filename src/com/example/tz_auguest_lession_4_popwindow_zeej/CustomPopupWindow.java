package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class CustomPopupWindow {
	private Context mContext;
	private View mContentView;
	public CustomPopupWindow(Context context,View contentView){
		this.mContext = context;
		this.mContentView = contentView;
	}
	
	public void show(View v){
		WindowManager windowManager  = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
	
		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		//设置window类型
		params.type = LayoutParams.TYPE_PHONE;
		//设置背景颜色 默认黑色
		params.format = PixelFormat.RGBA_8888;
		//设置事件类型
		params.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL 
				| LayoutParams.FLAG_NOT_FOCUSABLE 
				| LayoutParams.FLAG_NOT_TOUCHABLE;
		params.gravity = Gravity.START|Gravity.BOTTOM;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		
		//设置 位置 
		int [] location = new int[2];
		v.getLocationInWindow(location);
		params.x = location[0];
		params.y = location[1];
		
		windowManager.addView(mContentView, params);
				
		
	}
}
