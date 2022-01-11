package com.example.healpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBhandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "healpro";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String Username_COL = "username";
    private static final String Email_COL = "email";
    private static final String Phone_COL = "phone";
    private static final String Password_COL = "pwd";
    private static final String Gender_COL = "gender";

    public DBhandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + Username_COL + " TEXT,"
                + Email_COL + " TEXT,"
                + Phone_COL + " TEXT,"
                + Password_COL + " TEXT,"
                + Gender_COL + " TEXT)";
        db.execSQL(sql);
    }
    public void addNew(String n, String un, String em, String ph, String pd, String g){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL,n);
        values.put(Username_COL,un);
        values.put(Email_COL,em);
        values.put(Phone_COL,ph);
        values.put(Password_COL,pd);
        values.put(Gender_COL,g);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Data> read(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ", null);
        ArrayList<Data> d1=new ArrayList<Data>();
        if(c.moveToFirst())
        {
            do{
                d1.add(new Data(c.getString(1)))
            }
        }
    }
}