package com.raulmora.petagram.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raulmora.petagram.R;
import com.raulmora.petagram.adapter.MascotaAdaptador;
import com.raulmora.petagram.pojo.Mascota;
import com.raulmora.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.raulmora.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Raul Mora on 09/09/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


    /*public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.beagle,"Beagle",5));
        mascotas.add(new Mascota(R.drawable.boxer,"Boxer",5));
        mascotas.add(new Mascota(R.drawable.chow_chow,"Chow Chow",5));
        mascotas.add(new Mascota(R.drawable.pastor_aleman,"Pastor Aleman",5));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull",5));
        mascotas.add(new Mascota(R.drawable.pug,"Pug",5));
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
