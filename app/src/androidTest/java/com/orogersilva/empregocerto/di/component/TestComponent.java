package com.orogersilva.empregocerto.di.component;

import com.orogersilva.empregocerto.di.module.TestAuthenticationModule;
import com.orogersilva.empregocerto.di.module.TestPersistenceModule;
import com.orogersilva.empregocerto.model.VacancyModelTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by note-roger on 20/12/2015.
 */
@Singleton
@Component(
        modules = {TestPersistenceModule.class, TestAuthenticationModule.class}
)
public interface TestComponent extends AppComponent {

    void inject(VacancyModelTest vacancyModelTest);
}
