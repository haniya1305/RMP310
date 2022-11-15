package com.example.ratemypritch;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_Helper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DB_Helper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table ratings(ratingid INTEGER primary key, rating FLOAT)");
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table reviews(reviewid INTEGER primary key, reviewhead TEXT, reviewbot TEXT, ratingid INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists ratings");
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists reviews");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean insertReview(int reviewid, String reviewhead, String reviewbot, int ratingid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("reviewid", reviewid);
        contentValues.put("reviewhead", reviewhead);
        contentValues.put("reviewbot", reviewbot);
        contentValues.put("ratingid", ratingid);
        long result = MyDB.insert("reviews", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertRatings(int ratingid, Float rating){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("ratingid", ratingid);
        contentValues.put("rating", rating);
        long result = MyDB.insert("ratings", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public int ratingidassign() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from ratings", new String[]{});
        return cursor.getCount();
    }

    public int reviewidassign() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from reviews", new String[]{});
        return cursor.getCount();
    }

    public int getRatingidatreview(int reviewid) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String revid = String.valueOf(reviewid);
        Cursor cursor = MyDB.rawQuery("Select * from reviews where reviewid = ?", new String[]{revid});
        cursor.moveToFirst();
        return cursor.getInt(3);
    }

    public float getRating(int ratingid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String ratid = String.valueOf(ratingid);
        Cursor cursor = MyDB.rawQuery("Select * from ratings where ratingid = ?", new String[]{ratid});
        cursor.moveToFirst();
        Log.i("ratingfloat", String.valueOf(cursor.getFloat(1)));
        return cursor.getFloat(1);
    }

    public String getReviewtop(int reviewid) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String revid = String.valueOf(reviewid);
        Cursor cursor = MyDB.rawQuery("Select * from reviews where reviewid = ?", new String[]{revid});
        cursor.moveToFirst();
        Log.i("reviewtopat2", String.valueOf(cursor.getString(1)));
        return cursor.getString(1);
    }

    public String getReviewbot(int reviewid) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String revid = String.valueOf(reviewid);
        Cursor cursor = MyDB.rawQuery("Select * from reviews where reviewid = ?", new String[]{revid});
        cursor.moveToFirst();
        Log.i("reviewBOTat2", String.valueOf(cursor.getString(2)));
        return cursor.getString(2);
    }


    public float avgreview(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select AVG(rating) AS avgrating FROM ratings", null);
        cursor.moveToFirst();
        return cursor.getFloat(0);
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
