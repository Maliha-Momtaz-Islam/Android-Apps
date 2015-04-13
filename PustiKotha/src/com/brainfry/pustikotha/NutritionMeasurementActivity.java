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
public class NutritionMeasurementActivity extends TabActivity {
	private TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nutrition_measurement);

		tabHost = (TabHost) findViewById(android.R.id.tabhost);

		TabSpec measureTabOne = tabHost.newTabSpec("beforebirth");
		measureTabOne.setIndicator("Before Birth");
		Intent contentOne = new Intent(NutritionMeasurementActivity.this, BeforeBirthMeasureTab.class);
		measureTabOne.setContent(contentOne);

		TabSpec measureTabTwo = tabHost.newTabSpec("zerotoone");
		measureTabTwo.setIndicator("0-1 age");
		Intent contentTwo = new Intent(NutritionMeasurementActivity.this, ZeroToOneMesureTab.class);
		measureTabTwo.setContent(contentTwo);

		TabSpec measureTabThree = tabHost.newTabSpec("onetofive");
		measureTabThree.setIndicator("1-5 age");
		Intent contentThree = new Intent(NutritionMeasurementActivity.this, OneToFiveMeasureTab.class);
		measureTabThree.setContent(contentThree);

		tabHost.addTab(measureTabOne);
		tabHost.addTab(measureTabTwo);
		tabHost.addTab(measureTabThree);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nutrition_measurement, menu);
		return true;
	}

}
