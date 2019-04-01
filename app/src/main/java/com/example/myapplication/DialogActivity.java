package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public  class DialogActivity extends AppCompatDialogFragment {
    EditText name,pass;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        SharePre.init(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_layout,null);
        name=view.findViewById(R.id.name);
        pass=view.findViewById(R.id.pass);
        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharePre.Write("d1",name.getText().toString());
                        SharePre.Write("d2",pass.getText().toString());
                        Toast.makeText(getActivity(),"data saved",Toast.LENGTH_SHORT).show();

                    }
                });

        return builder.create();


    }

}
