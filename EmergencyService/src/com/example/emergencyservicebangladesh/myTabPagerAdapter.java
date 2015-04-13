package com.example.emergencyservicebangladesh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class myTabPagerAdapter extends FragmentPagerAdapter {

	public myTabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		
		switch (index) {
		case 0:
			return new PoliceAcitivity();
		case 1:
			return new FireServiceActivity();
		case 2:
			return new HospitalActivity();
		case 3: 
			return new SearchingActivity();
		}
		return null;
	}

	@Override
	public int getCount() {
		
		return 4;
	}

}
