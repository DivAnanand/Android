package com.example.dailyreport2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
           db.execSQL("DROP TABLE IF EXISTS "+Constant.TABLE_NAME);
           onCreate(db);

    }
    // insert info function


    public long insertInfo(String date,String project,String challenge,String difficulty,String staffname, String time,String village, String persongroup, String meetingpoint, String actionpoint, String nextdayplanning)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Constant.C_DATE,date);
        values.put(Constant.C_PROJECT,project);
        values.put(Constant.C_CHALLENGE,challenge);
        values.put(Constant.C_DIFFICULTY,difficulty);
        values.put(Constant.C_STAFFNAME,staffname);
        values.put(Constant.C_TIME, time);
        values.put(Constant.C_VILLAGE, village);
        values.put(Constant.C_PERSONGROUP, persongroup);
        values.put(Constant.C_MEETINGPOINT, meetingpoint);
        values.put(Constant.C_ACTIONPOINT, actionpoint);
        values.put(Constant.C_NEXTDAYPLANNING, nextdayplanning);


        long id=db.insert(Constant.TABLE_NAME,null,values);
        db.close();
        return id;

    }

    //update information
    public void updateInfo(String id,String date,String project,String challenge,String difficulty,String staffname,String time,String village, String persongroup, String meetingpoint, String actionpoint, String nextdayplanning)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Constant.C_DATE,date);
        values.put(Constant.C_PROJECT,project);
        values.put(Constant.C_CHALLENGE,challenge);
        values.put(Constant.C_DIFFICULTY,difficulty);
        values.put(Constant.C_STAFFNAME,staffname);
        values.put(Constant.C_TIME,time);
        values.put(Constant.C_VILLAGE,village);
        values.put(Constant.C_PERSONGROUP,persongroup);
        values.put(Constant.C_MEETINGPOINT,meetingpoint);
        values.put(Constant.C_ACTIONPOINT,actionpoint);
        values.put(Constant.C_NEXTDAYPLANNING,nextdayplanning);

        db.update(Constant.TABLE_NAME, values,Constant.C_ID + "=?",new String[]{id});
        db.close();

    }
    public ArrayList<Model> getAllData(String orderBy)
    {
        ArrayList<Model> arrayList=new ArrayList<>();

        //query for select all info in database

        String selectQuery = " SELECT * FROM "+ Constant.TABLE_NAME + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        //when we select all info from database new get the data from the columns
        if(cursor.getCount() > 0 && cursor.moveToNext())
        {
             do {
                 //do is used because first it gets the data from columns then move to next condition
                 Model model=new Model(

                     ""+cursor.getInt(cursor.getColumnIndex(Constant.C_ID)),
                             ""+cursor.getString(cursor.getColumnIndex(Constant.C_DATE)),
                             ""+cursor.getString(cursor.getColumnIndex(Constant.C_PROJECT)),
                             ""+cursor.getString(cursor.getColumnIndex(Constant.C_CHALLENGE)),
                             ""+cursor.getString(cursor.getColumnIndex(Constant.C_DIFFICULTY)),
                             ""+cursor.getString(cursor.getColumnIndex(Constant.C_STAFFNAME)),
                             ""+cursor.getString(cursor.getColumnIndex(Constant.C_TIME)),
                          ""+cursor.getString(cursor.getColumnIndex((Constant.C_VILLAGE))),
                         ""+cursor.getString(cursor.getColumnIndex(Constant.C_PERSONGROUP)),
                         ""+cursor.getString(cursor.getColumnIndex(Constant.C_MEETINGPOINT)),
                         ""+cursor.getString(cursor.getColumnIndex(Constant.C_ACTIONPOINT)),
                         ""+cursor.getString(cursor.getColumnIndex(Constant.C_NEXTDAYPLANNING))
                     );

                 arrayList.add(model);

             }
             while(cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
    // delete information
    public void deleteInfo(String id)
    {
        SQLiteDatabase db= getWritableDatabase();
        db.delete(Constant.TABLE_NAME,Constant.C_ID + " = ? ", new String[]{id});


    }
}
