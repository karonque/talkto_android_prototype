package to.talk.prototype.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import to.talk.prototype.R;
import to.talk.prototype.compatibility.actionbar.ActionBarActivity;
import to.talk.prototype.listeners.ActionBarTabListener;


public final class ContactsFragmentActivity extends ActionBarActivity
{
    ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        startActivity(TabsViewPagerFragmentActivity.class);
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

    private void ICSTabImplementation()
    {
        /*
        final boolean ICS = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;

        if (ICS)
        {
            actionBar = getActionBar();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.addTab(createTab("Active Chats", "activeChats", ActiveChatsFragment.class));
            actionBar.addTab(createTab("Contacts", "allContacts", AllContactsFragment.class));
        }
        else
        {

        }*/
    }

    private ActionBar.Tab createTab(String text, String tag, Class clz)
    {
        ActionBar.Tab tab = actionBar.newTab();
        tab.setText(text);
        tab.setTabListener(new ActionBarTabListener(this, tag, clz));
        return tab;
    }


}


