package com.example.locakstoragetest;



import com.example.locakstoragetest.utils.UIHelper;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	public static final String LOGTAG="EXPLORECA";
	public static final String USERNAME="username"; // username is to refer the value
	
	private SharedPreferences settings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		settings = getPreferences(MODE_PRIVATE);
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();		
		}
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

	public void setPreference(View v){
		Log.i(LOGTAG, "Clicked set");
		
		// To set a preference, needs the SharedPreferences editor object 
		// which is a class that's a field of SharedPreference.
		SharedPreferences.Editor editor = settings.edit(); // return an editor object.
		String prefValue = UIHelper.getText(this, R.id.editText1);
		editor.putString(USERNAME, prefValue);
		editor.commit();
		UIHelper.displayText(this, R.id.textView1, "Preference Saved");
	}
	public void showPreference(View v){
		Log.i(LOGTAG, "Clicked show");
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
