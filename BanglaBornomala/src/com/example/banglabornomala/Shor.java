package com.example.banglabornomala;
	
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Shor extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shor);
		Button b1=(Button)findViewById(R.id.one);
		b1.setOnClickListener(this);
		Button b2=(Button)findViewById(R.id.two);
		b2.setOnClickListener(this);
		Button b3=(Button)findViewById(R.id.three);
		b3.setOnClickListener(this);
		Button b4=(Button)findViewById(R.id.four);
		b4.setOnClickListener(this);
		Button b5=(Button)findViewById(R.id.five);
		b5.setOnClickListener(this);
		Button b6=(Button)findViewById(R.id.six);
		b6.setOnClickListener(this);
		Button b7=(Button)findViewById(R.id.seven);
		b7.setOnClickListener(this);
		Button b8=(Button)findViewById(R.id.eight);
		b8.setOnClickListener(this);
		Button b9=(Button)findViewById(R.id.nine);
		b9.setOnClickListener(this);
		Button b10=(Button)findViewById(R.id.ten);
		b10.setOnClickListener(this);
		Button b11=(Button)findViewById(R.id.eleven);
		b11.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.one)
		{
		Intent i=new Intent(this,One.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.two)
		{
		Intent i=new Intent(this,Two.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.three)
		{
		Intent i=new Intent(this,Three.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.four)
		{
		Intent i=new Intent(this,Four.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.five)
		{
		Intent i=new Intent(this,Five.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.six)
		{
		Intent i=new Intent(this,Six.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.seven)
		{
		Intent i=new Intent(this,Seven.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.eight)
		{
		Intent i=new Intent(this,Eight.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.nine)
		{
		Intent i=new Intent(this,Nine.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.ten)
		{
		Intent i=new Intent(this,Ten.class);
		this.startActivity(i);
			
		}
		else if(v.getId()==R.id.eleven)
		{
		Intent i=new Intent(this,Eleven.class);
		this.startActivity(i);
			
		}
		
	}

}
