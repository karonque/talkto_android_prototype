package to.talk.prototype.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import to.talk.prototype.R;

public final class RosterActivity extends Activity
{

    private ListView mContactList;
    private Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster_list);
        //spinner = (Spinner) findViewById(R.id.spinner);


        mContactList = (ListView) findViewById(R.id.rosterList);

        populateContactList();
        populateSpinner();

    }

    private void populateContactList()
    {
        String[] values = new String[] { "Pawan Maheshwari", "Aditya", "Kashif"};

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                R.layout.roster_entry,R.id.contactEntryText, values);
        mContactList.setAdapter(listAdapter);
    }

    private void populateSpinner()
    {
        Spinner spinner = new Spinner(this);
        String[] values = new String[] { "Busy", "Offline", "Invisible"};
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, R.id.spinner  ,values);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinAdapter);
    }


}
