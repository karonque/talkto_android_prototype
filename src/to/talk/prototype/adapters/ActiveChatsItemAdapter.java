package to.talk.prototype.adapters;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import to.talk.prototype.R;


public class ActiveChatsItemAdapter extends BaseAdapter
{
    private Activity mContext;
    private String[] mContactList = new String[] { "Vineet", "Vikram"};

    public ActiveChatsItemAdapter(Activity context)
    {
        mContext=context;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getCount()
    {
        return mContactList.length;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object getItem(int i)
    {
        return mContactList[i];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public long getItemId(int i)
    {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasStableIds()
    {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = null;

        if (convertView == null)
        {

            view = mContext. getLayoutInflater().inflate(R.layout.contacts_item, null);

            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.contactName = (TextView) view.findViewById(R.id.name);
            viewHolder.contactStatus = (TextView) view.findViewById(R.id.status);
            //viewHolder.spin = (Spinner) view.findViewById(R.id.rosterEntrySpinner);

            String[] values = new String[] { "Busy", "Offline", "Invisible"};

            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item,values);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

            //viewHolder.spin.setAdapter(spinnerAdapter);

            viewHolder.contactName.setText(mContactList[position]);
            viewHolder.contactStatus.setText("Status: " + mContactList[position]);

            view.setTag(viewHolder);


        } else
        {
            view = convertView;
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.contactName.setText(getItem(position).toString());
        return view;
    }

    public int getItemViewType(int i)
    {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getViewTypeCount()
    {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isEmpty()
    {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    static class ViewHolder
    {
        protected TextView contactName;
        protected TextView contactStatus;
        protected Spinner avatarSpinner;
    }
}

