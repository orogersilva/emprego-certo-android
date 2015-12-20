package com.orogersilva.empregocerto.di.module;

import android.database.sqlite.SQLiteDatabase;

import com.orogersilva.empregocerto.EmpregoCertoApp;
import com.orogersilva.empregocerto.model.VacancyModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

    @Provides
    @Singleton
    public VacancyModel provideVacancyModel(SQLiteDatabase database) {

        return new VacancyModel(mApp, database);
    }

    // endregion
}
