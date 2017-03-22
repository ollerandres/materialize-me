package com.andevcba.materializeme.presentation.main.fragment;

import com.andevcba.materializeme.domain.model.Pattern;

import java.util.List;

/**
 * @author Andres Oller.
 */

interface PatternsFragmentContract {

    interface View {

        void setAdapter(List<Pattern> patterns);

        void setLinearLayout();

        void setGridLayout(int columnCount);

        int getLinearDrawable();

        int getGridDrawable();
    }

    interface Presenter {

        void loadData();

        void chooseLayoutColumns();

        void setColumnCount(int columnCount);

        int chooseMenuLayoutItemDrawable();

        void changeLayoutDesign();
    }
}
