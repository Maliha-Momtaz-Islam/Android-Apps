package com.example.banglabornomala;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ten extends Activity{
	private MediaPlayer mp;
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
setContentView(R.layout.ten);
Button play =(Button)findViewById(R.id.play10);
Button stop =(Button)findViewById(R.id.stop10);
play.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mp=MediaPlayer.create(Ten.this, R.raw.ten);
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
