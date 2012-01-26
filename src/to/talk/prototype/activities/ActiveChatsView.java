package to.talk.prototype.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import to.talk.prototype.R;

/**
 * Created by IntelliJ IDEA.
 * User: pawan
 * Date: 1/26/12
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActiveChatsView extends Fragment
{

    private ListView listView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.contacts_fragment, container, false);
    }
}