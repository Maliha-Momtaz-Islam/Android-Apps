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
public class ChildInfoActivity extends TabActivity {
	private TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_info);
		Intent myInt = getIntent();
		String cName = myInt.getStringExtra("name");
		String fName = myInt.getStringExtra("fname");
		String mName = myInt.getStringExtra("mname");
		String bdate = myInt.getStringExtra("bdate");
		
		tabHost = (TabHost) findViewById(android.R.id.tabhost);

		TabSpec infoTab = tabHost.newTabSpec("info");
		infoTab.setIndicator("Information");
		Intent info = new Intent(ChildInfoActivity.this, ChildInfoTab.class);
		info.putExtra("name", cName);
		info.putExtra("fname", fName);
		info.putExtra("mname", mName);
		info.putExtra("bdate", bdate);
		
		infoTab.setContent(info);

		TabSpec measureTab = tabHost.newTabSpec("newmeasurement");
		measureTab.setIndicator("New Measurement");
		Intent measure = new Intent(ChildInfoActivity.this, NutritionMesureTab.class);
		measure.putExtra("name", cName);
		measure.putExtra("fname", fName);
		measure.putExtra("mname", mName);
		measure.putExtra("bdate", bdate);
		measureTab.setContent(measure);

		tabHost.addTab(infoTab);
		tabHost.addTab(measureTab);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_info, menu);
		return true;
	}

}
