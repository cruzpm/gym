package gimnasio;

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
import org.jdesktop.swingx.autocomplete.*;

/**
 *
 * @author UnTalNose
 */
public class Tienda extends javax.swing.JFrame {
    public static boolean Confirmar=false;
    public static int IDFolioInsertado = 0;
    public static int IDClienteInsertar = 0;
    public static DefaultTableModel Modelo= new DefaultTableModel();
    String[] Titulos = {"NOMBRE PRODUCTO", "TAMAÑO", "PRECIO UNIT", "CANTIDAD", "TOTAL"};
    ArrayList<String> ArregloList = new ArrayList();
    ArrayList<ArrayList<String>> DatosArrayList = new ArrayList<ArrayList<String>>();
    
    String Fecha(Calendar F) {
        int año = F.get(Calendar.YEAR);
        int mes = F.get(Calendar.MONTH) + 1;
        int dia = F.get(Calendar.DAY_OF_MONTH);
        int hora = F.get(Calendar.HOUR_OF_DAY);
        int minuto = F.get(Calendar.MINUTE);
        int segundo = F.get(Calendar.SECOND);
        String FechaHoy = dia + "/";
        if (mes < 10) {
            FechaHoy = FechaHoy + "0" + mes + "/" + año;
        } else {
            FechaHoy = FechaHoy + mes + "/" + año;
        }
        return FechaHoy;
    }

