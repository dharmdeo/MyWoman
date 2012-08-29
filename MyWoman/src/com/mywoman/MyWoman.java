package com.mywoman;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MyWoman extends Activity {
	ImageView womanPic; // object that will point to image view holding picture
	
	TextView tvName;
	TextViewBinder headLabels, headData;
	int screenWidth;
	float scale;
	
	String[] labels = {"Birthday","Anniversary","Height","Weight","Race","Religion","Country"};
	String[] data = {"September 16, 1992","May 31, 2010", "5'3\"", "100 lbs", "Ching-chong/Black", "Baptized Hindu","Guyana"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		headLabels = new TextViewBinder();
		headData = new TextViewBinder();
		
		scale = getResources().getDisplayMetrics().density;
		
		buildUI();
		setHeadData();
	}

	private void setHeadData() {
		for(int i =0;i<7;i++){
			headLabels.setText(i, labels[i]+ ":");
			headData.setText(i, data[i]);
		}
		
		tvName.setText("Tanya Maria Bishun");
	}

	private void buildUI() {
		// ============== Set the picture and place it ====================
		// get the screen size
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels; // need the width to size the image
										// properly

		womanPic = (ImageView) findViewById(R.id.womanPic);
		womanPic.setAdjustViewBounds(true); // preserve image aspect ratio
		womanPic.setMaxWidth(screenWidth / 3); // only take up 1/3 the screen
		womanPic.setImageResource(R.drawable.photo);
		
		// ============== Build the Header Table =========================
		
		tvName = (TextView) findViewById(R.id.textName);
		tvName.setTextSize(screenWidth * .043f);
		
		TextView label, data;
		TableRow tempRow;
		TableLayout tableHead = (TableLayout) findViewById(R.id.table_Head);
		
		for(int i = 0;i<7;i++){
			label = new TextView(this);
			label.setGravity(Gravity.RIGHT);
			label.setPadding(calcPx(5), 0, 0, 0);
			
			data = new TextView(this);
			data.setGravity(Gravity.LEFT);
			data.setPadding(calcPx(5), 0, 0, 0);
			
			headLabels.add(label);
			headData.add(data);
			
			tempRow = new TableRow(this);
			tempRow.addView(label);
			tempRow.addView(data);
			
			tableHead.addView(tempRow);
		}
		
		headData.setSize(screenWidth * .026f);
		headLabels.setSize(screenWidth * .026f);
	}
	
	private int calcPx(int dp){
		return (int) (dp * scale + 0.5f);
	}
}