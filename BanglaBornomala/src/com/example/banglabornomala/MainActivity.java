
package com.example.banglabornomala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1=(Button)findViewById(R.id.play);
		b1.setOnClickListener(this);
		Button b2=(Button)findViewById(R.id.stop2);
		b2.setOnClickListener(this);
	}
	public void onClick(View v)
	{
		if(v.getId()==R.id.play)
		{
		Intent i=new Intent(this,Shor.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.stop2)
		{
		Intent i=new Intent(this,Ban.class);
		this.startActivity(i);
			
		}
		
	}

	//@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
*/
}
