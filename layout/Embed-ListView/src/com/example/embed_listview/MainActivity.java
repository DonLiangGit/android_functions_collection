package com.example.embed_listview;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        // 
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        
        // Set actionbar title
        SetCustomTitle("Android UI");
        
        popListView();
        clickCallback();
		
        // The Code below makes the app crash!
        // Answer: *IMPORTANT!*
        /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        } */ 
    }

	private void SetCustomTitle(String title) {
		// TODO Auto-generated method stub
		TextView textViewTitle = (TextView)findViewById(R.id.mytext);
		textViewTitle.setText(title);
	}

	private void popListView() {
    	// Create list of items
		String[] myItems = getResources().getStringArray(R.array.Test);
		
		Log.d("popListView", "Items");
		// Build Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				R.layout.list_item,
				myItems
				);
		Log.d("popListView", "Adapter");
		
		// Configure the list view
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);
		Log.d("popListView", "Set Adapter");
		
	}

    private void clickCallback() {
		// TODO Auto-generated method stub
    	ListView list = (ListView) findViewById(R.id.listView1);
    	list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View viewClicked, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				TextView textView = (TextView)viewClicked;
				String message = textView.getText().toString();
				Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();				
			}
    	});  	
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
