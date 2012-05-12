package com.uruwolf.vominer.fragments;

import com.uruwolf.vominer.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SectorInfoFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		//Set up the layout that we want to use for this fragment
		View view = inflater.inflate(R.layout.sector_info, container, false);

		return view;
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
}
