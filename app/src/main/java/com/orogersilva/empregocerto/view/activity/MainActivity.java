package com.orogersilva.empregocerto.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.linkedin.platform.LISessionManager;

import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;
import com.orogersilva.empregocerto.BuildConfig;
import com.orogersilva.empregocerto.R;

import java.security.MessageDigest;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    // region FIELDS

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    LISessionManager mLISessionManager;

    // endregion

    // region ACTIVITY LIFECYCLE METHODS

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getComponent().inject(this);

        if (BuildConfig.FLAVOR.equals("candidate")) {

            // Sign in Linkedin.
            mLISessionManager.init(this, buildScope(), new AuthListener() {

                @Override
                public void onAuthSuccess() {

                    startActivity(JobActivity.intentFor(MainActivity.this));
                }

                @Override
                public void onAuthError(LIAuthError error) {

                    Log.d(TAG, "Authentication is failed.");
                }

            }, false);

        } else if (BuildConfig.FLAVOR.equals("hr")) {

        }
    }

    // endregion

    // region UTILITARY METHODS

    private Scope buildScope() {

        return Scope.build(Scope.R_BASICPROFILE);
    }

    // endregion

    // region PROTECTED METHODS

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        mLISessionManager.onActivityResult(this, requestCode, resultCode, data);
    }

    // endregion
}
