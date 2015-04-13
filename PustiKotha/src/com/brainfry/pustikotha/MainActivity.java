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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private MainAdapter mainAdapter;
	private List<MainListItem> list;
	private MainListItem listItem;
	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = new ArrayList<MainListItem>();
		listItem = new MainListItem();
		listItem.setImage(R.drawable.food_menu);
		listItem.setText("Nutrition Measure");
		list.add(listItem);

		listItem = new MainListItem();
		listItem.setImage(R.drawable.ic_launcher);		
		listItem.setText("Growth Monitoring");
		list.add(listItem);
				
		listItem = new MainListItem();
		listItem.setImage(R.drawable.food);
		listItem.setText("Food Menu");
		list.add(listItem);

		listItem = new MainListItem();
		listItem.setImage(R.drawable.hw_chart);
		listItem.setText("Height & Weight chart");
		list.add(listItem);

		mainAdapter = new MainAdapter(this, list);
		gridView = (GridView) findViewById(R.id.lv_main);
		gridView.setAdapter(mainAdapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView tv = (TextView) view.findViewById(R.id.textView1);
				String text = tv.getText().toString();
//				Toast.makeText(MainActivity.this, id+" "+position, Toast.LENGTH_SHORT).show();
				switch (position) {
				case 0:
					gotoActivity(NutritionMeasurementActivity.class);
					break;
				case 1:
					gotoActivity(GrowthMonitorActivity.class);
					break;
				case 2:
					gotoActivity(FoodMenuActivity.class);
					break;
				case 3:
					gotoActivity(WHChartActivity.class);
					break;
				default:
					break;
				}
				
				
			}
		});
	}

	private void gotoActivity(Class<?> cls){
		Intent intent = new Intent(MainActivity.this, cls);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
