package com.andevcba.materializeme.presentation.main.fragment;

import com.andevcba.materializeme.domain.model.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Andres Oller.
 */
public class PatternsFragmentPresenterTest {

    PatternsFragmentPresenter presenter;

    @Mock
    PatternsFragmentContract.View view;

    @Mock
    PatternsFragmentModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new PatternsFragmentPresenter(model);
        presenter.setView(view);
    }

    @Test
    public void loadData_ShouldLoadDataAndSetAdapter_IfViewIsNotNull() throws Exception {
        PatternsFragmentPresenter mockPresenter = spy(new PatternsFragmentPresenter(model));
        mockPresenter.setView(view);

        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern("0", "", "", ""));
        when(mockPresenter.populatePatternsList()).thenReturn(patterns);

        mockPresenter.loadData();

        verify(view).setAdapter(patterns);
    }

    @Test
    public void loadData_ShouldNotLoadDataAndSetAdapter_IfViewIsNull() throws Exception {
        PatternsFragmentPresenter mockPresenter = spy(new PatternsFragmentPresenter(model));
        mockPresenter.setView(null);

        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern("0", "", "", ""));
        when(mockPresenter.populatePatternsList()).thenReturn(patterns);

        mockPresenter.loadData();

        verify(view, never()).setAdapter(patterns);
    }

    @Test
    public void chooseLayoutColumns_ShouldSetLinearLayout_IfColumnCountIsOne() throws Exception {
        when(model.getColumnCount()).thenReturn(1);

        presenter.chooseLayoutColumns();

        verify(view).setLinearLayout();
    }
    @Test
    public void chooseLayoutColumns_ShouldSetGridLayout_IfColumnCountIsMoreThanOne() throws Exception {
        when(model.getColumnCount()).thenReturn(2);

        presenter.chooseLayoutColumns();

        verify(view).setGridLayout(2);
    }

    @Test
    public void setColumnCount_ShouldCallSetColumnCountOnModel() throws Exception {
        presenter.setColumnCount(0);

        verify(model).setColumnCount(0);
    }

    @Test
    public void chooseMenuLayoutItemDrawable_ShouldReturnLinearDrawable_IfColumnCountIsMoreThanOne() throws Exception {
        when(model.getColumnCount()).thenReturn(2);

        presenter.chooseMenuLayoutItemDrawable();

        verify(view).getLinearDrawable();
    }

    @Test
    public void chooseMenuLayoutItemDrawable_ShouldReturnGridDrawable_IfColumnCountIsOne() throws Exception {
        when(model.getColumnCount()).thenReturn(1);

        presenter.chooseMenuLayoutItemDrawable();

        verify(view).getGridDrawable();
    }

    @Test
    public void chooseMenuLayoutItemDrawable_ShouldReturnZero_IfViewIsNull() throws Exception {
        PatternsFragmentPresenter mockPresenter = spy(new PatternsFragmentPresenter(model));
        mockPresenter.setView(null);

        assertEquals("Drawable should be 0 when view is null", 0, mockPresenter.chooseMenuLayoutItemDrawable());
    }

    @Test
    public void changeLayoutDesign_ShouldSetColumnCountToTwoAndSetGridLayout_IfColumnCountIsOne() throws Exception {
        when(model.getColumnCount()).thenReturn(1);

        presenter.changeLayoutDesign();

        verify(model).setColumnCount(2);
        verify(view).setGridLayout(2);
    }

    @Test
    public void changeLayoutDesign_ShouldSetColumnCountToOneAndSetLinearLayout_IfColumnCountIsTwo() throws Exception {
        when(model.getColumnCount()).thenReturn(2);

        presenter.changeLayoutDesign();

        verify(model).setColumnCount(1);
        verify(view).setLinearLayout();
    }
}