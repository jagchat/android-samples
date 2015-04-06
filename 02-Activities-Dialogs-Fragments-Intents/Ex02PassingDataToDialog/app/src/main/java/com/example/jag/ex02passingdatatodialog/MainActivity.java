package com.example.jag.ex02passingdatatodialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText txtValue;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValue = (EditText) findViewById(R.id.txtValue);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(btnShowOnClickListener);
    }


    private View.OnClickListener btnShowOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultDialogActivity.class);

//            //-->using putExtra---method 1 (comment/uncomment in ResultDialogActivity accordingly)
//            intent.putExtra("ProvidedValue", txtValue.getText().toString());

//            //or------------------method 2 (comment/uncomment in ResultDialogActivity accordingly)
//            //-->using bundle
//            Bundle b = new Bundle();
//            b.putString("ProvidedValue", txtValue.getText().toString());
//            intent.putExtras(b);

            //or
            //-->using a custom object----method 3 (comment/uncomment in ResultDialogActivity ..)
            SampleData obj = new SampleData();
            obj.setValue(txtValue.getText().toString());
            intent.putExtra("ProvidedValue", obj);

            startActivity(intent);
        }
    };

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
