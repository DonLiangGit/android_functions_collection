package com.donliang.connectls;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.facebook.*;
import com.facebook.model.*;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {
	
	private UiLifecycleHelper uiHelper;
	private Button loginButton;
	private Button shareButton;
	private Button logoutButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Configure the UiLifecycleHelper in onCreate()
        uiHelper = new UiLifecycleHelper(this, null);
        uiHelper.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        checkHashKey();
        
        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Session session = Session.getActiveSession();
        		// logout button should set in a fragment.
        	    if (session.isOpened() == false) {
        	    	Log.d("session", "is not");
        	    	Session.openActiveSession(MainActivity.this, true, new Session.StatusCallback() {
        	            @Override
        	            public void call(Session session, SessionState state, Exception exception){
        	            	
        	            }	    		
        	    	});
        	    }
        	}
        });
        
        logoutButton = (Button)findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Session session = Session.getActiveSession();
        	    if (session != null) {
        	    	session.closeAndClearTokenInformation();
        	    	session.close();
        	    	Session.setActiveSession(null);
        	    	Toast.makeText(getBaseContext(), "Log out", Toast.LENGTH_SHORT).show();
        	    }
        	}
        });
        
        // start Facebook Login
        // .opernActiveSession(arg1, arg2, arg3)
        // arg1: a reference to this Activity
        // arg2: a flag that indicate the Login UI should be used
        // arg3: a callback when a status changes
        Session.openActiveSession(this, true, new Session.StatusCallback() {
          // callback when session changes state
          @Override
          public void call(Session session, SessionState state, Exception exception) {
            if (session.isOpened()) {

              // make request to the /me API
              Request.newMeRequest(session, new Request.GraphUserCallback() {

                // callback after Graph API response with user object
                @Override
                public void onCompleted(GraphUser user, Response response) {
                  if (user != null) {
                    TextView welcome = (TextView) findViewById(R.id.welcome);
                    welcome.setText("Hello " + user.getName() + "!");
                    Log.d("userId", user.getId());
//                    Log.d("bday", user.getBirthday());
                    Log.d("lastname", user.getLastName());
                    
                  }
                }
              }).executeAsync();
            }
          }
        });
        
        shareButton = (Button)findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		// Using Share Dialog if Facebook app installed natively
        		if (FacebookDialog.canPresentShareDialog(getApplicationContext(), 
        				FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) {
        			// Publish the post using the Share Dialog
        			FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(getParent())
        			.setLink("https://developers.facebook.com/android")
        			.build();
        			uiHelper.trackPendingDialogCall(shareDialog.present());
        		} else if (Session.getActiveSession().isOpened() == true){
        			// Fallback. For example, publish the post using the Feed Dialog
        			publishFeedDialog();
        		} else {
        			Toast.makeText(getBaseContext(), "Please login Facebook", Toast.LENGTH_SHORT).show();
        		}
        	}
        });


//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
    }
    
    private void publishFeedDialog() {
        Bundle params = new Bundle();
        params.putString("name", "Facebook SDK for Android");
        params.putString("caption", "Build great social apps and get more installs.");
        params.putString("description", "The Facebook SDK for Android makes it easier and faster to develop Facebook integrated Android apps.");
        params.putString("link", "https://developers.facebook.com/android");
        params.putString("picture", "https://raw.github.com/fbsamples/ios-3.x-howtos/master/Images/iossdk_logo.png");

        WebDialog feedDialog = (new WebDialog.FeedDialogBuilder(MainActivity.this,
        		Session.getActiveSession(),
        		params))
        		.setOnCompleteListener(new OnCompleteListener() {
    			   @Override
    			   public void onComplete(Bundle values,FacebookException error) {
    				   
    			   }
    		}).build();
        feedDialog.show();
    }
    
	private void checkHashKey() {
		// TODO Auto-generated method stub
        // Get the KeyHash from Local Machine
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.donliang.connectls", 
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                }
        } catch (NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

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
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
      
      uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
          @Override
          public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
              Log.e("Activity", String.format("Error: %s", error.toString()));
          }

          @Override
          public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
              Log.i("Activity", "Success!");
          }
      });
    }

    
    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }
    
}
