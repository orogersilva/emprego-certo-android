package com.orogersilva.empregocerto.vo;

import com.orogersilva.empregocerto.model.JobDatabase;
import com.orogersilva.empregocerto.utils.Validation;
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

    // region GETTERS AND SETTERS

    public long getId() {

        return id;
    }

    // endregion

    // region VALIDATION METHODS

    @Override
    public void validate() {

        // TODO: 20/12/2015 To implement.
    }

    // endregion
}
