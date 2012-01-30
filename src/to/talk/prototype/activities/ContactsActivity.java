package to.talk.prototype.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import to.talk.prototype.R;


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
                .setTabListener(new MTabListener<ActiveChatsFragment>(
                        this, "activeChats", ActiveChatsFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Contacts")
                .setTabListener(new MTabListener<AllContactsFragment>(
                        this, "allContacts", AllContactsFragment.class));
        actionBar.addTab(tab);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle item selection
        switch (item.getItemId())
        {
            case R.id.menu_accounts:
                startAccountActivity();
                return true;
            default:
                return false;

        }
    }

    private void startAccountActivity()
    {
        Intent intent = new Intent(getApplicationContext(), AccountDetailActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private class ActionBarClickListener implements View.OnClickListener
    {

        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.menu_accounts:
                      startAccountActivity();
                return;
            }
        }

        private void startAccountActivity()
        {
            Intent intent = new Intent(getApplicationContext(), ContactsActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private class MTabListener<T extends Fragment> implements ActionBar.TabListener
    {
        private Fragment mFragment;
        private final Activity mActivity;
        private final String mTag;
        private final Class<T> mClass;

        public MTabListener(Activity activity, String tag, Class<T> clz)
        {
            mActivity = activity;
            mTag = tag;
            mClass = clz;
        }


        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
        {
            if (mFragment == null)
            {
                mFragment = Fragment.instantiate(mActivity, mClass.getName());
                ft.add(android.R.id.content, mFragment, mTag);
            } else
            {
                ft.attach(mFragment);
            }
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
        {
            if (mFragment != null)
            {
                ft.detach(mFragment);
            }
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
        {
        }
    }


}


