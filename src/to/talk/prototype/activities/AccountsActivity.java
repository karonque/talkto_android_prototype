package to.talk.prototype.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import to.talk.prototype.R;


public class AccountsActivity extends Activity
{
    private Spinner spinner1;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounts_item);
        addItemOnSpinner();
    }

    private void addItemOnSpinner()
    {
        //spinner1=(Spinner)findViewById(R.id.spinner1);
        //spinner1.se
    }
}
