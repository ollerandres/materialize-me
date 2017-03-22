package com.andevcba.materializeme.presentation.main.activity;

import com.andevcba.materializeme.domain.model.Pattern;

/**
 * @author Andres Oller.
 */

class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void navigateOnCardClicked(Pattern pattern) {
        if (view != null) {
            switch (Integer.valueOf(pattern.getId())) {
                case 0:
                    view.navigateToNavigationDrawerPattern(pattern);
                    break;
                case 1:
                    view.navigateToNavigationDrawerNestedPattern(pattern);
                    break;
                case 2:
                    view.navigateToNavigationDrawerExpandedPattern(pattern);
                    break;
                case 3:
                    view.navigateToBottomNavigationPattern(pattern);
                    break;
                case 4:
                    view.navigateToTabsNavigationPattern(pattern);
                    break;
                case 5:
                    view.navigateToEmbeddedScreenPattern(pattern);
                    break;
                case 6:
                    view.navigateToGesturalNavigationPattern(pattern);
                    break;
                case 7:
                    view.navigateToInContextNavigationPattern(pattern);
                    break;
                case 8:
                    view.navigateToNavigationDrawerTabsPattern(pattern);
                    break;
                default:
                    view.showEmptyPatternErrorSnackBar();
            }
        }
    }
}
