package to.talk.prototype.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.RosterItemAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: pawan
 * Date: 1/26/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RosterContactActivity extends Activity
{

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster_list);

        listView = (ListView) findViewById(R.id.rosterList);

        RosterItemAdapter itemAdapter = new RosterItemAdapter(this);

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
