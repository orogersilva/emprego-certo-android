package com.orogersilva.empregocerto;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.orogersilva.empregocerto.di.component.AppComponent;
import com.orogersilva.empregocerto.di.component.DaggerAppComponent;
import com.orogersilva.empregocerto.di.module.AuthenticationModule;
import com.orogersilva.empregocerto.di.module.PersistenceModule;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by note-roger on 20/12/2015.
 */
public class EmpregoCertoApp extends Application {

    // region FIELDS

    private AppComponent mAppComponent;

    // endregion

    // region APPLICATION LIFECYCLE METHODS

    @Override
    public void onCreate() {

        super.onCreate();

        // Initializing DBFlow...
        FlowManager.init(this);

        // Initializing dependency graph...
        mAppComponent = DaggerAppComponent.builder()
                .authenticationModule(new AuthenticationModule(this))
                .persistenceModule(new PersistenceModule(this))
                .build();
    }

    // endregion

    // region GETTERS AND SETTERS

    public AppComponent getAppComponent() {

        return mAppComponent;
    }

    @VisibleForTesting
    public void setTestComponent(AppComponent appComponent) {

        mAppComponent = appComponent;
    }

    // endregion
}
