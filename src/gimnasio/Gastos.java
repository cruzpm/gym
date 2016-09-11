/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import static gimnasio.Productos.Modelo;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mancilla
 */
public class Gastos extends javax.swing.JFrame {

    public static int IDConsulta = 0;
    Calendar Fecha = Calendar.getInstance();
    String FechaHoy = Inscripcion.Fecha(Fecha);
    String[] Titulos = {"ID GASTO","AUTORIZADO POR","DESCRIPCION", "PRECIO", "CANTIDAD", "TOTAL","FECHA"};
    ArrayList<String> ArregloList = new ArrayList();
    ArrayList<ArrayList<String>> DatosArrayList = new ArrayList<ArrayList<String>>();
    
void AgregarATabla() {
        Conexion basedatos = new Conexion().conectar();
        String[] Datos = new String[Titulos.length];
        Modelo = new DefaultTableModel(null, Titulos);
        TablaGastos.setModel(Modelo);
        
        String ID = txtIDG.getText();
        String Descripcion = txtDescripcionG.getText();
        String Precio = txtPrecioG.getText();
        String Cantidad = txtCantidadG.getText();
        String Total = txtTotalG.getText();

        //String[] Titulos = {"ID GASTO","AUTORIZADO POR","DESCRIPCION", "PRECIO", "CANTIDAD", "TOTAL","FECHA"};
        ArregloList.add(ID);
        ArregloList.add(Login.UsuarioLogueado);
        ArregloList.add(Descripcion);
        ArregloList.add(Precio);
        ArregloList.add(Cantidad);
        ArregloList.add(Total);
        ArregloList.add(FechaHoy);
        //'" + ID + "','"+Login.UsuarioLogueado+"','" + Descripcion + "','" + Precio + "','" + 
        //Cantidad + "','" + Total + "','"+FechaHoy+"')";

        DatosArrayList.add(ArregloList);

        // Declaramos el Iterador e imprimimos los Elementos del ArrayList
        Iterator<String> nombreIterator = ArregloList.iterator();
        while (nombreIterator.hasNext()) {
            for (int i = 0; i < Titulos.length; i++) {
                Datos[i] = nombreIterator.next();
                System.out.print(Datos[i] + " / ");
            }
            Modelo.addRow(Datos);
        }
        int IDEntero = Integer.parseInt(ID) + 1;
        ID = String.valueOf(IDEntero);
        txtIDG.setText(ID);
        System.out.println("");

    }
    void Insertar() {
        Conexion basedatos1 = new Conexion().conectar();
        String ID = txtIDG.getText();
        String Descripcion = txtDescripcionG.getText();
        String Precio = txtPrecioG.getText();
        String Cantidad = txtCantidadG.getText();
        String Total = txtTotalG.getText();
        String Insertar = "Insert into gastos values('" + ID + "','"+Login.UsuarioLogueado+"','" + Descripcion + "','" + Precio + "','" + Cantidad + "','" + Total + "','"+FechaHoy+"')";
        //String Insertar = "Insert into detallegastos values(IDGasto='"+ID+"', Descripcion= '"+Descripcion+"',Precio='"+Precio+"',Cantidad='"+Cantidad+"',Total='"+Total+"')";
        System.out.println(Insertar);
        if (basedatos1.ejecutar(Insertar)) {
            ID();
            JOptionPane.showMessageDialog(null, "Insertado Correctamente");
        }
    }

    /*public void Buscar(String Texto) {
        Conexion baseDatos = new Conexion().conectar();
        
        String[] Datos = new String[Titulos.length];
        Modelo = new DefaultTableModel(null, Titulos);
        String Consulta = "SELECT * FROM Gastos where concat(IdGasto,NombreEmpleado,Descripcion,Precio,Cantidad,Total) like '%" + Texto + "%' and Fecha='" + FechaHoy + "';";
        ResultSet resultados = baseDatos.consultar(Consulta);
        System.out.println(Consulta+"\n"+FechaHoy);
        if (resultados != null) {
            try {
                while (resultados.next()) {
                    for (int i = 0; i < Datos.length; i++) {
                        Datos[i] = resultados.getString(i + 1);
                    }
                    Modelo.addRow(Datos);
                }
                TablaGastos.setModel(Modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + "qqqq");
            }
        }
    }*/

