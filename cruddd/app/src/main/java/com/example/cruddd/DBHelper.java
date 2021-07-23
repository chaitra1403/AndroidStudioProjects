package com.example.cruddd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "cardb.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table carDetail(ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,model TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists carDetail");
    }
    public Boolean addData(String name, String model) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("model", model);
        long result = DB.insert("carDetail", null, contentValues);
        return result != -1;
    }
    public Cursor getData() {
        SQLiteDatabase DB = this.getReadableDatabase();
        String query = "select * from carDetail";
        return DB.rawQuery(query, null);
    }
    public Boolean updateData(int id,String name, String model) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("model",model);
        Cursor cursor = DB.rawQuery("select * from carDetail where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            long result = DB.update("carDetail", contentValues, "id=?", new String[]{String.valueOf(id)});
            return result != -1;
        } else {
            return false;
        }
    }
    public Boolean deleteCar(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from carDetail where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            db.delete("carDetail", "id" + " = ?", new String[]{String.valueOf(id)});
            return true;
        }
        else{
            return false;
        }
    }
}
