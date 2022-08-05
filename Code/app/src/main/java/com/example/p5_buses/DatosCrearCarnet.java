package com.example.p5_buses;

public class DatosCrearCarnet {

    private String direccion, nombreCompleto, estado;
    private int cedula, telefono;

    public DatosCrearCarnet(){

    }

    public DatosCrearCarnet(String direccion, String nombreCompleto, String estado, int cedula, int telefono) {
        this.direccion = direccion;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
