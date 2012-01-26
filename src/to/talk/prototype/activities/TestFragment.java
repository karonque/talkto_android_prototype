package to.talk.prototype.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import to.talk.prototype.R;

/**
 * Created by IntelliJ IDEA.
 * User: pawan
 * Date: 1/26/12
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestFragment  extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.roster_tab, container, false);
    }
}
