package com.example.jag.ex18dialogfragmentwithlayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by jpulakhandam on 4/3/2015.
 */
public class SingleFieldInputDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String title = getArguments().getString("Title");
        builder.setTitle(title);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vSingleTextfieldInput = inflater.inflate(R.layout.single_textfield_input, null);
        final EditText txtValue = (EditText) vSingleTextfieldInput.findViewById(R.id.txtValue);
        builder.setView(vSingleTextfieldInput);

//--or
//        builder.setView(R.layout.single_textfield_input); //but we cannot access txtValue directly

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((MainActivity) getActivity()).OnDialogOkClick(txtValue.getText().toString());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((MainActivity) getActivity()).OnDialogCancelClick();
            }
        });

        return builder.create();
    }
}
