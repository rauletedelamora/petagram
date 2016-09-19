package com.raulmora.petagram.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.raulmora.petagram.R;
import com.raulmora.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Raul Mora on 15/09/2016.
 */
public class ConstructorMascotas {

    private static final int LIKE = 1;
    Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.beagle,"Beagle",5));
        mascotas.add(new Mascota(R.drawable.boxer,"Boxer",5));
        mascotas.add(new Mascota(R.drawable.chow_chow,"Chow Chow",5));
        mascotas.add(new Mascota(R.drawable.pastor_aleman,"Pastor Aleman",5));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull",5));
        mascotas.add(new Mascota(R.drawable.pug,"Pug",5));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public  void insertarMascotas(BaseDatos bd){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Beagle" );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.beagle );

        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Boxer" );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.boxer );

        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pastor Aleman" );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pastor_aleman );

        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pitbull" );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pitbull );

        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chow Chow" );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.chow_chow );

        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pug" );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pug );

        bd.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_MASCOTAS_CANTIDAD_LIKES, LIKE);

        bd.insertarLike(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerLikesMascota(mascota);
    }
}
