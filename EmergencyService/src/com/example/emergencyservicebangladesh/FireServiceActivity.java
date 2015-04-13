package com.example.emergencyservicebangladesh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entityclass.Emergency;

import utility.Utility;

import listviewclass.ExpandsListClass;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;

public class FireServiceActivity extends Fragment {
	private ExpandableListView expandlist;
	private ExpandableListAdapter listAdapter;
	private ImageButton imagebutton;
	private List<Emergency> list = new ArrayList<Emergency>();
	private Map<String, List<String>> child = new HashMap<String, List<String>>();
	private List<String> header = new ArrayList<String>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.expandable_list, container, false);
		expandlist = (ExpandableListView) view
				.findViewById(R.id.expandableListView);
		try {
			populateListAndMap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listAdapter = new ExpandsListClass(view.getContext(), header, child);
		expandlist.setAdapter(listAdapter);
		//onlclick();
		return view;
	}

	private void onlclick() {
		expandlist.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Toast.makeText(v.getContext(),"childclicked",Toast.LENGTH_LONG).show();
				return false;
			}
		});

	}

	private void populateListAndMap() throws SQLException, IOException {
		// TODO Auto-generated method stub
		header = Utility.GetHeaderList(getActivity(), "fire");
		child = Utility.getChildMap(getActivity(), "fire");
		// Log.i("map",child.get("Gulshan Thana").get(0));
	}

}
