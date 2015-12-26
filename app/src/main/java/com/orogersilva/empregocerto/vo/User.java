package com.orogersilva.empregocerto.vo;

import com.orogersilva.empregocerto.model.JobDatabase;
import com.orogersilva.empregocerto.utils.Validation;
import com.orogersilva.empregocerto.utils.exception.ValidationFailedException;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by note-roger on 26/12/2015.
 */
@Table(database = JobDatabase.class)
public class User extends BaseModel implements Validation {

    // region COLUMNS

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

    // endregion

    // region GETTERS AND SETTERS

    public long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    // endregion

    // region VALIDATION METHODS

    @Override
    public void validate() {

        if (id <= 0) throw new ValidationFailedException("Invalid user id.");
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof User)) return false;
        if (obj == this) return true;

        User user = (User) obj;

        return user.getId() == this.getId() &&
                user.getName().equals(this.getName());
    }

    // endregion
}
