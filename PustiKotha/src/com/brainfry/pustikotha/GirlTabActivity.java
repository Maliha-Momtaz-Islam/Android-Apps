package com.ashraful.pustikotha;

import java.util.ArrayList;
import java.util.List;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class GirlTabActivity extends Activity {
	private ChildAdapter childAdapter;
	private List<ChildModel> list;
	private ChildModel childModel;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_girl_tab);
		
		list = new ArrayList<ChildModel>();
		childModel = new ChildModel();
		childModel.setChildName("Shafia Akther");
		childModel.setFatherName("Abdur Rahman");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Shafia Akther");
		childModel.setFatherName("Abdur Rahman");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Shafia Akther");
		childModel.setFatherName("Abdur Rahman");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Shafia Akther");
		childModel.setFatherName("Abdur Rahman");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Shafia Akther");
		childModel.setFatherName("Abdur Rahman");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childAdapter = new ChildAdapter(this, list);
		listView = (ListView) findViewById(R.id.lv_girl);
		listView.setAdapter(childAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method st
				TextView tvName = (TextView)view.findViewById(R.id.tv_child_name);
				TextView tvFName = (TextView)view.findViewById(R.id.tv_father_name);
				TextView tvMName = (TextView)view.findViewById(R.id.tv_mother_name);
				TextView tvBDate = (TextView)view.findViewById(R.id.tv_bdate);
				
				String name = tvName.getText().toString();
				String fname = tvFName.getText().toString();
				String mname = tvMName.getText().toString();
				String bdate = tvBDate.getText().toString();
				Intent intent = new Intent(GirlTabActivity.this, ChildInfoActivity.class);
				intent.putExtra("name", name);
				intent.putExtra("fname", fname);
				intent.putExtra("mname", mname);
				intent.putExtra("bdate", bdate);
				startActivity(intent);
			}
		});

	}
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		View view = (View)findViewById(R.layout.child_option);
		switch (id){
		case 0 :
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("Option")
			.setView(view)
			.setNegativeButton("Cancel", 
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									
								}
							})
							
							.create();
		}
		return super.onCreateDialog(id);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_tab, menu);
		return true;
	}

}
