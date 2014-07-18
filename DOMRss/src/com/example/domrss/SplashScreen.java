package com.example.domrss;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        ConnectivityManager connectMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectMgr.getActiveNetworkInfo();
		if ( connectMgr == null || info == null || info.getState() == NetworkInfo.State.DISCONNECTED ) {
	        Handler handler = new Handler();
	        Runnable r = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new AlertDialog.Builder(SplashScreen.this)
					.setTitle("Internet")
					.setMessage("Internet connection fails")
					.setCancelable(false)
					.setNegativeButton("Ok", new OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {							
						}
					}).create().show();
				}       	
	        };
	        handler.postDelayed(r, 500);
        } else {
        	Handler handler1 = new Handler();
	        Runnable r1 = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new AlertDialog.Builder(SplashScreen.this)
					.setTitle("Internet")
					.setMessage("It works!")
					.setCancelable(false)
					.setNegativeButton("Ok", new OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {							
						}
					}).create().show();
				}       	
	        };
	        handler1.postDelayed(r1, 1000);
        }
    }

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
    
    
}
