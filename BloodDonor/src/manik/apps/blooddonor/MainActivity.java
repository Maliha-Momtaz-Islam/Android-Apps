package manik.apps.blooddonor;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnAddDoner = (Button) findViewById(R.id.btnAddDonor);	
		btnAddDoner.setOnClickListener(new OnClickListener() {
			
		// 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub					
				Intent ii = new Intent(MainActivity.this, AddDonorActivity.class);
				startActivity(ii);
			}
		});
		
		Button btnSearch = (Button) findViewById(R.id.btnSearchDonor);	
		btnSearch.setOnClickListener(new OnClickListener() {
			
		// 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub					
				Intent ii = new Intent(MainActivity.this, DonorList.class);
				startActivity(ii);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
