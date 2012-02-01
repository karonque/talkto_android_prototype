package to.talk.prototype.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.AccountItemAdapter;

public final class
        AccountDetailActivity extends Activity
{

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list);

        AccountItemAdapter itemAdapter = new AccountItemAdapter(this);

        listView = (ListView) findViewById(R.id.accountList);
        listView.setAdapter(itemAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_contacts:
                startActivity(ContactsFragmentActivity.class);
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
        menuInflater.inflate(R.menu.action_bar_accounts, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
