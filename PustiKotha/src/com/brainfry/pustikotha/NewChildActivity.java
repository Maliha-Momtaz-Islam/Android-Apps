package com.ashraful.pustikotha;

import java.util.Calendar;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NewChildActivity extends Activity {
	private EditText etChildName;
	private EditText etFatherName;
	private EditText etMotherName;
	private EditText etBdate;
	private RadioGroup rdgGender;
	private RadioButton rdoGirl;
	private RadioButton rdoBoy;
	private Button btnSave;
	private Button btnReset;
	private Button btnCancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_child);
		
		etChildName = (EditText)findViewById(R.id.et_nch_name);
		etFatherName = (EditText) findViewById(R.id.et_nch_fname);
		etMotherName = (EditText) findViewById(R.id.et_nch_mname);
		etBdate = (EditText) findViewById(R.id.et_nch_bdate);
		rdgGender = (RadioGroup) findViewById(R.id.rdg_nch_gender);
		rdoGirl = (RadioButton) findViewById(R.id.rdo_nch_girl);
		rdoBoy = (RadioButton) findViewById(R.id.rdo_nch_boy);
		btnSave = (Button) findViewById(R.id.btn_nch_save);
		btnReset = (Button) findViewById(R.id.btn_nch_reset);
		btnCancel = (Button) findViewById(R.id.btn_nch_cancel);
		
		etBdate.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(0);
				return false;
			}
		});
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String childName = etChildName.getText().toString();
				if (childName.isEmpty()) {
					showAlert("Please Enter Child Name", etChildName);
				} else {
					String fatherName = etFatherName.getText().toString();
					if (fatherName.isEmpty()) {
						showAlert("Please Enter Father Name", etFatherName);
					} else {
						String motherName = etMotherName.getText().toString();
						if (motherName.isEmpty()) {
							showAlert("Please Enter Mother Name", etMotherName);
						} else {
							String bDate = etBdate.getText().toString();
							if (bDate.isEmpty()) {
								showAlert("Please Enter Birth Date", etBdate);
							} else {

							}
						}
					}
				}
			}
		});
		
		btnReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				doReset();
			}
		});
		
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch(id){
		case 0 :			
			return getDpDialog();
		}
		return super.onCreateDialog(id);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_child, menu);
		return true;
	}
	
	private DatePickerDialog getDpDialog(){
		final Calendar c = Calendar.getInstance();
	    int year = c.get(Calendar.YEAR);
	    int month = c.get(Calendar.MONTH);
	    int day = c.get(Calendar.DAY_OF_MONTH);
		
		DatePickerDialog.OnDateSetListener dsl = new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				
				String msg = year + "/" + (monthOfYear+1) + "/" + dayOfMonth;
				etBdate.setText(msg);				
			}
		};
		
		return new DatePickerDialog(this,android.R.style.Theme_Dialog, dsl, year, month, day);
	}
	private void showAlert(String message, EditText editText){
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		editText.requestFocus();
	}
	private void doReset(){
		
		etChildName.setText(null);
		etFatherName.setText(null);
		etMotherName.setText(null);
		etBdate.setText(null);
		rdoGirl.setChecked(false);
		rdoBoy.setChecked(false);
		etChildName.requestFocus();
	}

}
