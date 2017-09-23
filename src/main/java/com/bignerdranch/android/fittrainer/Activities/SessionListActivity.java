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

import com.bignerdranch.android.fittrainer.R;
import com.bignerdranch.android.fittrainer.Fragments.SessionListFragment;

/**
 * Created by Talon on 9/22/2017.
 */

public class SessionListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_list);

        if (findViewById(R.id.session_list_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            // Create a fragment manager.
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.session_list_fragment_container);

            SessionListFragment sessionListFragment = new SessionListFragment();

            // If there are no fragments on the screen, add fragment_container.
            if (fragment == null) {
                fm.beginTransaction()
                        .add(R.id.session_list_fragment_container, sessionListFragment)
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
            Intent intent = new Intent(SessionListActivity.this, LoginAuthorizationActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    // Determines if the user has pressed the add button. If so,
    // Send the user to the New Session activity.
    public void onClickAdd (View view) {
        Intent intent = new Intent(SessionListActivity.this, NewSessionActivity.class);
        startActivity(intent);
    }

    // Determines if the user has pressed the back button. If so,
    // Send the user to the Main Menu activity.
    public void onClickBack (View view) {
        Intent intent = new Intent(SessionListActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }
}
