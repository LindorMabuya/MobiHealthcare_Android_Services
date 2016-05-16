package com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mabuya.lindor.mobilehealthacre_android_services.config.databases.DBConstants;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.DemographicInfo;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.DemographicInfoRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 213036223 on 4/23/2016.
 */
public class DemographicInfoRepositoryImpl extends SQLiteOpenHelper implements DemographicInfoRepository {
    public static final String TABLE_NAME = "demographicInfo";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_SEX = "sex";
    public static final String COLUMN_STATUS = "maritalStatus";
    public static final String COLUMN_OCCUPATION = "occupation";
    public static final String COLUMN_SALARY = "salary";

    //database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
        + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_AGE + " TEXT NOT NULL, "
            + COLUMN_SEX + " TEXT NOT NULL, "
            + COLUMN_STATUS + " TEXT NOT NULL, "
            + COLUMN_OCCUPATION + " TEXT NOT NULL, "
            + COLUMN_SALARY + " TEXT NOT NULL);";

    public DemographicInfoRepositoryImpl(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close(){
        this.close();
    }

    @Override
    public DemographicInfo findById(Long id) {
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_AGE,
                        COLUMN_SEX,
                        COLUMN_STATUS,
                        COLUMN_OCCUPATION,
                        COLUMN_SALARY},
                COLUMN_ID + " =?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            final DemographicInfo demographicInfo = new DemographicInfo.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                    .sex(cursor.getString(cursor.getColumnIndex(COLUMN_SEX)))
                    .maritalStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)))
                    .occupation(cursor.getString(cursor.getColumnIndex(COLUMN_OCCUPATION)))
                    .salary(cursor.getDouble(cursor.getColumnIndex(COLUMN_SALARY)))
                    .build();
            return demographicInfo;
        }else {
        return null;}
    }

    @Override
    public DemographicInfo save(DemographicInfo entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AGE, entity.getAge());
        values.put(COLUMN_SEX, entity.getSex());
        values.put(COLUMN_STATUS, entity.getMaritalStatus());
        values.put(COLUMN_OCCUPATION, entity.getOccupation());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        DemographicInfo insertedEntity = new DemographicInfo.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public DemographicInfo update(DemographicInfo entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AGE, entity.getAge());
        values.put(COLUMN_SEX, entity.getSex());
        values.put(COLUMN_STATUS, entity.getMaritalStatus());
        values.put(COLUMN_OCCUPATION, entity.getOccupation());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

   }

    @Override
    public DemographicInfo delete(DemographicInfo entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<DemographicInfo> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<DemographicInfo> demographicInfos = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final DemographicInfo setting = new  DemographicInfo .Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                        .sex(cursor.getString(cursor.getColumnIndex(COLUMN_SEX)))
                        .maritalStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)))
                        .occupation(cursor.getString(cursor.getColumnIndex(COLUMN_OCCUPATION)))
                        .salary(cursor.getDouble(cursor.getColumnIndex(COLUMN_SALARY)))
                        .build();
                demographicInfos.add(setting);
            } while (cursor.moveToNext());
        }
        return demographicInfos;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
