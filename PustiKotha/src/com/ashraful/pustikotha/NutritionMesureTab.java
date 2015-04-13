package com.ashraful.pustikotha;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class NutritionMesureTab extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nutrition_mesure_tab);
		Intent myInt = getIntent();
		String cName = myInt.getStringExtra("name");
		String fName = myInt.getStringExtra("fname");
		String mName = myInt.getStringExtra("mname");
		String bdate = myInt.getStringExtra("bdate");
		
		TextView tvName = (TextView)findViewById(R.id.tv_nm_name);
		tvName.setText(cName);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nutrition_mesure_tab, menu);
		return true;
	}

}
