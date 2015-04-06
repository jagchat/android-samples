package com.example.jag.ex10activityretainstate;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    String msg;

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "MA-OnRestart..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "MA-OnDestroy..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "MA-OnStop..");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        msg = savedInstanceState.getString("Msg");
        Log.d("MainActivity", "MA-onRestoreInstanceState..");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Msg", msg);
        Log.d("MainActivity", "MA-onSaveInstanceState..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "MA-OnPause..");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "MA-OnResume..");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "MA-OnStart..");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("MainActivity", "MA-onPostCreate..");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("MainActivity", "MA-onPostResume..");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d("MainActivity", "MA-onAttachFragment..");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("MainActivity", "MA-onConfigurationChanged..");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("MainActivity", "MA-onWindowFocusChanged..");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("MainActivity", "MA-onAttachedToWindow..");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("MainActivity", "MA-onDetachedFromWindow..");
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
        Log.d("MainActivity", "MA-onWindowAttributesChanged..");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d("MainActivity", "MA-onContentChanged..");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "MA-OnCreate..");
        Button btnShowMsg = (Button) findViewById(R.id.btnShowMsg);
        btnShowMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage1 = (Button) findViewById(R.id.btnSetMessage1);
        btnSetMessage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Hi, this is message 1";
                Toast.makeText(MainActivity.this, "Message 1 set", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage2 = (Button) findViewById(R.id.btnSetMessage2);
        btnSetMessage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Hello, this is message 2";
                Toast.makeText(MainActivity.this, "Message 2 set", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage3 = (Button) findViewById(R.id.btnSetMessage3);
        btnSetMessage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Guys, this is message 3";
                Toast.makeText(MainActivity.this, "Message 3 set", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnShowActivity02 = (Button) findViewById(R.id.btnShowActivity02);
        btnShowActivity02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity02Intent = new Intent(MainActivity.this, Activity02.class);
                startActivity(activity02Intent);
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
