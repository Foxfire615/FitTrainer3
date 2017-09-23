package com.bignerdranch.android.fittrainer.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import com.bignerdranch.android.fittrainer.Customer;
import com.bignerdranch.android.fittrainer.R;

/**
 * Created by Talon on 9/2/2017.
 */

public class MainMenuFragment extends Fragment{
    private Customer mCustomer;
    private EditText mCustomerListTitle;
    private Button mAddButton;
    private Button mEditButton;
    private Button mDeleteButton;
    private Button mSessionButton;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Store a new Customer object.
        mCustomer = new Customer();
    }

    /*protected Fragment createFragment() {
        return new CustomerListFragment();
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_menu,container,false);

        // Stores the elements in the current fragment.
        mCustomerListTitle = (EditText) v.findViewById(R.id.edit_Title);

        mAddButton = (Button) v.findViewById(R.id.main_button_add);
        mAddButton.setEnabled(true);

        mEditButton = (Button) v.findViewById(R.id.main_button_edit);
        mEditButton.setEnabled(true);

        mDeleteButton = (Button) v.findViewById(R.id.main_button_delete);
        mDeleteButton.setEnabled(true);

        mSessionButton = (Button) v.findViewById(R.id.main_button_session);
        mSessionButton.setEnabled(true);

        // Starts the class that creates a list fragment to be shown on the screen.
        mRecyclerView = (RecyclerView) v.findViewById(R.id.customer_recycler_view);

        //createFragment();

        return v;
    }
}
