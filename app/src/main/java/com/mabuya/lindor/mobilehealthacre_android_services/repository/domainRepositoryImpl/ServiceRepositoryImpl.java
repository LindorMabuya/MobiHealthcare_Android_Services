package com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mabuya.lindor.mobilehealthacre_android_services.config.databases.DBConstants;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Service;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.ServiceRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LILO on 2016/05/07.
 */
public class ServiceRepositoryImpl extends SQLiteOpenHelper implements ServiceRepository {
    public static final String TABLE_NAME = "settings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_POLICY = "policy";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_POLICY + " TEXT UNIQUE NOT NULL);";


    public ServiceRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
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

    @Override
    public Service findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_POLICY},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Service service = new Service.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                   // .policy(cursor.getString(cursor.getColumnIndex(COLUMN_POLICY)))
                    .build();

            return service;
        } else {
            return null;
        }
    }

    @Override
    public Service save(Service entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        //values.put(COLUMN_POLICY, entity.getPolicy());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Service insertedEntity = new Service.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Service update(Service entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
       // values.put(COLUMN_POLICY, entity.getPolicy());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public Service delete(Service entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Service> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Service> services = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Service service = new Service.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        //.policy(cursor.getString(cursor.getColumnIndex(COLUMN_POLICY)))
                        .build();
                services.add(service);
            } while (cursor.moveToNext());
        }
        return services;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