    void AgregarATabla() {
        Conexion basedatos = new Conexion().conectar();
        
        String[] Datos = new String[Titulos.length];

        Modelo = new DefaultTableModel(null, Titulos);
        TablaVentas.setModel(Modelo);

        String NombreProducto = (String) jComboBoxNombreP.getSelectedItem();
        String ConsultarPrecio = "SELECT TAMANIO,PRECIO FROM PRODUCTOS WHERE NombreProducto='" + NombreProducto + "'";
        ResultSet rs = basedatos.consultar(ConsultarPrecio);
        String Tamaño = "";
        int PrecioUnit = 0;
        try {
            while (rs.next()) {
                Tamaño = rs.getString("tamanio");
                PrecioUnit = rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

        int Cantidad = Integer.parseInt(txtCantidad.getText());
        double Total = Cantidad * PrecioUnit;

        ArregloList.add((String) jComboBoxNombreP.getSelectedItem());
        ArregloList.add(Tamaño);
        ArregloList.add(String.valueOf(PrecioUnit));
        ArregloList.add(String.valueOf(Cantidad));
        ArregloList.add(String.valueOf(Total));

        double TotalDeTotales = Double.parseDouble(txtTotal.getText());
        TotalDeTotales = TotalDeTotales + Total;
        txtTotal.setText(String.valueOf(TotalDeTotales));

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
        System.out.println("");
        /*
        for (ArrayList<String> NumeroArray : DatosArrayList) {
            for (String datos : NumeroArray) {
                    //Datos[i] = datos;
                    System.out.print(datos + " / ");
            }
        }*/

    }

    public int ConsultarIDProducto(String NombreProducto) {
        Conexion Basedatos = new Conexion().conectar();
        String Consultar = "SELECT IDPRODUCTO FROM PRODUCTOS WHERE NOMBREPRODUCTO='" + NombreProducto + "'";
        ResultSet rs = Basedatos.consultar(Consultar);
        int IDProducto = 0;
        String IDString = "";
        try {
            while (rs.next()) {
                IDString = rs.getString("IDPRODUCTO");
            }
        } catch (Exception e) {
        }
        IDProducto = Integer.parseInt(IDString);
        return IDProducto;
    }

    void InsertarDetallesVenta() {
        int Columnas = Modelo.getColumnCount();
        int Filas = Modelo.getRowCount();
        System.out.println("Tamaño de la tabla: " + Columnas + "," + Filas);
        Conexion basedatos = new Conexion().conectar();

        for (int i = 0; i < Filas; i++) {
            String Producto = (String) TablaVentas.getValueAt(i, 0);
            String Precio = (String) TablaVentas.getValueAt(i, 2);
            String Cantidad = (String) TablaVentas.getValueAt(i, 3);
            String Total = (String) TablaVentas.getValueAt(i, 4);

            int IDProducto = ConsultarIDProducto(Producto);
            //int ProductoInt = Integer.parseInt(Producto);
            //double PrecioDouble = Double.parseDouble(Precio);
            //int CantidadInt = Integer.parseInt(Cantidad);
            double TotalDouble = Double.parseDouble(Total);
            double TotalDeTotales = 0;
            TotalDeTotales = TotalDeTotales + TotalDouble;
            txtTotal.setText(String.valueOf(TotalDeTotales));

            String Insertar = "INSERT INTO DETALLEVENTAS VALUES('" + IDFolioInsertado + "','" + IDProducto + "','" + Producto + "','"
                    + Precio + "','" + Cantidad + "','" + TotalDouble + "')";
            if (basedatos.ejecutar(Insertar)) {
                JOptionPane.showMessageDialog(null, "Venta Agregada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la venta");
            }

            System.out.println(Insertar);
        }

        /*
        Iterator<String> nombreIterator = ArregloList.iterator();
        while (nombreIterator.hasNext()) {
            for(int i=0; i<Titulos.length;i++){
                Datos[i]=nombreIterator.next();
                System.out.print(Datos[i]+ " / ");
            }
            Modelo.addRow(Datos);
        }*/
    }

    boolean Validar() {
        boolean Confirmar = true;
        if (jComboBoxNombre.getSelectedIndex() < 0) {
            System.out.println("Entro Nombre");
            jComboBoxNombre.requestFocus();
            if (jComboBoxNombreP.getSelectedIndex() < 0) {
                System.out.println("Entro NombreP");
                jComboBoxNombreP.requestFocus();
                if (txtCantidad.getText().trim().length() == 0) {
                    System.out.println("Entro Cantidad");
                    txtCantidad.requestFocus();
                    if (txtTotal.getText().equals("0.0")) {
                        System.out.println("Entro Total");
                        Confirmar = false;
                    }
                }
            }
        }
        return Confirmar;
    }

    void Insertar() {
        Conexion baseDatos = new Conexion().conectar();
        Conexion baseDatos1 = new Conexion().conectar();
        Conexion baseDatos2 = new Conexion().conectar();
        String IDCliente = (String) jComboBoxNombre.getSelectedItem();
        //int IDCliente = jComboBoxNombre.getSelectedIndex();
        System.out.println(IDCliente);
        Calendar FechaVenta = Calendar.getInstance();
        String FechaString = Fecha(FechaVenta);
        String TotString = txtTotal.getText();
        //SELECT CONCAT(nombre, ' ', apellidos) AS NAME, IDCliente FROM c_datosGenerales HAVING NAME LIKE '"+IDCliente+"'";
        String ConsultarIDCliente = "SELECT IDCLIENTE FROM c_datosGenerales WHERE CONCAT(nombre, ' ', apellidos)='" + IDCliente + "'";
        System.out.println(ConsultarIDCliente);
        ResultSet Resultado1 = baseDatos.consultar(ConsultarIDCliente);
        try {
            while (Resultado1.next()) {
                IDClienteInsertar = Resultado1.getInt("IDCLIENTE");
                JOptionPane.showMessageDialog(null, "IDCLIENTE: " + IDClienteInsertar);

                String Insertar = "INSERT INTO TIENDA(Idcliente,Autorizador,FechaVta,Total) "
                        + "VALUES('" + IDClienteInsertar + "','" + Login.UsuarioLogueado + "','" + FechaString + "','" + TotString + "');";
                if(baseDatos1.ejecutar(Insertar)){
                    Confirmar = true;
                }
                System.out.println(Insertar);

            }
        } catch (Exception e) {
        }

        //int IDClienteEntero = Integer.parseInt(IDClienteInsertar);
        String ObtenerID = "SELECT MAX(FOLIO) AS ID FROM TIENDA;";
        ResultSet rs = baseDatos2.consultar(ObtenerID);
        try {
            while (rs.next()) {
                IDFolioInsertado = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("IDClienteInsertado es : " + IDFolioInsertado);

    }

    void Eliminar() {
        Conexion basedatos4 = new Conexion().conectar();
        String Eliminar = "DELETE FROM tienda WHERE Folio = '" + IDFolioInsertado + "'";
        System.out.println(Eliminar);

        if (basedatos4.ejecutar(Eliminar)) {
            JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente");
        }

    }

    void Cancelar() {
        jComboBoxNombre.setSelectedItem("");
        jComboBoxNombreP.setSelectedItem("");
        txtCantidad.setText("");
        txtTotal.setText("0.0");
        int Columnas=TablaVentas.getColumnCount();
        int Filas = TablaVentas.getRowCount();
        System.out.println(Columnas+","+Filas);
        TablaVentas.setModel(Modelo);
        /*for (int i = 0; i <TablaVentas.getRowCount(); i++) {
            //TablaVentas.remove(i);
            Modelo.removeRow(i);
        }*/
    }

    void Buscar(String texto) {
        //where concat(Folio,Nombre,apellidos,Direccion,ciudad,FechaNacimiento,telefono,Puesto,FechaContratacion) like '%" + texto + "%'"
        String Folio = "Select folio,IdProducto,Producto,Precio,Cantidad,Total  from detalleventas ";
        Conexion baseDatos = new Conexion().conectar();
        String[] Titulos = {"NOMBRE PRODUCTO", "PRECIO UNIT", "CANTIDAD", "TOTAL"};
        String[] Datos = new String[Titulos.length];
        Modelo = new DefaultTableModel(null, Titulos);

        ResultSet resultados = baseDatos.consultar(Folio);

        if (resultados != null) {
            try {
                while (resultados.next()) {
                    for (int i = 0; i < Datos.length; i++) {
                        Datos[i] = resultados.getString(i + 1);
                    }
                    Modelo.addRow(Datos);
                }
                TablaVentas.setModel(Modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + "qqqq");
            }
        } else {
            System.out.println("No hay Datos insertados");
            JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void LlenarComboBoxNombre() {
        Conexion ConexionComboBox = new Conexion().conectar();
        String consulta = "SELECT CONCAT(Nombre,' ',Apellidos) as Concatenacion FROM c_datosgenerales;";
        ResultSet Rs = ConexionComboBox.consultar(consulta);
        AutoCompleteDecorator.decorate(jComboBoxNombre);
        try {
            while (Rs.next()) {
                jComboBoxNombre.addItem(Rs.getString("Concatenacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void LlenarComboBoxProducto() {
        Conexion ConexionComboBox1 = new Conexion().conectar();
        String consulta = "SELECT NombreProducto FROM Productos;";
        ResultSet Rs = ConexionComboBox1.consultar(consulta);
        AutoCompleteDecorator.decorate(jComboBoxNombreP);
        try {
            while (Rs.next()) {
                jComboBoxNombreP.addItem(Rs.getString("NombreProducto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Creates new form Venta
     */
    public Tienda() {
        initComponents();
        LlenarComboBoxNombre();
        LlenarComboBoxProducto();
        Modelo = new DefaultTableModel(null, Titulos);
        //Buscar("");
        txtTotal.setText("0.0");
        txtCantidad.setText("1");
        jComboBoxNombre.setSelectedItem("");
        LabelNombreUsuario.setText("Venta realizada por : " + Login.UsuarioLogueado);
        LabelNombreUsuario.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jComboBoxNombre = new javax.swing.JComboBox<>();
        jLabelNombreP = new javax.swing.JLabel();
        jComboBoxNombreP = new javax.swing.JComboBox<>();
        jLabelCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnCobrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        LabelNombreUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabelNombre.setText("Nombre del cliente:");

        jLabelNombreP.setText("Nombre del producto:");

        jLabelCantidad.setText("Cantidad:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE PRODUCTO", "TAMAÑO", "PRECIO UNIT.", "CANTIDAD", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TablaVentas);

        jLabelTotal.setText("Total:");

        txtTotal.setEditable(false);

        btnCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnCobrar.setText("Cobrar");
        btnCobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCobrarMouseClicked(evt);
            }
        });
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        LabelNombreUsuario.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        LabelNombreUsuario.setToolTipText("");
        LabelNombreUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNombreP)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotal)
                                .addGap(35, 35, 35)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCobrar)
                                .addGap(147, 147, 147)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jComboBoxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombreP)
                            .addComponent(jComboBoxNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCantidad)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTotal)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCobrar)
                    .addComponent(btnCancelar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseClicked
        JOptionPane.showConfirmDialog(this, "Confirmar venta");
    }//GEN-LAST:event_btnCobrarMouseClicked

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if (txtCantidad.getText().length() == 2) {
            getToolkit().beep();
            evt.consume();
        }
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //Insertar();
        AgregarATabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (Validar() == false) {
            dispose();
        } else {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        if (TablaVentas.getColumnCount() <= 0 || TablaVentas.getRowCount() <=0
                || jComboBoxNombre.getSelectedIndex() < 0 || jComboBoxNombreP.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Asegurate que todos los campos esten llenos");
        } else {
            int confirmado = JOptionPane.showConfirmDialog(this, "¿Está seguro al realizar la venta?");
            if (JOptionPane.OK_OPTION == confirmado) {
                if(Confirmar == true){
                    InsertarDetallesVenta();
                }
                Insertar();
                
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se insertó nada");
            }
        }


    }//GEN-LAST:event_btnCobrarActionPerformed

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
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNombreUsuario;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JComboBox<String> jComboBoxNombre;
    private javax.swing.JComboBox<String> jComboBoxNombreP;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreP;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
