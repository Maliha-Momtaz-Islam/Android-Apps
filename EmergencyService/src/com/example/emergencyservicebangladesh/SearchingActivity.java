package com.example.emergencyservicebangladesh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utility.Utility;

import databasepakage.Gateway;
import entityclass.Emergency;

import listviewclass.AutoCompleteList;
import listviewclass.foundListAdapter;

import android.app.Dialog;
import android.content.Entity;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SearchingActivity extends Fragment {
	ImageButton searchButton;
	AutoCompleteTextView editText;
	TextView textview;
	ListView list;
	Gateway aGatewy;
	String searchString;
	ArrayList<Emergency>autoList=new ArrayList<Emergency>();
	ArrayList<Emergency> foundList = new ArrayList<Emergency>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		aGatewy = new Gateway(getActivity());
		View view = inflater.inflate(R.layout.searchactivity, container, false);
		searchButton = (ImageButton) view.findViewById(R.id.search);
		editText = (AutoCompleteTextView) view.findViewById(R.id.autocomplete);
		/*try {
		//	populateAutoComplete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		textview = (TextView) view.findViewById(R.id.textView1);
		list = (ListView) view.findViewById(R.id.listViewSearch);
		onclick(view);
		return view;
	}

	private void populateAutoComplete() throws SQLException, IOException {
		
		autoList=aGatewy.getAutoCompleteList("d");
		ArrayList<String>temp=new ArrayList<String>();
		Log.i("auto",autoList.size()+"");
		ArrayAdapter<Emergency>auto=new ArrayAdapter<Emergency>(getActivity(),android.R.layout.simple_dropdown_item_1line,autoList);
		editText.setThreshold(1);
		editText.setAdapter(auto);
		
	}

	private void onclick(final View view) {
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				list.setAdapter(null);
				searchString = editText.getText().toString();
				try {
					//foundList.clear();
					populateList(view);
					list.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View view,
								final int position, long id) {
							final Dialog dialog = new Dialog(getActivity());
							dialog.setContentView(R.layout.custom);
							dialog.setTitle("Call");
							TextView t1 = (TextView) dialog
									.findViewById(R.id.textViewAddress);
							t1.setText(foundList.get(position).getAddress());
							Spinner spinner = (Spinner) dialog
									.findViewById(R.id.spinner1);
							ArrayAdapter<String> adapter = new ArrayAdapter<String>(
									getActivity(),
									android.R.layout.simple_list_item_1,
									Utility.getNumbers(foundList.get(position)
											.getPhone()));
							spinner.setAdapter(adapter);
							ImageButton call = (ImageButton) dialog
									.findViewById(R.id.imageButtonCall);
							ImageButton dissmiss=(ImageButton)dialog.findViewById(R.id.imageButtonCrossButton);
							
							onclickImageButton(spinner, call, getActivity());
							ImageButton map=(ImageButton)dialog.findViewById(R.id.imageButtonMap);
							map.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									Intent intent=new Intent(getActivity(),EmergencyMapActivity.class);
									try {
										Gateway gate=new Gateway(getActivity());
										double latitude=gate.getLatitude(foundList.get(position).getName());
										double longitude=gate.getLongitude(foundList.get(position).getName());
										intent.putExtra("latitude",latitude);
										intent.putExtra("longitude",longitude);
										getActivity().startActivity(intent);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									
								}
							});
							dialog.show();
							
							dissmiss.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									dialog.dismiss();
									
								}
							});
						}
						private void onclickImageButton(final Spinner spinner,
								ImageButton call,
								final FragmentActivity fragmentActivity) {

							call.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									Intent call = new Intent(Intent.ACTION_CALL);
									call.setData(Uri.parse("tel:"
											+ spinner.getSelectedItem()
													.toString()));
									fragmentActivity.startActivity(call);

								}
							});
						}
					});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			private void populateList(View view) throws SQLException,
					IOException {
				foundList = aGatewy.getSearchedEntity(searchString);
			Toast toast=Utility.getToast(foundList,getActivity());
			toast.show();
			ArrayAdapter<Emergency> adapter = new foundListAdapter(view
					.getContext(), R.id.listViewSearch, foundList);
			list.setAdapter(adapter);
			}
		});
	}

}
