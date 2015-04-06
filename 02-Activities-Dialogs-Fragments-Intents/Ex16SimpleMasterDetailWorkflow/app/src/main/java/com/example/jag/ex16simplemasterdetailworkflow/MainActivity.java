package com.example.jag.ex16simplemasterdetailworkflow;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements ICitySelected {

    private String mCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCity = savedInstanceState.getString("City");
        }

        FrameLayout frameCityInfo = (FrameLayout) findViewById(R.id.frameCityInfo);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            frameCityInfo.setVisibility(View.GONE);
        } else {
            frameCityInfo.setVisibility(View.VISIBLE);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("City", mCity);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            mCity = savedInstanceState.getString("City");
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                SelectCityInListFragment(mCity);
                ShowDetailsFragment(mCity);
            }
        }
    }

    @Override
    public void onCitySelected(String selectedCity) {
        mCity = selectedCity;
        ShowDetailsFragment(selectedCity);
    }

    private void SelectCityInListFragment(String selectedCity){
        CitiesListFragment fragmentCitiesList = (CitiesListFragment) getFragmentManager().findFragmentById(R.id.fragmentCitiesList);
        ICitySelected iFragment = (ICitySelected) fragmentCitiesList;
        iFragment.onCitySelected(selectedCity);
    }

    private void ShowDetailsFragment(String selectedCity) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent cityInfoIntent = new Intent(MainActivity.this, CityInfoActivity.class);
            cityInfoIntent.putExtra("SelectedCity", selectedCity);
            startActivity(cityInfoIntent);
        } else {
            CityInfoFragment detailsFragment = (CityInfoFragment) getFragmentManager().findFragmentByTag("CityInfoFragment");
            if (detailsFragment == null) {
                detailsFragment = new CityInfoFragment();
                getFragmentManager().beginTransaction().add(R.id.frameCityInfo, detailsFragment, "CityInfoFragment").commit();
            }
            ICitySelected iFragment = (ICitySelected) detailsFragment;
            iFragment.onCitySelected(selectedCity);
        }
    }
}
