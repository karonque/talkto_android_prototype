package to.talk.prototype.activities;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBar;
import to.talk.prototype.listeners.ActionBarTabListener;


public final class ContactsFragmentActivity extends android.support.v4.app.FragmentActivity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        AllContactsFragment allContactsFragment = new AllContactsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content,allContactsFragment)
                .commit();


        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        getSupportActionBar().addTab(getTab("ActiveChats"));
        getSupportActionBar().addTab(getTab("Contacts"));
    }

    private ActionBar.Tab getTab(String text)
    {
        ActionBar.Tab tab = getSupportActionBar().newTab();//actionBar.newTab();
        tab.setText(text);
        tab.setTabListener(new ActionBarTabListener(this));
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


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater =  getMenuInflater() ;
        menuInflater.inflate(R.menu.action_bar_contacts, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

}


