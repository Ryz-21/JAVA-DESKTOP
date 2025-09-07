/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Entidades.Trabajadora_Social;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TSocialDAO {
    
 
    private Connection connection;

    public TSocialDAO(Connection connection) {
        this.connection = connection;
    }

    public void registrar(Trabajadora_Social ts) throws SQLException {
        String sql = "CALL registrar_tsocial(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ts.getNomApe());
            stmt.setString(2, ts.getDni());
            stmt.setString(3, ts.getTelefono());
            stmt.setString(4, ts.getEmail());
            stmt.executeUpdate();
        }
    }

    public void actualizar(Trabajadora_Social ts) throws SQLException {
        String sql = "CALL actualizar_tsocial(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ts.getNomApe());
            stmt.setString(2, ts.getDni());
            stmt.setString(3, ts.getTelefono());
            stmt.setString(4, ts.getEmail());
            stmt.setInt(5, ts.getIdTs());
            stmt.executeUpdate();
        }
    }

    public List<Trabajadora_Social> listar() throws SQLException {
        List<Trabajadora_Social> lista = new ArrayList<>();
        String sql = "CALL listar_tsocial()";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Trabajadora_Social ts = new Trabajadora_Social();
                ts.setIdTs(rs.getInt("id_tsocial"));
                ts.setNomApe(rs.getString("nomape"));
                ts.setDni(rs.getString("dni"));
                ts.setTelefono(rs.getString("telefono"));
                ts.setEmail(rs.getString("email"));
                // Puedes agregar más atributos si los necesitas
                lista.add(ts);
            }
        }
        return lista;
    }

    public void eliminar(int idTs) throws SQLException {
        String sql = "CALL eliminar_tsocial(?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTs);
            stmt.executeUpdate();
        }
    }
}


