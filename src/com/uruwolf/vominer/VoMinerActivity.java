package com.uruwolf.vominer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * The main activity for the app
 * @author Uru
 */
public class VoMinerActivity extends Activity implements OnItemSelectedListener{
	
	//Tag to use for debugging
	public static final String TAG = "Vo-Miner";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Make sure we can update the information when something is selected
        ((Spinner)findViewById(R.id.systemList)).setOnItemSelectedListener(this);
        ((Spinner)findViewById(R.id.gridAlphaList)).setOnItemSelectedListener(this);
        ((Spinner)findViewById(R.id.gridNumList)).setOnItemSelectedListener(this);
    }
    
    /**
     * Show a fancy menu at the top right. Not sure if this will stay or not
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }
    
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
    	toast();
    }
    
    /**
     * Shows the user a toast containing the selected system and sector
     */
    public void toast() {

    	//Load up the three selected values from the spinners
    	String system = (String) ((Spinner)findViewById(R.id.systemList)).getSelectedItem();
    	String alpha = (String) ((Spinner)findViewById(R.id.gridAlphaList)).getSelectedItem();
    	String num = (String) ((Spinner)findViewById(R.id.gridNumList)).getSelectedItem();
    	
    	//Show a Toast to make the user think that something happened
    	Toast.makeText(getApplicationContext(),
    			String.format(getString(R.string.toast_loading_message), system, alpha, num),
    			Toast.LENGTH_SHORT)
    			.show();
	}
    
    public void onNothingSelected(AdapterView<?> parentView) {
    	// Do nothing
    }
}