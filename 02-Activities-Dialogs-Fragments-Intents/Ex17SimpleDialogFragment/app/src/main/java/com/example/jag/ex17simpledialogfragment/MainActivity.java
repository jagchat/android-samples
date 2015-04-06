package com.example.jag.ex17simpledialogfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    TextView lblMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMsg = (TextView) findViewById(R.id.lblMsg);
        Button btnShow = (Button) findViewById(R.id.btnShowDialog);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmDialogFragment fragment = new ConfirmDialogFragment();
                Bundle args = new Bundle();
                args.putString("Title", "Are you Sure?");
                fragment.setArguments(args);
                fragment.show(getFragmentManager(), "ConfirmDialog");
            }
        });
    }


    public void OnDialogOkClick() {
        lblMsg.setText("You clicked 'Ok'"); //not really caring about saved state in this ex.
    }

    public void OnDialogCancelClick() {
        lblMsg.setText("You clicked 'Cancel'"); //not really caring about saved state in this ex.
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
