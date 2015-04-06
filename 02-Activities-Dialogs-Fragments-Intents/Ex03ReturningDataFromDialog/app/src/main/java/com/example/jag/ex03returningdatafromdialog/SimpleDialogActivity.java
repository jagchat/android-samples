package com.example.jag.ex03returningdatafromdialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SimpleDialogActivity extends Activity {

    EditText txtValue;
    TextView lblYouEnteredMsg;
    Button btnOk, btnCancel;
    SimpleDialogActivity CurrentInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_dialog);

        CurrentInstance = this;

        txtValue = (EditText) findViewById(R.id.activity_simple_dialog_txtValue);
        lblYouEnteredMsg = (TextView) findViewById(R.id.activity_simple_dialog_lblYouEnteredMsg);
        btnOk = (Button) findViewById(R.id.activity_simple_dialog_btnOk);
        btnOk.setOnClickListener(btnOkOnClickListener);
        btnCancel = (Button) findViewById(R.id.activity_simple_dialog_btnCancel);
        btnCancel.setOnClickListener(btnCancelOnClickListener);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String val = data.getString("ProvidedValue");
        lblYouEnteredMsg.setText("You entered: " + val);

    }

    private View.OnClickListener btnOkOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = CurrentInstance.getIntent();
            Bundle data = new Bundle();
            data.putString("DialogProvidedValue", txtValue.getText().toString());
            intent.putExtras(data);
            setResult(Activity.RESULT_OK, intent);
            CurrentInstance.finish();
        }
    };


    private View.OnClickListener btnCancelOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setResult(Activity.RESULT_CANCELED, null);
            CurrentInstance.finish();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_dialog, menu);
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
