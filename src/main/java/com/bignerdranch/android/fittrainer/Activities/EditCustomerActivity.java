package com.bignerdranch.android.fittrainer.Activities;

import android.content.Context;
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

import java.util.UUID;


/**
 * Created by Talon on 9/22/2017.
 */

public class EditCustomerActivity extends /*AppCompatActivity*/ SingleFragmentActivity {

    public static final String EXTRA_CUSTOMER_ID = "com.bignerdranch.android.fittrainer.customer_id";

    public static Intent newIntent(Context packageContext, UUID mId) {
        Intent intent = new Intent(packageContext, EditCustomerActivity.class);
        intent.putExtra(EXTRA_CUSTOMER_ID, mId);
        return intent;
    }
    
    protected Fragment createFragment() {
        UUID customerId = (UUID) getIntent().getSerializableExtra(EXTRA_CUSTOMER_ID);
        return EditCustomerFragment.newInstance(customerId);
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
