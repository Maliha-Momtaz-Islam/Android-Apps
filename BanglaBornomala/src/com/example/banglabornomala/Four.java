package com.example.banglabornomala;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Four extends Activity{
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.four);
	Button play =(Button)findViewById(R.id.play4);
	Button stop =(Button)findViewById(R.id.stop4);
	play.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mp=MediaPlayer.create(Four.this, R.raw.four);
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
