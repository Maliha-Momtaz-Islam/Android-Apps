package com.ashraful.pustikotha;

import java.util.List;

import com.ashraful.pustikotha.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChildAdapter extends ArrayAdapter<ChildModel>{

	public ChildAdapter(Context context, List<ChildModel> objects) {
		super(context, R.layout.child_list,  objects);
		// TODO Auto-generated constructor stub
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.child_list, parent, false);
		}
		TextView tvChildName = (TextView)convertView.findViewById(R.id.tv_child_name);
		TextView tvFatherName = (TextView)convertView.findViewById(R.id.tv_father_name);
		TextView tvMotherName = (TextView)convertView.findViewById(R.id.tv_mother_name);
		TextView tvBDate = (TextView)convertView.findViewById(R.id.tv_bdate);
		ChildModel child = getItem(position);
		if (child!=null) {
			tvChildName.setText(child.getChildName());
			tvFatherName.setText(child.getFatherName());
			tvMotherName.setText(child.getMotherName());
			tvBDate.setText(child.getbDate());
		}
//		return super.getView(position, convertView, parent);
		return convertView;
	}
}
