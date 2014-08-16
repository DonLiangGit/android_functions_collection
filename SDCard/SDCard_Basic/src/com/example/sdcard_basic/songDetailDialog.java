package com.example.sdcard_basic;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

public class songDetailDialog extends DialogFragment {
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		// The getActivity() method gives the context of the Activity. 
		// You can use YourActivityName.class instead of it.
		final Dialog dialog =new Dialog(getActivity());
		
		// remove the dialog title
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.songdialoglayout);
		dialog.setCanceledOnTouchOutside(true);
		// set the dialog background transparent
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		return dialog;
	}
}
