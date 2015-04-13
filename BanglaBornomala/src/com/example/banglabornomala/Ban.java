package com.example.banglabornomala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ban extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ban);
		Button b1=(Button)findViewById(R.id.chora1);
		b1.setOnClickListener(this);
		Button b2=(Button)findViewById(R.id.chora2);
		b2.setOnClickListener(this);
		Button b3=(Button)findViewById(R.id.chora3);
		b3.setOnClickListener(this);
		Button b4=(Button)findViewById(R.id.chora4);
		b4.setOnClickListener(this);
		Button b5=(Button)findViewById(R.id.chora5);
		b5.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.chora1)
		{
		Intent i=new Intent(this,Chora1.class);
		this.startActivity(i);
			
		}
		if(v.getId()==R.id.chora2)
		{
		Intent i=new Intent(this,Chora2.class);
		this.startActivity(i);
			
		}
		if(v.getId()==R.id.chora3)
		{
		Intent i=new Intent(this,Chora3.class);
		this.startActivity(i);
			
		}
		if(v.getId()==R.id.chora4)
		{
		Intent i=new Intent(this,Chora4.class);
		this.startActivity(i);
			
		}
		if(v.getId()==R.id.chora5)
		{
		Intent i=new Intent(this,Chora5.class);
		this.startActivity(i);
			
		}
	}

}
