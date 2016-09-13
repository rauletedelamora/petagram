package com.raulmora.petagram.pojo;

/**
 * Created by Raul Mora on 05/09/2016.
 */
public class Mascota {
    private int imgMascota;
    private String nombre;
    private String cantidadLikes;

    public Mascota(int imgMascota, String nombre, String cantidadLikes) {
        this.imgMascota = imgMascota;
        this.nombre = nombre;
        this.cantidadLikes = cantidadLikes;
    }

    public int getImgMascota() {
        return imgMascota;
    }

    public void setImgMascota(int imgMascota) {
        this.imgMascota = imgMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(String cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }
}
