package com.example.banglabornomala;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Nine extends Activity{
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.nine);
	Button play =(Button)findViewById(R.id.play9);
	Button stop =(Button)findViewById(R.id.stop9);
	play.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mp=MediaPlayer.create(Nine.this, R.raw.nine);
			mp.start();
		}
	});
	stop.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mp.stop();
		}
	});
	}

}
