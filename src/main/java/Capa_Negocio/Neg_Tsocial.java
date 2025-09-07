/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Conexion.ConexionMySQL;
import Capa_Datos.TSocialDAO;
import Entidades.Trabajadora_Social;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Leo_v
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;

public class Neg_Tsocial {
    private final TSocialDAO tsocialDAO;
    private final ConexionMySQL conex; // Asegúrate de tener una clase para manejar la conexión

    public Neg_Tsocial() {
        this.conex = new ConexionMySQL(); // Inicializa tu conexión
        this.tsocialDAO = new TSocialDAO(conex.conexion());
    }

    public String agregarTrabajadoraSocial(Trabajadora_Social ts) {
        String mensaje = "";
        Connection cn = conex.conexion();
        try {
            tsocialDAO.registrar(ts);
            mensaje = "Trabajadora social registrada con éxito.";
        } catch (SQLException e) {
            mensaje += "Error al agregar trabajadora social: " + e.getMessage();
        } finally {
            cerrarConexion(cn);
        }
        return mensaje;
    }

    public String actualizarTrabajadoraSocial(Trabajadora_Social ts) {
        String mensaje = "";
        Connection cn = conex.conexion();
        try {
            tsocialDAO.actualizar(ts);
            mensaje = "Trabajadora social actualizada con éxito.";
        } catch (SQLException e) {
            mensaje += "Error al actualizar trabajadora social: " + e.getMessage();
        } finally {
            cerrarConexion(cn);
        }
        return mensaje;
    }

    public void listarTrabajadorasSociales(JComboBox<String> combo) {
        Connection cn = conex.conexion();
        try {
            List<Trabajadora_Social> lista = tsocialDAO.listar();
            combo.removeAllItems(); // Limpiar el combo antes de llenarlo
            for (Trabajadora_Social ts : lista) {
                combo.addItem(ts.getNomApe());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar trabajadoras sociales: " + e.getMessage());
        } finally {
            cerrarConexion(cn);
        }
    }

    public String eliminarTrabajadoraSocial(int idTs) {
        String mensaje = "";
        Connection cn = conex.conexion();
        try {
            tsocialDAO.eliminar(idTs);
            mensaje = "Trabajadora social eliminada con éxito.";
        } catch (SQLException e) {
            mensaje += "Error al eliminar trabajadora social: " + e.getMessage();
        } finally {
            cerrarConexion(cn);
        }
        return mensaje;
    }

    private void cerrarConexion(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}

