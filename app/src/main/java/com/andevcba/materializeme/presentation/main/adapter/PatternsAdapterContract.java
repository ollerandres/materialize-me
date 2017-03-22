package com.andevcba.materializeme.presentation.main.adapter;

import com.andevcba.materializeme.presentation.main.fragment.PatternsFragment;
import com.andevcba.materializeme.domain.model.Pattern;

/**
 * @author Andres Oller.
 */

interface PatternsAdapterContract {

    interface View {

        void patternSelected(Pattern pattern);

        int getNavDrawerDrawable();

        int getNavNestedDrawable();

        int getNavExpandingDrawable();

        int getNavBottomDrawable();

        int getNavTabsDrawable();

        int getNavEmbeddedDrawable();

        int getNavGesturalDrawable();

        int getNavInContextDrawable();

        int getNavDrawerTabsDrawable();
    }

    interface Presenter {

        void patternSelected(PatternsFragment.OnListFragmentInteractionListener listener, Pattern pattern);

        int getDrawableForPattern(Pattern pattern);
    }
}
