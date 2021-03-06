package com.orogersilva.empregocerto.model;

import android.database.sqlite.SQLiteDatabase;

import com.orogersilva.empregocerto.EmpregoCertoApp;
import com.orogersilva.empregocerto.di.component.AppComponent;
import com.orogersilva.empregocerto.utils.exception.ValidationFailedException;
import com.orogersilva.empregocerto.vo.Vacancy;
import com.orogersilva.empregocerto.vo.Vacancy_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

/**
 * Created by note-roger on 20/12/2015.
 */
public class VacancyModel extends BaseModel {

    // region CONSTRUCTORS

    public VacancyModel(EmpregoCertoApp app, SQLiteDatabase database) {
        super(app, database);
    }

    // endregion

    // region "SQL STATEMENTS"

    public Vacancy load(long id) {

        return select()
                .from(Vacancy.class)
                .where(Vacancy_Table.id.is(id))
                .querySingle();
    }

    public synchronized void save(Vacancy vacancy) {

        if (vacancy == null)
            throw new NullPointerException();

        try {

            vacancy.validate();

        } catch (ValidationFailedException e) {

            throw e;
        }

        Vacancy existingVacancy = load(vacancy.getId());

        if (existingVacancy == null) {
            vacancy.save();
        } else {
            vacancy.update();
        }
    }

    // endregion
}
