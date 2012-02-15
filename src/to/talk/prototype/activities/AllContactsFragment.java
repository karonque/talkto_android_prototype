package to.talk.prototype.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.AllContactsAdapter;
import to.talk.prototype.adapters.FavouriteContactsAdapter;
import to.talk.prototype.adapters.SeparatedListAdapter;


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

        view =  inflater.inflate(R.layout.contacts_list, container, false);
        listView = (ListView) view.findViewById(R.id.contactsList);


        SeparatedListAdapter itemAdapter = new SeparatedListAdapter(this.getActivity());
        itemAdapter.addSection("Favourites", new FavouriteContactsAdapter(this.getActivity()));
        itemAdapter.addSection("All Online", new AllContactsAdapter(this.getActivity()));

        listView.setAdapter(itemAdapter);

        return view;
    }

}
