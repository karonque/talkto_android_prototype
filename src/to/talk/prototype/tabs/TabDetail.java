package to.talk.prototype.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by IntelliJ IDEA.
 * User: pawan
 * Date: 2/15/12
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TabDetail
{
    private String tag;
    private Class<?> clss;
    private Bundle args;
    private Fragment fragment;

    public TabDetail(String tag, Class<?> clazz, Bundle args)
    {
        this.tag = tag;
        this.clss = clazz;
        this.args = args;
    }


    public String getTag()
    {
        return tag;
    }
}
