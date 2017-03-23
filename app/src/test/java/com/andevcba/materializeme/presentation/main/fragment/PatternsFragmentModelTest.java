package com.andevcba.materializeme.presentation.main.fragment;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Andres Oller.
 */
public class PatternsFragmentModelTest {

    PatternsFragmentModel model;

    @Before
    public void setUp() throws Exception {
        model = new PatternsFragmentModel();
    }

    @Test
    public void getColumnCount() throws Exception {
        model.setColumnCount(2);
        assertEquals("Column count should be 2", 2, model.getColumnCount());
    }
}