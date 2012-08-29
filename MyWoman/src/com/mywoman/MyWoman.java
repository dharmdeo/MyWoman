package com.mywoman;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

public class MyWoman extends Activity {
	ImageView womanPic; // object that will point to image view holding picture
	// Text views which will display various information
	TextView tvName, tvBirthday, tvAnniversary, tvCountry, tvHeight, tvWeight,
			tvRace, tvReligion;
	TextViewBinder binder = new TextViewBinder();
	int screenWidth;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buildUI();
		setHeadData();
	}

	private void setHeadData() {
		tvBirthday.setText("September 16, 1992");
		tvAnniversary.setText("May 31, 2010");
		tvCountry.setText("Guyana");
		tvHeight.setText("5'3\"");
		tvWeight.setText("100 lbs");
		tvRace.setText("Ching-chong/Black");
		tvReligion.setText("Baptized Hindu");

		// Size the text properly so it takes up the entire space
		binder.setSize(screenWidth * .027f);
		tvName.setTextSize(screenWidth * .043f);
	}

	public void buildUI() {
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

		// Create objects for all the TextViews

		tvBirthday = (TextView) findViewById(R.id.textBirthday);
		tvAnniversary = (TextView) findViewById(R.id.textAnniversary);
		tvCountry = (TextView) findViewById(R.id.textCountry);
		tvHeight = (TextView) findViewById(R.id.textHeight);
		tvWeight = (TextView) findViewById(R.id.textWeight);
		tvRace = (TextView) findViewById(R.id.textRace);
		tvReligion = (TextView) findViewById(R.id.textReligion);
		
		tvName = (TextView) findViewById(R.id.textName);

		// Add all the new objects to the textview binder
		binder.add(tvAnniversary);
		binder.add(tvBirthday);
		binder.add(tvCountry);
		binder.add(tvHeight);
		binder.add(tvRace);
		binder.add(tvReligion);
		binder.add(tvWeight);
	}
}