package to.talk.prototype.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.Menu;
import android.view.MenuInflater;
import to.talk.prototype.R;
import to.talk.prototype.listeners.ActionBarTabListenerICS;


public final class ContactsFragmentActivity extends FragmentActivity implements ActionBar.TabListener
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final boolean IS_ICS = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
        if(IS_ICS)
        {
            setupICS();
        }
        else
        {
            setupHoneycomb();
        }
    }

    private void setupHoneycomb()
    {
        AllContactsFragment allContactsFragment = new AllContactsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, allContactsFragment)
                .commit();


        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        getSupportActionBar().addTab(getTab("ActiveChats"));
        getSupportActionBar().addTab(getTab("Contacts"));
    }


    private void setupICS()
    {
        android.app.ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        android.app.ActionBar.Tab tab = actionBar.newTab()
                .setText("Active Chats")
                .setTabListener(new ActionBarTabListenerICS(this, "activeChats", ActiveChatsFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Contacts")
                .setTabListener(new ActionBarTabListenerICS(this, "allContacts", AllContactsFragment.class));
        actionBar.addTab(tab);
    }
    private ActionBar.Tab getTab(String text)
    {
        ActionBar.Tab tab = getSupportActionBar().newTab();//actionBar.newTab();
        tab.setText(text);
        tab.setTabListener(this);
        return tab;
    }


   /* @Override
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
*/
    private void startActivity(Class clz)
    {
        Intent intent = new Intent(getApplicationContext(), clz);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater =  getMenuInflater() ;
        menuInflater.inflate(R.menu.action_bar_contacts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
    {
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
    {
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
    {
    }
}


