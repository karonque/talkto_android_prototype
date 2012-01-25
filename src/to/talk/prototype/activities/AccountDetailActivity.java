package to.talk.prototype.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.AccountItemAdapter;

public final class AccountDetailActivity extends Activity
{

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list);

        listView = (ListView) findViewById(R.id.accountList);

        AccountItemAdapter itemAdapter = new AccountItemAdapter(this);

        listView.setAdapter(itemAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }
}
