package gaogang.mvpdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高岗 on 2017/8/20.
 */
public class DBManage {
    private DBHelper mDBHelper;
    private SQLiteDatabase mSQLiteDatabase;

    public DBManage(Context context){
        mDBHelper=new DBHelper(context);
        mSQLiteDatabase=mDBHelper.getReadableDatabase();

    }


    public List<Person> query(Person person){
        List<Person> list=new ArrayList<>();
        mSQLiteDatabase.beginTransaction();
        Cursor cursor=mSQLiteDatabase.rawQuery("select * from person where age>?",new String[]{String.valueOf(person.age)});

        while (cursor.moveToNext()){
            Person person1=new Person();
            person.age=cursor.getInt(cursor.getColumnIndex("age"));
            person.name=cursor.getString(cursor.getColumnIndex("name"));
            person.id=cursor.getInt(cursor.getColumnIndex("id"));
            list.add(person1);
        }
        cursor.close();
        mSQLiteDatabase.endTransaction();
        return list;
    }


    public void delete(Person person){
        mSQLiteDatabase.beginTransaction();
        mSQLiteDatabase.delete("person","age>?",new String[]{String.valueOf(person.age)});
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();
    }

    public void insert(Person person){

        mSQLiteDatabase.beginTransaction();
     /*   ContentValues contentValues=new ContentValues();
        contentValues.put("age",person.age);
        contentValues.put("name",person.name);


        mSQLiteDatabase.insert("person",null,contentValues);*/
        mSQLiteDatabase.execSQL("insert into person values(null,?,?)",new Object[]{person.name,person.age});
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();
    }

    public void update(Person person){
        mSQLiteDatabase.beginTransaction();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",person.name);
        contentValues.put("age",person.age);
        mSQLiteDatabase.update("person",contentValues,"id=?",new String[]{String.valueOf(person.id)});
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();

    }

    public void DBClose(){
        mSQLiteDatabase.close();

    }
}
