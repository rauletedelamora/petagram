package com.raulmora.petagram.pojo;

/**
 * Created by Raul Mora on 05/09/2016.
 */
public class Mascota {
    private int id;
    private int imgMascota;
    private String nombre;
    private int cantidadLikes;

    public Mascota(int imgMascota, String nombre, int cantidadLikes) {

        this.imgMascota = imgMascota;
        this.nombre = nombre;
        this.cantidadLikes = cantidadLikes;
    }

    public Mascota() {

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

    public int getCantidadLikes() {  return cantidadLikes; }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
