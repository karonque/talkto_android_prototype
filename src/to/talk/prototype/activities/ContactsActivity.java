package to.talk.prototype.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import to.talk.prototype.R;
import to.talk.prototype.adapters.PagerAdapter;
import to.talk.prototype.compatibility.actionbar.ActionBarActivity;
import to.talk.prototype.tabs.TabDetail;
import to.talk.prototype.tabs.TabFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ContactsActivity extends ActionBarActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabDetail> mapTabInfo = new HashMap<String, TabDetail>();
    private PagerAdapter mPagerAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_tabs_viewpager);
        this.initTabHost(savedInstanceState);
        if (savedInstanceState != null)
        {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("currentTab"));
        }
        this.initViewPager();
    }

    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("currentTab", mTabHost.getCurrentTabTag());
        super.onSaveInstanceState(outState);
    }

    private void initViewPager()
    {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, AllContactsFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, ActiveChatsFragment.class.getName()));
        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private void initTabHost(Bundle args)
    {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        TabDetail contactsTabDetail = new TabDetail("Contacts", AllContactsFragment.class, args);
        TabDetail activeChatsDetail = new TabDetail("ActiveChats", ActiveChatsFragment.class, args);

        ContactsActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("activeChats").setIndicator("Active Chats"), contactsTabDetail);
        this.mapTabInfo.put(contactsTabDetail.getTag(), contactsTabDetail);

        ContactsActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("allContacts").setIndicator("All Contacts"), activeChatsDetail);
        this.mapTabInfo.put(activeChatsDetail.getTag(), activeChatsDetail);

        mTabHost.setOnTabChangedListener(this);
    }

    private static void AddTab(ContactsActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabDetail tabInfo)
    {
        tabSpec.setContent(new TabFactory(activity));
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
