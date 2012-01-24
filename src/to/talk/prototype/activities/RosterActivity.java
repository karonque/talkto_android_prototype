package to.talk.prototype.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.RosterEntryAdapter;

public final class RosterActivity extends Activity
{

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster_list);

        listView = (ListView) findViewById(R.id.rosterList);

        RosterEntryAdapter rosterEntryAdapter = new RosterEntryAdapter(this);

        listView.setAdapter(rosterEntryAdapter);


    }
}
