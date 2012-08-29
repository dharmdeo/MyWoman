package com.mywoman;

import java.util.ArrayList;

import android.widget.TextView;

// This class allows me to operate on multiple TextViews at once

public class TextViewBinder {
	private ArrayList<TextView> binder;
	
	public TextViewBinder() {
		binder = new ArrayList<TextView>();
	}
	
	public void add(TextView tv){
		binder.add(tv);
	}
	
	public void setSize(float size){
		int len = binder.size();
		for(int i = 0;i<len;i++)
			binder.get(i).setTextSize(size);
	}
	
	public void setText(int pos, String text){
		binder.get(pos).setText(text);
	}
}
