package com.example.jag.ex17simpledialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by jpulakhandam on 4/3/2015.
 */
public class ConfirmDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("Title");

        AlertDialog.Builder dialogBuilder =  new AlertDialog.Builder(getActivity());

        dialogBuilder.setTitle(title);

        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((MainActivity)
                        getActivity()).OnDialogOkClick();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((MainActivity)
                        getActivity()).OnDialogCancelClick();
            }
        });

        return dialogBuilder.create();
    }
}
