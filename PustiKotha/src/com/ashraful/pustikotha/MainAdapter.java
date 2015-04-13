package com.ashraful.pustikotha;

import java.util.List;

import com.ashraful.pustikotha.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends ArrayAdapter<MainListItem> {

	public MainAdapter(Context context,  List<MainListItem> objects) {
		super(context, R.layout.main_list, objects);
		// TODO Auto-generated constructor stub
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.main_list, parent, false);
		}
		
		ImageView thumbImage = (ImageView) convertView.findViewById(R.id.thumb_image);		
		TextView text = (TextView)convertView.findViewById(R.id.textView1);
		MainListItem item = getItem(position);
		
		if (item != null) {
			thumbImage.setImageResource(item.getImage());
			text.setText(item.getText());
		}
		
//		return super.getView(position, convertView, parent);
		return convertView;
	}
}
