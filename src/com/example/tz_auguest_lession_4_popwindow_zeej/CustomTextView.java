package com.example.tz_auguest_lession_4_popwindow_zeej;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Camera.Size;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class CustomTextView extends View {
	// 画笔
	private Paint paint;
	private int textColor;
	private float textSize;
	private String text;
	private Rect rectText;
	private Paint paintBg;

	public CustomTextView(Context context) {
		super(context);
		initPaint();

	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public CustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.CustomTextView);
		textColor = typedArray.getColor(R.styleable.CustomTextView_textColor,
				Color.MAGENTA);
		textSize = typedArray.getDimension(R.styleable.CustomTextView_textSize,
				20);
		text = typedArray.getString(R.styleable.CustomTextView_text);
		if (TextUtils.isEmpty(text)) {
			text = "laputa";
		}
		
		initPaint();
	}

	// 初始化画笔
	private void initPaint() {
		paint = new Paint();
		paint.setColor(textColor);
		paint.setTextSize(textSize);
		paintBg = new Paint();
		paintBg.setColor(Color.GRAY);

	}

	// @Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		rectText = new Rect();
		int width = widthSize;
		int height = heightSize;
		paint.getTextBounds(text, 0, text.length(), rectText);
		if (widthMode == MeasureSpec.AT_MOST) {
			width = (int) (getPaddingLeft() + rectText.width() + getPaddingRight());
			
		} else if (widthMode == MeasureSpec.EXACTLY) {
			width = widthSize;
		}
		if (heightMode == MeasureSpec.AT_MOST) {
			height  = (int) (getPaddingTop() + rectText.height() + getPaddingBottom());

		} else if (widthMode == MeasureSpec.EXACTLY) {
			height = heightSize;
		}
		setMeasuredDimension(width, height);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(), paintBg);
		canvas.drawText(text, getMeasuredWidth()/2-rectText.width()/2, getMeasuredHeight()/2+rectText.height()/2, paint);
	}

}
