package com.orogersilva.empregocerto.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.orogersilva.empregocerto.R;

/**
 * Created by note-roger on 01/01/2016.
 */
public class JobActivity extends BaseActivity {

    // region ACTIVITY LIFECYCLE METHODS

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
    }

    // endregion

    // region STATIC METHODS

    public static Intent intentFor(Context source) {

        return new Intent(source, JobActivity.class);
    }

    // endregion
}
