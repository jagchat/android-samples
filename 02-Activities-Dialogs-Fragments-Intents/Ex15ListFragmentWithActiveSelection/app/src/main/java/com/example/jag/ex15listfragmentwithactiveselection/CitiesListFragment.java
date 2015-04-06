package com.example.jag.ex15listfragmentwithactiveselection;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jpulakhandam on 3/31/2015.
 */
public class CitiesListFragment extends ListFragment {

    String[] cities = CitiesList.Cities;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        l.setItemChecked(position, true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView lv = this.getListView();
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                cities));
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ListView lv = this.getListView();
        if (lv.getCheckedItemPosition() != AdapterView.INVALID_POSITION) {
            outState.putString("pos", String.valueOf(lv.getCheckedItemPosition()));
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            ListView lv = this.getListView();
            String pos = savedInstanceState.getString("pos");
            if(pos !=null && !pos.isEmpty()){
                lv.setItemChecked(Integer.parseInt(pos), true);
            }
        }
    }
}
