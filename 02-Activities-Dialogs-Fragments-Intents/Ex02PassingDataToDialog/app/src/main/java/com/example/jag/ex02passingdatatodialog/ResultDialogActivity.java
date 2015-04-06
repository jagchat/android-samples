package com.example.jag.ex02passingdatatodialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultDialogActivity extends Activity {

    TextView lblMsg;
    Button btnOk;
    ResultDialogActivity CurrentInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        CurrentInstance = this;

        lblMsg = (TextView) findViewById(R.id.lblResultDialogMsg);
        btnOk = (Button) findViewById(R.id.btnResultDialogOk);
        btnOk.setOnClickListener(btnOkOnClickListener);

        Intent intent = getIntent();

//        //-->using putExtra -------- method 1 (comment/uncomment in MainActivity accordingly)
//        int value = Integer.parseInt(intent.getStringExtra("ProvidedValue"));

//        //or              ---------- method 2 (comment/uncomment in MainActivity accordingly)
//        //-->using Bundle
//        Bundle b = intent.getExtras();
//        int value = Integer.parseInt(b.getString("ProvidedValue"));

        //or
        //-->using a custom object----method 3 (comment/uncomment in ResultDialogActivity ..)
        SampleData obj = (SampleData) intent.getSerializableExtra("ProvidedValue");
        int value = Integer.parseInt(obj.Value());

        value = value * value;
        lblMsg.setText("Square of the value: " + value);

    }

    private View.OnClickListener btnOkOnClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CurrentInstance.finish();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_dialog, menu);
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
