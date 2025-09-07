/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Timestamp;

//Creacion de entidades y contructor.
public class Trabajadora_Social {
  
    private int idTs;
    private String nomApe;
    private String dni;
    private String telefono;
    private String email;
    private Timestamp fechaRegistro;

    public int getIdTs() {
        return idTs;
    }

    public void setIdTs(int idTs) {
        this.idTs = idTs;
    }

    public String getNomApe() {
        return nomApe;
    }

    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Trabajadora_Social(int idTs, String nomApe, String dni, String telefono, String email) {
        this.idTs = idTs;
        this.nomApe = nomApe;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public Trabajadora_Social() {
    }
}
