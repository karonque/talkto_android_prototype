package to.talk.prototype.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import to.talk.prototype.R;
import to.talk.prototype.listeners.ActionBarTabListener;


public final class ContactsActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab tab = actionBar.newTab()
                .setText("Active Chats")
                .setTabListener(new ActionBarTabListener(
                        this, "activeChats", ActiveChatsFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Contacts")
                .setTabListener(new ActionBarTabListener(
                        this, "allContacts", AllContactsFragment.class));
        actionBar.addTab(tab);

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

}


