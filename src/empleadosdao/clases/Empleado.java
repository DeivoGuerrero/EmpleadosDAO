/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdao.clases;

/**
 *
 * @author David
 */
public class Empleado {
    
    /**
     * Atributo que referencia el identificador del empleado
     */
    private int idEmpleado;
    
    /**
     * Atributo que referencia el nombre del empleado
     */
    private String nombre;
    
    /**
     * Atributo que referencia la edad del empleado
     */
    private int edad;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
