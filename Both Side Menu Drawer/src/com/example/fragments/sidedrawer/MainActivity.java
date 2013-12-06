package com.example.fragments.sidedrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;


public class MainActivity extends SherlockFragmentActivity{
	 // Declare Variables
    DrawerLayout mDrawerLayout;
    ListView mLeftDrawer, mRightDrawer;
    ActionBarDrawerToggle mDrawerToggle;
    MenuListAdapter mMenuAdapter;
    String[] title;
    String[] subtitle;
    int[] icon;
    Fragment fragment1 = new Fragment1();
    Fragment fragment2 = new Fragment2();
    Fragment fragment3 = new Fragment3();
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	        // Get the view from drawer_main.xml
	        setContentView(R.layout.activity_main);
	 
	        mTitle = mDrawerTitle = getTitle();
	        title = new String[] { "Title Fragment 1", "Title Fragment 2", "Title Fragment 3" };
	        subtitle = new String[] { "Subtitle Fragment 1", "Subtitle Fragment 2", "Subtitle Fragment 3" };
	        icon = new int[] { R.drawable.abs__ab_solid_light_holo, R.drawable.abs__ab_solid_light_holo, R.drawable.abs__ab_solid_light_holo };
	       
	        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	        mLeftDrawer = (ListView) findViewById(R.id.left_drawer);
	        mRightDrawer = (ListView) findViewById(R.id.right_drawer);
	        // Set a custom shadow that overlays the main content when the drawer opens
	        //mDrawerLayout.setDrawerShadow(R.drawable.ic_launcher, GravityCompat.START);
	 
	        mMenuAdapter = new MenuListAdapter(MainActivity.this, title, subtitle, icon);
	        
	        mLeftDrawer.setAdapter(mMenuAdapter);
	        mRightDrawer.setAdapter(mMenuAdapter);
	 
	        mLeftDrawer.setOnItemClickListener(new DrawerItemClickListener());
	        mRightDrawer.setOnItemClickListener(new DrawerItemClickListener());
	 
	        // Enable ActionBar app icon to behave as action to toggle nav drawer
	        getSupportActionBar().setHomeButtonEnabled(true);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	        //getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	 
	        // ActionBarDrawerToggle ties together the the proper interactions
	        // between the sliding drawer and the action bar app icon
	        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
	                R.drawable.abs__ab_solid_light_holo, R.string.drawer_open,
	                R.string.drawer_close) {
	 
	            public void onDrawerClosed(View view) {
	                super.onDrawerClosed(view);
	            }
	 
	            public void onDrawerOpened(View drawerView) {
	                getSupportActionBar().setTitle(mDrawerTitle);
	                super.onDrawerOpened(drawerView);
	            }
	        };
	 
	        mDrawerLayout.setDrawerListener(mDrawerToggle);
	 
	        if (savedInstanceState == null) {
	            selectItem(0);
	        }
	    }
	 
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	 
	        if (item.getItemId() == android.R.id.home) {
	 
	            if (mDrawerLayout.isDrawerOpen(mLeftDrawer)) {
	                mDrawerLayout.closeDrawer(mLeftDrawer);
	                
	            } else {
	                mDrawerLayout.openDrawer(mLeftDrawer);
	            }
	        }
	 
	        return super.onOptionsItemSelected(item);
	    }
	 
	    // ListView click listener in the navigation drawer
	    private class DrawerItemClickListener implements ListView.OnItemClickListener {
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            selectItem(position);
	        }
	    }
	 
	    private void selectItem(int position) {
	 
	        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	        // Locate Position
	        switch (position) {
	        case 0:
	            ft.replace(R.id.content_frame, fragment1);
	            break;
	        case 1:
	            ft.replace(R.id.content_frame, fragment2);
	            break;
	        case 2:
	            ft.replace(R.id.content_frame, fragment3);
	            break;
	        }
	        ft.commit();
	        mLeftDrawer.setItemChecked(position, true);
	 
	        // Get the title followed by the position
	        setTitle(title[position]);
	        // Close drawer
	        mDrawerLayout.closeDrawer(mLeftDrawer);
	    }
	 
	    @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mDrawerToggle.syncState();
	    }
	 
	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        // Pass any configuration change to the drawer toggles
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }
	 
	    @Override
	    public void setTitle(CharSequence title) {
	        mTitle = title;
	        getSupportActionBar().setTitle(mTitle);
	    }
	}