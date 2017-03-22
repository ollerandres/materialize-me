package com.andevcba.materializeme.presentation.main.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.andevcba.materializeme.R;
import com.andevcba.materializeme.presentation.bottom_pattern.BottomNavigationActivity;
import com.andevcba.materializeme.presentation.drawer_pattern.NavigationDrawerActivity;
import com.andevcba.materializeme.presentation.embedded.EmbeddedNavigationActivity;
import com.andevcba.materializeme.presentation.gestural.GesturalNavigationActivity;
import com.andevcba.materializeme.presentation.main.fragment.PatternsFragment;
import com.andevcba.materializeme.presentation.main.fragment.PatternsFragment.OnListFragmentInteractionListener;
import com.andevcba.materializeme.domain.model.Pattern;
import com.andevcba.materializeme.presentation.tab_pattern.TabNavigationActivity;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, OnListFragmentInteractionListener {

    private static final String PATTERN_EXTRA = "PATTERN";
    private MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PatternsFragment(), PatternsFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void onListFragmentInteraction(Pattern pattern) {
        presenter.navigateOnCardClicked(pattern);
    }

    @Override
    public void navigateToNavigationDrawerPattern(Pattern pattern) {
        startActivity(new Intent(this, NavigationDrawerActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToNavigationDrawerNestedPattern(Pattern pattern) {
        startActivity(new Intent(this, NavigationDrawerActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToNavigationDrawerExpandedPattern(Pattern pattern) {
        startActivity(new Intent(this, NavigationDrawerActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToBottomNavigationPattern(Pattern pattern) {
        startActivity(new Intent(this, BottomNavigationActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToTabsNavigationPattern(Pattern pattern) {
        startActivity(new Intent(this, TabNavigationActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToEmbeddedScreenPattern(Pattern pattern) {
        startActivity(new Intent(this, EmbeddedNavigationActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToGesturalNavigationPattern(Pattern pattern) {
        startActivity(new Intent(this, GesturalNavigationActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToInContextNavigationPattern(Pattern pattern) {
        startActivity(new Intent(this, NavigationDrawerActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void navigateToNavigationDrawerTabsPattern(Pattern pattern) {
        startActivity(new Intent(this, NavigationDrawerActivity.class)
                .putExtra(PATTERN_EXTRA, pattern));
    }

    @Override
    public void showEmptyPatternErrorSnackBar() {
        Snackbar.make(findViewById(R.id.root_view), R.string.empty_pattern_error, Snackbar.LENGTH_SHORT);
    }

}
