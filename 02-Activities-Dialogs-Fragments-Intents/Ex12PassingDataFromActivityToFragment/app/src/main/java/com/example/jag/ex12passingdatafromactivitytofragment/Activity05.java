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


public class Activity05 extends Activity {

    String msg;
    EditText txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity05);


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
                Toast.makeText(Activity05.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnShowMessageInFragment = (Button) findViewById(R.id.btnShowMessageInFragment);
        btnShowMessageInFragment.setOnClickListener(btnShowMessageInFragmentOnClick);
    }

    private View.OnClickListener btnShowMessageInFragmentOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            Activity05Fragment01 activity05Fragment01 = (Activity05Fragment01) fm.findFragmentByTag("activity05Fragment01");

            if (activity05Fragment01 == null) //create new fragment
            {
                Log.d("Activity05Fragment01", "creating new fragment..");
                activity05Fragment01 = new Activity05Fragment01();
                Bundle argsBundle = new Bundle();
                argsBundle.putString("msg", msg);
                activity05Fragment01.setArguments(argsBundle);
                fm.beginTransaction()
                        .add(R.id.frame01, activity05Fragment01, "activity05Fragment01")
                        .commit();
            } else {
                Log.d("Activity05Fragment01", "setting message..");
                IMsgSetData fragInterface = (IMsgSetData) activity05Fragment01;
                fragInterface.setData(msg);
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
        getMenuInflater().inflate(R.menu.menu_activity05, menu);
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
