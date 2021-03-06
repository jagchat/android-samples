package com.example.jag.ex08navigatingupbetweenactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;


public class Activity03 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity03);

        getActionBar().setDisplayHomeAsUpEnabled(true); //Up navigation

        Button btnShowActivity2 = (Button) findViewById(R.id.btnShowActivity2);
        btnShowActivity2.setOnClickListener(btnShowActivity2ClickListener);
    }

    protected View.OnClickListener btnShowActivity2ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activity02Intent = new Intent(Activity03.this, Activity02.class);
            startActivity(activity02Intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity03, menu);
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

        if (id == android.R.id.home) {//Up navigation
            //NavUtils.navigateUpFromSameTask(this); //no state will be restored (replaces with new)

            //to restore state
            Intent intent = NavUtils.getParentActivityIntent(this);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            NavUtils.navigateUpTo(this, intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
