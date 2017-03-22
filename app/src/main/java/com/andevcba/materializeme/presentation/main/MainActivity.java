package com.andevcba.materializeme.presentation.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andevcba.materializeme.R;
import com.andevcba.materializeme.presentation.bottom_pattern.BottomNavigationActivity;
import com.andevcba.materializeme.presentation.drawer_pattern.NavigationDrawerActivity;
import com.andevcba.materializeme.presentation.embedded.EmbeddedNavigationActivity;
import com.andevcba.materializeme.presentation.gestural.GesturalNavigationActivity;
import com.andevcba.materializeme.presentation.main.PatternsFragment.OnListFragmentInteractionListener;
import com.andevcba.materializeme.presentation.main.model.Pattern;
import com.andevcba.materializeme.presentation.tab_pattern.TabNavigationActivity;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PatternsFragment(), PatternsFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(Pattern pattern) {
        Intent intent = null;



        switch (Integer.valueOf(pattern.getId())) {
            case 0:
                intent = new Intent(this, NavigationDrawerActivity.class);
                break;
            case 1:
                intent = new Intent(this, NavigationDrawerActivity.class);
                break;
            case 2:
                intent = new Intent(this, NavigationDrawerActivity.class);
                break;
            case 3:
                intent = new Intent(this, BottomNavigationActivity.class);
                break;
            case 4:
                intent = new Intent(this, TabNavigationActivity.class);
                break;
            case 5:
                intent = new Intent(this, EmbeddedNavigationActivity.class);
                break;
            case 6:
                intent = new Intent(this, GesturalNavigationActivity.class);
                break;
            case 7:
                intent = new Intent(this, NavigationDrawerActivity.class);
                break;
            case 8:
                intent = new Intent(this, NavigationDrawerActivity.class);
                break;
        }

        if (intent != null) {
            intent.putExtra("PATTERN", pattern);
        }
        startActivity(intent);
    }
}
