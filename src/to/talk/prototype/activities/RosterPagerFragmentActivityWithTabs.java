package to.talk.prototype.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import to.talk.prototype.R;
import to.talk.prototype.adapters.PagerAdapter;
import to.talk.prototype.compatibility.actionbar.ActionBarActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class RosterPagerFragmentActivityWithTabs extends ActionBarActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, RosterPagerFragmentActivityWithTabs.TabInfo>();
    private PagerAdapter mPagerAdapter;

    private class TabInfo
    {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args)
        {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }

    }

    class TabFactory implements TabContentFactory
    {

        private final Context mContext;

        public TabFactory(Context context)
        {
            mContext = context;
        }

        public View createTabContent(String tag)
        {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_viewpager);
        this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null)
        {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
        this.initViewPager();
    }

    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("tab", mTabHost.getCurrentTabTag());
        super.onSaveInstanceState(outState);
    }

    private void initViewPager()
    {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, AllContactsFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, ActiveChatsFragment.class.getName()));
        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private void initialiseTabHost(Bundle args)
    {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        RosterPagerFragmentActivityWithTabs.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("Tab 1"), (tabInfo = new TabInfo("Contacts", AllContactsFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        RosterPagerFragmentActivityWithTabs.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("Tab 2"), (tabInfo = new TabInfo("ActiveChats", ActiveChatsFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        mTabHost.setOnTabChangedListener(this);
    }

    private static void AddTab(RosterPagerFragmentActivityWithTabs activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo)
    {
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    public void onTabChanged(String tag)
    {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    //@Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels)
    {

    }

    //@Override
    public void onPageSelected(int position)
    {
        this.mTabHost.setCurrentTab(position);
    }

    //@Override
    public void onPageScrollStateChanged(int state)
    {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_accounts:
                startActivity(AccountDetailActivity.class);
            default:
                return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_contacts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void startActivity(Class clz)
    {
        Intent intent = new Intent(getApplicationContext(), clz);
        startActivity(intent);
        finish();
    }



}
