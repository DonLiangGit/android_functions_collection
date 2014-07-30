package com.example.sdcard_basic;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
    
//	TextView textview;
	private File SDCard_Path = Environment.getExternalStorageDirectory();;
	private File musicPathFile;
	
	private List<String> songs = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	private final String Path = new String(SDCard_Path.toString() + "/Musixygen/");
	
	private ListView lv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        textview = (TextView)findViewById(R.id.textView1);
        lv = (ListView)findViewById(R.id.testListView);
        checkAvail();
//        getFiles();
        lv.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				Log.d("position", Path+songs.get(position));
				try {
					mp.reset();
					mp.setDataSource(Path+songs.get(position));
					mp.prepare();
					mp.start();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        	
        });

    }

    
//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//
//	}


	private void checkAvail() {
        // Check SD Card mounted or not
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)) {
        	return;
        } else { 
//        	textview.setText("SD Card is here.");
        	SDCard_Path = Environment.getExternalStorageDirectory();
        }
        // Check folder in SD Card exists or not
        // Environment.getExternalStorageDirectory.getParent() returns '/storage/emulated'
        // Environment.getExternalStorageDirectory.getName() returns' 0
        // Full path return exact directory name in SDCard.
        musicPathFile = new File(SDCard_Path.getParent() + "/" + SDCard_Path.getName() + "/Musixygen/");
        if (musicPathFile.exists()) {
        	// exists
//        	textview.setText("Folder exists.");
        	final String path = musicPathFile.getPath();
        	Log.d("get", path);
        }
        if (musicPathFile.listFiles() == null) {
//        	textview.setText("Cannot find files!");
        } else {
//        	textview.setText("Yo!");
        	if (musicPathFile.listFiles(new mp3FileFilter()).length > 0) {
        		for (File file : musicPathFile.listFiles(new mp3FileFilter())) {
        			songs.add(file.getName());
        		}
        		ArrayAdapter<String> songList = new ArrayAdapter<String>(this, R.layout.list_item, R.id.text1, songs);
        		lv.setAdapter(songList);
        	}       	
        }
//        Log.d("Files", "Size: "+ files.length);
        
//        	textview.setText("Folder does not exists");
//        }
	}
	
	class mp3FileFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}

