package com.xianwei.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xianwei.habittracker.data.HabitContract.HabitEntry;
import com.xianwei.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    HabitDbHelper habitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habitDbHelper = new HabitDbHelper(this);

        Button button = (Button) findViewById(R.id.add_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                displayData();
            }
        });

    }

    void insertData() {
        SQLiteDatabase db = habitDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_TYPE, HabitEntry.EXERCISE_TYPE_GYM);
        values.put(HabitEntry.COLUMN_TIME, 30);
        values.put(HabitEntry.COLUMN_NOTE, "feels good");

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    void displayData() {
        SQLiteDatabase db = habitDbHelper.getReadableDatabase();
        String[] project = {HabitEntry._ID,
                            HabitEntry.COLUMN_TYPE,
                            HabitEntry.COLUMN_TIME,
                            HabitEntry.COLUMN_NOTE};

        Cursor cursor = db.query(HabitEntry.TABLE_NAME, project, null, null, null, null, null);

        try {
            int idIndex = cursor.getColumnIndex(HabitEntry._ID);
            int typeIndex = cursor.getColumnIndex(HabitEntry.COLUMN_TYPE);
            int timeIndex = cursor.getColumnIndex(HabitEntry.COLUMN_TIME);
            int noteIndex = cursor.getColumnIndex(HabitEntry.COLUMN_NOTE);

            TextView textView = (TextView) findViewById(R.id.text_view);
            textView.setText(" Number of rows: " + cursor.getCount());
            textView.append("\n id - type - time - note ");

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idIndex);
                int type = cursor.getInt(typeIndex);
                int time = cursor.getInt(timeIndex);
                String note = cursor.getString(noteIndex);
                textView.append("\n" + id +" - " + type + " - " + time + " - " + note);
            }
        } finally {
            cursor.close();
        }
    }
}
