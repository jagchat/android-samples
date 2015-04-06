package com.example.jag.ex13passingdatafromfragmenttoactivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Activity01 extends Activity
        implements Activity01Fragment01.OnFragmentInteractionListener {

    String msg;
    TextView lblMsg;

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
            refreshLabel();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity01);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.frame01, new Activity01Fragment01())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity01, menu);
        return true;
    }

    private void refreshLabel() {
        lblMsg = (TextView) findViewById(R.id.lblMsg);
        lblMsg.setText(msg);
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

    @Override
    public void onFragmentInteraction(String msg) {
        this.msg = msg;
        refreshLabel();
    }
}
