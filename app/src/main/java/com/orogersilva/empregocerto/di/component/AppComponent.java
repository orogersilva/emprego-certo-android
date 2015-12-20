package com.orogersilva.empregocerto.di.component;

import com.orogersilva.empregocerto.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by note-roger on 20/12/2015.
 */
@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {
}
