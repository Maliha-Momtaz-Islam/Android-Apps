package com.ashraful.pustikotha;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class BeforeBirthMeasureTab extends Activity {
	EditText etFirstValue;
	EditText etSecondValue;
	EditText etRunningMonth;
	Button btnReset;
	Button btnCancel;
	Button btnMeasure;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_birth_measure_tab);

		etFirstValue = (EditText) findViewById(R.id.et_bbm_mother_weight_one);
		etSecondValue = (EditText) findViewById(R.id.et_bbm_mother_weight_two);
		etRunningMonth = (EditText) findViewById(R.id.et_bbm_running_month);
		btnReset = (Button) findViewById(R.id.btn_bbm_reset);
		btnCancel = (Button) findViewById(R.id.btn_bbm_cancel);
		btnMeasure = (Button) findViewById(R.id.btn_bbm_measure);
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
				etFirstValue.setText(null);
				etSecondValue.setText(null);
				etRunningMonth.setText(null);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.before_birth_measure_tab, menu);
		return true;
	}

}
