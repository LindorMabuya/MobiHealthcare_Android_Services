package com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mabuya.lindor.mobilehealthacre_android_services.config.databases.DBConstants;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.AddressRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 213036223 on 4/24/2016.
 */
public class AddressRepositoryImpl extends SQLiteOpenHelper implements AddressRepository {
    public static final String TABLE_NAME = "address";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STREETNUMBER = "streetNumber";
    public static final String COLUMN_STREETNAME = "streetName";
    public static final String COLUMN_TOWN = "town";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_ZIPCODE = "code";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STREETNUMBER + " TEXT NOT NULL , "
            + COLUMN_STREETNAME + " TEXT NOT NULL , "
            + COLUMN_TOWN + " TEXT NOT NULL , "
            + COLUMN_CITY+ " TEXT NOT NULL , "
            + COLUMN_ZIPCODE + " TEXT NOT NULL );";

    public AddressRepositoryImpl(Context context) {
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
    public Address findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_STREETNUMBER,
                        COLUMN_STREETNAME,
                        COLUMN_TOWN,
                        COLUMN_CITY,
                        COLUMN_ZIPCODE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Address address = new Address.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .streetNumber(cursor.getInt(cursor.getColumnIndex(COLUMN_STREETNUMBER)))
                    .streetName(cursor.getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                    .town(cursor.getString(cursor.getColumnIndex(COLUMN_TOWN)))
                    .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                    .zipCode(cursor.getInt(cursor.getColumnIndex(COLUMN_ZIPCODE)))
                    .build();

            return address;
        } else {
            return null;
        }
    }

    @Override
    public Address save(Address entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STREETNUMBER, entity.getStreetNumber());
        values.put(COLUMN_STREETNAME, entity.getStreetName());
        values.put(COLUMN_TOWN, entity.getTown());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_ZIPCODE, entity.getZipCode());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Address insertedEntity = new Address.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Address update(Address entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STREETNUMBER, entity.getStreetNumber());
        values.put(COLUMN_STREETNAME, entity.getStreetName());
        values.put(COLUMN_TOWN, entity.getTown());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_ZIPCODE, entity.getZipCode());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Address delete(Address entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Address> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Address> addresses = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Address address = new Address.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .streetNumber(cursor.getInt(cursor.getColumnIndex(COLUMN_STREETNUMBER)))
                        .streetName(cursor.getString(cursor.getColumnIndex(COLUMN_STREETNAME)))
                        .town(cursor.getString(cursor.getColumnIndex(COLUMN_TOWN)))
                        .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                        .zipCode(cursor.getInt(cursor.getColumnIndex(COLUMN_ZIPCODE)))
                        .build();
                addresses.add(address);
            } while (cursor.moveToNext());
        }
        return addresses;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
