package com.bignerdranch.android.fittrainer;

import android.support.v4.app.Fragment;

public class MainMenuActivity extends SingleFragmentActivity {
    // Starts the class that creates a list fragment to be shown on the screen.
    @Override
    protected Fragment createFragment() {
        return new CustomerListFragment();
    }
}
