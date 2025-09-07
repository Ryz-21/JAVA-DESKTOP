/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Entidades.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class PacienteDAO {
    
    String mensaje;
    CallableStatement cts;

    public String registrarPaciente(Connection cn, Paciente paciente) {
        try {
            cts = cn.prepareCall("call registrar_pacientes (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            cts.setString(1, paciente.getNomApe());
            cts.setString(2, paciente.getDni());
            cts.setString(3, paciente.getTelefono());
            cts.setString(4, paciente.getEmail());
            cts.setString(5, paciente.getDireccion());
            cts.setString(6, paciente.getGerencia());
            cts.setString(7, paciente.getCondicionLaboral());
            cts.setString(8, paciente.getDiagnostico());
            cts.setString(9, paciente.getSeguro());
            cts.setDate(10, paciente.getFechaNac());

            cts.execute();
            mensaje = "Paciente registrado correctamente";
        } catch (SQLException e) {
            mensaje = "Error al registrar paciente: " + e.getMessage();
            System.out.println("Error " + e);
        } finally {
            try {
                if (cts != null) {
                    cts.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar CallableStatement: " + e.getMessage());
            }
        }
        return mensaje;
    }

    public String actualizarPaciente(Connection cn, Paciente paciente) {
        try {
            cts = cn.prepareCall("call actualizar_pacientes (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            cts.setString(1, paciente.getNomApe());
            cts.setString(2, paciente.getDni());
            cts.setString(3, paciente.getTelefono());
            cts.setString(4, paciente.getEmail());
            cts.setString(5, paciente.getDireccion());
            cts.setString(6, paciente.getGerencia());
            cts.setString(7, paciente.getCondicionLaboral());
            cts.setString(8, paciente.getDiagnostico());
            cts.setString(9, paciente.getSeguro());
            cts.setDate(10, paciente.getFechaNac());
            cts.setInt(11, paciente.getIdPaciente());

            cts.execute();
            mensaje = "Paciente actualizado correctamente";
        } catch (SQLException e) {
            mensaje = "Error al actualizar paciente: " + e.getMessage();
            System.out.println("Error " + e);
        } finally {
            try {
                if (cts != null) {
                    cts.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar CallableStatement: " + e.getMessage());
            }
        }
        return mensaje;
    }

    public void listarPacientes(Connection cn, JComboBox<String> combo) {
        combo.addItem("Seleccione Paciente");
        try {
            cts = cn.prepareCall("call listar_pacientes()");
            ResultSet rs = cts.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString("nomape"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        } finally {
            try {
                if (cts != null) {
                    cts.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar CallableStatement: " + e.getMessage());
            }
        }
    }

    public String eliminarPaciente(Connection cn, int idPaciente) {
        try {
            cts = cn.prepareCall("call eliminar_pacientes(?)");
            cts.setInt(1, idPaciente);

            cts.execute();
            mensaje = "Paciente eliminado correctamente";
        } catch (SQLException e) {
            mensaje = "Error al eliminar paciente: " + e.getMessage();
            System.out.println("Error " + e);
        } finally {
            try {
                if (cts != null) {
                    cts.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar CallableStatement: " + e.getMessage());
            }
        }
        return mensaje;
    
}
    
       
     public int recuperaridPaciente(Connection cn, String nombrePaciente) {
        int idPaciente = -1;
        CallableStatement cts = null;
        ResultSet rs = null;

        try {
            cts = cn.prepareCall("CALL recuperaridPaciente(?)");
            cts.setString(1, nombrePaciente);
            rs = cts.executeQuery();
            if (rs.next()) {
                idPaciente = rs.getInt("id_paciente");
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar ID del paciente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cts != null) {
                    cts.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return idPaciente;
    }
}

