package com.example.termproject0502;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(com.example.termproject0502.DataBases.CreateDB._CREATE0);
        db.execSQL(com.example.termproject0502.DataBases.CreateDB._CREATE1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ com.example.termproject0502.DataBases.CreateDB._TABLENAME0);
        db.execSQL("DROP TABLE IF EXISTS "+ com.example.termproject0502.DataBases.CreateDB._TABLENAME1);
        onCreate(db);
    }
    public void create(){
        mDBHelper.onCreate(mDB);
    }
    public void close(){
        mDB.close();
    }

    //Delete DB in user_table
    public boolean deleteColumn1(Long id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(com.example.termproject0502.DataBases.CreateDB._TABLENAME1, "_id="+id, null) > 0;
    }
    public boolean insertData( String[] nowData,Long idx){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Log.d("DBHelper nowdata 0: ",nowData[0]);
        Log.d("DBHelper nowdata 1: ",nowData[1]);
        Log.d("DBHelper nowdata 2: ",nowData[2]);
        Log.d("DBHelper nowdata 3: ",nowData[3]);
        Log.d("DBHelper nowdata 4: ",nowData[4]);
        Log.d("DBHelper nowdata 5: ",nowData[5]);
        Log.d("DBHelper nowdata 6: ",nowData[6]);
        Log.d("DBHelper nowdata 7: ",nowData[7]);
        values.put(com.example.termproject0502.DataBases.CreateDB.NAME,nowData[0]);
        values.put(com.example.termproject0502.DataBases.CreateDB.SUGAR,Long.parseLong(nowData[1]));
        values.put(com.example.termproject0502.DataBases.CreateDB.ALCOHOL,Long.parseLong(nowData[2]));
        values.put(com.example.termproject0502.DataBases.CreateDB.BODY,Long.parseLong(nowData[3]));
        values.put(com.example.termproject0502.DataBases.CreateDB.UNIQUE_,Long.parseLong(nowData[4]));
        values.put(com.example.termproject0502.DataBases.CreateDB.BASE,nowData[5]);
        values.put(com.example.termproject0502.DataBases.CreateDB._ID,nowData[6]);
        long result = db.insert(com.example.termproject0502.DataBases.CreateDB._TABLENAME1,null,values);
        if(result==-1){
            Log.d("Insert Error"," error");
            return false;
        }
        else{
            Log.d("Insert result", String.valueOf(result));
            return true;
        }
    }
    public ArrayList<Cocktail> getAllData0(){
        ArrayList<Cocktail> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+com.example.termproject0502.DataBases.CreateDB._TABLENAME0,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            int sugar = cursor.getInt(1);
            int alcohol = cursor.getInt(2);
            int body = cursor.getInt(3);
            int unique_ = cursor.getInt(4);
            String base = cursor.getString(5);
            int _id = cursor.getInt(6);
            Cocktail cocktail = new Cocktail(name,sugar,alcohol,body,unique_,base,_id);
            arrayList.add(cocktail);
        }
        return arrayList;
    }
    public ArrayList<Cocktail> getAllData1(){
        ArrayList<Cocktail> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+com.example.termproject0502.DataBases.CreateDB._TABLENAME1,null);

        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            int sugar = cursor.getInt(1);
            int alcohol = cursor.getInt(2);
            int body = cursor.getInt(3);
            int unique_ = cursor.getInt(4);
            String base = cursor.getString(5);
            int _id = cursor.getInt(6);
            Cocktail cocktail = new Cocktail(name,sugar,alcohol,body,unique_,base,_id);

            Log.d("cursor 0: ",name);
            Log.d("cursor 1: ",Integer.toString(sugar));
            Log.d("cursor 2: ",Integer.toString(alcohol));
            Log.d("cursor 3: ",Integer.toString(body));
            Log.d("cursor 4: ",Integer.toString(unique_));
            Log.d("cursor 5: ",base);
            Log.d("cursor 6: ",Integer.toString(_id));

            arrayList.add(cocktail);
        }
        return arrayList;
    }
}