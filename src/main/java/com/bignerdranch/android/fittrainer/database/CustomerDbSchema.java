package com.bignerdranch.android.fittrainer.database;

/**
 * Created by Talon on 9/25/2017.
 */

// Create a SQL Table schematic for the Customer object.
public class CustomerDbSchema {
    public static final class CustomerTable {
        public static final String NAME = "customers";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String CITY = "city";
            public static final String STATE = "state";
            public static final String ADDRESS = "address";
            public static final String ZIPCODE = "zipcode";
        }
    }
}
