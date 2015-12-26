package com.orogersilva.empregocerto.di.module;

import android.database.sqlite.SQLiteDatabase;

import com.orogersilva.empregocerto.EmpregoCertoApp;
import com.orogersilva.empregocerto.model.JobDatabase;
import com.orogersilva.empregocerto.model.VacancyModel;
import com.raizlabs.android.dbflow.config.FlowManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by note-roger on 26/12/2015.
 */
@Module
public class PersistenceModule {

    // region FIELDS

    private final EmpregoCertoApp mApp;

    // endregion

    // region CONSTRUCTORS

    public PersistenceModule(EmpregoCertoApp app) {

        mApp = app;
    }

    // region DEPENDENCY PROVIDERS

    @Provides
    @Singleton
    public SQLiteDatabase provideDatabase() {

        return FlowManager.getDatabase(JobDatabase.NAME).getWritableDatabase();
    }

    @Provides
    @Singleton
    public VacancyModel provideVacancyModel(SQLiteDatabase database) {

        return new VacancyModel(mApp, database);
    }

    // endregion
}
