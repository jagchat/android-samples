package com.example.jag.ex06dynamicfragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) //first time
        {
            // get fragment manager/transaction
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            //add fragment 01
            Fragment fragment01 = new Fragment01();
            ft.add(R.id.frame1, fragment01, "fragment01");

            //add fragment 02 (if landscape)
            FrameLayout frame2 = (FrameLayout) findViewById(R.id.frame2);
            if (getResources().getBoolean(R.bool.landscape) == true) {
                Fragment fragment02 = new Fragment02();
                ft.add(R.id.frame2, fragment02, "fragment02");
                frame2.setVisibility(View.VISIBLE);
            } else {
                frame2.setVisibility(View.GONE);
            }

            //commit transaction
            ft.commit();

        } else {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            FrameLayout frame2 = (FrameLayout) findViewById(R.id.frame2);
            if (getResources().getBoolean(R.bool.landscape) == true) {
                Fragment fragment02 = fm.findFragmentByTag("fragment02");
                if (fragment02 == null) {
                    fragment02 = new Fragment02();
                    ft.replace(R.id.frame2, fragment02, "fragment02");
                }
                frame2.setVisibility(View.VISIBLE);
            } else {
                frame2.setVisibility(View.GONE);
            }
            ft.commit();

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
