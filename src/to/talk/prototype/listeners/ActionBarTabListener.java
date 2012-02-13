package to.talk.prototype.listeners;

import android.app.Activity;
import android.support.v4.app.ActionBar;
import android.support.v4.app.Fragment;

public class ActionBarTabListener  implements ActionBar.TabListener
{
    private Fragment mFragment;
    private final Activity mActivity;

    public ActionBarTabListener(Activity activity)
    {
        mActivity = activity;
    }

   /* public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
    {
        if (mFragment == null)
        {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(android.R.id.content, mFragment, mTag);
        } else
        {
            ft.attach(mFragment);
        }
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
    {
        if (mFragment != null)
        {
            ft.detach(mFragment);
        }
    }
*/
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft)
    {
    }

    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft)
    {
    }

    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft)
    {

    }
}


