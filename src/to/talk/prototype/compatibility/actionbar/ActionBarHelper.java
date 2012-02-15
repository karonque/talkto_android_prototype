package to.talk.prototype.compatibility.actionbar;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public abstract class ActionBarHelper
{
    protected Activity mActivity;

    public static ActionBarHelper createInstance(Activity activity)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        {
            return new ActionBarHelperICS(activity);
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            return new ActionBarHelperHoneycomb(activity);
        }
        else
        {
            return new ActionBarHelperBase(activity);
        }
    }

    protected ActionBarHelper(Activity activity)
    {
        mActivity = activity;
    }

    public void onCreate(Bundle savedInstanceState)
    {
    }

    public void onPostCreate(Bundle savedInstanceState)
    {
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onTitleChanged(CharSequence title, int color)
    {
    }

    public abstract void setRefreshActionItemState(boolean refreshing);

    public MenuInflater getMenuInflater(MenuInflater superMenuInflater)
    {
        return superMenuInflater;
    }
}
