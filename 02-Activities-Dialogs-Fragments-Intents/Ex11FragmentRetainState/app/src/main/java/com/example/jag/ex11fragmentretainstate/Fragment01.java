package com.example.jag.ex11fragmentretainstate;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment01.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment01#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment01 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String msg;

    private OnFragmentInteractionListener mListener;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment01.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment01 newInstance(String param1, String param2) {
        Fragment01 fragment = new Fragment01();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment01() {
        // Required empty public constructor
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment01", "F1-OnDestroy..");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment01", "F1-OnDestroyView..");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment01", "F1-OnStop..");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment01", "F1-OnPause..");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment01", "F1-OnResume..");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment01", "F1-OnStart..");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment01", "F1-OnActivityCreated..");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Fragment01", "F1-onSaveInstanceState..");
        outState.putString("Msg", msg);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("Fragment01", "F1-onViewStateRestored..");
        if (savedInstanceState != null) {
            msg = savedInstanceState.getString("Msg");
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("Fragment01", "F1-onConfigurationChanged..");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment01", "F1-OnCreate..");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Fragment01", "F1-OnCreateView..");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment01, container, false);
        Button btnShowMsg = (Button) v.findViewById(R.id.btnShowMsg);
        btnShowMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSetMessage1 = (Button) v.findViewById(R.id.btnSetMessage1);
        btnSetMessage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "Hi, this is message 1 (from Fragment01)";
                Toast.makeText(getActivity(), "Message 1 set", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Fragment01", "F1-OnAttach..");
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment01", "F1-OnDetach..");
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
