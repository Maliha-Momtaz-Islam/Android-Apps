package com.ashraful.pustikotha;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;

public class ChildInfoTab extends Activity {
String[] sl = new String[]{"1","2","3"};
String[] dates = new String[]{"01/01/2013","01/02/2013","01/03/2013"};
String[] weights = new String[]{"2.750kg","3.55kg","4.35kg"};
String[] heights = new String[]{"38cm","45cm","53cm"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_info_tab);
		Intent myInt = getIntent();
		String cName = myInt.getStringExtra("name");
		String fName = myInt.getStringExtra("fname");
		String mName = myInt.getStringExtra("mname");
		String bdate = myInt.getStringExtra("bdate");
		
		TextView tvName = (TextView)findViewById(R.id.tv_cht_name);
		TextView tvFName = (TextView)findViewById(R.id.tv_cht_fname);
		TextView tvMName = (TextView)findViewById(R.id.tv_cht_mname);
		TextView tvBDate = (TextView)findViewById(R.id.tv_cht_bdate);
		tvName.setText(cName);
		tvFName.setText(fName);
		tvMName.setText(mName);
		tvBDate.setText(bdate);
		
		TableLayout measureTable = (TableLayout)findViewById(R.id.measure_info_table);
		
		TableRow th = new TableRow(this);
		th.setBackgroundColor(Color.BLACK);
		th.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		TextView thd = new TextView(this);
		thd.setPadding(3, 3, 3, 3);
		thd.setTextColor(Color.WHITE);
		thd.setText("SL No.");
		th.addView(thd);
		
		TextView thd1 = new TextView(this);
		thd1.setPadding(3, 3, 3, 3);
		thd1.setTextColor(Color.WHITE);
		thd1.setText("Date");
		th.addView(thd1);
		
		TextView thd2 = new TextView(this);
		thd2.setPadding(3, 3, 3, 3);
		thd2.setTextColor(Color.WHITE);
		thd2.setText("Weight");
		th.addView(thd2);
		
		TextView thd3 = new TextView(this);
		thd3.setPadding(3, 3, 3, 3);
		thd3.setTextColor(Color.WHITE);
		thd3.setText("Height");
		th.addView(thd3);
		
		TextView thd4 = new TextView(this);
		thd4.setPadding(3, 3, 3, 3);
		thd4.setTextColor(Color.WHITE);
		thd4.setText("Comment");
		th.addView(thd4);
		measureTable.addView(th);
		
		for (int i = 0; i < sl.length; i++) {
			TableRow tr = new TableRow(this);
//			if((sl[i])%2==0)tr.setBackgroundColor(Color.DKGRAY);
			tr.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			
			final TextView td = new TextView(this);
			td.setPadding(7, 3, 3, 3);			
			td.setTextColor(Color.WHITE);
			td.setText(sl[i]);
			tr.addView(td);
			
			final TextView td1 = new TextView(this);
			td1.setPadding(3, 3, 3, 3);
			td1.setTextColor(Color.WHITE);
			td1.setText(dates[i]);
			tr.addView(td1);
			
			final TextView td2 = new TextView(this);
			td2.setPadding(3, 3, 3, 3);
			td2.setTextColor(Color.WHITE);
			td2.setText(weights[i]);
			tr.addView(td2);
			
			final TextView td3 = new TextView(this);
			td3.setPadding(3, 3, 3, 3);
			td3.setTextColor(Color.WHITE);
			td3.setText(heights[i]);
			tr.addView(td3);
			
			final TextView td4 = new TextView(this);
			td4.setPadding(3, 3, 3, 3);
			td4.setTextColor(Color.WHITE);
			td4.setText("OK");
			tr.addView(td4);
			
			measureTable.addView(tr);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_info_tab, menu);
		return true;
	}

}
