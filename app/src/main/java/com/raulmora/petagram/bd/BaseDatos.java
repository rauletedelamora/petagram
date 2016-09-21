package com.raulmora.petagram.bd;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.raulmora.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Raul Mora on 17/09/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_MASCOTAS + " ( " +
                ConstanteBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstanteBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER " + ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS + "(" +
                ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, " +
                ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_CANTIDAD_LIKES + " INTEGER, " +
                " FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + ") " +
                " REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTAS + "(" + ConstanteBaseDatos.TABLE_MASCOTAS_ID + ") "
                + ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImgMascota(registros.getInt(2));

            String queryLikes = "SELECT COUNT (" + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_CANTIDAD_LIKES + ") as likes " +
                    " FROM " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLike = db.rawQuery(queryLikes, null);
            if (registrosLike.moveToNext()) {
                mascotaActual.setCantidadLikes(registrosLike.getInt(0));
            } else {
                mascotaActual.setCantidadLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLike(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKES_MASCOTAS, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota) {
        int likes = 0;
        String query = "SELECT COUNT ( " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_CANTIDAD_LIKES + " ) " +
                " FROM " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " = " + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }
}