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
		
		//Set up all the spinners. One for the system and another two for the coords. I hate how messy this is
		Spinner oreSpinner = (Spinner) view.findViewById(R.id.oreList);
        ArrayAdapter<CharSequence> systemAdapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.system_list, android.R.layout.simple_spinner_item);
        systemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        oreSpinner.setAdapter(systemAdapter);

		return view;
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
}
