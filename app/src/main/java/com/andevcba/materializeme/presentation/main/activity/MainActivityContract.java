package com.andevcba.materializeme.presentation.main.activity;

import com.andevcba.materializeme.domain.model.Pattern;

/**
 * @author Andres Oller.
 */

interface MainActivityContract {

    interface View {

        void navigateToNavigationDrawerPattern(Pattern pattern);

        void navigateToNavigationDrawerNestedPattern(Pattern pattern);

        void navigateToNavigationDrawerExpandedPattern(Pattern pattern);

        void navigateToBottomNavigationPattern(Pattern pattern);

        void navigateToTabsNavigationPattern(Pattern pattern);

        void navigateToEmbeddedScreenPattern(Pattern pattern);

        void navigateToGesturalNavigationPattern(Pattern pattern);

        void navigateToInContextNavigationPattern(Pattern pattern);

        void navigateToNavigationDrawerTabsPattern(Pattern pattern);

        void showEmptyPatternErrorSnackBar();
    }

    interface Presenter {

        void navigateOnCardClicked(Pattern pattern);

    }

}
