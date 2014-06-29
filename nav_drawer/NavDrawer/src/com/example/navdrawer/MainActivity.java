package com.example.navdrawer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends Activity {

    private DrawerLayout layDrawer;
    private ListView lstDrawer;
    
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
        initActionBar();
        initDrawer();
        initDrawerList();
    }

    private void initActionBar(){
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
    }
    
    private void initDrawer(){
        setContentView(R.layout.drawer);
        layDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        lstDrawer = (ListView) findViewById(R.id.left_drawer);
        
        //layDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mTitle = mDrawerTitle = getTitle();
        
        drawerToggle = new ActionBarDrawerToggle(
                this, 
                layDrawer,
                R.drawable.ic_drawer, 
                R.string.drawer_open,
                R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };
        drawerToggle.syncState();

        layDrawer.setDrawerListener(drawerToggle);
    }

    private void initDrawerList(){
        String[] drawer_menu = this.getResources().getStringArray(R.array.drawer_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawer_menu);
        lstDrawer.setAdapter(adapter);
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
        
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        
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
    
    public void onBakPressed() {
    	  finish();
    }

}
