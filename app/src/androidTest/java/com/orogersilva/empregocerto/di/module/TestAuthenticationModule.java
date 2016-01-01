package com.orogersilva.empregocerto.di.module;

import android.content.Context;

import com.linkedin.platform.LISessionManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by note-roger on 26/12/2015.
 */
@Module
public class TestAuthenticationModule {

    // region FIELDS

    private Context mContext;

    // endregion

    // region CONSTRUCTORS

    public TestAuthenticationModule(Context context) {

        mContext = context;
    }

    // endregion

    // region DEPENDENCY PROVIDERS

    @Provides
    @Singleton
    public LISessionManager provideLISessionManager() {

        return LISessionManager.getInstance(mContext);
    }

    // endregion
}
