/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Conexion.ConexionMySQL;
import Capa_Datos.Asig_PacienteDAO;
import Entidades.Asig_Paciente;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class Neg_Atenciones {
      private String mensaje = "";
    private Asig_PacienteDAO asig_dao = new Asig_PacienteDAO();
    private ConexionMySQL conex = new ConexionMySQL();

    public String agregarAtencion(Asig_Paciente a_paciente) {
        Connection cn = conex.conexion();
        try {
            mensaje = asig_dao.agregarAsignacion(cn, a_paciente);
        } catch (Exception e) {
            mensaje += "Error al agregar atención: " + e.getMessage();
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

    public void num_cod_atencion(JLabel lblnumReserva) {
        Connection cn = conex.conexion();
        try {
            asig_dao.num_atencion(cn, lblnumReserva);
        } catch (Exception e) {
            System.out.println("Error al obtener el número de atención: " + e.getMessage());
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

    public void listarPacientes(JComboBox<String> combo) {
        Connection cn = conex.conexion();
        try {
            asig_dao.listar_Pacientes(cn, combo);
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

    public void listarDoctores(JComboBox<String> combo) {
        Connection cn = conex.conexion();
        try {
            asig_dao.listar_Doctor(cn, combo);
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
    }

    public void listarTSocial(JComboBox<String> combo) {
        Connection cn = conex.conexion();
        try {
            asig_dao.listar_TSocial(cn, combo);
        } catch (Exception e) {
            System.out.println("Error al listar trabajadoras sociales: " + e.getMessage());
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

    public int recuperaridPaciente(String nomPaciente) {
        Connection cn = conex.conexion();
        int idPaciente = 0;
        try {
            idPaciente = asig_dao.recuperaridPaciente(nomPaciente, cn);
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

    public int recuperaridDoctor(String nomDoctor) {
        Connection cn = conex.conexion();
        int idDoctor = 0;
        try {
            idDoctor = asig_dao.recuperaridDoctor(nomDoctor, cn);
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

 public int recuperaridTSocial(String nomTSocial) {
    Connection cn = conex.conexion();
    int idTSocial = 0;
    try {
        idTSocial = asig_dao.recuperaridTS(nomTSocial, cn);
    } catch (Exception e) {
        System.out.println("Error al recuperar ID de trabajadora social: " + e.getMessage());
    } finally {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
    return idTSocial;
}

}

