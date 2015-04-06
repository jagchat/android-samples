package com.example.jag.ex03returningdatafromdialog;

import android.app.Activity;
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

    private int SIMPLE_DIALOG_REQ_CODE = 101; //any unique code acceptable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValue = (EditText)findViewById(R.id.activity_main_txtValue);
        btnShow = (Button) findViewById(R.id.activity_main_btnShow);
        btnShow.setOnClickListener(btnShowOnClickListener);
    }


    private View.OnClickListener btnShowOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),SimpleDialogActivity.class);
            Bundle data = new Bundle();
            data.putString("ProvidedValue", txtValue.getText().toString());
            intent.putExtras(data);
            startActivityForResult(intent,SIMPLE_DIALOG_REQ_CODE);
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SIMPLE_DIALOG_REQ_CODE)
        {
            switch (resultCode)
            {
                case Activity.RESULT_OK:
                    int a = Integer.parseInt(txtValue.getText().toString());
                    Bundle d = data.getExtras();
                    int b = Integer.parseInt(d.getString("DialogProvidedValue"));
                    int s = a + b;
                    Toast.makeText(this,"Sum = " + s, Toast.LENGTH_LONG).show();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(this,"Cancelled!", Toast.LENGTH_LONG).show();
                    break;
            }
        }
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
