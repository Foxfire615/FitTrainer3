package com.bignerdranch.android.fittrainer.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.bignerdranch.android.fittrainer.R;

public class SessionListFragment extends Fragment {


    public Button mAddSessionBttn;
    public Button mBackSessionBttn;
    public EditText mCustomerInfoText;
    private ListView mCustomerInfoList;


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
        View sessionView = inflater.inflate(R.layout.fragment_session_list, container, false);
        // Stores the elements in the current fragment.
        mAddSessionBttn = (Button) sessionView.findViewById(R.id.sessionList_add_button);
        mBackSessionBttn = (Button) sessionView.findViewById(R.id.sessionList_back_button);
        mCustomerInfoText = (EditText) sessionView.findViewById(R.id.sessionList_text);
        mCustomerInfoList = (ListView) sessionView.findViewById(R.id.sessionList_session_listView);
        // Inflate the layout for this fragment
        return sessionView;
    }
}
