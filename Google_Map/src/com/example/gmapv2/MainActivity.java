package com.example.gmapv2;
// key path: /Users/new/.android/debug.keystore
// get key command: keytool -list -v -keystore "C:\Users\用戶名稱\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
// Certificate fingerprints:
// MD5:  18:17:86:CE:C7:D7:76:94:99:86:D0:48:2A:46:8C:79
// SHA1: 68:43:A8:94:3A:AB:F1:78:BF:32:DB:5B:2E:3D:E9:8D:93:53:4A:92
// SHA256: 26:B9:B8:A3:EA:06:DB:F1:2D:E5:52:E3:23:6A:B2:89:87:F8:9D:B7:14:86:00:27:4B:A0:A4:2C:9B:8A:4B:39
// API key:	AIzaSyBNA3tS8zhlmCtnE-SIz2Cb8vpMeCuXAdY

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	static final LatLng NKUT = new LatLng(23.979548, 120.696745);
    private GoogleMap map;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        Marker nkut = map.addMarker(new MarkerOptions().position(NKUT).title("南開科技大學").snippet("數位生活創意系"));

        // Move the camera instantly to NKUT with a zoom of 16.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(NKUT, 16));
        
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
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
