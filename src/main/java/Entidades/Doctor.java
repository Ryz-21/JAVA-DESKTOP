/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Timestamp;

/**
 *
 * @author Leo_v
 */

//Creacion de entidades y contructor.

public class Doctor {

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Doctor(int idDoc, String nomApe, String dni, String telefono, String email, String especialidad, Timestamp fechaRegistro) {
        this.idDoc = idDoc;
        this.nomApe = nomApe;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        this.fechaRegistro = fechaRegistro;
    }

    public Doctor() {
    }
    
      private int idDoc;
    private String nomApe;
    private String dni;
    private String telefono;
    private String email;
    private String especialidad;
    private Timestamp fechaRegistro;

}
