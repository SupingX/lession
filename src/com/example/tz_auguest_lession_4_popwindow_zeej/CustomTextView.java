package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;


public class CustomTextView extends View{
	//画笔
	private Paint paint;
	private int textColor;
	private float textSize;
	private String text;
	
	public CustomTextView(Context context) {
		super(context);
		initPaint();
	
	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
		initPaint();
	}

	public CustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
		initPaint();
	}
	
	private void init(Context context,AttributeSet attrs){
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
		textColor = typedArray.getColor(R.styleable.CustomTextView_textColor, Color.MAGENTA);
		textSize = typedArray.getDimension(R.styleable.CustomTextView_textSize, 20);
		text = typedArray.getString(R.styleable.CustomTextView_text);
	}
	
	//初始化画笔
	private void initPaint(){
		paint = new Paint();
		paint.setColor(textColor);
		paint.setTextSize(textSize);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (TextUtils.isEmpty(text)) {
			text="laputa";
		}
		canvas.drawText(text, 50, 60, paint);
	}

}
