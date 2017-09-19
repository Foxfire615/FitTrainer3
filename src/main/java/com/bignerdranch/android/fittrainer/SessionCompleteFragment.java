package com.bignerdranch.android.fittrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SessionCompleteFragment extends Fragment {
    public Button mSessionCompleteBackBttn;
    public Button mSessionCompleteAcceptBttn;
    public EditText mSessionCompleteTitleText;
    public EditText mSessionCompleteInfoText;
    public EditText mSessionCompleteSignText;
    public EditText mSessionCompleteSignitureTextBox;

    public SessionCompleteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View sessionCompleteView = inflater.inflate(R.layout.activity_session_completed, container, false);
        // Stores the elements in the current fragment.
        mSessionCompleteBackBttn = (Button) sessionCompleteView.findViewById(R.id.sessionComplete_back_button);
        mSessionCompleteAcceptBttn = (Button) sessionCompleteView.findViewById(R.id.sessionComplete_accept_button);
        mSessionCompleteTitleText = (EditText) sessionCompleteView.findViewById(R.id.sessionComplete_text);
        mSessionCompleteInfoText = (EditText) sessionCompleteView.findViewById(R.id.sessionComplete_confirmation_text);
        mSessionCompleteSignText = (EditText) sessionCompleteView.findViewById(R.id.sessionComplete_signature_text);
        mSessionCompleteSignitureTextBox = (EditText) sessionCompleteView.findViewById(R.id.sessionComplete_signiture_textBox);
        return sessionCompleteView;
    }
}
