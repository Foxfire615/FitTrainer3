package com.bignerdranch.android.fittrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SessionPurchaseFragment extends Fragment {
    public Button SessionPurchaseBackBttn;
    public Button SessionPurchasePrintBttn;
    public Button SessionPurchaseEmailBttn;
    public EditText SessionPurchaseTitleText;
    public EditText SessionPurchasePrintText;
    public EditText SessionPurchaseEmailText;
    public EditText SessionPurchaseEmailAddressTextBox;

    public SessionPurchaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View SessionPurchaseView = inflater.inflate(R.layout.activity_purchase,container,false);
        // Stores the elements in the current fragment.
        SessionPurchaseBackBttn = (Button) SessionPurchaseView.findViewById(R.id.purchase_back_button);
        SessionPurchasePrintBttn = (Button) SessionPurchaseView.findViewById(R.id.purchase_print_button);
        SessionPurchaseEmailBttn = (Button) SessionPurchaseView.findViewById(R.id.purchase_send_button);
        SessionPurchaseTitleText = (EditText) SessionPurchaseView.findViewById(R.id.purchase_thanks_text);
        SessionPurchasePrintText = (EditText) SessionPurchaseView.findViewById(R.id.purchase_question_text);
        SessionPurchaseEmailText = (EditText) SessionPurchaseView.findViewById(R.id.purchase_email_text);
        SessionPurchaseEmailAddressTextBox = (EditText) SessionPurchaseView.findViewById(R.id.purchase_email_textBox);

        return SessionPurchaseView;
    }
}
