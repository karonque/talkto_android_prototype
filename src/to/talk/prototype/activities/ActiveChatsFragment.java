package to.talk.prototype.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.ActiveChatsAdapter;
import to.talk.prototype.adapters.FavouriteContactsAdapter;
import to.talk.prototype.adapters.SeparatedListAdapter;

public class ActiveChatsFragment extends Fragment
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

        view =  inflater.inflate(R.layout.active_chats_view, container, false);

        listView = (ListView) view.findViewById(R.id.activeChatsList);

        SeparatedListAdapter itemAdapter = new SeparatedListAdapter(this.getActivity());
        itemAdapter.addSection("Active Chats", new ActiveChatsAdapter(this.getActivity()));
        itemAdapter.addSection("Recent List", new FavouriteContactsAdapter(this.getActivity()));

        listView.setAdapter(itemAdapter);

        return view;
    }

}
