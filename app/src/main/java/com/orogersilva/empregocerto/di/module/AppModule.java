package com.orogersilva.empregocerto.di.module;

import com.orogersilva.empregocerto.EmpregoCertoApp;

import dagger.Module;

/**
 * Created by note-roger on 20/12/2015.
 */
@Module
public class AppModule {

    // region FIELDS

    private final EmpregoCertoApp mApp;

    // endregion

    // region CONSTRUCTORS

    public AppModule(EmpregoCertoApp app) {

        mApp = app;
    }

    // endregion

    // region DEPENDENCY PROVIDERS



    // endregion
}
