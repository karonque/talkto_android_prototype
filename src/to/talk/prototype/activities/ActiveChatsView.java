package to.talk.prototype.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import to.talk.prototype.R;
import to.talk.prototype.adapters.ActiveChatsAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: pawan
 * Date: 1/26/12
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActiveChatsView extends Fragment
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

        view =  inflater.inflate(R.layout.active_chats_list, container, false);

        listView = (ListView) view.findViewById(R.id.activeChatsList);

        ActiveChatsAdapter itemAdapter = new ActiveChatsAdapter(this.getActivity());

        listView.setAdapter(itemAdapter);

        return view;
    }

}
