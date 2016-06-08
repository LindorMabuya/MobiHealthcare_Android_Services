package com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mabuya.lindor.mobilehealthacre_android_services.config.databases.DBConstants;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PlanRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LILO on 2016/05/07.
 */
public class PlanRepositoryImpl extends SQLiteOpenHelper implements PlanRepository {
    public static final String TABLE_NAME = "settings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_RISK = "riskCover";
    public static final String COLUMN_INCOME = "fixedIncomeReturn";
    public static final String COLUMN_TAX = "tax";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RISK + " TEXT UNIQUE NOT NULL , "
            + COLUMN_INCOME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_TAX + " TEXT NOT NULL );";


    public PlanRepositoryImpl(Context context) {
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
    public Plan findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_RISK,
                        COLUMN_INCOME,
                        COLUMN_TAX},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Plan plan = new Plan.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .riskCover(cursor.getString(cursor.getColumnIndex(COLUMN_RISK)))
                    .fixedIncomeReturn(cursor.getDouble(cursor.getColumnIndex(COLUMN_INCOME)))
                    .tax(cursor.getDouble(cursor.getColumnIndex(COLUMN_TAX)))
                    .build();

            return plan;
        } else {
            return null;
        }
    }

    @Override
    public Plan save(Plan entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_RISK, entity.getRiskCover());
        values.put(COLUMN_INCOME, entity.getFixedIncomeReturn());
        values.put(COLUMN_TAX, entity.getTax());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Plan insertedEntity = new Plan.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Plan update(Plan entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_RISK, entity.getRiskCover());
        values.put(COLUMN_INCOME, entity.getFixedIncomeReturn());
        values.put(COLUMN_TAX, entity.getTax());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Plan delete(Plan entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Plan> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Plan> planSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Plan plan = new Plan.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .riskCover(cursor.getString(cursor.getColumnIndex(COLUMN_RISK)))
                        .fixedIncomeReturn(cursor.getDouble(cursor.getColumnIndex(COLUMN_INCOME)))
                        .tax(cursor.getDouble(cursor.getColumnIndex(COLUMN_TAX)))
                        .build();
                planSet.add(plan);
            } while (cursor.moveToNext());
        }
        return planSet;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
