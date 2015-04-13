package com.ashraful.pustikotha;

import java.util.ArrayList;
import java.util.List;

import com.ashraful.pustikotha.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class BoyTabActivity extends Activity {
	private ChildAdapter childAdapter;
	private List<ChildModel> list;
	private ChildModel childModel;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boy_tab);
		
		list = new ArrayList<ChildModel>();
		childModel = new ChildModel();
		childModel.setChildName("Md. Sifat ul Haque");
		childModel.setFatherName("Md. ziaul Haque");
		childModel.setMotherName("Tanjina");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Eanmul Haque");
		childModel.setFatherName("Abdul Mannan");
		childModel.setMotherName("Sirina Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Ahmed Rasel");
		childModel.setFatherName("Shahid Uddin");
		childModel.setMotherName("Rabea Khatun");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Mashukur Rahman");
		childModel.setFatherName("Abdul Mannan");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Ashfaqul Islam");
		childModel.setFatherName("Sirajul islam");
		childModel.setMotherName("Mohua Arju");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Md. Sifat ul Haque");
		childModel.setFatherName("Md. ziaul Haque");
		childModel.setMotherName("Tanjina");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Eanmul Haque");
		childModel.setFatherName("Abdul Mannan");
		childModel.setMotherName("Sirina Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Ahmed Rasel");
		childModel.setFatherName("Shahid Uddin");
		childModel.setMotherName("Rabea Khatun");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Mashukur Rahman");
		childModel.setFatherName("Abdul Mannan");
		childModel.setMotherName("Amena Akther");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		childModel = new ChildModel();
		childModel.setChildName("Ashfaqul Islam");
		childModel.setFatherName("Sirajul islam");
		childModel.setMotherName("Mohua Arju");
		childModel.setbDate("05/11/2013");
		list.add(childModel);
		
		
		childAdapter = new ChildAdapter(this, list);
		listView = (ListView) findViewById(R.id.lv_boy);
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
				Intent intent = new Intent(BoyTabActivity.this, ChildInfoActivity.class);
				intent.putExtra("name", name);
				intent.putExtra("fname", fname);
				intent.putExtra("mname", mname);
				intent.putExtra("bdate", bdate);
				startActivity(intent);
			}
		});

	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_info_tab, menu);
		return true;
	}

}
