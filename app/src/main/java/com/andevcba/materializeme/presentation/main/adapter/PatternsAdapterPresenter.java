package com.andevcba.materializeme.presentation.main.adapter;

import com.andevcba.materializeme.presentation.main.fragment.PatternsFragment.OnListFragmentInteractionListener;
import com.andevcba.materializeme.domain.model.Pattern;

/**
 * @author Andres Oller.
 */

class PatternsAdapterPresenter implements PatternsAdapterContract.Presenter {

    PatternsAdapterContract.View view;

    public PatternsAdapterPresenter(PatternsAdapterContract.View view) {
        this.view = view;
    }

    @Override
    public void patternSelected(OnListFragmentInteractionListener listener, Pattern pattern) {
        if (listener != null && view != null) {
            view.patternSelected(pattern);
        }
    }

    @Override
    public int getDrawableForPattern(Pattern pattern) {
        switch (Integer.valueOf(pattern.getId())) {
            case 0:
                return view.getNavDrawerDrawable();
            case 1:
                return view.getNavNestedDrawable();
            case 2:
                return view.getNavExpandingDrawable();
            case 3:
                return view.getNavBottomDrawable();
            case 4:
                return view.getNavTabsDrawable();
            case 5:
                return view.getNavEmbeddedDrawable();
            case 6:
                return view.getNavGesturalDrawable();
            case 7:
                return view.getNavInContextDrawable();
            case 8:
                return view.getNavDrawerTabsDrawable();
            default:
                return 0;
        }
    }
}