    void ID() {
        Conexion basedatosID = new Conexion().conectar();
        //String Consulta="select max(Idgastos) as Maximo from gastos;";
        ResultSet Resultado = basedatosID.consultar("select max(Idgasto) as Maximo from gastos;");
        try {
            while (Resultado.next()) {
                IDConsulta = Resultado.getInt("Maximo");
                txtIDG.setText(String.valueOf(IDConsulta + 1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Gastos() {
        initComponents();
        //Buscar("");
        ID();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDescripcion = new javax.swing.JLabel();
        txtDescripcionG = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        txtPrecioG = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaGastos = new javax.swing.JTable();
        btnnAgregarGasto = new javax.swing.JButton();
        btnCancelarGasto = new javax.swing.JButton();
        txtTotalG = new javax.swing.JTextField();
        jLabelTotal1 = new javax.swing.JLabel();
        txtCantidadG = new javax.swing.JTextField();
        jLabelDescripcion1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDG = new javax.swing.JTextField();
        btnnAgregarGasto1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelDescripcion.setText("Descripción:");

        jLabelTotal.setText("Precio:");

        txtPrecioG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioGFocusLost(evt);
            }
        });
        txtPrecioG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioGKeyTyped(evt);
            }
        });

        TablaGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaGastos);

        btnnAgregarGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar.png"))); // NOI18N
        btnnAgregarGasto.setText("Agregar");
        btnnAgregarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnAgregarGastoActionPerformed(evt);
            }
        });

        btnCancelarGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelarbtn.png"))); // NOI18N
        btnCancelarGasto.setText("Cancelar");
        btnCancelarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarGastoActionPerformed(evt);
            }
        });

        txtTotalG.setEditable(false);

        jLabelTotal1.setText("Total:");

        txtCantidadG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadGFocusLost(evt);
            }
        });
        txtCantidadG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadGKeyTyped(evt);
            }
        });

        jLabelDescripcion1.setText("Cantidad:");

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel1.setText("GASTOS");

        jLabel2.setText("ID:");

        txtIDG.setEditable(false);

        btnnAgregarGasto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar.png"))); // NOI18N
        btnnAgregarGasto1.setText("Grabar");
        btnnAgregarGasto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnAgregarGasto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecioG, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDescripcion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadG, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTotal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalG, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnCancelarGasto)
                        .addGap(34, 34, 34)
                        .addComponent(btnnAgregarGasto1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescripcionG, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addComponent(btnnAgregarGasto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescripcion)
                    .addComponent(txtDescripcionG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnAgregarGasto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(txtPrecioG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescripcion1)
                    .addComponent(txtCantidadG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotal1)
                    .addComponent(txtTotalG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarGasto)
                    .addComponent(btnnAgregarGasto1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarGastoActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarGastoActionPerformed

    private void btnnAgregarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnAgregarGastoActionPerformed
        AgregarATabla();
        
        //Buscar("");
    }//GEN-LAST:event_btnnAgregarGastoActionPerformed

    private void txtCantidadGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadGFocusLost
        txtTotalG.setText(String.valueOf(Float.parseFloat(txtPrecioG.getText())*Float.parseFloat(txtCantidadG.getText())));
        btnnAgregarGasto.requestFocus();
    }//GEN-LAST:event_txtCantidadGFocusLost

    private void txtPrecioGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioGFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioGFocusLost

    private void txtPrecioGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioGKeyTyped
        if (!Character.isDigit(evt.getKeyChar())&& evt.getKeyChar()!='.') {
            evt.consume();
        }
        if(evt.getKeyChar()=='.'&&txtPrecioG.getText().contains(".")){
            evt.consume();
        }
    
    }//GEN-LAST:event_txtPrecioGKeyTyped

    private void txtCantidadGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadGKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
//        if(evt.getKeyChar()=='.'&&txtPrecioG.getText().contains(".")){
//            evt.consume();
//        }
    }//GEN-LAST:event_txtCantidadGKeyTyped

    private void btnnAgregarGasto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnAgregarGasto1ActionPerformed
        Insertar();
    }//GEN-LAST:event_btnnAgregarGasto1ActionPerformed

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
            java.util.logging.Logger.getLogger(Gastos.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gastos.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gastos.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gastos.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gastos().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaGastos;
    private javax.swing.JButton btnCancelarGasto;
    private javax.swing.JButton btnnAgregarGasto;
    private javax.swing.JButton btnnAgregarGasto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcion1;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotal1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidadG;
    private javax.swing.JTextField txtDescripcionG;
    private javax.swing.JTextField txtIDG;
    private javax.swing.JTextField txtPrecioG;
    private javax.swing.JTextField txtTotalG;
    // End of variables declaration//GEN-END:variables
}
