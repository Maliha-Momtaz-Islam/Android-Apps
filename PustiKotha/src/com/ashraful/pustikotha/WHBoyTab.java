package com.ashraful.pustikotha;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WHBoyTab extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_whboy_tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.whboy_tab, menu);
		return true;
	}

}
