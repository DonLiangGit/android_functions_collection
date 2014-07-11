package com.example.viewpager;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Build;

public class GuideActivity extends FragmentActivity implements OnPageChangeListener{
	
	private MyAdapter mAdapter;
	private ViewPager mPager;
	
	// Indicator
	private ImageView[] dots;
	// Current Index
	private int currentIndex;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_guide);
		
		final Button button = (Button) findViewById(R.id.button_previous);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Toast.makeText(getApplicationContext(), "Index", Toast.LENGTH_SHORT).show(); 
            }
        });
        		
		mPager = (ViewPager) findViewById(R.id.pager);
		mAdapter = new MyAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		
		//
		initDots();
		mPager.setOnPageChangeListener(this);		
	}
	
	private void initDots() {
		LinearLayout dotlayout = (LinearLayout) findViewById(R.id.dotlayout);

		dots = new ImageView[4];

		// get dots image
		for (int i = 0; i < 4; i++) {
			dots[i] = (ImageView) dotlayout.getChildAt(i);
			dots[i].setEnabled(true);// default
			dots[i].setTag(i);// setTag?
		}
		currentIndex = 0;
		dots[currentIndex].setEnabled(false);// selected state
	}
	
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
	}

	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	// ViewPager Index starts from 0
	public void onPageSelected(int position) {
		  setCurDot(position);
		  if( position == 1 ){
			  //Toast.makeText(getApplicationContext(), "Index", Toast.LENGTH_SHORT).show(); 
		  }
	}
	
	private void setCurDot(int position) {
		// TODO Auto-generated method stub
		if (position < 0 || position > 5 - 1 || currentIndex == position) {
			return;
		}
		dots[position].setEnabled(false);
		
		dots[currentIndex].setEnabled(true);
		currentIndex = position;
	}

//	protected void pageButtonClick(View v) {
//		// TODO Auto-generated method stub
//		Toast.makeText(getApplicationContext(), "Index", Toast.LENGTH_SHORT).show(); 
//		
//	}

	public static class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		// Method to return number of Viewpager fragment
		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public android.support.v4.app.Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new DetailOneFragment();
			case 1:
				return new ImageFragment(R.drawable.frag_img2, "Onigiri");
			case 2:
				return new ImageFragment(R.drawable.frag_img3, "Cake");
			case 3:
				return new ImageFragment(R.drawable.frag_img4, "Green Tea");
			default:
				return null;
			}
		}
	}

}