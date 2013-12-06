package com.example.fragments.sidedrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.fragments.sidedrawer.R;

/**
 * vinay Sep 25, 2013, 3:38:25 PM Fragments Side Menu Drawer ActionBarSherlock
 */

public class Fragment2 extends SherlockFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment2, container, false);
		return rootView;
	}

}
