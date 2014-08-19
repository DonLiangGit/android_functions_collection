package com.example.sdcard_basic;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class songDetailDialog extends DialogFragment implements OnItemClickListener{
	
	String[] listItems = {"Add to playlist", "Song Details", "Share", "Feedback"};
	
	ListView dialogList;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.songdialoglayout, null, false);
        dialogList = (ListView) view.findViewById(R.id.dialoglist);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.song_dhandle, listItems);

        dialogList.setAdapter(adapter);
        dialogList.setOnItemClickListener(this);

    }
    
//	public Dialog onCreateDialog(Bundle savedInstanceState) {
//		
//		// The getActivity() method gives the context of the Activity. 
//		// You can use YourActivityName.class instead of it.
//		final Dialog dialog =new Dialog(getActivity());
//		
//		// remove the dialog title
//		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		dialog.setContentView(R.layout.songdialoglayout);
//		dialog.setCanceledOnTouchOutside(true);
//		// set the dialog background transparent
//		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//		
//		return dialog;
//	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
        dismiss();
        Toast.makeText(getActivity(), listItems[arg2], Toast.LENGTH_SHORT).show();
	}
}
