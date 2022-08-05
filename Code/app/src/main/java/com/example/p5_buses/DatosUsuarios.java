package com.example.p5_buses;

public class DatosUsuarios {
    private String nombreCompleto, email, contrasena, rol;
    private int telefono, cedula;

    public DatosUsuarios(String nombreCompleto, String email, String contrasena, String rol, int telefono, int cedula) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public DatosUsuarios() {

    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }


}
