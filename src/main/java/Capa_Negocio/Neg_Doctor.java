/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Conexion.ConexionMySQL;
import Capa_Datos.DoctorDAO;
import Entidades.Doctor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Leo_v
 */
public class Neg_Doctor {


    private String mensaje = "";
    private DoctorDAO doctorDAO = new DoctorDAO();
    private ConexionMySQL conex = new ConexionMySQL();

    public String agregarDoctor(Doctor doctor) {
        Connection cn = conex.conexion();
        try {
            mensaje = doctorDAO.registrarDoctor(cn, doctor);
        } catch (Exception e) {
            mensaje += "Error al agregar doctor: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                mensaje += "Error al cerrar conexión: " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String actualizarDoctor(Doctor doctor) {
        Connection cn = conex.conexion();
        try {
            mensaje = doctorDAO.actualizarDoctor(cn, doctor);
        } catch (Exception e) {
            mensaje += "Error al actualizar doctor: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                mensaje += "Error al cerrar conexión: " + e.getMessage();
            }
        }
        return mensaje;
    }

    public List<Doctor> listarDoctores() {
        Connection cn = conex.conexion();
        List<Doctor> doctores = null;
        try {
            doctores = doctorDAO.listarDoctores(cn);
        } catch (Exception e) {
            System.out.println("Error al listar doctores: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return doctores;
    }

    public String eliminarDoctor(int idDoc) {
        Connection cn = conex.conexion();
        try {
            mensaje = doctorDAO.eliminarDoctor(cn, idDoc);
        } catch (Exception e) {
            mensaje += "Error al eliminar doctor: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                mensaje += "Error al cerrar conexión: " + e.getMessage();
            }
        }
        return mensaje;
    }

    public int recuperarIdDoctor(String nomape) {
        Connection cn = conex.conexion();
        int idDoctor = 0;
        try {
            idDoctor = doctorDAO.recuperarIdDoctor(cn, nomape);
        } catch (Exception e) {
            System.out.println("Error al recuperar ID de doctor: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return idDoctor;
    }
}


