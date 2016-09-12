package gimnasio;

import dao.DAO;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que contiene detalle de Salarios.
 * @author missael
 */
public class DetallesDePagos extends javax.swing.JDialog {

    /**
     * Fecha inicial.
     */
    private String fechaInicial = "";
    /**
     * Fecha de final.
     */
    private String fechaFinal = "";
    /**
     * Salario por hora.
     */
    private String salarioHora = "";
    /**
     * Salario por Dia.
     */
    private String salarioDia = "";
    /**
     * Constructor.
     * @param parent Frame.
     * @param modal Modal.
     */
    public DetallesDePagos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        inicializa();
    }

    private void inicializa() {
        DAO dao = new DAO();
        dao.cargaTablaEmpleados(tblEmpleados);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        ContenedorDetallesPago = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox();
        txtPeriodo = new javax.swing.JTextField();
        ContenedorBotones = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        ContenedorBotones1 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ContenedorDetallesPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de pagos"));

        lblTotal.setText("Total");

        txtTotal.setEnabled(false);

        btnImprimir.setText("Autorizar");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir);

        jLabel1.setText("Periodo :");

        jLabel3.setText("Horas Trabajadas :");

        jLabel4.setText("Dias Trabajados :");

        jLabel5.setText("Sueldo :");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por Hora", "Por Dia" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenedorDetallesPagoLayout = new javax.swing.GroupLayout(ContenedorDetallesPago);
        ContenedorDetallesPago.setLayout(ContenedorDetallesPagoLayout);
        ContenedorDetallesPagoLayout.setHorizontalGroup(
            ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ContenedorDetallesPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorDetallesPagoLayout.createSequentialGroup()
                        .addGap(0, 628, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenedorDetallesPagoLayout.createSequentialGroup()
                        .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ContenedorDetallesPagoLayout.createSequentialGroup()
                                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ContenedorDetallesPagoLayout.createSequentialGroup()
                                        .addComponent(txtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDias)))
                            .addGroup(ContenedorDetallesPagoLayout.createSequentialGroup()
                                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                    .addComponent(txtHoras))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        ContenedorDetallesPagoLayout.setVerticalGroup(
            ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDetallesPagoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(ContenedorDetallesPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ContenedorBotones.setLayout(new java.awt.GridBagLayout());

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        ContenedorBotones.add(btnCancelar, new java.awt.GridBagConstraints());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

        tblEmpleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblEmpleados);

        ContenedorBotones1.setLayout(new java.awt.GridBagLayout());

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        ContenedorBotones1.add(btnCalcular, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ContenedorBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 129, Short.MAX_VALUE)
                    .addComponent(ContenedorBotones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ContenedorDetallesPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenedorDetallesPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenedorBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int option = JOptionPane.showConfirmDialog(rootPane, "Esta a punto de "
                + "autorizar la cantidad de " + txtTotal.getText()
                + " al empleado. ¿Desea Continuar?");
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        salarioDia = "";
        salarioHora = "";
        calculaDatosTrabajados();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void calculaDatosTrabajados() {
        HashMap<String, String> resultados = new HashMap<String, String>();
        int cuentaFilasSeleccionadas = tblEmpleados.getSelectedRowCount();
        //JOptionPane.showMessageDialog(null, "Hay seleccionadas: " + cuentaFilasSeleccionadas + " filas");
        if (cuentaFilasSeleccionadas == 1) {
            try {
                //Sólo hay una fila seleccionada
                int indiceFilaSeleccionada = tblEmpleados.getSelectedRow();
                String numEmpleado = String.valueOf(tblEmpleados.getValueAt(
                        indiceFilaSeleccionada, 0));
                
                fechaInicial = "2016-09-01";
                fechaFinal = "2016-09-15";
                resultados = new DAO().calculaHorasTrabajadas(
                        fechaInicial, fechaFinal, numEmpleado);

                
                int dias = Integer.parseInt(resultados.get("Dias"));
                String horas = resultados.get("Horas").split(":")[0];
                salarioDia = resultados.get("SalarioDia");
                salarioHora = resultados.get("SalarioHora");

                double sueldoHora = Double.parseDouble(salarioHora);

                txtTotal.setText("" + (sueldoHora * Integer.parseInt(horas)));

                txtPeriodo.setText("De " + fechaInicial + " a "
                        + fechaFinal);
                txtDias.setText(String.valueOf(dias));
                txtHoras.setText(horas);
                txtSueldo.setText(String.valueOf(sueldoHora));

                
            } catch (SQLException ex) {
                Logger.getLogger(DetallesDePagos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Ocurrio un error al"
                        + " intentar realizar los calculos.");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccione solo un empleado");
        }

        


     }
    /**
     * Calcula el salario de un empleado X.
     */
    
    public void CargarPagosRealizados(String ClaveInscripcion){
//        String FoliosDePagos = "Select Folio,NombreQuienRealizaPago,Autorizador, Fecha, Total from foliospagos where ClaveInscripcion='"+ClaveInscripcion+"'";
//        String[] Titulos = {"FOLIO", "Nombre de quien realizó pago", "Autorizador", "Fecha", "Total"};
//        new Conexion().conectar().CargarDatosEnTabla(FoliosDePagos, Titulos, tblFolios);
//        new Utilerias().adjustColumnPreferredWidths(tblFolios);
    }
    
    public void BuscarFolio() {
//        if (Validaciones.ValidacionesDeDatos.esNumeroEntero(txtFolio, "Folio")) {
//            String Folio = txtFolio.getText();
//            int Resultado = Integer.parseInt(new ConexionConMysql.Conexion().conectar().getDato("select coalesce(count(*),0) from foliospagos where folio='" + Folio + "'"));
//            if (Resultado == 0) {
//                JOptionPane.showMessageDialog(null, "El Folio no genero ningun resultado");
//                btnImprimir.setEnabled(false);
//            } else {
//                btnImprimir.setEnabled(true);
//            }
//
//            CargarTablaDetallePagos(Folio);
//
//        }
    }

    public void CargarTablaDetallePagos(String Folio) {
//        String sql1 = "select concat('MENSUALIDAD ', mes)as concepto, costo, porccargo,cargo,porcdcto,dcto,total  "
//                + "from calendariodepagos where folio = '" + Folio + "'";
//        String sql2 = "select  concepto, costo, porcentajerecargo,recargo,porcentajedcto,dcto,total "
//                + "from detallepagos where folio='" + Folio + "'";
//
//        System.out.println(sql1);
//        Conexion baseDatos = new Conexion().conectar();
//        String[] Titulos = {"CONCEPTO", "SUBTOTAL", "%RECARGO", "RECARGO", "%DESCUENTO", "DESCUENTO", "TOTAL"};
//        String[] Datos = new String[Titulos.length];
//        DefaultTableModel Modelo = new DefaultTableModel(null, Titulos);
//        tblDetalle.getTableHeader().setFont(new Font("Arial Narrow", 1, 8));
//        ResultSet resultados = baseDatos.consultar(sql1);
//        if (resultados != null) {
//            try {
//                while (resultados.next()) {
//                    int j = 0;
//                    for (int i = 1; i <= Datos.length; i++) {
//                        Datos[j] = resultados.getString(i);
//                        j++;
//                    }
//                    Modelo.addRow(Datos);
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//        resultados = baseDatos.consultar(sql2);
//        if (resultados != null) {
//            try {
//                while (resultados.next()) {
//                    int j = 0;
//                    for (int i = 1; i <= Datos.length; i++) {
//                        Datos[j] = resultados.getString(i);
//                        j++;
//                    }
//                    Modelo.addRow(Datos);
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//        tblDetalle.setModel(Modelo);
//        ((DefaultTableCellRenderer) tblDetalle.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
////        new Utilerias().adjustColumnPreferredWidths(tblDetallesPago);

        setTotal(Folio);

    }

    public void setTotal(String Folio) {
//        String Total = "select Total from FoliosPagos where Folio='"+Folio+"'";
//        System.out.println(Total);
//        Total = new Conexion().conectar().getDato(Total);
//        txtTotal.setText(Total);
    }

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
            java.util.logging.Logger.getLogger(DetallesDePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesDePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesDePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesDePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DetallesDePagos dialog = new DetallesDePagos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorBotones;
    private javax.swing.JPanel ContenedorBotones1;
    private javax.swing.JPanel ContenedorDetallesPago;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
