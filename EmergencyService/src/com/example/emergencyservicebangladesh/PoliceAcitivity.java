package com.example.emergencyservicebangladesh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utility.Utility;

import listviewclass.ExpandsListClass;
import listviewclass.PoliceListView;

import databasepakage.Gateway;
import entityclass.Emergency;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

public class PoliceAcitivity extends Fragment {

	private ExpandableListView expandlist;
	private ExpandableListAdapter listAdapter;
	private List<Emergency> list=new ArrayList<Emergency>();
	private Map<String,List<String>>child=new HashMap<String, List<String>>();
	private List<String>header=new ArrayList<String>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
	    View view=inflater.inflate(R.layout.expandable_list,container,false);
	    expandlist=(ExpandableListView)view.findViewById(R.id.expandableListView);
        //Suppose you have one textview in that Row
       
	    try {
			populateListAndMap();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	    listAdapter=new ExpandsListClass(view.getContext(), header, child);
	    expandlist.setAdapter(listAdapter);
		return view;
	}
	private void populateListAndMap() throws SQLException, IOException {
		// TODO Auto-generated method stub
		header=Utility.GetHeaderList(getActivity(),"police");
		child=Utility.getChildMap(getActivity(),"police");
		
	}
}
