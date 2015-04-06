package com.example.jag.ex07movingbetweenactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity02 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02);

        Button btnShowActivity3 = (Button) findViewById(R.id.btnShowActivity3);
        btnShowActivity3.setOnClickListener(btnShowActivity3ClickListener);
    }

    protected View.OnClickListener btnShowActivity3ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Activity02.this, "from Activity02", Toast.LENGTH_LONG).show();
            Intent activity03Intent = new Intent(Activity02.this, Activity03.class);
            startActivity(activity03Intent);
        }
    };

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
