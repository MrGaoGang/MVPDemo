package gaogang.mvpdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 高岗 on 2017/8/20.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME="test.db";
    private static final int VERSION=1;

    public DBHelper(Context context) {
        super(context,TABLE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists person(id integer primary key autoincrement,name varchar,age integer) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
