/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdao;

import empleadosdao.clases.Empleado;
import empleadosdao.datos.EmpleadoDAO;
import java.util.List;

/**
 *
 * @author David
 */
public class EmpleadosDAO {

    public EmpleadosDAO(){
        
    }
    
      
    public List listarEmpleados(){
        EmpleadoDAO e = new EmpleadoDAO();
        List empleados  = e.obtenerEmpleados();
        return empleados;
    }
    
    public void agregarEmpleado(String nombre, int edad){
        Empleado e = new Empleado();
        e.setNombre(nombre);
        e.setEdad(edad);
        EmpleadoDAO dao = new EmpleadoDAO();
        dao.agregarEmpleado(e);
    }
    
    public Empleado seleccionarEmpleado(int id){
        EmpleadoDAO e = new EmpleadoDAO();
        return e.buscarEmpleado(id);
    }
    
    public Empleado buscarEmpleadoPorNombre(String n){
        Empleado e = null;
        List em = listarEmpleados();
        for(int i = 0; i < em.size(); i++){
            e = (Empleado) em.get(i);
            if(e.getNombre().equalsIgnoreCase(n)){
                return e;
            }
        }
        return e;
    }
    
    public void actualizarEmpleado(String nNombre, int nEdad){
        Empleado e = new Empleado();
        e.setNombre(nNombre);
        e.setEdad(nEdad);
        EmpleadoDAO dao = new EmpleadoDAO();
        dao.actualizarEmpleado(e);
    }
    
    public void eliminarEmpleado(int id){
        EmpleadoDAO dao = new EmpleadoDAO();
        dao.eliminarEmpleado(id);
    }
    
}
