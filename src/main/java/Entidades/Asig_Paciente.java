/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Timestamp;


public class Asig_Paciente {
//Creacion de entidades y contructor.

    public Asig_Paciente() {
    }

   
     private String idAtencion;
    private int idPaciente;
    private int idDoc;
    private int idTs;
    private String situacion;
    private Timestamp fechaAsig;

    public Asig_Paciente(String idAtencion, int idPaciente, int idDoc, int idTs, String situacion, Timestamp fechaAsig) {
        this.idAtencion = idAtencion;
        this.idPaciente = idPaciente;
        this.idDoc = idDoc;
        this.idTs = idTs;
        this.situacion = situacion;
        this.fechaAsig = fechaAsig;
    }

    public String getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public int getIdTs() {
        return idTs;
    }

    public void setIdTs(int idTs) {
        this.idTs = idTs;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Timestamp getFechaAsig() {
        return fechaAsig;
    }

    public void setFechaAsig(Timestamp fechaAsig) {
        this.fechaAsig = fechaAsig;
    }
}
