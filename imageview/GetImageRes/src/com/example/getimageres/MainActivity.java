package com.example.getimageres;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends Activity {

	private ImageView image;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads()
//                .detectDiskWrites()
//                .detectNetwork()   // or .detectAll() for all detectable problems
//                .penaltyLog()
//                .build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects()
//                .detectLeakedClosableObjects()
//                .penaltyLog()
//                .penaltyDeath()
//                .build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // The XML way to set image in a layout:
        // 1. Put image into res->drawable folder
        // 2. Set android:id="@+id/id-name" & android:src"@drawable/your-file-name" in ImageView component
        
        // findViewById() way to set image:
        // 1. Create an ImageView variable for xml imageview component (import android.widget.ImageView). (Set android:id="@+id/id-name")
        // 2. variable = (ImageView) findViewById(R.id.id-name), link it.
        // 3. use imageview variable method setImageResource(R.drawable.your-file-name) to get the image file.
//        image = (ImageView) findViewById(R.id.imageView1);
//        image.setImageResource(R.drawable.header);
        
        // url to fetch image
        // 1. Strict mode:
//      image = (ImageView) findViewById(R.id.imageView1);
//		image.setImageDrawable(loadImageFromURL("http://kawaii.ph/wp-content/uploads/2014/03/kawaiiph-sample-header-2-copy.png"));
        // Need loadImageFromURL(String url) method
        
        // Will go NetworkOnMainThreadException if the network manipulation is in the main thread (android 3.0+ limited).      
        image = (ImageView) findViewById(R.id.imageView1);
		String URL = "http://kawaii.ph/wp-content/uploads/2014/03/kawaiiph-sample-header-2-copy.png";
        
		image.setTag(URL);
		LoadImageTask LIT = new LoadImageTask();
		LIT.execute(image);
    }
    
    private static Drawable loadImageFromURL(String url){
        try{
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable draw = Drawable.createFromStream(is, "src"); // the second parameter might be null
            return draw;
        }catch (Exception e) {
            //TODO handle error
            Log.i("loadingImg", e.toString());
            return null;
        }
    }

    private class LoadImageTask extends AsyncTask <ImageView, Void, Bitmap>{

    	ImageView imageView = null;

    	@Override
    	protected Bitmap doInBackground(ImageView... imageViews) {
    	    this.imageView = imageViews[0];
    	    return download_Image((String)imageView.getTag());
    	}

    	@Override
    	protected void onPostExecute(Bitmap result) {
    	    imageView.setImageBitmap(result);
    	}


    	private Bitmap download_Image(String url) {
            Bitmap bmp =null;
            try{
                URL ulrn = new URL(url);
                HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                InputStream is = con.getInputStream();
                bmp = BitmapFactory.decodeStream(is);
                if (null != bmp)
                    return bmp;

                }catch(Exception e){}
            return bmp;
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

//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            return rootView;
//        }
//    }

}
