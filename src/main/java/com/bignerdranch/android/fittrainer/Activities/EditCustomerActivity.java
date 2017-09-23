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

import com.bignerdranch.android.fittrainer.Fragments.EditCustomerFragment;
import com.bignerdranch.android.fittrainer.R;


/**
 * Created by Talon on 9/22/2017.
 */

public class EditCustomerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);

        if (findViewById(R.id.edit_customer_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            // Create a fragment manager.
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.edit_customer_fragment_container);

            EditCustomerFragment editCustomerFragment = new EditCustomerFragment();

            // If there are no fragments on the screen, add fragment_container.
            if (fragment == null) {
                fm.beginTransaction()
                        .add(R.id.edit_customer_fragment_container,editCustomerFragment)
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
            Intent intent = new Intent(EditCustomerActivity.this, LoginAuthorizationActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    // Determines if the user has pressed the apply button. If so,
    // Send the user to the Main Menu activity.
    public void onClickApply (View view) {
        Intent intent = new Intent(EditCustomerActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }

    // Determines if the user has pressed the back button. If so,
    // Send the user to the Main Menu activity.
    public void OnClickBack (View view) {
        Intent intent = new Intent(EditCustomerActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }

    public void OnClickUpload (View view) {
        // Nothing yet.
    }
}
