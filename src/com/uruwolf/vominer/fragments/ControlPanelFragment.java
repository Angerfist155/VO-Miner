/*
 * ControlPanelFragment.java
 * Copyright (C) 2011 Steve "Uru" West <uruwolf@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 */
package com.uruwolf.vominer.fragments;

import com.uruwolf.vominer.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.uruwolf.vominer.data.Static;

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
        ArrayAdapter<String> systemAdapter = new ArrayAdapter<String>(getActivity(),
        		android.R.layout.simple_list_item_1,
        		Static.systemList);
        systemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSpinner.setAdapter(systemAdapter);
		
        //Load the letter selection
        Spinner gridAlphaSpinner = (Spinner) view.findViewById(R.id.gridAlphaList);
        ArrayAdapter<String> gridAlphaAdapter = new ArrayAdapter<String>(getActivity(),
        		android.R.layout.simple_list_item_1,
        		Static.alphaCoordList);
        gridAlphaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gridAlphaSpinner.setAdapter(gridAlphaAdapter);

        //And finally load the number selector
        Spinner gridNumSpinner = (Spinner) view.findViewById(R.id.gridNumList);
        ArrayAdapter<String> gridNumAdapter = new ArrayAdapter<String>(getActivity(),
        		android.R.layout.simple_list_item_1,
        		Static.numCoordList);
        gridNumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gridNumSpinner.setAdapter(gridNumAdapter);
        
		return view;
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}
}
