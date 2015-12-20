package com.orogersilva.empregocerto.model;

import android.database.sqlite.SQLiteDatabase;

import com.orogersilva.empregocerto.EmpregoCertoApp;
import com.orogersilva.empregocerto.di.component.AppComponent;

/**
 * Created by note-roger on 20/12/2015.
 */
public class BaseModel {

    // region FIELDS

    protected final AppComponent mAppComponent;
    protected final SQLiteDatabase mSQLiteDatabase;

    // endregion

    // region CONSTRUCTORS

    public BaseModel(EmpregoCertoApp app, SQLiteDatabase database) {

        mAppComponent = app.getAppComponent();
        mSQLiteDatabase = database;
    }

    // endregion
}
