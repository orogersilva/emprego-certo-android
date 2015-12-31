package com.orogersilva.empregocerto.di.component;

import com.orogersilva.empregocerto.di.module.AuthenticationModule;
import com.orogersilva.empregocerto.di.module.PersistenceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by note-roger on 20/12/2015.
 */
@Singleton
@Component(
        modules = {PersistenceModule.class, AuthenticationModule.class}
)
public interface AppComponent {
}
