package com.bignerdranch.android.fittrainer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SessionListFragment extends Fragment {


    public Button mAddSessionBttn;
    public Button mBackSessionBttn;
    public EditText mCustomerInfoText;


    public SessionListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View sessionView = inflater.inflate(R.layout.activity_session_list, container, false);
        // Stores the elements in the current fragment.
        mAddSessionBttn = (Button) sessionView.findViewById(R.id.sessionList_add_button);
        mBackSessionBttn = (Button) sessionView.findViewById(R.id.sessionList_back_button);
        mCustomerInfoText = (EditText) sessionView.findViewById(R.id.sessionList_text);
        // Inflate the layout for this fragment
        return sessionView;
    }
}
