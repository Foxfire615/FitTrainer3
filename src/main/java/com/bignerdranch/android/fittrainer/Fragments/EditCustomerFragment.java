package com.bignerdranch.android.fittrainer.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bignerdranch.android.fittrainer.Activities.EditCustomerActivity;
import com.bignerdranch.android.fittrainer.Customer;
import com.bignerdranch.android.fittrainer.CustomerList;
import com.bignerdranch.android.fittrainer.R;

import java.util.UUID;

/**
 * Created by Talon on 9/22/2017.
 */

public class EditCustomerFragment extends Fragment {

    // private static final String ARG_CUSTOMER_ID = "cust_id";
    private static final String ARG_CUSTOMER_ID = "customerId";

    private Customer mCustomer;
    private TextView mEditCustomerTitle;
    private TextView mEditCustomerBillingTitle;

    private EditText mEditCustomerName;
    private EditText mEditCustomerAddress;
    private EditText mEditCustomerCity;
    private EditText mEditCustomerZipCode;
    private EditText mEditCustomerState;

    private Button mEditCustomerButtonApply;
    private Button mEditCustomerButtonBack;
    private Button mEditCustomerButtonUpload;

    public static EditCustomerFragment newInstance(UUID customerId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CUSTOMER_ID, customerId);

        EditCustomerFragment fragment = new EditCustomerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // Get the id of the selected customer.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID customerId = (UUID) getArguments().getSerializable(ARG_CUSTOMER_ID);
        // If the id is not null, then grab the customerId.
        if (customerId != null) {
            mCustomer = CustomerList.get(getActivity()).getList(customerId);
        }
    }

    // Update the list when paused.
    @Override
    public void onPause() {
        super.onPause();
        CustomerList.get(getActivity())
        .updateCustomer(mCustomer);
    }

    // Set up the widgets in the fragment, and allow the user to make changes in the edit textboxes.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ediCustomerView = inflater.inflate(R.layout.fragment_edit_customer,container,false);

        mEditCustomerTitle = (TextView) ediCustomerView.findViewById(R.id.edit_Title);
        mEditCustomerBillingTitle = (TextView) ediCustomerView.findViewById(R.id.edit_Billing_Address);

        mEditCustomerName = (EditText) ediCustomerView.findViewById(R.id.edit_Name);
        // mEditCustomerName.setText(mCustomer.getName()); /* !!!!Causes crash!!!! */
        mEditCustomerName.setText("John doe");
        mEditCustomerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Leave blank.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Leave blank.
            }
        });

        mEditCustomerAddress = (EditText) ediCustomerView.findViewById(R.id.edit_Address);
        mEditCustomerAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Leave blank.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Leave blank.
            }
        });

        mEditCustomerCity = (EditText) ediCustomerView.findViewById(R.id.edit_City);
        mEditCustomerCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Leave blank.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Leave blank.
            }
        });

        mEditCustomerZipCode = (EditText) ediCustomerView.findViewById(R.id.edit_Zip_Code);
        mEditCustomerZipCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Leave blank.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setZipCode(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Leave blank.
            }
        });

        mEditCustomerState = (EditText) ediCustomerView.findViewById(R.id.edit_State);
        mEditCustomerState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Leave blank.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setState(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Leave blank.
            }
        });

        mEditCustomerButtonApply = (Button) ediCustomerView.findViewById(R.id.edit_customer_button_apply);
        mEditCustomerButtonBack = (Button) ediCustomerView.findViewById(R.id.edit_customer_button_back);
        mEditCustomerButtonUpload = (Button) ediCustomerView.findViewById(R.id.edit_Customer_Button_Upload);
        return ediCustomerView;
    }
}
