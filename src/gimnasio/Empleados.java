package gimnasio;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mancilla
 */
public class Empleados extends javax.swing.JInternalFrame {

    public static DefaultTableModel Modelo;
    public static String IDModificar = "";
    public static boolean Confirm = true;
    public static int ID = 0;

    void LlenarComboBox() {
        Conexion ConexionComboBox = new Conexion().conectar();
        String consulta = "Select Descripcion from puestos";
        ResultSet Rs = ConexionComboBox.consultar(consulta);
        try {
            while (Rs.next()) {
                ComboBoxPuesto.addItem(Rs.getString("Descripcion"));
                System.out.println(Rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
    void Buscar(String texto) {
        String mostrar = "Select * from empleados where concat(IDEmpleado,Nombre,apellidos,Direccion,ciudad,FechaNacimiento,telefono,Puesto,FechaContratacion) like '%" + texto + "%'";
        Conexion baseDatos = new Conexion().conectar();
        String[] Titulos = {"ID EMPLEADO", "NOMBRE", "APELLIDOS", "DIRECCION", "CIUDAD", "FECHA NACIMIENTO", "TELEFONO", "PUESTO", "CONTRATACION"};
        String[] Datos = new String[Titulos.length];
        Modelo = new DefaultTableModel(null, Titulos);

        ResultSet resultados = baseDatos.consultar(mostrar);

        if (resultados != null) {
            try {
                while (resultados.next()) {
                    for (int i = 0; i < Datos.length; i++) {
                        Datos[i] = resultados.getString(i + 1);
                    }
                    Modelo.addRow(Datos);
                }
                TablaEmpleados.setModel(Modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + "qqqq");
            }
        } else {
            System.out.println("No hay Datos insertados");
            JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void Bloquear() {
        txtNombre.setEditable(false);
        txtApellidos.setEditable(false);
        txtDireccion.setEditable(false);
        txtCiudad.setEditable(false);
        DCFechaN.setEnabled(false);
        txtTelefono.setEditable(false);
        ComboBoxPuesto.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
    }
    void Desbloquear() {
        txtNombre.setEditable(true);
        txtApellidos.setEditable(true);
        txtDireccion.setEditable(true);
        txtCiudad.setEditable(true);
        DCFechaN.setEnabled(true);
        txtTelefono.setEditable(true);
        ComboBoxPuesto.setEnabled(true);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnCancelar.setEnabled(true);
    }
    void BorrarDatos() {
        txtID.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
        DCFechaN.setDateFormatString("");
        txtTelefono.setText("");
        ComboBoxPuesto.setSelectedIndex(-1);
    }
    public boolean ValidarCasillas() {
        if (txtNombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "NOMBRE campo vacio");
        } else if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Apellidos campo vacio");
        } else if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Dirección campo vacio");
        } else if (txtCiudad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ciudad campo vacio");
        } else if (DCFechaN.getDateFormatString().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Fecha de Nacimiento campo vacio");
        } else if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Telefono campo vacio");
        } else {
            Confirm = false;
        }
        return Confirm;
    }
    void InsertarEmpleado() {
        Calendar FechaContrato = Calendar.getInstance();
        if (ValidarCasillas() == false) {
            try {
                String ID = txtID.getText();
                String Nombre = txtNombre.getText();
                String Apellidos = txtApellidos.getText();
                String Direccion = txtDireccion.getText();
                String Ciudad = txtCiudad.getText();
                Calendar FechaN = DCFechaN.getCalendar();

                JOptionPane.showMessageDialog(null, "FECHA DE NACIMIENTO : " + Fecha(FechaN));
                String Telefono = txtTelefono.getText();
                String Puesto = (String) ComboBoxPuesto.getSelectedItem();

                Conexion basedatos = new Conexion().conectar();
                String Insertar = "INSERT INTO Empleados(Nombre,Apellidos,Direccion,Ciudad,Fechanacimiento,Telefono,Puesto,FechaContratacion) "
                        + "VALUES('" + Nombre + "','" + Apellidos + "','" + Direccion + "','" + Ciudad + "','" + Fecha(FechaN)
                        + "','" + Telefono + "','" + Puesto + "','" + Fecha(FechaContrato) + "');";
                System.out.println(Insertar);
                if (basedatos.ejecutar(Insertar)) {
                    JOptionPane.showMessageDialog(null, "Empleado agregado");
                    BorrarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Agregar el Empleado");
                }
                Buscar("");
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
    }
    void BotonModificar() {
        Conexion Modificar = new Conexion().conectar();
        String Nombre = txtNombre.getText();
        String Apellidos = txtApellidos.getText();
        String Direccion = txtDireccion.getText();
        String Ciudad = txtCiudad.getText();
        Calendar Nacimiento = DCFechaN.getCalendar();
        String Fechanacimiento = Fecha(Nacimiento);
        String Telefono = txtTelefono.getText();
        String Puesto = (String) ComboBoxPuesto.getSelectedItem();
        Calendar FContratacion = Calendar.getInstance();
        String FechaContratacion = Fecha(FContratacion);

        String Actualizar = "Update empleados set Nombre='" + Nombre + "',Apellidos='" + Apellidos + "',Direccion='" + Direccion + "',Ciudad='"
                + Ciudad + "',Fechanacimiento='" + Fechanacimiento + "',Telefono='" + Telefono + "',Puesto='" + Puesto
                + "',FechaContratacion='" + FechaContratacion + "' where idEmpleado ='" + IDModificar + "'";
        System.out.println(Actualizar);
        if (Modificar.ejecutar(Actualizar)) {
            JOptionPane.showMessageDialog(null, "Empleado Modificado");
            Confirm = true;
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al Modificar Empleado");
        }
    }
    void Modificar() {
        int filamodificar = TablaEmpleados.getSelectedRow();
        if (filamodificar >= 0) {
            IDModificar = TablaEmpleados.getValueAt(filamodificar, 0).toString();
            txtID.setText(IDModificar);
            txtNombre.setText(TablaEmpleados.getValueAt(filamodificar, 1).toString());
            txtApellidos.setText(TablaEmpleados.getValueAt(filamodificar, 2).toString());
            txtDireccion.setText(TablaEmpleados.getValueAt(filamodificar, 3).toString());
            txtCiudad.setText(TablaEmpleados.getValueAt(filamodificar, 4).toString());
            String FechaString = TablaEmpleados.getValueAt(filamodificar, 5).toString();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fechaDate = formato.parse(FechaString);
                DCFechaN.setDate(fechaDate);
            } catch (ParseException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }

            //CalendarFecha.setDateFormatString(FechaString);
            //CalendarFecha.setDateFormatString(TablaEmpleados.getValueAt(filamodificar, 5).toString());
            txtTelefono.setText(TablaEmpleados.getValueAt(filamodificar, 6).toString());
            ComboBoxPuesto.setSelectedItem(TablaEmpleados.getValueAt(filamodificar, 7).toString());
            btnModificar.setEnabled(true);
            btnNuevo.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona el empleado a modificar");
        }

    }

    /**
     * Creates new form NewJInternalFrame
     */
    public Empleados() {
        initComponents();
        Buscar("");
        Bloquear();
        LlenarComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jLabelID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabelCiudad = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabelFechaN = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabelBuscar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        DCFechaN = new com.toedter.calendar.JDateChooser();
        ComboBoxPuesto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        jLabelID.setText("ID :");

        txtID.setEditable(false);

        jLabelNombre.setText("Nombre:");

        jLabelApellidos.setText("Apellidos:");

        jLabelDireccion.setText("Dirección:");

        jLabelCiudad.setText("Ciudad:");

        jLabelFechaN.setText("Fecha de Nacimiento:");

        jLabelTelefono.setText("Telefono:");

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaEmpleados.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TablaEmpleados);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCerrar.setText("Salir");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabelBuscar.setText("Buscar:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        DCFechaN.setDateFormatString("dd/MM/yyyy");

        jLabel2.setText("Tipo de Usuario: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(14, 14, 14)
                        .addComponent(btnCerrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelID)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabelNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabelApellidos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelBuscar)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(105, 105, 105))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelTelefono)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(ComboBoxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelDireccion)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelCiudad)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)))
                                        .addComponent(jLabelFechaN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DCFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDireccion)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCiudad)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelFechaN))
                    .addComponent(DCFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBuscar))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnNuevo)
                    .addComponent(btnCerrar)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost

    }//GEN-LAST:event_txtTelefonoFocusLost

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        InsertarEmpleado();
        Bloquear();
        BorrarDatos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        Buscar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        String Consulta = "Select max(idempleado) from empleados";
        Conexion ConsultaID = new Conexion().conectar();
        ResultSet ResultadoID = ConsultaID.consultar(Consulta);
        try {
            while (ResultadoID.next()) {
                ID = Integer.parseInt(ResultadoID.getString(1));
                ID = ID + 1;
                System.out.println("ESTE ES EL MÁXIMO DE LOS ID: " + ID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtID.setText(String.valueOf(ID));
        Desbloquear();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        FrameInterno Cerrar = new FrameInterno();
        Cerrar.setVisible(true);

        Principal.PanelInterno.removeAll();
        Principal.PanelInterno.add(Cerrar);
        try {
            Cerrar.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        BorrarDatos();
        Bloquear();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        Desbloquear();
        Modificar();
        TablaEmpleados.clearSelection();
        Buscar("");
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
    }//GEN-LAST:event_ModificarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        BotonModificar();
        if (Confirm == true) {
            BorrarDatos();
            Bloquear();
            TablaEmpleados.clearSelection();
            Buscar("");
        }
        btnNuevo.setEnabled(true);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try {
            Conexion basedatos = new Conexion().conectar();
            int fila = TablaEmpleados.getSelectedRow();
            String IDE = TablaEmpleados.getValueAt(fila, 0).toString();
            System.out.println(IDE);
            String Nom = TablaEmpleados.getValueAt(fila, 1).toString();
            System.out.println(Nom);
            int confirmado = JOptionPane.showConfirmDialog(null,
                    "Seguro de eliminar el Empleado con nombre '" + Nom + "'", "Confirmar Salida",
                    JOptionPane.OK_OPTION);

            if (JOptionPane.OK_OPTION == confirmado) {
                String Eliminar = "DELETE FROM empleados WHERE IDEmpleado = '" + IDE + "'";
                System.out.println(Eliminar);
                if (basedatos.ejecutar(Eliminar)) {
                    JOptionPane.showMessageDialog(null, "Elemento Eliminado");

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Eliminar");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        TablaEmpleados.clearSelection();
        Buscar("");
    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxPuesto;
    private com.toedter.calendar.JDateChooser DCFechaN;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFechaN;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
