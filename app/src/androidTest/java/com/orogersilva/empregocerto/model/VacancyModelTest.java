package com.orogersilva.empregocerto.model;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.orogersilva.empregocerto.BaseTest;
import com.orogersilva.empregocerto.utils.exception.ValidationFailedException;
import com.orogersilva.empregocerto.vo.Vacancy;

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

    @SmallTest
    @Test(expected = NullPointerException.class)
    public void saveWhenVacancyIsNullThrowsNullPointerException() throws Exception {

        // ACT / ASSERT

        mVacancyModel.save(null);
    }

    @SmallTest
    @Test(expected = ValidationFailedException.class)
    public void saveWhenVacancyIdIsInvalidThrowsValidationFailedException() throws Exception {

        // ARRANGE

        final long INVALID_ID = 0;
        final String TITLE = "";
        final String DESCRIPTION = "";
        final double SALARY = 0;

        final String EXPECTED_EXCEPTION_MESSAGE = "Invalid vacancy id.";
        final String ASSERT_ERROR_MESSAGE = "Unexpected expection!";

        Vacancy vacancyWithInvalidId = new Vacancy(INVALID_ID, TITLE, DESCRIPTION, SALARY);

        // ACT

        try {

            mVacancyModel.save(vacancyWithInvalidId);

        } catch (ValidationFailedException e) {

            // ASSERT

            assertEquals(ASSERT_ERROR_MESSAGE, EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
            throw e;
        }

        fail("ValidationFailedException did not throw!");
    }

    @MediumTest
    @Test
    public void saveWhenIsNewVacancyThenSaveIsSuccessuful() throws Exception {

        // ARRANGE

        final long ID = 1;
        final String TITLE = "Programmer";
        final String DESCRIPTION = "Responsible for developing software.";
        final double SALARY = 3000.0;

        final String ASSERT_ERROR_MESSAGE = "Vacancies must be equals!";

        Vacancy expectedVacancy = new Vacancy(ID, TITLE, DESCRIPTION, SALARY);

        // ACT

        mVacancyModel.save(expectedVacancy);

        // ASSERT

        Vacancy vacancyRetrievedFromDatabase = mVacancyModel.load(ID);

        assertEquals(ASSERT_ERROR_MESSAGE, expectedVacancy, vacancyRetrievedFromDatabase);
    }

    @MediumTest
    @Test
    public void saveWhenVacancyExistsThenUpdateVacancyWithSuccess() throws Exception {

        // ARRANGE

        final long ID = 1;
        final String TITLE = "Programmer";
        final String DESCRIPTION = "Responsible for developing software.";
        final double SALARY = 3000.0;

        final String ASSERT_ERROR_MESSAGE = "Vacancies must be equals!";

        Vacancy expectedVacancy = new Vacancy(ID, TITLE, DESCRIPTION, SALARY);

        final double NEW_SALARY = 3500.0;

        // ACT

        mVacancyModel.save(expectedVacancy);
        expectedVacancy.setSalary(NEW_SALARY);
        mVacancyModel.save(expectedVacancy);

        // ASSERT

        Vacancy vacancyRetrievedFromDatabase = mVacancyModel.load(ID);

        assertEquals(ASSERT_ERROR_MESSAGE, expectedVacancy, vacancyRetrievedFromDatabase);
    }

    @MediumTest
    @Test
    public void loadWhenVacancyIdNotExistsThenReturnsNull() throws Exception {

        // ARRANGE

        final long INVALID_ID = 0;

        final String ASSERT_ERROR_MESSAGE = "Vacancy object must be null!";

        // ACT

        Vacancy vacancyRetrievedFromDatabase = mVacancyModel.load(INVALID_ID);

        // ASSERT

        assertNull(ASSERT_ERROR_MESSAGE, vacancyRetrievedFromDatabase);
    }

    @MediumTest
    @Test
    public void loadWhenVacancyIdIsExistsThenReturnsVacancy() throws Exception {

        // ARRANGE

        final long ID = 1;
        final String TITLE = "Programmer";
        final String DESCRIPTION = "Responsible for developing software.";
        final double SALARY = 3000.0;

        final String ASSERT_ERROR_MESSAGE = "";

        Vacancy expectedVacancy = new Vacancy(ID, TITLE, DESCRIPTION, SALARY);

        // ACT

        mVacancyModel.save(expectedVacancy);

        Vacancy vacancyRetrievedFromDatabase = mVacancyModel.load(ID);

        // ASSERT

        assertEquals(ASSERT_ERROR_MESSAGE, expectedVacancy, vacancyRetrievedFromDatabase);
    }

    // endregion

    // region TEARDOWN

    @After
    public void tearDown() throws Exception {
    }

    // endregion
}
