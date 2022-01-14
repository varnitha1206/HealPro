package com.example.healpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "healpro";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String TABLE_NAME2 = "doctors";
    private static final String TABLE_NAME3 = "consultations";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String AGE_COL="age";
    private static final String status="status";
    private static final String Username_COL = "username";
    private static final String Email_COL = "email";
    private static final String Phone_COL = "phone";
    private static final String Password_COL = "pwd";
    private static final String Specialist_COL = "spd";
    private static final String Gender_COL = "gender";
    public static  final String sql2 = "CREATE TABLE "+ TABLE_NAME2 + " ("
            + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Username_COL + " TEXT,"
            + Password_COL + " TEXT,"
            + Specialist_COL + " TEXT)";
    public static  final String sql3 = "CREATE TABLE "+ TABLE_NAME3 + " ("
            + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_COL + " TEXT,"
            + AGE_COL + " INTEGER,"
            + Specialist_COL + " INTEGER,"
            + Gender_COL + " TEXT,"
            + Phone_COL + " INTEGER,"
            + status + " INTEGER)";

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
        db.execSQL(sql2);
        db.execSQL(sql3);
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
    public void addDocs(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL,"Doctor1");
        values.put(Password_COL,"doctor1");
        values.put(Specialist_COL,"Dermat");
        db.insert(TABLE_NAME2,null,values);
        values.put(NAME_COL,"Doctor2");
        values.put(Password_COL,"doctor2");
        values.put(Specialist_COL,"Orthopedic");
        db.insert(TABLE_NAME2,null,values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }

    // we have created a new method for reading all the courses.
    public int read(String n, String p) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor c = db.rawQuery("Select * from users where username = ? and pwd = ?", new String[]{n,p});
        if (c.moveToFirst()) {
            return 1;
        }
        else{
        return 0;}
    }
    public int readDoctor(String n, String p) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor c = db.rawQuery("Select * from doctors where username = ? and pwd = ?", new String[]{n,p});
        if (c.moveToFirst()) {
            return 1;
        }
        else{
            return 0;}
    }
    public void addConsult(String n, int a,int s, String g,int p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL,n);
        values.put(AGE_COL,a);
        values.put(Specialist_COL,s);
        values.put(Gender_COL,g);
        values.put(Phone_COL,p);
        values.put(status,0);
        db.insert(TABLE_NAME3,null,values);
        db.close();
    }
//    public ArrayList<String> list(int s)
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<String> p = new ArrayList<>();
//        Cursor c = db.rawQuery("SELECT * FROM consultations where spd = "+s+" and status = 0",null);
//        if(c.moveToFirst())
//        {
//            do{
//                p.add(c.getString(0));
//            }while(c.moveToNext());
//        }
//        return p;
//    }
}