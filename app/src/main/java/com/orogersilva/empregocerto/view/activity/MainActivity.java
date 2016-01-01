package com.orogersilva.empregocerto.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linkedin.platform.LISessionManager;
import com.orogersilva.empregocerto.R;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    // region FIELDS

    @Inject
    LISessionManager mLISessionManager;

    // endregion

    // region ACTIVITY LIFECYCLE METHODS

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getComponent().inject(this);
    }

    // endregion
}
