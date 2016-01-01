package com.orogersilva.empregocerto.di.component;

import com.orogersilva.empregocerto.di.module.AuthenticationModule;
import com.orogersilva.empregocerto.di.module.PersistenceModule;
import com.orogersilva.empregocerto.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by note-roger on 20/12/2015.
 */
@Singleton
@Component(
        modules = {AuthenticationModule.class, PersistenceModule.class}
)
public interface AppComponent {

    // region INJECT METHODS

    void inject(MainActivity mainActivity);

    // endregion
}
