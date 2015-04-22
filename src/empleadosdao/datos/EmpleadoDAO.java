/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdao.datos;

import empleadosdao.clases.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class EmpleadoDAO {
    
    public List<Empleado> obtenerEmpleados() {
        FuenteDeDatos fuenteDB = new FuenteDeDatos();
        Connection conexion = fuenteDB.crearConexion();
        Statement stmt = null;
        ResultSet rs = null;
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            String query = "SELECT * FROM empleado";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setEdad(rs.getInt("edad"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }
        }
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        Connection conexion = null;
        Statement stmt = null;
        String sql = "insert into empleado (nombre,edad) values('" + empleado.getNombre() + "'"
                + "," + empleado.getEdad() + ")";
        try {
            FuenteDeDatos fuenteDB = new FuenteDeDatos();
            conexion = fuenteDB.crearConexion();
            stmt = conexion.prepareStatement(sql);
            stmt.executeUpdate(sql);
            System.out.println("Se ha registrado un nuevo empleado, nombre: " + empleado.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        FuenteDeDatos fuenteDB = new FuenteDeDatos();
        Connection conexion = fuenteDB.crearConexion();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM empleado where idempleado=" + idEmpleado;
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setEdad(rs.getInt("edad"));
                return empleado;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }
        }
        return null;
    }

    public void actualizarEmpleado(Empleado empleado) {
        Connection conexion = null;
        Statement stmt = null;
        String sql = "update empleado set nombre=" + "'" + empleado.getNombre()
                + "'" + ", edad="+empleado.getEdad()+" where idempleado=" + empleado.getIdEmpleado();
        try {
            FuenteDeDatos fuenteDB = new FuenteDeDatos();
            conexion = fuenteDB.crearConexion();
            stmt = conexion.prepareStatement(sql);
            stmt.executeUpdate(sql);

            System.out.println("Se ha actualizado el empleado con id : "
                    + empleado.getIdEmpleado());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
           }
        }
    }

    public void eliminarEmpleado(int idEmpleado) {
        Connection conexion = null;
        Statement stmt = null;
        String sql = "delete from empleado where idempleado=" + idEmpleado;
        try {
            FuenteDeDatos fuenteDB = new FuenteDeDatos();
            conexion = fuenteDB.crearConexion();
            stmt = conexion.prepareStatement(sql);
            stmt.executeUpdate(sql);
           System.out.println("Ha sido eliminado el empleado con id : "
                    + idEmpleado);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
