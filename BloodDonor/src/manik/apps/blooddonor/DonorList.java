package manik.apps.blooddonor;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DonorList extends Activity {

	// List view
	private ListView lv;

	// Listview Adapter
	DonorAdapter adapter;

	// Search EditText
	EditText inputBG;
	EditText inputAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_donor_view);

		
	        
		inputBG = (EditText) findViewById(R.id.inputgroup);
		inputAddress = (EditText) findViewById(R.id.inputAddress);
		inputBG.addTextChangedListener(new TextWatcher() {
		     
		    @Override
		    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
		        // When user changed the Text
		    	//DonorList.this.adapter.getFilter().filter(cs); 
		    	try
		    	{
		    		MySQLiteHelper db=new MySQLiteHelper(DonorList.this);
		    		String bg=cs.toString();
		    		String add =inputAddress.getText().toString();
			    	List<Donor> doners=db.searchDonor(bg, add);
			    	//Donor[] array = doners.toArray(new Donor[doners.size()]);
			    	ListView lv = (ListView) findViewById(R.id.list_view);
					adapter = new DonorAdapter(
							DonorList.this, 
				        		R.layout.list_item, 
				        		doners);
				        lv.setAdapter(adapter);
		    	}catch (Exception e) {
					// TODO: handle exception
		    		AlertDialog alertDialog;
					alertDialog = new AlertDialog.Builder(DonorList.this).create();
					alertDialog.setTitle("ERROR!!!");
					alertDialog.setMessage(e.getMessage());
					alertDialog.show();
				}
		    	
		    }
		     
		    @Override
		    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
		            int arg3) {
		        // TODO Auto-generated method stub
		         
		    }
		     
		    @Override
		    public void afterTextChanged(Editable arg0) {
		        // TODO Auto-generated method stub                          
		    }
		});
		
		inputAddress.addTextChangedListener(new TextWatcher() {
		     
		    @Override
		    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
		        // When user changed the Text
		    	//DonorList.this.adapter.getFilter().filter(cs); 
		    	try
		    	{
		    		
		    		MySQLiteHelper db=new MySQLiteHelper(DonorList.this);
			    	List<Donor> doners=db.searchDonor(inputBG.getText().toString(),cs.toString());
			    	//Donor[] array = doners.toArray(new Donor[doners.size()]);
			    	ListView lv = (ListView) findViewById(R.id.list_view);
					adapter = new DonorAdapter(
							DonorList.this, 
				        		R.layout.list_item, 
				        		doners);
				        lv.setAdapter(adapter);
		    	}catch (Exception e) {
					// TODO: handle exception
				}
		    	
		    }
		     
		    @Override
		    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
		            int arg3) {
		        // TODO Auto-generated method stub
		         
		    }
		     
		    @Override
		    public void afterTextChanged(Editable arg0) {
		        // TODO Auto-generated method stub                          
		    }
		});

	}

}
