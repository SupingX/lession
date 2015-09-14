package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class RadarView extends View{
	
	private Matrix matrix;
	//线和园
	private Paint mPaintLine;
	//渐变背景
	private Paint mPaintSectorPaint;
	private int widthPixels;
	private int heightPixels;
	private Drawable drawable;
	private Bitmap bitmap;
	private Handler mHandler = new Handler(){
		
	};
	//
	private Runnable runnable  =  new Runnable() {
		private float degrees = 0;
		public void run() {
			degrees++;
			matrix = new Matrix();
			matrix.postRotate(degrees, widthPixels/2, heightPixels/2);
			//chonghui
			invalidate();
			mHandler.postDelayed(runnable, 50);
		}
	};
	
	public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPaint(context);
	}

	public RadarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPaint(context);
	}

	public RadarView(Context context) {
		super(context);
		initPaint(context);
	}

	private void initPaint(Context context) {
		
		
		mPaintLine = new Paint();
		mPaintLine.setColor(Color.MAGENTA);
		mPaintLine.setStrokeWidth(3);
		mPaintLine.setAntiAlias(true);
		mPaintLine.setStyle(Style.STROKE);
		
		mPaintSectorPaint = new Paint();
		mPaintSectorPaint.setColor(0x9d00ff00);
		mPaintLine.setAntiAlias(true);
		
		
		
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		widthPixels = displayMetrics.widthPixels;
		heightPixels = displayMetrics.heightPixels;
		
		setBackgroundColor(Color.BLACK);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.all);
		
		//
		mHandler.post(runnable);
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (int i = 0; i < 5; i++) {
			canvas.drawCircle(widthPixels/2, heightPixels/2, 75*i, mPaintLine);
		}
		SweepGradient gradient = new SweepGradient(widthPixels/2, heightPixels/2, Color.TRANSPARENT, Color.parseColor("#aaaaaaaa"));
		mPaintSectorPaint.setShader(gradient);
		//xuanzhan
		canvas.concat(matrix);
		canvas.drawCircle(widthPixels/2, heightPixels/2, 75*3, mPaintSectorPaint);
		canvas.drawBitmap(bitmap, widthPixels/2-bitmap.getWidth()/2,heightPixels/2-bitmap.getHeight()/2 , mPaintLine);
	
	}
	
	
}
