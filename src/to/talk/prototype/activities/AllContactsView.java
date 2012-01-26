package to.talk.prototype.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class AllContactsView extends Fragment
{

    View view;
    private ListView listView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(container == null)
        {
            return null;
        }

        if(view !=null)
        {
            return view;
        }

        view =  inflater.inflate(R.layout.all_contacts_list, container, false);

        listView = (ListView) view.findViewById(R.id.allContactsList);

        RosterItemAdapter itemAdapter = new RosterItemAdapter(this.getActivity());

        listView.setAdapter(itemAdapter);

        return view;
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_fragment);

        listView = (ListView) findViewById(R.id.rosterList);

        RosterItemAdapter itemAdapter = new RosterItemAdapter(this);

        listView.setAdapter(itemAdapter);


    }
*/
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }*/
}
