package com.orogersilva.empregocerto;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by note-roger on 20/12/2015.
 */
public class EmpregoCertoApp extends Application {

    // region FIELDS



    // endregion

    // region APPLICATION LIFECYCLE METHODS

    @Override
    public void onCreate() {

        super.onCreate();

        // Initializing DBFlow...
        FlowManager.init(this);
    }

    // endregion
}
