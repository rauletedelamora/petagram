package com.raulmora.petagram.fragment;

import com.raulmora.petagram.adapter.MascotaAdaptador;
import com.raulmora.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Raul Mora on 15/09/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
