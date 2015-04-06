package com.example.jag.ex09multipleactivitiesanddynamicfragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) { //first time when app opens

            //Start Fragment Transaction
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            //Fragment 01
            Fragment fragment01 = new Fragment01();
            ft.add(R.id.frame01, fragment01, "fragment01");

            //Fragment 02
            FrameLayout frame02 = (FrameLayout) findViewById(R.id.frame02);
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                Fragment fragment02 = new Fragment02();
                ft.add(R.id.frame02, fragment02, "fragment02");
                frame02.setVisibility(View.VISIBLE);
            } else {
                frame02.setVisibility(View.GONE);
            }

            //Commit Fragment Transaction
            ft.commit();
        } else {
            //Start Fragment Transaction
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            //Fragment 02
            Fragment fragment02 = fm.findFragmentByTag("fragment02");
            FrameLayout frame02 = (FrameLayout) findViewById(R.id.frame02);
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (fragment02 == null) {
                    fragment02 = new Fragment02();
                    ft.replace(R.id.frame02, fragment02, "fragment02");
                }
                frame02.setVisibility(View.VISIBLE);
            } else {
                frame02.setVisibility(View.GONE);
            }

            //Commit Fragment Transaction
            ft.commit();
        }

        Button btnShowActivity02 = (Button) findViewById(R.id.btnShowActivity02);
        btnShowActivity02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActivity02 = new Intent(MainActivity.this, Activity02.class);
                startActivity(intentActivity02);
            }
        });

        Button btnShowActivityWithRuntimeFragmentReplacing = (Button) findViewById(R.id.btnShowActivityWithRuntimeFragmentReplacing);
        btnShowActivityWithRuntimeFragmentReplacing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActivityWithRuntimeFragmentReplacing = new Intent(MainActivity.this, ActivityWithRuntimeFragmentReplacing.class);
                startActivity(intentActivityWithRuntimeFragmentReplacing);
            }
        });
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
