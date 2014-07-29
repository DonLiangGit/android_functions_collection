package com.example.sdcard_basic;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;


public class MainActivity extends Activity {
    
	TextView textview;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textview = (TextView)findViewById(R.id.textView1);
        
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)) {
        	return;
        } else { 
        	textview.setText("SD Card is here.");
        }
    }
   
}