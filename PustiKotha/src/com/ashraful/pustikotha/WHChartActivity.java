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
public class WHChartActivity extends TabActivity {
	private TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_whchart);
		

		tabHost = (TabHost)findViewById(android.R.id.tabhost);
		
		TabSpec girlTab = tabHost.newTabSpec("girl");
		girlTab.setIndicator("Girl");
		Intent girl = new Intent(WHChartActivity.this, WHGirlTab.class);
		girlTab.setContent(girl);
		
		TabSpec boyTab = tabHost.newTabSpec("boy");
		boyTab.setIndicator("Boy");
		Intent boy = new Intent(WHChartActivity.this, WHBoyTab.class);
		boyTab.setContent(boy);
		
		tabHost.addTab(girlTab);
		tabHost.addTab(boyTab);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.whchart, menu);
		return true;
	}

}
