package com.example.analysis;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class ListViewLoader extends ListActivity {
	// Step 1: create a class extends ListActivity(import related class)
	// Step 2: create an XML file for string resources
	// Step 3: create an XML file for display each item (type: textView)
	// Step 4: create ArrayAdapter to get the string[]

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String[] appetize_features = getResources().getStringArray(R.array.Appetize_features);
		ArrayAdapter listadapter = new ArrayAdapter<String>(this, R.layout.list_item, appetize_features);
		
		setListAdapter(listadapter);
		
		// set a listener for a single item while onClick
		// import ListView Class
		ListView listview = getListView();
		
		listview.setOnItemClickListener(new OnItemClickListener() {
			// import Adapter Class
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				// import TextView Class
				String feature = ((TextView) view).getText().toString();
				
				// import Intent Class
				Intent i = new Intent(getApplicationContext(), SingleListItem.class);
				
				i.putExtra("feature", feature);
				startActivity(i);
			}
		} );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_loader, menu);
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

}
