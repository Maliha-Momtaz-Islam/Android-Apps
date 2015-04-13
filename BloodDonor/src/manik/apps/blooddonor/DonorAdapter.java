package manik.apps.blooddonor;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DonorAdapter  extends ArrayAdapter<Donor>{
	private Activity _context = null;
	private List<Donor> _objects = null;
 
	/*
	 * Constructor
	 */
	public DonorAdapter(Activity context, int textViewResourceId, List<Donor> objects) {
		super(context, textViewResourceId, objects);
 
		this._context = context;
		this._objects = objects;
	}
 
	/*
	 * Get a View that displays the data at the specified position in the data set.
	 * (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
 
		// ListView item
		View view = null;
 
		// ListView item has a complex structure
		final ListViewItemHolder listViewItemHolder = new ListViewItemHolder();
 
		LayoutInflater inflator = _context.getLayoutInflater();
 
		view = inflator.inflate(R.layout.list_item2, null);
		listViewItemHolder._textBD = (TextView) view.findViewById(R.id.lblBirthDate);
		listViewItemHolder._textAddress = (TextView) view.findViewById(R.id.lblAddress);
		listViewItemHolder._textBG = (TextView) view.findViewById(R.id.lblBG);
		listViewItemHolder._textId = (TextView) view.findViewById(R.id.lblIdentity);
		listViewItemHolder._textLD = (TextView) view.findViewById(R.id.lblLD);
		listViewItemHolder._textMobile = (TextView) view.findViewById(R.id.lblMobile);
		listViewItemHolder._textName = (TextView) view.findViewById(R.id.lblName);
 
		
		listViewItemHolder._textBD.setText("BirthDate: " + _objects.get(position).BirthDate);
		listViewItemHolder._textAddress.setText("Address: "+ _objects.get(position).Address);
		listViewItemHolder._textBG.setText(_objects.get(position).BloodGroup);
		listViewItemHolder._textId.setText("ID: "+ _objects.get(position).Identity);
		listViewItemHolder._textLD.setText("Last Donate: "+ _objects.get(position).LastDonate);
		listViewItemHolder._textMobile.setText("Mobile: "+ _objects.get(position).MobileNumber);
		listViewItemHolder._textName.setText(_objects.get(position).DonorName);
 
		view.setTag(listViewItemHolder); 
 
		return view;
	}
 
	static class ListViewItemHolder {
		protected TextView _textName = null;
		protected TextView _textBG = null;
		protected TextView _textMobile = null;
		protected TextView _textAddress = null;
		protected TextView _textBD = null;
		protected TextView _textId = null;
		protected TextView _textLD = null;
	}
}
