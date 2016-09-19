package com.raulmora.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.raulmora.petagram.bd.ConstructorMascotas;
import com.raulmora.petagram.pojo.Mascota;
import com.raulmora.petagram.R;

import java.util.ArrayList;

/**
 * Created by Raul Mora on 05/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.activity = activity;
        this.mascotas = mascotas;
    }

    //Infla el layout y lo pasa al viewholder para q obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.ibFoto.setImageResource(mascota.getImgMascota());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvcantLikesCV.setText(String.valueOf(mascota.getCantidadLikes()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Diste like a "+mascota.getNombre(), Toast.LENGTH_LONG).show();
                ConstructorMascotas constructor = new ConstructorMascotas(activity);
                constructor.darLikeMascota(mascota);
                mascotaViewHolder.tvcantLikesCV.setText(constructor.obtenerLikesMascota(mascota));
            }
        });

    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder  extends RecyclerView.ViewHolder {

        private ImageView ibFoto;
        private TextView tvNombreCV;
        private TextView tvcantLikesCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ibFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
            tvcantLikesCV = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.ibHuesoBlanco);
        }
    }
}
