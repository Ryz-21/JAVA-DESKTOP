/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Entidades.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DoctorDAO {
   

    // Método para registrar un nuevo doctor
    public String registrarDoctor(Connection cn, Doctor doctor) {
        String mensaje = "";
        String sql = "CALL registrar_doctor(?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, doctor.getNomApe());
            ps.setString(2, doctor.getDni());
            ps.setString(3, doctor.getTelefono());
            ps.setString(4, doctor.getEmail());
            ps.setString(5, doctor.getEspecialidad());
            ps.executeUpdate();
            mensaje = "Doctor registrado con éxito.";
        } catch (SQLException e) {
            mensaje = "Error al registrar doctor: " + e.getMessage();
        }
        return mensaje;
    }

    // Método para actualizar un doctor
    public String actualizarDoctor(Connection cn, Doctor doctor) {
        String mensaje = "";
        String sql = "CALL actualizar_doctor(?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, doctor.getNomApe());
            ps.setString(2, doctor.getDni());
            ps.setString(3, doctor.getTelefono());
            ps.setString(4, doctor.getEmail());
            ps.setString(5, doctor.getEspecialidad());
            ps.setInt(6, doctor.getIdDoc());
            ps.executeUpdate();
            mensaje = "Doctor actualizado con éxito.";
        } catch (SQLException e) {
            mensaje = "Error al actualizar doctor: " + e.getMessage();
        }
        return mensaje;
    }

    // Método para listar doctores
            public List<Doctor> listarDoctores(Connection cn) {
                List<Doctor> doctores = new ArrayList<>();
                String sql = "CALL listar_doctor()";

                try (Statement stmt = cn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setIdDoc(rs.getInt("id_doc"));
                        doctor.setNomApe(rs.getString("nomape"));
                        doctor.setDni(rs.getString("dni"));
                        doctor.setTelefono(rs.getString("telefono"));
                        doctor.setEmail(rs.getString("email"));
                        doctor.setEspecialidad(rs.getString("especialidad"));
                        doctor.setFechaRegistro(rs.getTimestamp("fechap"));
                        doctores.add(doctor);
                    }
                } catch (SQLException e) {
                    System.out.println("Error al listar doctores: " + e.getMessage());
                }
                return doctores;
            }

    // Método para eliminar un doctor
    public String eliminarDoctor(Connection cn, int idDoc) {
        String mensaje = "";
        String sql = "CALL eliminar_doctor(?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idDoc);
            ps.executeUpdate();
            mensaje = "Doctor eliminado con éxito.";
        } catch (SQLException e) {
            mensaje = "Error al eliminar doctor: " + e.getMessage();
        }
        return mensaje;
    }

    // Método para recuperar el ID de un doctor por su nombre
    public int recuperarIdDoctor(Connection cn, String nomape) {
        int idDoctor = 0;
        String sql = "CALL recuperaridDoctor(?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nomape);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idDoctor = rs.getInt("id_doc");
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar ID de doctor: " + e.getMessage());
        }
        return idDoctor;
    }
}


