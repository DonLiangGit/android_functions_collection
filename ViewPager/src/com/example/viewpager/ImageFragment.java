package com.example.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageFragment extends Fragment {
	private final int imageResourceId;
	private final String title;

	public ImageFragment(int imageResourceId, String title) {
		this.imageResourceId = imageResourceId;
		this.title = title;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ImageFragment", "onCreate()");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.image_layout, container, false);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
		imageView.setImageResource(imageResourceId);
		TextView textView = (TextView)view.findViewById(R.id.detailsText);
		textView.setText(title);
		return view;
	}
}