package to.talk.prototype.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.AllContactsItemAdapter;
import to.talk.prototype.adapters.SeparatedListAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: pawan
 * Date: 1/26/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllContactsFragment extends Fragment
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

        view =  inflater.inflate(R.layout.all_contacts_view, container, false);

        listView = (ListView) view.findViewById(R.id.allContactsList);

        SeparatedListAdapter itemAdapter = new SeparatedListAdapter(this.getActivity());

        itemAdapter.addSection("Favourite Contacts", new AllContactsItemAdapter(this.getActivity()));

        itemAdapter.addSection("All Contacts", new AllContactsItemAdapter(this.getActivity()));




        listView.setAdapter(itemAdapter);

        return view;
    }

}
