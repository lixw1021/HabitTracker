package com.xianwei.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceActivity;

import com.xianwei.habittracker.data.HabitContract.HabitEntry;

import org.xml.sax.HandlerBase;

/**
 * Created by xianwei li on 8/18/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "ExerciseTracking.db";
    private final static int DATABASE_VERSION = 1;
    String SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitEntry.TABLE_NAME + "("
            + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HabitEntry.COLUMN_TYPE + " INTEGER NOT NULL DEFAULT 0, "
            + HabitEntry.COLUMN_TIME + " INTEGER NOT NULL DEFAULT 0, "
            + HabitEntry.COLUMN_NOTE + " TEXT )";

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
