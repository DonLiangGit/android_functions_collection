package com.example.sdcard_basic;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends Activity {
    
//	TextView textview;
	private File SDCard_Path = Environment.getExternalStorageDirectory();;
	private File musicPathFile;
	
	private List<String> songs = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	private final String Path = new String(SDCard_Path.toString() + "/Musixygen/");
	
	private ListView lv;
	
	// testing customized listview
	ArrayList<Song> songsTest;
	
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
				Log.d("position", Path+songsTest.get(position).getFilenmae());
				try {
					mp.reset();
					mp.setDataSource(Path+songsTest.get(position).getFilenmae());
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
		
		// testing
		songsTest = new ArrayList<Song>();
		ArrayList<Map<String,String>> songsMap = new ArrayList<Map<String,String>>();
		
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

        			// get MediaMetaData for each song
        			MediaMetadataRetriever songMetaData = new MediaMetadataRetriever();
        			songMetaData.setDataSource(Path + file.getName());
        			String artistName = songMetaData.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST);
        			
        			// time is retrieval
        			int secs = Integer.parseInt(songMetaData.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)) / 1000;
        			int mins = secs / 60;
        			secs = secs % 60;
        			String duration = String.format("%02d:%02d", mins, secs);
        			
        			if (artistName == null) {
        				artistName = "Unknown";
        			}
        			
        			// customized listview 7.31 testing
        			Song s = new Song();
        			s.setFilename(file.getName());
        			s.setDuration(duration);
        			songsTest.add(s);
        			
        			Map<String, String> mapSongInfo = convertSongToMap(s);
        			songsMap.add(mapSongInfo);
        			
//        			songs.add(file.getName());
        			
        		}
        		
        		SimpleAdapter adapter = new SimpleAdapter(this,songsMap,R.layout.list_item, new String[]{"songName","duration"},new int[]{R.id.text1, R.id.text2});
        		lv.setAdapter(adapter);
        		
//        		ArrayAdapter<String> songList = new ArrayAdapter<String>(this, R.layout.list_item, R.id.text1, songs);
//        		lv.setAdapter(songList);
        	}       	
        }
//        Log.d("Files", "Size: "+ files.length);
        
//        	textview.setText("Folder does not exists");
//        }
	}
	
	private Map<String, String> convertSongToMap(Song s) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("songName", s.getFilenmae());
		map.put("duration", s.getDuration());
		return map;
	}

	class mp3FileFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}

