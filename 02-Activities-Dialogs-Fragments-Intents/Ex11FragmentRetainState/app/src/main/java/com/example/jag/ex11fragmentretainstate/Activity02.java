package com.example.jag.ex11fragmentretainstate;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity02 extends Activity {

    String msg;

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity02", "A2-OnRestart..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity02", "A2-OnDestroy..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity02", "A2-OnStop..");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        msg = savedInstanceState.getString("Msg");
        Log.d("Activity02", "A2-onRestoreInstanceState..");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Msg", msg);
        Log.d("Activity02", "A2-onSaveInstanceState..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity02", "A2-OnPause..");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Activity02", "A2-OnResume..");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity02", "A2-OnResume..");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity02", "A2-OnStart..");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("Activity02", "A2-onPostCreate..");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("Activity02", "A2-onNewIntent..");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("Activity02", "A2-onConfigurationChanged..");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d("Activity02", "A2-onContentChanged..");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("Activity02", "A2-onWindowFocusChanged..");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("Activity02", "A2-onAttachedToWindow..");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("Activity02", "A2-onDetachedFromWindow..");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02);

        Log.d("Activity02", "A2-OnCreate..");
        Button btnShowMsg = (Button) findViewById(R.id.btnShowMsg);
        btnShowMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity02.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage1 = (Button) findViewById(R.id.btnSetMessage1);
        btnSetMessage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Hi, this is message 1 (from Activity02)";
                Toast.makeText(Activity02.this, "Message 1 set", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage2 = (Button) findViewById(R.id.btnSetMessage2);
        btnSetMessage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Hello, this is message 2 (from Activity02)";
                Toast.makeText(Activity02.this, "Message 2 set", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage3 = (Button) findViewById(R.id.btnSetMessage3);
        btnSetMessage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Guys, this is message 3 (from Activity02)";
                Toast.makeText(Activity02.this, "Message 3 set", Toast.LENGTH_SHORT).show();
            }
        });
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
