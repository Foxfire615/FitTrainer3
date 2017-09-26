package com.bignerdranch.android.fittrainer.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.fittrainer.Activities.EditCustomerActivity;
import com.bignerdranch.android.fittrainer.Activities.SessionCompleteActivity;
import com.bignerdranch.android.fittrainer.Activities.SessionListActivity;
import com.bignerdranch.android.fittrainer.Customer;
import com.bignerdranch.android.fittrainer.CustomerList;
import com.bignerdranch.android.fittrainer.R;

import java.util.List;

public class CustomerListFragment extends Fragment {
    private RecyclerView mCustomerRecyclerView;
    private CustomerAdapter mAdapter;
    private Customer mCustomer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedIInstanceState) {
        // Set up view.
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        // Create the RecyclerView.
        mCustomerRecyclerView = (RecyclerView) view
                .findViewById(R.id.customer_recycler_view);
        mCustomerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Call method.
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // TextView element.
        private TextView mNameTextView;

        // Allows the use of holding a view for the RecyclerView.
        public CustomerHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_customer_item,parent,false));
            mNameTextView = (TextView) itemView.findViewById(R.id.customer_name);
            itemView.setOnClickListener(this);
        }

        // Stores the current name of a customer in the list.
        private void bind(Customer customer) {
            mCustomer = customer;
            mNameTextView.setText(mCustomer.getName());
        }

        @Override
        public void onClick(View view) {
            //Intent intent = new Intent(getActivity(), SessionListActivity.class);
            Intent intent = EditCustomerActivity.newIntent(getActivity(), mCustomer.getId());
            startActivity(intent);
        }
    }

    private class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder>  {
        // Create a list that will store the data of Customer objects.
        private List<Customer> mCustomer;

        // Allows the adapter to use the Customer objects as a list.
        public CustomerAdapter(List<Customer> customers) {
            mCustomer = customers;
        }

        // Creates a ViewHolder that will inflate the activity.
        @Override
        public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CustomerHolder(layoutInflater, parent);
        }

        // Allows the user to scroll up or down on the list.
        @Override
        public void onBindViewHolder(CustomerHolder holder, int position) {
            Customer customer = mCustomer.get(position);
            holder.bind(customer);
        }

        // Returns the size of the list.
        @Override
        public int getItemCount() {
            return mCustomer.size();
        }
    }

    // Gets the list and sets the adapter for use.
    private void updateUI() {
        CustomerList customerList = CustomerList.get(getActivity());
        List<Customer> customers = customerList.getList();

        if (mAdapter == null) {
            mAdapter = new CustomerAdapter(customers);
            mCustomerRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
}

