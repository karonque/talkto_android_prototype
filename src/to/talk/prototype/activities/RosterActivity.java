package to.talk.prototype.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import to.talk.prototype.R;

public final class RosterActivity extends Activity
{

    private ListView listView;
    private Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster_list);

        listView = (ListView) findViewById(R.id.rosterList);
        spinner = (Spinner)  getLayoutInflater().inflate(R.layout.roster_entry,null).findViewById(R.id.spinner);

        populateContactList();
        populateSpinner();

    }

    private void populateContactList()
    {
        String[] values = new String[] { "Pawan Maheshwari", "Aditya", "Kashif"};

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                R.layout.roster_entry,R.id.contactEntryText, values);
        listView.setAdapter(listAdapter);
    }

    private void populateSpinner()
    {
        String[] values = new String[] { "Busy", "Offline", "Invisible"};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,values);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(spinnerAdapter);
    }


}
