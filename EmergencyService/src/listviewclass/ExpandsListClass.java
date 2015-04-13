package listviewclass;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.emergencyservicebangladesh.EmergencyMapActivity;
import com.example.emergencyservicebangladesh.R;

import databasepakage.Gateway;
 
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Typeface;
import android.net.Uri;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
 
public class ExpandsListClass extends BaseExpandableListAdapter {
 
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private Map<String, List<String>> _listDataChild;
    private Gateway aGateway;
    private ImageButton imageButton,imageButtonMap;
    public ExpandsListClass(Context context, List<String> listDataHeader,
            Map<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        aGateway=new Gateway(_context);
    }
 
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
        
    }
 
    @Override
    public long getChildId(int groupPosition, int childPosition) {
    	
        return childPosition;
    }
 
    @Override
    public View getChildView( int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
 
        final String childText = (String) getChild(groupPosition, childPosition);
        final String headerTitle = (String) getGroup(groupPosition);
        Log.i("group",""+groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.subitem, null);
        }
 
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.textView_subitem); 
        txtListChild.setText(childText);
        convertView.setPadding(0,0,0,20);
        imageButton=(ImageButton)convertView.findViewById(R.id.imageButton1);
        imageButtonMap=(ImageButton)convertView.findViewById(R.id.imageButton2);
        
        imageButtonMap.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(_context,EmergencyMapActivity.class);
				try {
					double latitude=aGateway.getLatitude(headerTitle);
					double longitude=aGateway.getLongitude(headerTitle);
					intent.putExtra("latitude",latitude);
					intent.putExtra("longitude",longitude);
					_context.startActivity(intent);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
        onclick(childText,convertView);
        
        return convertView;
    }
 
    private void onclick(final String childText, View convertView) {
		imageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(),"clicked",Toast.LENGTH_LONG).show();
				Intent call=new Intent(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:"+childText));
				_context.startActivity(call);	
			}
		});
	}

	@Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }
 
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }
 
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }
 
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group, null);
        }
 
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.textView_GroupHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        convertView.setPadding(20, 0,0,0);
        if (isExpanded)
            convertView.setPadding(0, 0, 0, 0);
        else
            convertView.setPadding(0, 0, 0, 20);

        return convertView;
    }

	@Override
    public boolean hasStableIds() {
        return false;
    }
 
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    
}