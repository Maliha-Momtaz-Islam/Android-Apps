package manik.apps.blooddonor;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddDonorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_doner_view);
		
		Button btnSave = (Button) findViewById(R.id.btnSaveDonor);	
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				try {
					EditText txtName=(EditText)findViewById(R.id.txtName);
					Spinner spinBG=(Spinner)findViewById(R.id.spinGroup);
					EditText txtmobile=(EditText)findViewById(R.id.txtMobileNo);
					
					EditText txtAddress=(EditText)findViewById(R.id.txtAutoAddress);
					EditText txtbirthdate=(EditText)findViewById(R.id.txtBirthDate);
					EditText txtlastdonate=(EditText)findViewById(R.id.txtLastDonate);
					EditText txtIdentity=(EditText)findViewById(R.id.txtIdentity);
					Donor donor =new Donor();
					donor.DonorName=txtName.getText().toString();
					donor.MobileNumber=txtmobile.getText().toString();
					donor.BloodGroup=spinBG.getSelectedItem().toString();
					donor.Identity=txtIdentity.getText().toString();
					donor.Address=txtAddress.getText().toString();
					donor.LastDonate=txtlastdonate.getText().toString();
					donor.BirthDate=txtbirthdate.getText().toString();
					
					if(donor.DonorName.length()<=0)
					{
						AlertDialog alertDialog;
						alertDialog = new AlertDialog.Builder(AddDonorActivity.this).create();
						alertDialog.setTitle("Warning!!!");
						alertDialog.setMessage("Input the Name.");
						alertDialog.show();
						return;
					}
					
					
					MySQLiteHelper db=new MySQLiteHelper(AddDonorActivity.this);
					db.addDonor(donor);
					AlertDialog alertDialog;
					alertDialog = new AlertDialog.Builder(AddDonorActivity.this).create();
					alertDialog.setTitle("SUCCESS!!!");
					alertDialog.setMessage("Saved Successfully.");
					alertDialog.show();
					
					txtName.setText("");
					txtmobile.setText("");
					txtAddress.setText("");
					txtbirthdate.setText("");
					txtlastdonate.setText("");
					txtIdentity.setText("");
					
				} catch (Exception e) {
					AlertDialog alertDialog;
					alertDialog = new AlertDialog.Builder(AddDonorActivity.this).create();
					alertDialog.setTitle("ERROR!!!");
					alertDialog.setMessage(e.getMessage());
					alertDialog.show();
				}
				
			}
		});
	}

}
