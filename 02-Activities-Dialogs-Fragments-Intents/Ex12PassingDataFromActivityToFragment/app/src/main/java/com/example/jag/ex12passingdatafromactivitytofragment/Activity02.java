package com.example.jag.ex12passingdatafromactivitytofragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity02 extends Activity {

    String msg;
    EditText txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02);

        txtMsg = (EditText) findViewById(R.id.txtMsg);
        Button btnSetMessage = (Button) findViewById(R.id.btnSetMessage);
        btnSetMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = txtMsg.getText().toString();
            }
        });

        Button btnShowMessage = (Button) findViewById(R.id.btnShowMessage);
        btnShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity02.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnShowMessageInFragment = (Button) findViewById(R.id.btnShowMessageInFragment);
        btnShowMessageInFragment.setOnClickListener(btnShowMessageInFragmentOnClick);
    }

    private View.OnClickListener btnShowMessageInFragmentOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            Activity02Fragment01 activity02Fragment01 = (Activity02Fragment01) fm.findFragmentByTag("activity02Fragment01");

            if (activity02Fragment01 == null) //create new fragment
            {
                Log.d("Activity02Fragment01", "creating new fragment..");
                activity02Fragment01 = new Activity02Fragment01();
                Bundle argsBundle = new Bundle();
                argsBundle.putString("msg", msg);
                activity02Fragment01.setArguments(argsBundle);
                fm.beginTransaction()
                        .add(R.id.frame01, activity02Fragment01, "activity02Fragment01")
                        .commit();
            } else {
                Log.d("Activity02Fragment01", "setting message..");
                activity02Fragment01.setMessage(msg);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("msg", msg);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            msg = savedInstanceState.getString("msg");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity02, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
