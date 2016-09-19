package com.raulmora.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raulmora.petagram.R;
import com.raulmora.petagram.adapter.MascotaAdaptador;
import com.raulmora.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment {


    public PerfilMascotaFragment() {
        // Required empty public constructor
    }
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.beagle1,"",5));
        mascotas.add(new Mascota(R.drawable.beagle2,"",4));
        mascotas.add(new Mascota(R.drawable.beagle3,"",5));
        mascotas.add(new Mascota(R.drawable.beagle4,"",7));
        mascotas.add(new Mascota(R.drawable.beagle5,"",8));
    }

}
