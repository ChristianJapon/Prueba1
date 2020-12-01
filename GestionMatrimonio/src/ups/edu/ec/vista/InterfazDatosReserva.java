/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorMatrimonio;
import ups.edu.ec.controlador.ControladorPersona;
import ups.edu.ec.modelo.Matrimonio;
import ups.edu.ec.modelo.Persona;
import static ups.edu.ec.vista.InterfazPersona.ruta;


/**
 *
 * @author japch
 */
public class InterfazDatosReserva extends javax.swing.JFrame {
    private InterfazPersona ip;
    
    ControladorMatrimonio controladorMatrimonio = new ControladorMatrimonio();
    ControladorPersona controladorPersonas = new ControladorPersona();
    public static String ruta = "basedatos.obj";
    public static String ruta2 = "basedatosMatrimonios.obj";
    DefaultTableModel modelo;
    boolean valor=false;


    /**
     * Creates new form InterfazDatos
     */
    public InterfazDatosReserva() {
        try {
            System.out.println(controladorPersonas.lista);
            initComponents();
            CrearModelo();
            controladorMatrimonio.cargarDatos(ruta2);
            try {
                controladorPersonas.cargarDatos(ruta);
                //    System.out.println(controladorPersonas.lista+"--------");
            }  catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            modelo = (DefaultTableModel) jtable0.getModel();
            this.listarDatos();
            //this.tablita();
            this.jtable0.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    cargarDatos(jtable0.getSelectedRow());
                }
            });
        }  catch (IOException ex) {
            Logger.getLogger(InterfazDatosReserva.class.getName()).log(Level.SEVERE, null, ex);   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfazDatosReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
       
              

                }
    
         public void listarDatos() {
        modelo.setRowCount(0);
        for (Matrimonio matr : controladorMatrimonio.getLista()) {
            String datos[] = {String.valueOf(matr.getId()),matr.getFecha(),matr.getLugar(),matr.getEsposo(),matr.getEsposa(),matr.getSutoridad()};
            modelo.addRow(datos);
        }
    }
        private void CrearModelo(){
            try {
                modelo = (new DefaultTableModel (
                null,  new  String []{
                    "Id", "Fecha","Lugar","Esposo","Esposa","Autoridad"})  {} );
                jtable0.setModel(modelo);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }
    
    
        public void verificaresposo(){
        boolean encontrado=false;
        String nameesposo= txtesposo0.getText();
        
        for (int x = 0; x < controladorPersonas.lista.size(); x++) {
        Persona p = controladorPersonas.lista.get(x);
             if (p.getNombre().equals(nameesposo)) {
                System.out.println("Las Persona esposo esta registrada: "+nameesposo+"=="+p.getNombre());
                 encontrado=true;
                break;
               }
           }
        if(encontrado){
            JOptionPane.showMessageDialog(null, "El ESPOSO esta registrado");
        }else{
            JOptionPane.showMessageDialog(null, "El ESPOSO NO esta registrado");
        InterfazPersona inp= new InterfazPersona();
        inp.setVisible(true);

        }
   
    }
        public void verificaresposa(){ 
        String nameesposa= txtesposa0.getText();
        boolean encontrado=false;
        for (int x = 0; x < controladorPersonas.lista.size(); x++) {
        Persona p = controladorPersonas.lista.get(x);
             if (p.getNombre().equals(nameesposa)) {
                  encontrado=true;
                System.out.println("Las Persona esposo esta registrada: "+nameesposa+"=="+p.getNombre());
                break;
         }
             
        }if(encontrado){
           JOptionPane.showMessageDialog(null, "La ESPOSA esta registrada");
        }else{
          JOptionPane.showMessageDialog(null, "La ESPOSA NO esta registrada");
        InterfazPersona inp= new InterfazPersona();
        inp.setVisible(true);

        }
        
    }
        public void verificarautoridad(){
        String nameautoridad= txtautoridad0.getText();
          boolean encontrado=false;
        for (int x = 0; x < controladorPersonas.lista.size(); x++) {
        Persona p = controladorPersonas.lista.get(x);
             if (p.getNombre().equals(nameautoridad)) {
                 encontrado =true;
                System.out.println("Las Persona esposo esta registrada: "+nameautoridad+"=="+p.getNombre());
            break;
            }
        }if(encontrado){
          JOptionPane.showMessageDialog(null, "La AUTORIDAD esta registrada");
        }else{
         JOptionPane.showMessageDialog(null, "La AUTORIDAD NO esta registrada");
        InterfazPersona inp= new InterfazPersona();
        inp.setVisible(true);

        }
    }
        
        public void registromatrimonio(){
            String id0= txtid0.getText();
            String fecha0= txtfecha0.getText();
            String lugar0= txtlugar0.getText();
            String esposo0=txtesposo0.getText();
            String esposa0=txtesposa0.getText();
            String autoridad0=txtautoridad0.getText();
            
            if(!id0.isEmpty()){
                if(!fecha0.isEmpty()){
                    if(!lugar0.isEmpty()){
                        if(!esposo0.isEmpty()){
                            if(!esposa0.isEmpty()){
                                if(!autoridad0.isEmpty()){
                                                                           
                                       Matrimonio cm = new Matrimonio(id0, fecha0, lugar0, esposo0, esposa0, autoridad0);
                                        controladorMatrimonio.crear(cm);
                                        System.out.println("Lista Matrimonios "+controladorMatrimonio.lista);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                                    }}else{
                                    JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                                } }else{
                                JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                            }}else{
                            JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Revisar!! un campo se encientra vacio");
                }
            }
       public void limpiar(){
       txtid0.setText("");
       txtesposo0.setText("");
       txtesposa0.setText("");
       txtesposo0.setText("");
       txtesposa0.setText("");
       txtautoridad0.setText("");
       }
       
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtid0 = new javax.swing.JTextField();
        txtfecha0 = new javax.swing.JTextField();
        txtlugar0 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtautoridad = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtesposo0 = new javax.swing.JTextField();
        txtesposa0 = new javax.swing.JTextField();
        txtautoridad0 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable0 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("DATOS PARA RESERVACION");

        jLabel3.setText("FECHA:");

        jLabel4.setText("LUGAR:");

        jLabel16.setText("ID:");

        jLabel6.setText("Esposo");

        txtautoridad.setText("Autoridad");

        jLabel11.setText("Esposa");

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtable0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FECHA", "Title LUGAR", "ESPOSO", "ESPOSA", "AUTORIDAD"
            }
        ));
        jScrollPane2.setViewportView(jtable0);

        jButton2.setText("Verficar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(351, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtautoridad)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtesposo0, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtesposa0, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtid0)
                        .addComponent(txtfecha0)
                        .addComponent(txtlugar0, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3)
                        .addComponent(txtautoridad0, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfecha0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlugar0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtesposa0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(txtesposo0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtautoridad)
                    .addComponent(txtautoridad0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    // verificaciondepersonas();
      verificaresposo();
      verificaresposa();
      verificarautoridad();
      System.out.println(controladorMatrimonio.lista);
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         registromatrimonio();
         listarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        // TODO add your handling code here:
           try {
            controladorMatrimonio.guardarDatos(ruta2);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        }
      
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int fila = jtable0.getSelectedRow();
        if(fila>=0){
            modelo.removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar Fila");}
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazDatosReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazDatosReserva().setVisible(true);
            }
        });
    }
    

    public boolean buscaPersonas(String name){
        
      boolean encontrado =false;
      
        int i=0;
        while (encontrado == false && i< controladorPersonas.lista.size()){
            if(controladorPersonas.lista.get(i).getNombre().compareToIgnoreCase(name)==0){
                encontrado=true;
            }else{
                i++;
            }
        }if(encontrado){
            JOptionPane.showConfirmDialog(null, "Encontrado");
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "Persona no encontrada");
        }
        return true;
    }
public void cargarDatos(int posicion) {
        if (posicion >= 0) {
            Persona persona = controladorPersonas.getLista().get(posicion);
            System.out.println(controladorPersonas.lista);
             txtesposa0.setText(persona.getNombre());
        }
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtable0;
    private javax.swing.JLabel txtautoridad;
    private javax.swing.JTextField txtautoridad0;
    private javax.swing.JTextField txtesposa0;
    private javax.swing.JTextField txtesposo0;
    private javax.swing.JTextField txtfecha0;
    private javax.swing.JTextField txtid0;
    private javax.swing.JTextField txtlugar0;
    // End of variables declaration//GEN-END:variables
}
