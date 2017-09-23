package com.bignerdranch.android.fittrainer.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bignerdranch.android.fittrainer.R;


public class NewSessionFragment extends Fragment {

    public Button mNewSessionApplyButton;

    public EditText mNewSessionTitleText;
    public EditText mNewSessionDateText;
    public EditText mNewSessionPriceText;
    public EditText mNewSessionBillInfoText;
    public EditText mNewSessionCardNumberText;
    public EditText mNewSessionExpirationText;
    public EditText mNewSessionSecurityNumberText;

    public EditText mNewSessionDateTextBox;
    public EditText mNewSessionPriceTextBox;
    public EditText mNewSessionCardNumberTextBox;
    public EditText mNewSessionExpirationTextBox;
    public EditText mNewSessionSecurityNumberTextBox;
    public EditText mNewSessionSignitureTextBox;


    public NewSessionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View newSessionView = inflater.inflate(R.layout.fragment_new_session,container,false);

        mNewSessionApplyButton = (Button) newSessionView.findViewById(R.id.session_apply_button);
        // Stores the elements in the current fragment.
        mNewSessionTitleText = (EditText) newSessionView.findViewById(R.id.session_create_text);
        mNewSessionDateText = (EditText) newSessionView.findViewById(R.id.session_date_text);
        mNewSessionPriceText = (EditText) newSessionView.findViewById(R.id.session_price_text);
        mNewSessionBillInfoText = (EditText) newSessionView.findViewById(R.id.session_billing_text);
        mNewSessionCardNumberText = (EditText) newSessionView.findViewById(R.id.session_card_text);
        mNewSessionExpirationText = (EditText) newSessionView.findViewById(R.id.session_expiration_text);
        mNewSessionSecurityNumberText = (EditText) newSessionView.findViewById(R.id.session_security_text);

        return newSessionView;
    }

}
