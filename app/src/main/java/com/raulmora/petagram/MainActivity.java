package com.raulmora.petagram;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    /**Métodos**/

    public void irActividadDetalleMascota(){
        Intent intent = new Intent(this,detalleMascotasFavoritas.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.beagle,"Beagle","5"));
        mascotas.add(new Mascota(R.drawable.boxer,"Boxer","5"));
        mascotas.add(new Mascota(R.drawable.chow_chow,"Chow Chow","5"));
        mascotas.add(new Mascota(R.drawable.pastor_aleman,"Pastor Aleman","5"));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull","5"));
        mascotas.add(new Mascota(R.drawable.pug,"Pug","5"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favoritos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.acc5estrellas:
                irActividadDetalleMascota();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
