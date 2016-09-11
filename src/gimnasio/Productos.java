/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane.*;

/**
 *
 * @author UnTalNose
 */
public class Productos extends javax.swing.JFrame {
    public static DefaultTableModel Modelo;
    public void BorrarDatos() {
        txtNombreP.setText("");
        txtIDProductos.setText("");
        txtPrecio.setText("");
        txtTamanio.setText("");
        txtStock.setText("");
    }

    public void RellenarTabla(String Texto) {
        Conexion baseDatos = new Conexion().conectar();
        String[] Titulos = {"ID PRODUCTO", "NOMBRE PRODUCTO", "STOCK", "TAMAÑO", "PRECIO"};
        String[] Datos = new String[Titulos.length];
        Modelo = new DefaultTableModel(null, Titulos);
        ResultSet resultados = baseDatos.consultar("SELECT * FROM PRODUCTOS where concat(Idproducto,Nombreproducto,stock,tamanio,precio) like '%"+Texto+"%'");
        if (resultados != null) {
            try {
                while (resultados.next()) {
                    for (int i = 0; i < Datos.length; i++) {
                        Datos[i] = resultados.getString(i + 1);
                    }
                    Modelo.addRow(Datos);
                }
                TablaProductos.setModel(Modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + "qqqq");
            }
        } else {
            System.out.println("No hay Datos insertados");
            JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean ValidarCasillas() {
        boolean confirm = true;
        if (txtIDProductos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "ID campo vacio");
        } else if (txtNombreP.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "NOMBRE campo vacio");
        } else if (txtTamanio.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "TAMAÑO campo vacio");
        } else if (txtStock.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "STOCK campo vacio");
        } else if (txtPrecio.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "PRECIO campo vacio");
        } else {
            confirm = false;
        }
        return confirm;
    }

    public boolean ValidarCasillas1() {
        boolean confirm = true;
        if (txtIDM.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "ID campo vacio");
        } else if (txtNombreM.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "NOMBRE campo vacio");
        } else if (txtTamanioM.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "TAMAÑO campo vacio");
        } else if (txtStockM.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "STOCK campo vacio");
        } else if (txtPrecioM.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "PRECIO campo vacio");
        } else {
            confirm = false;
        }
        return confirm;
    }

    public Productos() {
        initComponents();
        RellenarTabla("");
        if (PanelPrincipal.getSelectedIndex() != 0) {
            if (TablaProductos.getRowSelectionAllowed()) {
                btnEliminar.setEnabled(false);
                btnIrModificar.setEnabled(false);
            }
        }

        PanelPrincipal.remove(2);
        PanelPrincipal.remove(1);
        setLocationRelativeTo(null);
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JTabbedPane();
        PanelProductos = new javax.swing.JPanel();
        jLabelImagenP = new javax.swing.JLabel();
        btnIrCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnIrModificar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        PanelCrear = new javax.swing.JPanel();
        CrearProducto = new javax.swing.JLabel();
        jLabelIDProducto = new javax.swing.JLabel();
        txtIDProductos = new javax.swing.JTextField();
        jLabelNombreP = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        jLabelTamanio = new javax.swing.JLabel();
        txtTamanio = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabelPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        BotonAnadir = new javax.swing.JButton();
        BotonRegresarProductos = new javax.swing.JButton();
        PanelModificar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnCerrarMod = new javax.swing.JButton();
        jLabelImagenM = new javax.swing.JLabel();
        jLabelIdPM = new javax.swing.JLabel();
        txtIDM = new javax.swing.JTextField();
        jLabelNombreM = new javax.swing.JLabel();
        txtNombreM = new javax.swing.JTextField();
        jLabelTamanioM = new javax.swing.JLabel();
        txtTamanioM = new javax.swing.JTextField();
        jLabelStockM = new javax.swing.JLabel();
        txtStockM = new javax.swing.JTextField();
        jLabelPrecioM = new javax.swing.JLabel();
        txtPrecioM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelPrincipal.setFocusable(false);

        PanelProductos.setEnabled(false);
        PanelProductos.setFocusable(false);

        jLabelImagenP.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabelImagenP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ProductosPantalla.png"))); // NOI18N
        jLabelImagenP.setText("Lista de Productos");

        btnIrCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarIcono.png"))); // NOI18N
        btnIrCrear.setText("Añadir");
        btnIrCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrCrearActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/EliminarUsuarioIcono.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnIrModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ModificarUsuario.png"))); // NOI18N
        btnIrModificar.setText("Modificar");
        btnIrModificar.setEnabled(false);
        btnIrModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrModificarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        javax.swing.GroupLayout PanelProductosLayout = new javax.swing.GroupLayout(PanelProductos);
        PanelProductos.setLayout(PanelProductosLayout);
        PanelProductosLayout.setHorizontalGroup(
            PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(PanelProductosLayout.createSequentialGroup()
                        .addGroup(PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProductosLayout.createSequentialGroup()
                                .addComponent(btnIrCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelImagenP, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(btnIrModificar)
                        .addGap(20, 20, 20)
                        .addComponent(btnCerrar)))
                .addGap(15, 15, 15))
        );
        PanelProductosLayout.setVerticalGroup(
            PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnIrModificar)
                    .addComponent(btnIrCrear)
                    .addComponent(btnEliminar))
                .addGap(20, 20, 20))
        );

        PanelPrincipal.addTab("Producrtos", PanelProductos);

        PanelCrear.setDoubleBuffered(false);
        PanelCrear.setEnabled(false);

        CrearProducto.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        CrearProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarCiclo.png"))); // NOI18N
        CrearProducto.setText("Añadir Producto");

        jLabelIDProducto.setText("IDProducto");

        txtIDProductos.setEditable(false);
        txtIDProductos.setText(" ");

        jLabelNombreP.setText("Nombre Producto:");

        txtNombreP.setText(" ");

        jLabelTamanio.setText("Tamaño:");

        txtTamanio.setText(" ");

        jLabelStock.setText("Stock:");

        txtStock.setText(" ");
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabelPrecio.setText("Precio:");

        txtPrecio.setText(" ");
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        BotonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        BotonAnadir.setText("Añadir");
        BotonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnadirActionPerformed(evt);
            }
        });

        BotonRegresarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        BotonRegresarProductos.setText("Cerrar");
        BotonRegresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCrearLayout = new javax.swing.GroupLayout(PanelCrear);
        PanelCrear.setLayout(PanelCrearLayout);
        PanelCrearLayout.setHorizontalGroup(
            PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCrearLayout.createSequentialGroup()
                                        .addComponent(jLabelTamanio)
                                        .addGap(49, 49, 49))
                                    .addGroup(PanelCrearLayout.createSequentialGroup()
                                        .addComponent(jLabelStock)
                                        .addGap(61, 61, 61)))
                                .addGroup(PanelCrearLayout.createSequentialGroup()
                                    .addComponent(jLabelPrecio)
                                    .addGap(58, 58, 58)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCrearLayout.createSequentialGroup()
                                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombreP)
                                    .addComponent(jLabelIDProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTamanio)
                            .addComponent(txtStock)
                            .addGroup(PanelCrearLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonRegresarProductos))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        PanelCrearLayout.setVerticalGroup(
            PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CrearProducto)
                .addGap(35, 35, 35)
                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIDProducto))
                        .addGap(20, 20, 20)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreP))
                        .addGap(20, 20, 20)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTamanio))
                        .addGap(20, 20, 20)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStock)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addComponent(BotonAnadir)
                        .addGap(36, 36, 36)
                        .addComponent(BotonRegresarProductos)
                        .addGap(49, 49, 49))))
        );

        PanelPrincipal.addTab("Añadir Producto", PanelCrear);

        PanelModificar.setEnabled(false);
        PanelModificar.setFocusable(false);
        PanelModificar.setRequestFocusEnabled(false);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ModificarUsuario.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCerrarMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        btnCerrarMod.setText("Cerrar");
        btnCerrarMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarModActionPerformed(evt);
            }
        });

        jLabelImagenM.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabelImagenM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ModificarUsuarioPantalla.png"))); // NOI18N
        jLabelImagenM.setText("Modificar");

        jLabelIdPM.setText("IDProducto");

        txtIDM.setEditable(false);
        txtIDM.setText(" ");

        jLabelNombreM.setText("Nombre Producto:");

        txtNombreM.setText(" ");

        jLabelTamanioM.setText("Tamaño:");

        txtTamanioM.setText(" ");

        jLabelStockM.setText("Stock:");

        txtStockM.setText(" ");
        txtStockM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMKeyTyped(evt);
            }
        });

        jLabelPrecioM.setText("Precio:");

        txtPrecioM.setText(" ");
        txtPrecioM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioMKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout PanelModificarLayout = new javax.swing.GroupLayout(PanelModificar);
        PanelModificar.setLayout(PanelModificarLayout);
        PanelModificarLayout.setHorizontalGroup(
            PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarLayout.createSequentialGroup()
                .addComponent(jLabelImagenM, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarLayout.createSequentialGroup()
                                .addComponent(jLabelTamanioM)
                                .addGap(49, 49, 49))
                            .addGroup(PanelModificarLayout.createSequentialGroup()
                                .addComponent(jLabelStockM)
                                .addGap(61, 61, 61)))
                        .addGroup(PanelModificarLayout.createSequentialGroup()
                            .addComponent(jLabelPrecioM)
                            .addGap(58, 58, 58)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarLayout.createSequentialGroup()
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreM)
                            .addComponent(jLabelIdPM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTamanioM)
                    .addComponent(txtStockM)
                    .addGroup(PanelModificarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDM, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtPrecioM, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarMod))
                .addGap(85, 85, 85))
        );
        PanelModificarLayout.setVerticalGroup(
            PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenM, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnModificar)
                        .addGap(26, 26, 26)
                        .addComponent(btnCerrarMod))
                    .addGroup(PanelModificarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIdPM))
                        .addGap(20, 20, 20)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreM))
                        .addGap(20, 20, 20)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTamanioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTamanioM))
                        .addGap(20, 20, 20)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStockM)
                            .addComponent(txtStockM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrecioM)
                            .addComponent(txtPrecioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        PanelPrincipal.addTab("Modificar", PanelModificar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnIrModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrModificarActionPerformed
        PanelPrincipal.addTab("Modificar", PanelModificar);
        PanelPrincipal.setSelectedIndex(1);

        txtIDM.setEnabled(false);
        int fila = TablaProductos.getSelectedRow();
        if (fila >= 0) {
            txtIDM.setText(TablaProductos.getValueAt(fila, 0).toString());
            txtNombreM.setText(TablaProductos.getValueAt(fila, 1).toString());
            txtStockM.setText(TablaProductos.getValueAt(fila, 2).toString());
            txtTamanioM.setText(TablaProductos.getValueAt(fila, 3).toString());
            txtPrecioM.setText(TablaProductos.getValueAt(fila, 4).toString());

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado nada");
        }
    }//GEN-LAST:event_btnIrModificarActionPerformed

    private void BotonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnadirActionPerformed
        if (ValidarCasillas() == false) {
            try {
                PanelPrincipal.setSelectedIndex(0);
                PanelPrincipal.remove(1);
                String ID = txtIDProductos.getText();
                String Nombre = txtNombreP.getText();
                String Tamanio = txtTamanio.getText();
                String Stock = txtStock.getText();
                String Precio = txtPrecio.getText();

                Conexion basedatos = new Conexion().conectar();
                String Insertar = "INSERT INTO PRODUCTOS VALUES('" + ID + "','" + Nombre + "','" + Stock + "','" + Tamanio + "','" + Precio + "');";
                System.out.println(Insertar);
                if (basedatos.ejecutar(Insertar)) {
                    JOptionPane.showMessageDialog(null, "Producto agregado");

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Agregar el producto");
                }
                BorrarDatos();
                RellenarTabla("");
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
    }//GEN-LAST:event_BotonAnadirActionPerformed

    private void BotonRegresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarProductosActionPerformed
        btnIrModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        PanelPrincipal.setSelectedIndex(0);
        PanelPrincipal.remove(1);
        RellenarTabla("");
    }//GEN-LAST:event_BotonRegresarProductosActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ValidarCasillas1() == false) {
            try {
                String ID = txtIDM.getText();
                String Nombre = txtNombreM.getText();
                String Tamanio = txtTamanioM.getText();
                String Stock = txtStockM.getText();
                String Precio = txtPrecioM.getText();
                Conexion basedatos = new Conexion().conectar();
                String Modificar = "UPDATE PRODUCTOS set nombreproducto='" + Nombre + "',Stock='" + Stock + "', Tamanio='" + Tamanio + "', Precio='" + Precio + "'  WHERE IDProducto ='" + ID + "'";
                System.out.println(Modificar);
                if (basedatos.ejecutar(Modificar)) {
                    JOptionPane.showMessageDialog(null, "Producto Moddificado");

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Modificar el producto");
                }
                BorrarDatos();
                RellenarTabla("");
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
            PanelPrincipal.setSelectedIndex(0);
            PanelPrincipal.remove(1);
            PanelPrincipal.setSelectedIndex(0);
            RellenarTabla("");
            btnIrModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCerrarModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarModActionPerformed
        btnIrModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        PanelPrincipal.setSelectedIndex(0);
        PanelPrincipal.remove(1);
        RellenarTabla("");
    }//GEN-LAST:event_btnCerrarModActionPerformed

    private void btnIrCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrCrearActionPerformed
        PanelPrincipal.addTab("Añadir producto", PanelCrear);
        PanelPrincipal.setSelectedIndex(1);
        Conexion basededatos = new Conexion().conectar();
        ResultSet resultado = basededatos.consultar("SELECT IDProducto from Productos");

        try {
            if (resultado.last()) {
                String b = resultado.getString("IDProducto");
                int a = Integer.parseInt(b) + 1;
                txtIDProductos.setText(String.valueOf(a));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIrCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Conexion basedatos = new Conexion().conectar();
            int fila = TablaProductos.getSelectedRow();
            String IDP = TablaProductos.getValueAt(fila, 0).toString();
            System.out.println(IDP);
            String Nom = TablaProductos.getValueAt(fila, 1).toString();
            System.out.println(Nom);
            int confirmado = JOptionPane.showConfirmDialog(null,
                    "Seguro de eliminar el producto '" + Nom + "'", "Confirmar Salida",
                    JOptionPane.OK_OPTION);

            if (JOptionPane.OK_OPTION == confirmado) {
                String Eliminar = "DELETE FROM PRODUCTOS WHERE IDProducto = '" + IDP + "'";
                System.out.println(Eliminar);
                if (basedatos.ejecutar(Eliminar)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se elimino el producto");
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        TablaProductos.clearSelection();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMouseClicked
        if (evt.getButton() == 1) {
            int fila = TablaProductos.getSelectedRow();
            if (fila >= 0) {
                btnEliminar.setEnabled(true);
                btnIrModificar.setEnabled(true);
            } else {
                btnEliminar.setEnabled(false);
                btnIrModificar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "No se ha seleccionado nada");
            }
        }
    }//GEN-LAST:event_TablaProductosMouseClicked

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtStockMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMKeyTyped

    private void txtPrecioMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMKeyTyped

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e){
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnadir;
    private javax.swing.JButton BotonRegresarProductos;
    private javax.swing.JLabel CrearProducto;
    private javax.swing.JPanel PanelCrear;
    private javax.swing.JPanel PanelModificar;
    private javax.swing.JTabbedPane PanelPrincipal;
    private javax.swing.JPanel PanelProductos;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCerrarMod;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIrCrear;
    private javax.swing.JButton btnIrModificar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabelIDProducto;
    private javax.swing.JLabel jLabelIdPM;
    private javax.swing.JLabel jLabelImagenM;
    private javax.swing.JLabel jLabelImagenP;
    private javax.swing.JLabel jLabelNombreM;
    private javax.swing.JLabel jLabelNombreP;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPrecioM;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelStockM;
    private javax.swing.JLabel jLabelTamanio;
    private javax.swing.JLabel jLabelTamanioM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIDM;
    private javax.swing.JTextField txtIDProductos;
    private javax.swing.JTextField txtNombreM;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioM;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockM;
    private javax.swing.JTextField txtTamanio;
    private javax.swing.JTextField txtTamanioM;
    // End of variables declaration//GEN-END:variables
}
