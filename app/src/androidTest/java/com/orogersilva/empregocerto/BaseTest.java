package com.orogersilva.empregocerto;

import android.support.test.InstrumentationRegistry;
import android.test.AndroidTestCase;

import com.orogersilva.empregocerto.di.component.DaggerAppComponent;
import com.orogersilva.empregocerto.di.component.DaggerTestComponent;
import com.orogersilva.empregocerto.di.component.TestComponent;
import com.orogersilva.empregocerto.di.module.AppModule;
import com.orogersilva.empregocerto.di.module.TestModule;

import org.junit.After;
import org.junit.Before;

/**
 * Created by note-roger on 20/12/2015.
 */
public class BaseTest extends AndroidTestCase {

    // region FIELDS

    private EmpregoCertoApp app;
    private TestComponent mTestComponent;

    // endregion

    // region SETUP

    @Before
    public final void setUpBaseTest() throws Exception {

        super.setUp();

        app = (EmpregoCertoApp) InstrumentationRegistry
                .getTargetContext().getApplicationContext();

        mTestComponent = DaggerTestComponent.builder()
                .testModule(new TestModule(app))
                .build();

        app.setTestComponent(mTestComponent);
    }

    // endregion

    // region GETTERS AND SETTERS

    protected TestComponent getTestComponent() {

        return mTestComponent;
    }

    // endregion

    // region TEARDOWN

    @After
    public void tearDown() throws Exception {

        app = null;
    }

    // endregion
}
