package com.orogersilva.empregocerto.vo;

import android.support.annotation.VisibleForTesting;

import com.orogersilva.empregocerto.model.JobDatabase;
import com.orogersilva.empregocerto.utils.Validation;
import com.orogersilva.empregocerto.utils.exception.ValidationFailedException;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by note-roger on 20/12/2015.
 */
@Table(database = JobDatabase.class)
public class Vacancy extends BaseModel implements Validation {

    // region COLUMNS

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String title;

    @Column
    String description;

    @Column
    double salary;

    // endregion

    // region CONSTRUCTORS

    public Vacancy() {}

    @VisibleForTesting
    public Vacancy(long id, String title, String description, double salary) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
    }

    // endregion

    // region GETTERS AND SETTERS

    public long getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {

        return description;
    }

    public double getSalary() {

        return salary;
    }

    @VisibleForTesting
    public void setSalary(double salary) {

        this.salary = salary;
    }

    // endregion

    // region VALIDATION METHODS

    @Override
    public void validate() {

        if (id <= 0) throw new ValidationFailedException("Invalid vacancy id.");
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Vacancy)) return false;
        if (obj == this) return true;

        Vacancy vacancy = (Vacancy) obj;

        final double ACCEPTABLE_PRECISION = 0.001;

        return vacancy.getId() == this.getId() &&
                vacancy.getTitle().equals(this.getTitle()) &&
                vacancy.getDescription().equals(this.getDescription()) &&
                (Math.abs(vacancy.getSalary() - this.getSalary()) < ACCEPTABLE_PRECISION);
    }

    // endregion
}
