package com.example.jag.ex12passingdatafromactivitytofragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowUsingActivityMethod = (Button) findViewById(R.id.btnShowUsingActivityMethod);
        btnShowUsingActivityMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity01 = new Intent(MainActivity.this, Activity01.class);
                startActivity(Activity01);
            }
        });

        Button btnShowDuringLoad = (Button) findViewById(R.id.btnShowDuringLoad);
        btnShowDuringLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity02 = new Intent(MainActivity.this, Activity02.class);
                startActivity(Activity02);
            }
        });

        Button btnShowUsingActivityIntent = (Button) findViewById(R.id.btnShowUsingActivityIntent);
        btnShowUsingActivityIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity03 = new Intent(MainActivity.this, Activity03.class);
                startActivity(Activity03);
            }
        });

        Button btnShowUsingActivityInterface = (Button) findViewById(R.id.btnShowUsingActivityInterface);
        btnShowUsingActivityInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity04 = new Intent(MainActivity.this, Activity04.class);
                startActivity(Activity04);
            }
        });

        Button btnShowUsingFragInterface = (Button) findViewById(R.id.btnShowUsingFragInterface);
        btnShowUsingFragInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity05 = new Intent(MainActivity.this, Activity05.class);
                startActivity(Activity05);
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
