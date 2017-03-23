package com.andevcba.materializeme.presentation.main.adapter;

import com.andevcba.materializeme.domain.model.Pattern;
import com.andevcba.materializeme.presentation.main.fragment.PatternsFragment.OnListFragmentInteractionListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Andres Oller.
 */
public class PatternsAdapterPresenterTest {

    PatternsAdapterPresenter presenter;

    @Mock
    PatternsAdapterContract.View view;

    @Mock
    OnListFragmentInteractionListener listener;

    @Mock
    Pattern pattern;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new PatternsAdapterPresenter(view);
    }

    @Test
    public void patternSelected_ShouldCallPatternSelected_IfListenerAndViewAreNotNull() throws Exception {
        presenter.patternSelected(listener, pattern);

        verify(view).patternSelected(pattern);
    }

    @Test
    public void patternSelected_ShouldNotCallPatternSelected_IfListenerIsNull() throws Exception {
        listener = null;

        presenter.patternSelected(listener, pattern);

        verify(view, never()).patternSelected(pattern);
    }

    @Test
    public void patternSelected_ShouldNotCallPatternSelected_IfViewIsNull() throws Exception {
        presenter = new PatternsAdapterPresenter(null);

        presenter.patternSelected(listener, pattern);

        verify(view, never()).patternSelected(pattern);
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavDrawerDrawable_IfPatternIdIsZero() throws Exception {
        Pattern pattern = new Pattern("0", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavDrawerDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavNestedDrawable_IfPatternIdIsOne() throws Exception {
        Pattern pattern = new Pattern("1", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavNestedDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavExpandingDrawable_IfPatternIdIsTwo() throws Exception {
        Pattern pattern = new Pattern("2", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavExpandingDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavBottomDrawable_IfPatternIdIsThree() throws Exception {
        Pattern pattern = new Pattern("3", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavBottomDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavTabsDrawable_IfPatternIdIsFour() throws Exception {
        Pattern pattern = new Pattern("4", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavTabsDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavEmbeddedDrawable_IfPatternIdIsFive() throws Exception {
        Pattern pattern = new Pattern("5", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavEmbeddedDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavGesturalDrawable_IfPatternIdIsSix() throws Exception {
        Pattern pattern = new Pattern("6", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavGesturalDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavInContextDrawable_IfPatternIdIsSeven() throws Exception {
        Pattern pattern = new Pattern("7", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavInContextDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnNavDrawerTabsDrawable_IfPatternIdIsEight() throws Exception {
        Pattern pattern = new Pattern("8", "", "", "");

        presenter.getDrawableForPattern(pattern);

        verify(view).getNavDrawerTabsDrawable();
    }

    @Test
    public void getDrawableForPattern_ShouldReturnZero_IfPatternIdIsNotFound() throws Exception {
        Pattern pattern = new Pattern("9", "", "", "");

        assertEquals("Drawable should be 0", 0, presenter.getDrawableForPattern(pattern));
    }
}