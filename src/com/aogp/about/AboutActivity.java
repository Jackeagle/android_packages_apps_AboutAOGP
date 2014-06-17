/*
 * Copyright (C) 2012 Crossbones Software
 * This code has been modified.  Portions copyright (C) 2014, AOGP Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aogp.about;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class AboutActivity extends FragmentActivity {
    public static Context appContext;
    private ViewPager mViewPager;
    private TabsAdapter mTabsAdapter;

    public static final String PREFS_NAME = "About";
    public static final String AOGP_VERSION = "aogp_version";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.pager);

        setContentView(mViewPager);
        appContext = getApplicationContext();

        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionbar.setDisplayShowHomeEnabled(false);
        mTabsAdapter = new TabsAdapter(this, mViewPager);
        mTabsAdapter.addTab(actionbar.newTab().setText(R.string.about_tab_title),AboutFragment.class, null);
        mTabsAdapter.addTab(actionbar.newTab().setText(R.string.features_tab_title),FeaturesFragment.class, null);
        mTabsAdapter.addTab(actionbar.newTab().setText(R.string.dirt_tab_title),AOGPFragment.class, null);
        mTabsAdapter.addTab(actionbar.newTab().setText(R.string.contributors_tab_title),ContributorsFragment.class, null);
        mTabsAdapter.addTab(actionbar.newTab().setText(R.string.testers_tab_title),TestersFragment.class, null);
        mTabsAdapter.addTab(actionbar.newTab().setText(R.string.social_tab_title),SocialFragment.class, null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuitem_exit:
                String AOGPVersion = Utils.getAOGPVersion();

                SharedPreferences prefs = this.getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString(AOGP_VERSION, AOGPVersion);
                prefEditor.commit();

                finish();
                return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

    public void launchGoogleplus(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.googleplus_url)));
        startActivity(intent);
    }
    public void launchGithub(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.github_url)));
        startActivity(intent);
    }
    public void launchKartik(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.kartik_url)));
        startActivity(intent);
    }
    public void launchJeremy(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.jeremy_url)));
        startActivity(intent);
    }
    public void launchAshishB(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.ashishb_url)));
        startActivity(intent);
    }
    public void launchAshishS(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.ashishs_url)));
        startActivity(intent);
    }
    public void launchRutvik(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.rutvik_url)));
        startActivity(intent);
    }
    public void launchKishan(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.kishan_url)));
        startActivity(intent);
    }
    public void launchJay(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.jay_url)));
        startActivity(intent);
    }
    public void launchJack(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.jack_url)));
        startActivity(intent);
    }
    public void launchAokp(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.aokp_url)));
        startActivity(intent);
    }
    public void launchOmni(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.omni_url)));
        startActivity(intent);
    }
    public void launchSlim(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.slim_url)));
        startActivity(intent);
    }
    public void launchChaos(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.chaos_url)));
        startActivity(intent);
    }    
    public void launchNitin(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.nitin_url)));
        startActivity(intent);
    }

    public static class TabsAdapter extends FragmentPagerAdapter
    implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    	private static final String TAG = "About AOGP";
    	private final Context mContext;
    	private final ActionBar mActionBar;
    	private final ViewPager mViewPager;
    	private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

    	static final class TabInfo {
    		private final Class<?> clss;
    		private final Bundle args;

    		TabInfo(Class<?> _class, Bundle _args) {
    			clss = _class;
    			args = _args;
    		}
    	}

    	public TabsAdapter(FragmentActivity activity, ViewPager pager) {
    		super(activity.getSupportFragmentManager());
    		mContext = activity;
    		mActionBar = activity.getActionBar();
    		mViewPager = pager;
    		mViewPager.setAdapter(this);
    		mViewPager.setOnPageChangeListener(this);
    	}

    	public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
    		TabInfo info = new TabInfo(clss, args);
    		tab.setTag(info);
    		tab.setTabListener(this);
    		mTabs.add(info);
    		mActionBar.addTab(tab);
    		notifyDataSetChanged();
    	}


    	public int getCount() {
    		return mTabs.size();
    	}

    	public Fragment getItem(int position) {
    		TabInfo info = mTabs.get(position);
    		return Fragment.instantiate(mContext, info.clss.getName(), info.args);
    	}


    	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    	}


    	public void onPageSelected(int position) {
    		mActionBar.setSelectedNavigationItem(position);
    	}


    	public void onPageScrollStateChanged(int state) {
    	}


    	public void onTabSelected(Tab tab, FragmentTransaction ft) {
    		mViewPager.setCurrentItem(tab.getPosition());
    		Log.v(TAG, "clicked");
    		Object tag = tab.getTag();
    		for (int i=0; i<mTabs.size(); i++) {
    			if (mTabs.get(i) == tag) {
    				mViewPager.setCurrentItem(i);
    			}
    		}
    	}

		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {


		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {


		}
    }
}
