/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdao.interfaz;

import empleadosdao.EmpleadosDAO;
import empleadosdao.clases.Empleado;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class InterfazEmpleadosDAO extends javax.swing.JFrame {

    
    private EmpleadosDAO empleados;
    
    private PanelListaEmpleados panelLista;
    private PanelOpcionesEmpleados panelOpciones;
    /**
     * Creates new form InterfazEmpleadosDAO
     */
    public InterfazEmpleadosDAO() {
        empleados = new EmpleadosDAO();
        
        setLayout(new GridLayout());
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Empresa");
        setResizable(false);
        
        panelLista = new PanelListaEmpleados(this);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelLista, gbc);
        
        panelOpciones = new PanelOpcionesEmpleados(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelOpciones, gbc);
        
        setLocationRelativeTo(null);
        pack();
    }
    
    public void mostrarDialogoAgregarEmpleado(){
        DialogoAgregarEmpleado dialogo = new DialogoAgregarEmpleado(this);
        dialogo.setLocation(200, 200);
        dialogo.setVisible( true );
    }
    
    public void mostrarDialogoModificarEmpleado(){
        Empleado e = panelLista.darEmpleadoSeleccionado();
        DialogoModificarEmpleado dialogo = new DialogoModificarEmpleado(this, e);
        dialogo.setLocation(200, 200);
        dialogo.setVisible(true);
    }
    
    public List darEmpleados(){
        return empleados.listarEmpleados();
    }
    
    public void agregarEmpleado(String nombre, int edad){
        empleados.agregarEmpleado(nombre, edad);
    }
    
    public void modificarEmpleado(String nombre, int edad){
        empleados.actualizarEmpleado(nombre, edad);
    }
    
    public void buscarEmpleado(){
        String nombre = JOptionPane.showInputDialog(this,"Nombre: ", "Buscar empleado", JOptionPane.QUESTION_MESSAGE);
        empleados.buscarEmpleadoPorNombre(nombre);
    }
    
    public void eliminarEmpleado( ){
        empleados.eliminarEmpleado(panelLista.darEmpleadoSeleccionado().getIdEmpleado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        InterfazEmpleadosDAO interfaz = new InterfazEmpleadosDAO();
        interfaz.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
