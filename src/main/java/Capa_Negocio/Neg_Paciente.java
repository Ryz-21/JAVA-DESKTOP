/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Conexion.ConexionMySQL;
import Capa_Datos.PacienteDAO;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class Neg_Paciente {
     private String mensaje = "";
    private PacienteDAO pacienteDAO = new PacienteDAO();
    private ConexionMySQL conex = new ConexionMySQL();
        public String agregarPaciente(Paciente paciente) {
        Connection cn = conex.conexion();
        try {
            mensaje = pacienteDAO.registrarPaciente(cn, paciente);
        } catch (Exception e) {
            mensaje += "Error al agregar paciente: " + e.getMessage();
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

    public String actualizarPaciente(Paciente paciente) {
        Connection cn = conex.conexion();
        try {
            mensaje = pacienteDAO.actualizarPaciente(cn, paciente);
        } catch (Exception e) {
            mensaje += "Error al actualizar paciente: " + e.getMessage();
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

    public void listarPacientes(JComboBox<String> combo) {
        Connection cn = conex.conexion();
        try {
            pacienteDAO.listarPacientes(cn, combo);
        } catch (Exception e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public String eliminarPaciente(int idPaciente) {
        Connection cn = conex.conexion();
        try {
            mensaje = pacienteDAO.eliminarPaciente(cn, idPaciente);
        } catch (Exception e) {
            mensaje += "Error al eliminar paciente: " + e.getMessage();
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
    
            public int recuperarIdPaciente(String nomPaciente) {
        Connection cn = conex.conexion();
        int idPaciente = -1;
        try {
            idPaciente = pacienteDAO.recuperaridPaciente(cn, nomPaciente);
        } catch (Exception e) {
            System.out.println("Error al recuperar ID de paciente: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return idPaciente;
    }
}
    

