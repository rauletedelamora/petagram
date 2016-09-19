package com.raulmora.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.raulmora.petagram.adapter.MascotaAdaptador;
import com.raulmora.petagram.pojo.Mascota;

import java.util.ArrayList;

public class DetalleMascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_mascotas_favoritas);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.beagle, "Beagle", 4));
        mascotas.add(new Mascota(R.drawable.boxer, "Boxer", 5));
        mascotas.add(new Mascota(R.drawable.pastor_aleman, "Pastor Aleman", 3));
        mascotas.add(new Mascota(R.drawable.pitbull, "Pitbull", 8));
        mascotas.add(new Mascota(R.drawable.pug, "Pug", 7));
    }

    public void irActividadDetalleMascota(View view) {
        Intent intent = new Intent(this, DetalleMascotasFavoritas.class);
        startActivity(intent);
    }


}
