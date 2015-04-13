package listviewclass;

import java.util.ArrayList;

import com.example.emergencyservicebangladesh.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PoliceListView extends ArrayAdapter<String>{
	private Context context;
	private ArrayList<String> departmentList=new ArrayList<String>();
	
	public PoliceListView(Context context, int resource, ArrayList<String> departmentList) {
		super(context, resource,departmentList);
		this.context=context;
		this.departmentList=departmentList;
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
		txt.setText(departmentList.get(position));
		return itemview;
	}

}
