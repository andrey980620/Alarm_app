package meme2lz.wumf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseHelper {
    public static final String DB_NAME = "alarmList_2.db";
    private static final int DB_VERSION = 1;

    public static final String TB_NAME = "alarmList_data_2";
    public static final String COL1 = "ID";
    public static final String COL2 = "ATTR_1";
    public static final String COL3 = "ATTR_2";




    private String[] allColumn = {COL1,COL2,COL3};

    public static final String CREATE_QUERY = "CREATE TABLE " + TB_NAME + "( "
            + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL2 + " TEXT NOT NULL, "
            + COL3 + " INT);";

    private SQLiteDatabase db;
    private Context context;

    private DBHandler dbHandler;

    //Constructor for the class DBHelper
    public DatabaseHelper(Context ctx) {
        context = ctx;
    }

    public DatabaseHelper open() throws android.database.SQLException{
        dbHandler = new DBHandler(context);
        db = dbHandler.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHandler.close();
    }

    public SQLiteDatabase getDB(){return db;}



    //This method gets called if you want to add a new note
    public boolean addData(String newDate){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, newDate);
        contentValues.put(COL3, 1);

        long insertId = db.insert(TB_NAME, null, contentValues);
        Log.v("DB: "," inserted with id="+ insertId);
        if (insertId == -1) {
            return false;
        } else {
            return true;
        }
    }

//    //This method gets called if you want to edit the existing note
//    public long updateNote(long idToUpdate, String title, String note, NoteModel.Category category){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_TITLE, title);
//        contentValues.put(COL_NOTE, note);
//        contentValues.put(COL_CATEGORY, category.name() + "");
//        contentValues.put(COL_DATE, Calendar.getInstance().getTimeInMillis()+ "");
//
//        return db.update(TB_NAME, contentValues, COL_ID + " = " + idToUpdate, null);
//
//    }

    public long deleteAlarm(long idToDelete){
        return db.delete(TB_NAME, COL1 + " = " + idToDelete, null);

    }


    //This method gets called in displaying the notes in the ListView
    public ArrayList<AlarmModel> getAll(){
        ArrayList<AlarmModel> arrayAlarms = new ArrayList<AlarmModel>();

        //Grab all the information in our database for the notes in it
        Cursor res = db.query(TB_NAME, allColumn, null, null, null, null, null);

        //Loop through all of the rows (arraynotes) in our database and create new note objects from
        //those rows and add them to our array list
        for (res.moveToLast(); !res.isBeforeFirst(); res.moveToPrevious()){
            AlarmModel alarmModel = cursorToAlarm(res);
            arrayAlarms.add(alarmModel);
        }

        //Close our cursor (Required)
        res.close();
        return arrayAlarms;
    }

    private AlarmModel cursorToAlarm(Cursor res){
        AlarmModel newAlarm = new AlarmModel(res.getLong(0), res.getString(1),res.getInt(2));
        return newAlarm;
    }


    private static class DBHandler extends SQLiteOpenHelper{

        public DBHandler(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST " + TB_NAME);
            onCreate(db);
        }


    }
}
