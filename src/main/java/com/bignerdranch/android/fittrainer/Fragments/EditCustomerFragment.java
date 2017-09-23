package com.bignerdranch.android.fittrainer.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bignerdranch.android.fittrainer.R;

/**
 * Created by Talon on 9/22/2017.
 */

public class EditCustomerFragment extends Fragment {
    private EditText mEditCustomerTitle;
    private EditText mEditCustomerBillingTitle;

    private TextView mEditCustomerName;
    private TextView mEditCustomerAddress;
    private TextView mEditCustomerCity;
    private TextView mEditCustomerZipCode;
    private TextView mEditCustomerState;

    private Button mEditCustomerButtonApply;
    private Button mEditCustomerButtoBack;
    private Button mEditCustomerButtonUpload;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ediCustomerView = inflater.inflate(R.layout.fragment_edit_customer,container,false);

        mEditCustomerTitle = (EditText) ediCustomerView.findViewById(R.id.edit_Title);
        mEditCustomerBillingTitle = (EditText) ediCustomerView.findViewById(R.id.edit_Billing_Address);

        mEditCustomerName = (TextView) ediCustomerView.findViewById(R.id.edit_Name);
        mEditCustomerAddress = (TextView) ediCustomerView.findViewById(R.id.edit_Address);
        mEditCustomerCity = (TextView) ediCustomerView.findViewById(R.id.edit_City);
        mEditCustomerZipCode = (TextView) ediCustomerView.findViewById(R.id.edit_Zip_Code);
        mEditCustomerState = (TextView) ediCustomerView.findViewById(R.id.edit_State);

        mEditCustomerButtonApply = (Button) ediCustomerView.findViewById(R.id.edit_customer_button_apply);
        mEditCustomerButtonApply = (Button) ediCustomerView.findViewById(R.id.edit_customer_button_back);
        mEditCustomerButtonApply = (Button) ediCustomerView.findViewById(R.id.edit_Customer_Button_Upload);
        return ediCustomerView;
    }
}
