package com.ashraful.pustikotha;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ZeroToOneMesureTab extends Activity {
	Button btnReset;
	Button btnCancel;
	Button btnMeasure;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zerotoone_mesure_tab);
		btnReset = (Button) findViewById(R.id.btn_zto_reset);
		btnCancel = (Button) findViewById(R.id.btn_zto_cancel);
		btnMeasure = (Button) findViewById(R.id.btn_zto_measure);
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		btnReset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zero_to_one_mesure_tab, menu);
		return true;
	}

}
