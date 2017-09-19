package com.bignerdranch.android.fittrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

/**
 * Created by Talon on 9/2/2017.
 */

public class FitFragment extends Fragment{
    private Customer mCustomer;
    private EditText mCustomerListTitle;
    private Button mAddButton;
    private Button mEditButton;
    private Button mDeleteButton;
    private Button mSessionButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Store a new Customer object.
        mCustomer = new Customer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_menu,container,false);

        // Stores the elements in the current fragment.
        mCustomerListTitle = (EditText) v.findViewById(R.id.textView);

        mAddButton = (Button) v.findViewById(R.id.main_button_add);
        mAddButton.setEnabled(true);

        mEditButton = (Button) v.findViewById(R.id.main_button_edit);
        mEditButton.setEnabled(true);

        mDeleteButton = (Button) v.findViewById(R.id.main_button_delete);
        mDeleteButton.setEnabled(true);

        mSessionButton = (Button) v.findViewById(R.id.main_button_session);
        mSessionButton.setEnabled(true);

        return v;
    }
}
