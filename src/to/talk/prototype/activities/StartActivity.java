package to.talk.prototype.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import to.talk.prototype.R;


public class StartActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //wait(3);
        startActivity();
    }

    private void startActivity()
    {
        Intent intent = new Intent(getApplicationContext(), ContactsActivity.class);
        startActivity(intent);
        finish();
    }

    private void wait(int seconds)
    {
        try
        {
            Thread.sleep(1000*seconds);
        }
        catch (Exception ex)
        {

        }
    }

}
