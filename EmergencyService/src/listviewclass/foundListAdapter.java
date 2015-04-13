package listviewclass;

import java.util.ArrayList;

import com.example.emergencyservicebangladesh.R;

import entityclass.Emergency;

import android.content.Context;
import android.content.Entity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class foundListAdapter extends ArrayAdapter<Emergency> {

	Context context;
	ArrayList<Emergency> list=new ArrayList<Emergency>();
	public foundListAdapter(Context context, int resource, ArrayList<Emergency> foundList) {
		super(context, resource, foundList);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.list=foundList;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
View itemview=convertView;
		
		if(itemview==null)
		{
			LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemview=layoutInflater.inflate(R.layout.list, parent, false);
		}
		TextView txt=(TextView)itemview.findViewById(R.id.textView1);
		txt.setText(list.get(position).getName());
		return itemview;
	}

}
