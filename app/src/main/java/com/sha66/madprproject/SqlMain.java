package com.sha66.madprproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SqlMain extends SQLiteOpenHelper {
    public SqlMain(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Users.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Users(ID Integer Primary Key AutoIncrement,Name Text Unique,Email Text Unique);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS Users;");
onCreate(db);
    }
    public void add_user(String name,String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Email",email);
        this.getWritableDatabase().insertOrThrow("Users","",contentValues);
    }
    public void remove_user(String name){
        this.getWritableDatabase().delete("Users","Name='"+name+"'", null);
    }
    public void Update_user(String oldname,String newname){
this.getWritableDatabase().execSQL("UPDATE Users SET NAME='"+newname+"'WHERE NAME='"+oldname+"'");
    }
    public void listAllUsers(TextView textView){
        textView.setText("");
        Cursor cursor= this.getReadableDatabase().rawQuery("Select * from Users",null);
while (cursor.moveToNext()){
    textView.append(cursor.getString(1)+""+cursor.getString(2)+"\n");
}
    }
}
