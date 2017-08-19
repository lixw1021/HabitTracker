package com.xianwei.habittracker.data;

import android.provider.BaseColumns;

import java.security.PublicKey;

/**
 * Created by xianwei li on 8/18/2017.
 */

public final class HabitContract {

    public static class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "exercise";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_TYPE  = "type";
        public final static String COLUMN_TIME  = "time";
        public final static String COLUMN_NOTE  = "note";

        public final static int EXERCISE_TYPE_RUNNING = 1;
        public final static int EXERCISE_TYPE_SWIMMING = 2;
        public final static int EXERCISE_TYPE_YOGA = 3;
        public final static int EXERCISE_TYPE_GYM = 4;
        public final static int EXERCISE_TYPE_OTHER = 0;
    }
}
