package com.example.emergencyservicebangladesh;


import java.io.IOException;

import databasepakage.Gateway;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.database.SQLException;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.ListView;

public class Launcher extends FragmentActivity implements TabListener {
	private ViewPager viewPager;
	private myTabPagerAdapter myTabAdapter;
	private ActionBar actionBar;
	Gateway aGateway;
	ListView listViewPolice;
	
	private String[] tabs = { "Police", "Fire Service", "Hospital","Search" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		initializeControls();
		registerControls();
		populateTab();
		clickEvent();
	}

	private void clickEvent() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				actionBar.setSelectedNavigationItem(pos);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void initializeControls() {
		
		viewPager=(ViewPager)findViewById(R.id.pager);
		actionBar=getActionBar();
		listViewPolice=(ListView)findViewById(R.id.listView1);
	}
	private void registerControls() {
		
		myTabAdapter=new myTabPagerAdapter(getSupportFragmentManager());
		
		viewPager.setAdapter(myTabAdapter);
		//viewPager.
		actionBar.setHomeButtonEnabled(false);
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}
	private void populateTab() {
		
		for(String tab: tabs)
		{
			actionBar.addTab(actionBar.newTab().setText(tab).setTabListener(this));
		}
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
}
