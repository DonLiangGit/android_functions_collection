package com.example.sdcard_basic;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;


public class MainActivity extends Activity {
    
	TextView textview;
	private File SDCard_Path;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textview = (TextView)findViewById(R.id.textView1);
        
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)) {
        	return;
        } else { 
        	textview.setText("SD Card is here.");
        	SDCard_Path = Environment.getExternalStorageDirectory();
        }
        
        File musicPath = new File(SDCard_Path.getParent() + "/"+ SDCard_Path.getName() + "/MusicDownload");
        if (musicPath.exists()) {
        	textview.setText("Folder exists.");
        } else {
        	textview.setText("Folder does not exists");
        }
    }
   
}