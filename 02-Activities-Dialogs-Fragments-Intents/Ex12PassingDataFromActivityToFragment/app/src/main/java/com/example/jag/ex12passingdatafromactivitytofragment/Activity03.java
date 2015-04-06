package com.example.jag.ex12passingdatafromactivitytofragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity03 extends Activity {

    String msg;
    EditText txtMsg;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("msg", msg);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        msg = savedInstanceState.getString("msg");
        updateIntentParams();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity03);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.frame01, new Activity03Fragment01())
                    .commit();
        }

        txtMsg = (EditText) findViewById(R.id.txtMsg);
        Button btnSetMessage = (Button) findViewById(R.id.btnSetMessage);
        btnSetMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = txtMsg.getText().toString();
                updateIntentParams();
            }
        });

        Button btnShowMessage = (Button) findViewById(R.id.btnShowMessage);
        btnShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity03.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateIntentParams() {
        this.getIntent().putExtra("msg", msg);
    }

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

        return super.onOptionsItemSelected(item);
    }
}
