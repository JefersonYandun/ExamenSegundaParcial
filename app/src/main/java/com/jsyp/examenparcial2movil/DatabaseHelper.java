package com.jsyp.examenparcial2movil;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "usuario";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_CEDULA = "cedula";
    private static final String COLUMN_FECHA = "fecha";
    private static final String COLUMN_PLACA = "placa";
    private static final String COLUMN_ANIO = "anio";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NOMBRE + " TEXT," +
                COLUMN_CEDULA + " TEXT," +
                COLUMN_FECHA + " TEXT," +
                COLUMN_PLACA + " TEXT," +
                COLUMN_ANIO + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nombre, String cedula, String fecha, String placa, String anio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NOMBRE, nombre);
        contentValues.put(COLUMN_CEDULA, cedula);
        contentValues.put(COLUMN_FECHA, fecha);
        contentValues.put(COLUMN_PLACA, placa);
        contentValues.put(COLUMN_ANIO, anio);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}