package com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mabuya.lindor.mobilehealthacre_android_services.config.databases.DBConstants;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PayerRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LILO on 2016/05/07.
 */
public class PayerRepositoryImpl extends SQLiteOpenHelper implements PayerRepository {
    public static final String TABLE_NAME = "settings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUM = "accNum";
    public static final String COLUMN_TYPE = "accType";
    public static final String COLUMN_NAME = "bankName";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUM + " TEXT UNIQUE NOT NULL , "
            + COLUMN_TYPE + " TEXT UNIQUE NOT NULL , "
            + COLUMN_NAME + " TEXT NOT NULL );";


    public PayerRepositoryImpl(Context context) {
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
    public Payer findById(Long id) {
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NUM,
                        COLUMN_TYPE,
                        COLUMN_NAME},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Payer payer = new Payer.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .accNum(cursor.getString(cursor.getColumnIndex(COLUMN_NUM)))
                    .accType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)))
                    .bankname(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();

            return payer;
        } else {
            return null;
        }
    }

    @Override
    public Payer save(Payer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NUM, entity.getAccNum());
        values.put(COLUMN_TYPE, entity.getAccType());
        values.put(COLUMN_NAME, entity.getBankName());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Payer insertedEntity = new Payer.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Payer update(Payer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NUM, entity.getAccNum());
        values.put(COLUMN_TYPE, entity.getAccType());
        values.put(COLUMN_NAME, entity.getBankName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Payer delete(Payer entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Payer> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Payer> payers = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Payer payer = new Payer.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .accNum(cursor.getString(cursor.getColumnIndex(COLUMN_NUM)))
                        .accType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)))
                        .bankname(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                payers.add(payer);
            } while (cursor.moveToNext());
        }
        return payers;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
