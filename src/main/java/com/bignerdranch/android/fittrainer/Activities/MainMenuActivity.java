package com.bignerdranch.android.fittrainer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bignerdranch.android.fittrainer.Fragments.CustomerListFragment;
import com.bignerdranch.android.fittrainer.Fragments.MainMenuFragment;
import com.bignerdranch.android.fittrainer.R;

public class MainMenuActivity extends /*SingleFragmentActivity*/ AppCompatActivity {
    // Starts the class that creates a list fragment to be shown on the screen.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_twopane);

        if (findViewById(R.id.main_menu_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            // Create a fragment manager.
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.main_menu_fragment_container);

            MainMenuFragment mainMenuFragment = new MainMenuFragment();
            CustomerListFragment customerListFragment = new CustomerListFragment();

            // If there are no fragments on the screen, add fragment_container.
            if (fragment == null) {
                fm.beginTransaction()
                        .add(R.id.main_menu_fragment_container, mainMenuFragment)
                        .add(R.id.main_menu_fragment_container, customerListFragment)
                        .commit();
            }
        }
    }

    // Creates/Inflates options menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.fragment_menu_option,menu);
        return true;
    }

    // Determines if the user has pressed the log out button. If so,
    // Return the user back to the log in activity.
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.log_out) {
            // Inform the user that they are logging out.
            Toast.makeText(this, "Logging you out.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainMenuActivity.this, LoginAuthorizationActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    // Determines if the user has pressed the add button. If so,
    // Send the user to the Edit Customer activity. (Adding a new person not implemented yet)
    public void onClickAdd(View view) {
        Intent intent = new Intent(MainMenuActivity.this, EditCustomerActivity.class);
        startActivity(intent);
    }
    // Determines if the user has pressed the edit button. If so,
    // Send the user to the Edit Customer activity.
    public void onClickEdit(View view) {
        Intent intent = new Intent(MainMenuActivity.this, EditCustomerActivity.class);
        startActivity(intent);
    }

    public void onClickSession(View view) {
        Intent intent = new Intent(MainMenuActivity.this, SessionCompleteActivity.class);
        startActivity(intent);
    }
}
