package com.bignerdranch.android.fittrainer.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.fittrainer.Customer;

import java.util.UUID;

/**
 * Created by Talon on 9/25/2017.
 */

// Initiates the curser that will be used for the database.
public class CustomerCursorWrapper extends CursorWrapper {
    public CustomerCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Customer getCustomer() {
        // Collect the necessary values from the customer class as strings.
        String uuidString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.UUID));
        String nameString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.NAME));
        String addressString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.ADDRESS));
        String cityString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.CITY));
        String zipCodeString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.ZIPCODE));

        Customer customer = new Customer(UUID.fromString(uuidString));
        customer.setName(nameString);
        customer.setAddress(addressString);
        customer.setCity(cityString);
        customer.setZipCode(zipCodeString);
        return customer;
    }
}
