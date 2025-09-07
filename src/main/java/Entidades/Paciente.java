/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Leo_v
 */


public class Paciente {
      private int idPaciente;
    private String nomApe;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;
    private String gerencia;
    private String condicionLaboral;
    private String diagnostico;
    private String seguro;
    private Date fechaNac;
    private Timestamp fechaRegistro;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nomApe, String dni, String telefono, String email, String direccion, String gerencia, String condicionLaboral, String diagnostico, String seguro, Date fechaNac, Timestamp fechaRegistro) {
        this.idPaciente = idPaciente;
        this.nomApe = nomApe;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.gerencia = gerencia;
        this.condicionLaboral = condicionLaboral;
        this.diagnostico = diagnostico;
        this.seguro = seguro;
        this.fechaNac = fechaNac;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getCondicionLaboral() {
        return condicionLaboral;
    }

    public void setCondicionLaboral(String condicionLaboral) {
        this.condicionLaboral = condicionLaboral;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
