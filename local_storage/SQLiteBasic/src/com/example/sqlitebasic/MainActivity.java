package com.example.sqlitebasic;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	DBAdapter myDatabase;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        openDB();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		closeDB();
	}

	private void openDB() {
		// TODO Auto-generated method stub
		myDatabase = new DBAdapter(this);
		myDatabase.open();
	}
	
	private void closeDB() {
		// TODO Auto-generated method stub
		myDatabase.close();
	}

	private void showText(String msg) {
    	TextView textView = (TextView)findViewById(R.id.textView1);
    	textView.setText(msg);
    }

    public void onClick_Add(View v) {
    	showText("Clicked add record");
    	long newid = myDatabase.insertRow("Don", 1035504, "BlackandYellow");
    }
    
    public void onClick_Clear(View v) {
    	showText("Clicked clear all records");
    }
    
    public void onClick_Show(View v) {
    	showText("Clicked show all records");
    	Cursor cursor = myDatabase.getAllRows();
    	
    	displayRecords(cursor);
    }
    
    private void displayRecords(Cursor cursor) {
		// TODO Auto-generated method stub
    	String message = "Hi";
		showText(message);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
