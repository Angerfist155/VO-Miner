package com.uruwolf.vominer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;

/**
 * The main activity for the app
 * @author Uru
 */
public class VoMinerActivity extends Activity implements OnClickListener{
	
	//Tag to use for debugging
	public static final String TAG = "Vo-Miner";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Make sure we can respond to button clicks
        Button loadButton = (Button) findViewById(R.id.load_button);
        loadButton.setOnClickListener(this);
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
    
    /**
     * Process a click event for the button
     */
    public void onClick(View v) {

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
}