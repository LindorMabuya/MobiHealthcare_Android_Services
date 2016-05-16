package com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mabuya.lindor.mobilehealthacre_android_services.config.databases.DBConstants;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.BenefitSet;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.BenefitSetRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LILO on 2016/05/07.
 */
public class BenefitSetRepositoryImpl extends SQLiteOpenHelper implements BenefitSetRepository {
    public static final String TABLE_NAME = "benefitSet";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_INSURANCECOVERAGE = "insuranceCoverage";
    public static final String COLUMN_BENEFIT = "benefit";
    public static final String COLUMN_BENEFITCOST = "benefitCost";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_INSURANCECOVERAGE + " TEXT NOT NULL , "
            +COLUMN_BENEFIT + " TEXT NOT NULL , "
            + COLUMN_BENEFITCOST + " TEXT NOT NULL );";

    public BenefitSetRepositoryImpl(Context context) {
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
    public BenefitSet findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_INSURANCECOVERAGE,
                        COLUMN_BENEFIT,
                        COLUMN_BENEFITCOST},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final BenefitSet benefitSet = new BenefitSet.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .insuranceCoverage(cursor.getString(cursor.getColumnIndex(COLUMN_INSURANCECOVERAGE)))
                    .benefit(cursor.getString(cursor.getColumnIndex(COLUMN_BENEFIT)))
                    .benefitCost(cursor.getDouble(cursor.getColumnIndex(COLUMN_BENEFITCOST)))
                    .build();

            return benefitSet;
        } else {
            return null;
        }
    }

    @Override
    public BenefitSet save(BenefitSet entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_INSURANCECOVERAGE, entity.getInsuranceCoverage());
        values.put(COLUMN_BENEFIT, entity.getBenefit());
        values.put(COLUMN_BENEFITCOST, entity.getBenefitCost());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        BenefitSet insertedEntity = new BenefitSet.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public BenefitSet update(BenefitSet entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_INSURANCECOVERAGE, entity.getInsuranceCoverage());
        values.put(COLUMN_BENEFIT, entity.getBenefit());
        values.put(COLUMN_BENEFITCOST, entity.getBenefitCost());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public BenefitSet delete(BenefitSet entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<BenefitSet> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<BenefitSet> settings = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final BenefitSet benefitSet = new BenefitSet.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .insuranceCoverage(cursor.getString(cursor.getColumnIndex(COLUMN_INSURANCECOVERAGE)))
                        .benefit(cursor.getString(cursor.getColumnIndex(COLUMN_BENEFIT)))
                        .benefitCost(cursor.getDouble(cursor.getColumnIndex(COLUMN_BENEFITCOST)))
                        .build();
                settings.add(benefitSet);
            } while (cursor.moveToNext());
        }
        return settings;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;    }
}
