package com.uruwolf.vominer.fragments;

import com.uruwolf.vominer.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Controls a view for selecting a system and sector and as well as a button to trigger loading information for said sector.
 * @author Steve "Uru" West <uruwolf@gmail.com>
 */
public class ControlPanelFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		//Set up the layout that we want to use for this fragment
		View view = inflater.inflate(R.layout.sector_select, container, false);
		
		//Set up all the spinners. One for the system and another two for the coords. I hate how messy this is
		Spinner systemSpinner = (Spinner) view.findViewById(R.id.systemList);
        ArrayAdapter<CharSequence> systemAdapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.system_list, android.R.layout.simple_spinner_item);
        systemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSpinner.setAdapter(systemAdapter);
		
        //Load the letter selection
        Spinner gridAlphaSpinner = (Spinner) view.findViewById(R.id.gridAlphaList);
        ArrayAdapter<CharSequence> gridAlphaAdapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.grid_alpha_list, android.R.layout.simple_spinner_item);
        gridAlphaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gridAlphaSpinner.setAdapter(gridAlphaAdapter);

        //And finally load the number selector
        Spinner gridNumSpinner = (Spinner) view.findViewById(R.id.gridNumList);
        ArrayAdapter<CharSequence> gridNumAdapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.grid_num_list, android.R.layout.simple_spinner_item);
        gridNumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gridNumSpinner.setAdapter(gridNumAdapter);
        
		return view;
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
}
