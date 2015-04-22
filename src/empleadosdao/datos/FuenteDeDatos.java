/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdao.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class FuenteDeDatos {
    
    private Connection conexion;
    private String url;
    private String baseDeDatos;
    private String usuario;
    private String clave;

    public FuenteDeDatos() {
        baseDeDatos = "empresa";
        clave = "mysql";
        usuario = "root";
        url = "jdbc:mysql://localhost/"+baseDeDatos;
    }
    
    public Connection crearConexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión realizada correctamente");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuenteDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuenteDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
}
