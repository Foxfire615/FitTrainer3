package com.bignerdranch.android.fittrainer;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Talon on 9/18/2017.
 */

public class CustomerList {
    private static CustomerList sCustomerList;

    private List<Customer> mList;

    // Ensures that sCustomerList is not empty.
    // If so, add a new CustomerList to it
    public static CustomerList get(Context context) {
        if (sCustomerList == null) {
            sCustomerList = new CustomerList(context);
        }
        return sCustomerList;
    }

    // Create an ArrayList for storing customer names
    private CustomerList(Context context){
        mList = new ArrayList<>();
        // Create a list of a hundred John Does.
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setName("John Doe #" + i);
            mList.add(customer);
        }
    }

    // Allows the use of retrieving the names of customers.
    public List<Customer> getList(){
        return mList;
    }

    // Allows the use of retrieving the names of customers with an unique id.
    public Customer getList(UUID id) {
        for (Customer list : mList) {
            // Return the list if the id being tested matches what is needed.
            if (list.getId().equals(id)) {
                return list;
            }
        }
        return null;
    }
}