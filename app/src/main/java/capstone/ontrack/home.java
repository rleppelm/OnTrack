package capstone.ontrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;

public class home extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setTitle("Home");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        OnActionExpandListener expandListener = new OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when action item collapses
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        };

        MenuItem settingsItem = menu.findItem(R.id.action_settings);
        MenuItemCompat.setOnActionExpandListener(settingsItem, expandListener);


        MenuItem profileItem = menu.findItem(R.id.action_add);
        MenuItemCompat.setOnActionExpandListener(profileItem, expandListener);

        MenuItem addItem = menu.findItem(R.id.action_profile);
        MenuItemCompat.setOnActionExpandListener(addItem, expandListener);

        return super.onCreateOptionsMenu(menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, settings.class);
                startActivity(intent);
                return true;
            case R.id.action_add:
                Intent add = new Intent(this, routine.class);
                startActivity(add);
                return true;
            case R.id.action_profile:
                Intent profile = new Intent(this, profile.class);
                startActivity(profile);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return true;

        }
    }

}
