package com.orogersilva.empregocerto.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orogersilva.empregocerto.EmpregoCertoApp;
import com.orogersilva.empregocerto.di.component.AppComponent;

/**
 * Created by note-roger on 31/12/2015.
 */
public class BaseActivity extends AppCompatActivity {

    // region FIELDS

    private AppComponent mComponent;

    // endregion

    // region ACTIVITY LIFECYCLE METHODS

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mComponent = ((EmpregoCertoApp) getApplicationContext()).getAppComponent();
    }

    // endregion

    // region PROTECTED METHODS

    protected AppComponent getComponent() {

        return mComponent;
    }

    // endregion
}
