package com.andevcba.materializeme.presentation.main.activity;

import com.andevcba.materializeme.domain.model.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Andres Oller.
 */
public class MainActivityPresenterTest {

    private MainActivityPresenter presenter;

    @Mock
    MainActivityContract.View view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToNavigationDrawerPattern_IfPatternIdIsZero() {
        Pattern pattern = new Pattern("0", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToNavigationDrawerPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToNavigationDrawerNestedPattern_IfPatternIdIsOne() {
        Pattern pattern = new Pattern("1", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToNavigationDrawerNestedPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToNavigationDrawerExpandedPattern_IfPatternIdIsTwo() {
        Pattern pattern = new Pattern("2", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToNavigationDrawerExpandedPattern(pattern);
    }
    @Test
    public void navigateOnCardClicked_ShouldNavigateToBottomNavigationPattern_IfPatternIdIsThree() {
        Pattern pattern = new Pattern("3", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToBottomNavigationPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToTabsNavigationPattern_IfPatternIdIsFour() {
        Pattern pattern = new Pattern("4", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToTabsNavigationPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToEmbeddedScreenPattern_IfPatternIdIsFive() {
        Pattern pattern = new Pattern("5", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToEmbeddedScreenPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToGesturalNavigationPattern_IfPatternIdIsSix() {
        Pattern pattern = new Pattern("6", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToGesturalNavigationPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToInContextNavigationPattern_IfPatternIdIsSeven() {
        Pattern pattern = new Pattern("7", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToInContextNavigationPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldNavigateToNavigationDrawerTabsPattern_IfPatternIdIsEight() {
        Pattern pattern = new Pattern("8", "", "", "");

        presenter.navigateOnCardClicked(pattern);

        verify(view).navigateToNavigationDrawerTabsPattern(pattern);
    }

    @Test
    public void navigateOnCardClicked_ShouldShowSnackBar_IfPatternIdIsNotFound() {
        Pattern pattern = new Pattern("9", "", "", "");;

        presenter.navigateOnCardClicked(pattern);

        verify(view).showEmptyPatternErrorSnackBar();
    }
}