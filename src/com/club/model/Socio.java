package com.club.model;

public class Socio {
    private  int id;
    private String nombre;
    private String apellido;
    private String dni;
    private boolean activo;

    public Socio(int id, String nombre, String apellido, String dni, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.activo = activo;
    }

    public int getId () {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString () {
        return "{Datos del socio" +
                "id: " + id +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ", dni: " + dni +
                ", es activo: " + activo + "}";

    }
}
