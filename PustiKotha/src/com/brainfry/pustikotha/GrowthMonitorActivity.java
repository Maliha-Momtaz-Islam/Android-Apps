package com.ashraful.pustikotha;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class GrowthMonitorActivity extends TabActivity {
	private TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_child);
		
		tabHost = (TabHost)findViewById(android.R.id.tabhost);
		
		TabSpec girlTab = tabHost.newTabSpec("girl");
		girlTab.setIndicator("Girl");
		Intent girl = new Intent(GrowthMonitorActivity.this, GirlTabActivity.class);
		girlTab.setContent(girl);
		
		TabSpec boyTab = tabHost.newTabSpec("boy");
		boyTab.setIndicator("Boy");
		Intent boy = new Intent(GrowthMonitorActivity.this, BoyTabActivity.class);
		boyTab.setContent(boy);
		
		TabSpec newBabyTab = tabHost.newTabSpec("newbaby");
		newBabyTab.setIndicator("New Child");
		Intent newBaby = new Intent(GrowthMonitorActivity.this, NewChildActivity.class);
		newBabyTab.setContent(newBaby);
		
		tabHost.addTab(girlTab);
		tabHost.addTab(boyTab);
		tabHost.addTab(newBabyTab);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_child, menu);
		return true;
	}

}
