package com.orogersilva.empregocerto.model;

import android.support.test.runner.AndroidJUnit4;

import com.orogersilva.empregocerto.BaseTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by note-roger on 20/12/2015.
 */
@RunWith(AndroidJUnit4.class)
public class VacancyModelTest extends BaseTest {

    // region FIELDS

    @Inject
    VacancyModel mVacancyModel;

    // endregion

    // region SETUP

    @Before
    public void setUp() throws Exception {

        getTestComponent().inject(this);
    }

    // endregion

    // region TEST METHODS

    @Test(expected = NullPointerException.class)
    public void testSaveWhenVacancyIsNullThrowsNullPointerException() throws Exception {

        // ACT / ASSERT

        mVacancyModel.save(null);
    }

    // endregion

    // region TEARDOWN

    @After
    public void tearDown() throws Exception {
    }

    // endregion
}
