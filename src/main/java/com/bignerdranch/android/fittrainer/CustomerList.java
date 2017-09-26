package com.bignerdranch.android.fittrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.fittrainer.database.CustomerBaseHelper;
import com.bignerdranch.android.fittrainer.database.CustomerCursorWrapper;
import com.bignerdranch.android.fittrainer.database.CustomerDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Talon on 9/18/2017.
 */

public class CustomerList {
    private static CustomerList sCustomerList;

    //private List<Customer> mList;
    // Initiates the database.
    private Context mContext;
    private SQLiteDatabase mDatabase;

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
        mContext = context.getApplicationContext();
        mDatabase = new CustomerBaseHelper(mContext)
                .getWritableDatabase();
    }

    // A method that will add a new Customer object into the database.
    public void addCustomer(Customer c) {
        ContentValues values = getContentValues(c);
        // Inserts values into the database.
        mDatabase.insert(CustomerDbSchema.CustomerTable.NAME, null, values);
    }

    // Allows the use of retrieving the names of customers.
    public List<Customer> getList(){
        List<Customer> customers = new ArrayList<>();

        // A cursor
        CustomerCursorWrapper cursor = queryCustomer(null,null);

        // Attempt to move the cursor to where ever it
        // needs to go in order to find the needed values.
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                customers.add(cursor.getCustomer());
                cursor.moveToNext();
            }
        }finally {
            // CLose the cursor.
            cursor.close();
        }
        return customers;
    }

    private static ContentValues getContentValues(Customer customer) {
        ContentValues values = new ContentValues();
        // Allows the database to pull the values from the Customer object.
        values.put(CustomerDbSchema.CustomerTable.Cols.UUID, customer.getId().toString());
        values.put(CustomerDbSchema.CustomerTable.Cols.NAME, customer.getName().toString());
        values.put(CustomerDbSchema.CustomerTable.Cols.ADDRESS, customer.getAddress().toString());
        values.put(CustomerDbSchema.CustomerTable.Cols.CITY, customer.getCity().toString());
        values.put(CustomerDbSchema.CustomerTable.Cols.STATE, customer.getState().toString());
        values.put(CustomerDbSchema.CustomerTable.Cols.ZIPCODE, customer.getZipCode().toString());
        return values;
    }

    // Allows the use of retrieving the names of customers with an unique id.
    public Customer getList(UUID id) {

            CustomerCursorWrapper cursor = queryCustomer(
                    CustomerDbSchema.CustomerTable.Cols.UUID + " = ?",
                    new String[]{id.toString()}
            );

            try {
                if (cursor.getCount() == 0) {
                    return null;
                }

                cursor.moveToFirst();
                return cursor.getCustomer();
            } finally {
                cursor.close();
            }
        }

        // Update the database when called.
    public void updateCustomer(Customer customer) {
        String uuidString = customer.getId().toString();
        ContentValues values = getContentValues(customer);

        mDatabase.update(CustomerDbSchema.CustomerTable.NAME, values,
                CustomerDbSchema.CustomerTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    // A cursor that sets up the structure of a query.
    private CustomerCursorWrapper queryCustomer(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CustomerDbSchema.CustomerTable.NAME,
                null, // Columns
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new CustomerCursorWrapper(cursor);
    }
}