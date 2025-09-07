/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Entidades.Asig_Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class Asig_PacienteDAO {
    
    String mensaje;
    CallableStatement cts;

    public String agregarAsignacion(Connection cn, Asig_Paciente a_paciente) {
    try {
        cts = cn.prepareCall("call registrar_atenciones (?, ?, ?, ?, ?, ?)");
        
        // Cambiar setInt a setString para el idAtencion
        cts.setString(1, a_paciente.getIdAtencion()); // Cambiado de setInt a setString
        cts.setInt(2, a_paciente.getIdPaciente());
        cts.setInt(3, a_paciente.getIdDoc());
        cts.setInt(4, a_paciente.getIdTs());
        cts.setString(5, a_paciente.getSituacion());
        cts.setTimestamp(6, a_paciente.getFechaAsig());

        cts.execute();
        mensaje = "Atención Agregada Correctamente";
    } catch (SQLException e) {
        mensaje = "Error al agregar Atención: " + e.getMessage();
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

    
    public void num_atencion(Connection con, JLabel lblnumAtencion) {
    int c = 0;
    try {
        cts = con.prepareCall("call numero_atencion()");
        ResultSet rs = cts.executeQuery();
        if (rs.next()) {
            c = rs.getInt(1);
        }
        lblnumAtencion.setText(c == 0 ? "A-00000001" : Metodos_Generales.generarNumero(c));
    } catch (SQLException e) {
        System.out.println("Error al obtener el número de atención: " + e.getMessage());
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

public void listar_Pacientes(Connection cn, JComboBox<String> combo) {
    combo.addItem("Seleccione Paciente");
    try {
        cts = cn.prepareCall("call listar_pacientes()");
        ResultSet rs = cts.executeQuery();
        while (rs.next()) {
            combo.addItem(rs.getString("nomape")); // Cambia esto si la columna tiene otro nombre
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

public void listar_Doctor(Connection cn, JComboBox<String> combo) {
    combo.addItem("Seleccione Doctor");
    try {
        cts = cn.prepareCall("call listar_doctor()");
        ResultSet rs = cts.executeQuery();
        while (rs.next()) {
            combo.addItem(rs.getString("nomape")); // Cambia esto si la columna tiene otro nombre
        }
    } catch (SQLException e) {
        System.out.println("Error al listar doctores: " + e.getMessage());
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

public void listar_TSocial(Connection cn, JComboBox<String> combo) {
    combo.addItem("Seleccione Trabajadora Social");
    try {
        cts = cn.prepareCall("call listar_tsocial()");
        ResultSet rs = cts.executeQuery();
        while (rs.next()) {
            combo.addItem(rs.getString("nomape")); // Cambia esto si la columna tiene otro nombre
        }
    } catch (SQLException e) {
        System.out.println("Error al listar trabajadoras sociales: " + e.getMessage());
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

public int recuperaridPaciente(String nomPaciente, Connection con) {
    int idPaciente = 0;
    ResultSet rs = null;
    try {
        cts = con.prepareCall("call recuperaridPaciente(?)");
        cts.setString(1, nomPaciente);
        rs = cts.executeQuery();

        if (rs.next()) {
            idPaciente = rs.getInt(1);
        }
    } catch (SQLException ex) {
        System.out.println("Error al recuperar ID de paciente: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cts != null) {
                cts.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet o CallableStatement: " + e.getMessage());
        }
    }
    return idPaciente;
}

public int recuperaridDoctor(String nomDoctor, Connection con) {
    int idDoctor = 0;
    ResultSet rs = null;
    try {
        cts = con.prepareCall("call recuperaridDoctor(?)");
        cts.setString(1, nomDoctor);
        rs = cts.executeQuery();

        if (rs.next()) {
            idDoctor = rs.getInt(1);
        }
    } catch (SQLException ex) {
        System.out.println("Error al recuperar ID de doctor: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cts != null) {
                cts.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet o CallableStatement: " + e.getMessage());
        }
    }
    return idDoctor;
}
public int recuperaridTS(String nomTS, Connection con) {
    int idTS = 0;
    ResultSet rs = null;
    try {
        cts = con.prepareCall("call recuperaridTSocial(?)");
        cts.setString(1, nomTS);
        rs = cts.executeQuery();

        if (rs.next()) {
            idTS = rs.getInt(1);
        }
    } catch (SQLException ex) {
        System.out.println("Error al recuperar ID de trabajadora social: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cts != null) {
                cts.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet o CallableStatement: " + e.getMessage());
        }
    }
    return idTS;
}


}


