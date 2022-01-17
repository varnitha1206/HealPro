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
    private static final String TABLE_NAME2 = "doctors";
    private static final String TABLE_NAME3 = "consultations";
    private static final String TABLE_NAME4 = "prescription";
    private static final String TABLE_NAME5 = "Mapping";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String AGE_COL = "age";
    private static final String status = "status";
    private static final String Username_COL = "username";
    private static final String Email_COL = "email";
    private static final String Phone_COL = "phone";
    private static final String Password_COL = "pwd";
    private static final String Specialist_COL = "spd";
    private static final String Gender_COL = "gender";
    private static final String PRES_COL = "pres";
    static int flag = 1;

    public DBhandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + Username_COL + " TEXT,"
                + Email_COL + " TEXT,"
                + Phone_COL + " TEXT,"
                + Password_COL + " TEXT,"
                + Gender_COL + " TEXT);";
        String sql2 = "CREATE TABLE " + TABLE_NAME2 + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Username_COL + " TEXT UNIQUE ,"
                + Password_COL + " TEXT,"
                + Specialist_COL + " TEXT);";
        String sql3 = "CREATE TABLE " + TABLE_NAME3 + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + AGE_COL + " TEXT,"
                + Specialist_COL + " TEXT,"
                + Gender_COL + " TEXT,"
                + Phone_COL + " TEXT,"
                + status + " TEXT);";
        String sql4 = "CREATE TABLE " + TABLE_NAME4 + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + Phone_COL + " TEXT,"
                + PRES_COL + " TEXT);";
        String sql5 = "CREATE TABLE " + TABLE_NAME5 + " ("
                + ID_COL + " INTEGER, "
                + NAME_COL + " TEXT,"
                + Phone_COL + " TEXT);";
        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
    }

    public void addNew(String n, String un, String em, String ph, String pd, String g) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, n);
        values.put(Username_COL, un);
        values.put(Email_COL, em);
        values.put(Phone_COL, ph);
        values.put(Password_COL, pd);
        values.put(Gender_COL, g);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void addDocs() {
        if (flag == 1) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Username_COL, "doctor1");
            values.put(Password_COL, "doctor1");
            values.put(Specialist_COL, "0");
            db.insert(TABLE_NAME2, null, values);
            values.put(Username_COL, "doctor2");
            values.put(Password_COL, "doctor2");
            values.put(Specialist_COL, "1");
            flag = 0;
            db.insert(TABLE_NAME2, null, values);
            db.close();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3 + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4 + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5 + ";");
        onCreate(db);
    }

    // we have created a new method for reading all the courses.
    public int read(String n, String p) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor c = db.rawQuery("Select * from users where username = ? and pwd = ?", new String[]{n, p});
        if (c.moveToFirst()) {
            String s = c.getString(0);
            int num = Integer.parseInt(s);
            return num;
        } else {
            return 0;
        }
    }

    public int readDoctor(String n, String p) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();
        // on below line we are creating a cursor with query to read data from database.
        Cursor c = db.rawQuery("Select * from doctors where username = ? and pwd = ?", new String[]{n, p});
        if (c.moveToFirst()) {
            return c.getInt(0);
        } else {
            return -1;
        }
    }

    public void addConsult(String n, String a, String s, String g, String p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, n);
        values.put(AGE_COL, a);
        values.put(Specialist_COL, s);
        values.put(Gender_COL, g);
        values.put(Phone_COL, p);
        values.put(status, 0);
        db.insert(TABLE_NAME3, null, values);
        db.close();
    }

    public ArrayList<String> list(String s) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> p = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM consultations where spd = " + s + " and status = 0", null);
        if (c.moveToFirst()) {
            do {
                StringBuilder s1 = new StringBuilder();
                s1.append(c.getString(1));
                s1.append("-");
                s1.append(c.getString(5));
                p.add(s1.toString());
                s1.delete(0, s1.length());
            } while (c.moveToNext());
        }
        return p;
    }

    void addPrescriptions(String pname, String p, String ph) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, pname);
        values.put(Phone_COL, ph);
        values.put(PRES_COL, p);
        db.insert(TABLE_NAME4, null, values);
    }

    String finish(String n, String ph) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from consultations where name = ? and phone = ?", new String[]{n, ph});
        if (c.moveToFirst()) {
            db.execSQL("UPDATE " + TABLE_NAME3 + " SET status =1 WHERE name = ? and phone = ?", new String[]{c.getString(1), c.getString(5)});
            return c.getString(3);
        } else {
            return "-1";
        }
    }

    int addmap(int cid, String name, String ph) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_COL, cid);
        values.put(NAME_COL, name);
        values.put(Phone_COL, ph);
        db.insert(TABLE_NAME5, null, values);
        return cid;
    }

    String readmap(int cid, String name, String ph)
    {
        String s = String.valueOf(cid);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from Mapping where name = ? and phone = ?", new String[]{name, ph});
        if (c.moveToFirst())
        {
            if (c.getInt(0)==cid)
            {
                Cursor c1 = db.rawQuery("Select * from prescription where name = ? and phone = ?", new String[]{name, ph});
                if (c1.moveToFirst()) {
                    return c1.getString(3);
                } else {
                    return "Please wait while the doctor uploads the prescription";
                }
            }
            else
            {
                return "You can only view your prescriptions!";
            }
        } else {
            return "Invalid details";
        }
    }
}