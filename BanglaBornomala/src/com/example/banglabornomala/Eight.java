package com.example.banglabornomala;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Eight extends Activity{
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.eight);
	Button play =(Button)findViewById(R.id.play8);
	Button stop =(Button)findViewById(R.id.stop8);
	play.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mp=MediaPlayer.create(Eight.this, R.raw.eight);
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
