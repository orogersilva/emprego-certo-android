package com.orogersilva.empregocerto.model;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by note-roger on 20/12/2015.
 */
@Database(name = JobDatabase.NAME, version = JobDatabase.VERSION)
public class JobDatabase {

    // region FIELDS

    public static final String NAME = "Jobs";
    public static final int VERSION = 1;

    // endregion
}
