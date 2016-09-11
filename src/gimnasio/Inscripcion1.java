/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.UIManager;

/**
 *
 * @author UnTalNose
 */
public class Inscripcion1 extends javax.swing.JFrame {

    /**
     * Creates new form Inscripcion
     */
    public Inscripcion1() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelDatos = new javax.swing.JPanel();
        jLabellNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelFechaNac = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        jLabelEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        LabellTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabelSexo = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jLabelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        SituacionMedica = new javax.swing.JPanel();
        jLabelServicioMedico = new javax.swing.JLabel();
        txtServicioM = new javax.swing.JTextField();
        jLabelNumFolio = new javax.swing.JLabel();
        txtNumFolio = new javax.swing.JTextField();
        jLabelEnfermedad = new javax.swing.JLabel();
        txtEnfermedad = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabelEstatura = new javax.swing.JLabel();
        txtEstatura = new javax.swing.JTextField();
        jLabelIMC = new javax.swing.JLabel();
        jTextIMC = new javax.swing.JTextField();
        jLabelTipoSangre = new javax.swing.JLabel();
        jComboBoxTipoSangre = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtContactoE = new javax.swing.JTextField();
        jComboBoxSexoE = new javax.swing.JComboBox<>();
        jLabelTelefonoE = new javax.swing.JLabel();
        txtTelefonoE = new javax.swing.JTextField();
        jLabelSexoE = new javax.swing.JLabel();
        jLabelContactoE = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxVn = new javax.swing.JCheckBox();
        jCheckBoxVE = new javax.swing.JCheckBox();
        jCheckBoxMN = new javax.swing.JCheckBox();
        jCheckBoxME = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxSi = new javax.swing.JCheckBox();
        jCheckBoxNo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxPesas = new javax.swing.JCheckBox();
        jCheckBoxZumba = new javax.swing.JCheckBox();
        jCheckBoxCardio = new javax.swing.JCheckBox();
        jCheckBoxSquash = new javax.swing.JCheckBox();
        jCheckBoxSpining = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxPerdidaP = new javax.swing.JCheckBox();
        jCheckBoxFuerza = new javax.swing.JCheckBox();
        jCheckBoxTornicidad = new javax.swing.JCheckBox();
        jCheckBoxFlexibilidad = new javax.swing.JCheckBox();
        jCheckBoxEsteticaS = new javax.swing.JCheckBox();
        jCheckBoxSalud = new javax.swing.JCheckBox();
        jCheckBoxCompetencia = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setResizable(false);

        JPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos "));
        JPanelDatos.setToolTipText("Datos");
        JPanelDatos.setFocusable(false);
        JPanelDatos.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        JPanelDatos.setName("Datos"); // NOI18N
        JPanelDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 2));

        jLabellNombre.setText("Nombre: ");
        JPanelDatos.add(jLabellNombre);

        txtNombre.setMinimumSize(new java.awt.Dimension(20, 20));
        txtNombre.setPreferredSize(new java.awt.Dimension(250, 20));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        JPanelDatos.add(txtNombre);

        jLabelFechaNac.setText("Fecha de Nacimiento:");
        JPanelDatos.add(jLabelFechaNac);

        txtFechaNac.setPreferredSize(new java.awt.Dimension(100, 20));
        txtFechaNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaNacFocusLost(evt);
            }
        });
        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });
        JPanelDatos.add(txtFechaNac);

        jLabelEdad.setText("Edad:");
        JPanelDatos.add(jLabelEdad);

        txtEdad.setEditable(false);
        txtEdad.setPreferredSize(new java.awt.Dimension(60, 20));
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        JPanelDatos.add(txtEdad);

        LabellTelefono.setText("Teléfono: ");
        JPanelDatos.add(LabellTelefono);

        txtTelefono.setMinimumSize(new java.awt.Dimension(100, 20));
        txtTelefono.setPreferredSize(new java.awt.Dimension(100, 20));
        JPanelDatos.add(txtTelefono);

        jLabelDireccion.setText("Dirección:");
        JPanelDatos.add(jLabelDireccion);

        txtDireccion.setPreferredSize(new java.awt.Dimension(250, 20));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        JPanelDatos.add(txtDireccion);

        jLabelSexo.setText("Sexo:");
        JPanelDatos.add(jLabelSexo);

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Otro.." }));
        jComboBoxSexo.setPreferredSize(new java.awt.Dimension(85, 20));
        JPanelDatos.add(jComboBoxSexo);

        jLabelEmail.setText("Email:");
        JPanelDatos.add(jLabelEmail);

        txtEmail.setPreferredSize(new java.awt.Dimension(160, 20));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        JPanelDatos.add(txtEmail);

        SituacionMedica.setBorder(javax.swing.BorderFactory.createTitledBorder("Situación Médica"));
        SituacionMedica.setToolTipText("Situación Médica");
        SituacionMedica.setFocusable(false);
        SituacionMedica.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        SituacionMedica.setName("Datos"); // NOI18N

        jLabelServicioMedico.setText("Servicio Médico:");

        txtServicioM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioMActionPerformed(evt);
            }
        });

        jLabelNumFolio.setText("Num. Folio:");

        jLabelEnfermedad.setText("Alguna Enfermedad / Alegia");

        txtEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnfermedadActionPerformed(evt);
            }
        });

        jLabelPeso.setText("Peso:");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        jLabelEstatura.setText("Estatura:");

        txtEstatura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstaturaFocusLost(evt);
            }
        });
        txtEstatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstaturaActionPerformed(evt);
            }
        });

        jLabelIMC.setText("IMC :");

        jTextIMC.setEditable(false);
        jTextIMC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextIMCFocusLost(evt);
            }
        });
        jTextIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIMCActionPerformed(evt);
            }
        });

        jLabelTipoSangre.setText("Tipo de Sangre:");

        jComboBoxTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "O+", "A-" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Emergencia"));

        txtContactoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoEActionPerformed(evt);
            }
        });

        jComboBoxSexoE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Otro.." }));

        jLabelTelefonoE.setText("Teléfono de Emergencia:");

        txtTelefonoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoEActionPerformed(evt);
            }
        });

        jLabelSexoE.setText("Sexo:");

        jLabelContactoE.setText("Contacto de Emergencia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelContactoE)
                .addGap(5, 5, 5)
                .addComponent(txtContactoE, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTelefonoE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSexoE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContactoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefonoE)
                    .addComponent(txtTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContactoE)
                    .addComponent(jLabelSexoE)
                    .addComponent(jComboBoxSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de pago"));
        jPanel2.setToolTipText("Tipo de Pago");

        jCheckBoxVn.setText("Visita Normal");

        jCheckBoxVE.setText("Visita Empresa");

        jCheckBoxMN.setText("Mensualidad Normal");

        jCheckBoxME.setText("Mensualidad Estudiante");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jCheckBoxVn)
                .addGap(78, 78, 78)
                .addComponent(jCheckBoxVE)
                .addGap(78, 78, 78)
                .addComponent(jCheckBoxMN)
                .addGap(75, 75, 75)
                .addComponent(jCheckBoxME)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxVn)
                    .addComponent(jCheckBoxVE)
                    .addComponent(jCheckBoxMN)
                    .addComponent(jCheckBoxME)))
        );

        javax.swing.GroupLayout SituacionMedicaLayout = new javax.swing.GroupLayout(SituacionMedica);
        SituacionMedica.setLayout(SituacionMedicaLayout);
        SituacionMedicaLayout.setHorizontalGroup(
            SituacionMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SituacionMedicaLayout.createSequentialGroup()
                .addGroup(SituacionMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SituacionMedicaLayout.createSequentialGroup()
                        .addComponent(jLabelServicioMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServicioM, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumFolio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEnfermedad)
                        .addGap(18, 18, 18)
                        .addComponent(txtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SituacionMedicaLayout.createSequentialGroup()
                        .addComponent(jLabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEstatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIMC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTipoSangre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SituacionMedicaLayout.setVerticalGroup(
            SituacionMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SituacionMedicaLayout.createSequentialGroup()
                .addGroup(SituacionMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelServicioMedico)
                    .addComponent(txtServicioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumFolio)
                    .addComponent(txtNumFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEnfermedad)
                    .addComponent(txtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SituacionMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstatura)
                    .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIMC)
                    .addComponent(jTextIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoSangre)
                    .addComponent(jComboBoxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicio"));
        jPanel3.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N

        jLabel2.setText("¿Experiencia en entrenamiento?");

        jCheckBoxSi.setText("Si");

        jCheckBoxNo.setText("No");
        jCheckBoxNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNoActionPerformed(evt);
            }
        });

        jLabel3.setText("¿Cuál de nuestros servicios te interesa?");

        jCheckBoxPesas.setText("Pesas");

        jCheckBoxZumba.setText("Zumba");

        jCheckBoxCardio.setText("Cardio");

        jCheckBoxSquash.setText("Squash");

        jCheckBoxSpining.setText("Spining");

        jLabel4.setText("¿Cuáles son tus objetivos para estar en forma?");

        jCheckBoxPerdidaP.setText("Pérdida de peso");

        jCheckBoxFuerza.setText("Fuerza");

        jCheckBoxTornicidad.setText("Tornicidad muscular");

        jCheckBoxFlexibilidad.setText("Flexibiliddad");

        jCheckBoxEsteticaS.setText("Estetica y salud");

        jCheckBoxSalud.setText("Salud");

        jCheckBoxCompetencia.setText("Competencia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(jCheckBoxSi)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxNo))
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBoxPesas)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxZumba)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxCardio)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSquash)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSpining))
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBoxPerdidaP)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxFuerza)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxTornicidad)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxFlexibilidad)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxEsteticaS)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSalud)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxCompetencia)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBoxSi)
                    .addComponent(jCheckBoxNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPesas)
                    .addComponent(jCheckBoxZumba)
                    .addComponent(jCheckBoxCardio)
                    .addComponent(jCheckBoxSquash)
                    .addComponent(jCheckBoxSpining))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxSalud)
                        .addComponent(jCheckBoxCompetencia))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxPerdidaP)
                        .addComponent(jCheckBoxFuerza)
                        .addComponent(jCheckBoxTornicidad)
                        .addComponent(jCheckBoxFlexibilidad)
                        .addComponent(jCheckBoxEsteticaS))))
        );

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SituacionMedica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(btnAceptar)
                .addGap(82, 82, 82)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SituacionMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        JPanelDatos.getAccessibleContext().setAccessibleName("Datos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacActionPerformed

    private void txtContactoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoEActionPerformed

    private void txtTelefonoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoEActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtServicioMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicioMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicioMActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnfermedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnfermedadActionPerformed

    private void txtEstaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstaturaActionPerformed

    private void jTextIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIMCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIMCActionPerformed

    
    
    private void jTextIMCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextIMCFocusLost
        // TODO add your handling code 
        
    }//GEN-LAST:event_jTextIMCFocusLost

    private void txtEstaturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstaturaFocusLost
        int P = Integer.parseInt(txtPeso.getText());
        float E = Float.parseFloat(txtEstatura.getText());
        String IMC= String.valueOf(P/(E*E));
        System.out.println(IMC);
        System.out.println(P);
        System.out.println(E);
        jTextIMC.setText(IMC);
        
    }//GEN-LAST:event_txtEstaturaFocusLost

    private void txtFechaNacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacFocusLost
        String fecha= txtFechaNac.getText();
        Date fechaNac= null;
        
        try {
            /**Se puede cambiar la mascara por el formato de la fecha
            que se quiera recibir, por ejemplo año mes día "yyyy-MM-dd"
            en este caso es día mes año*/
            fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
        } catch (Exception ex) {
            System.out.println("Error:"+ex);
        }
        Calendar fechaNacimiento = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //Se asigna la fecha recibida a la fecha de nacimiento.
        fechaNacimiento.setTime(fechaNac);
        //Se restan la fecha actual y la fecha de nacimiento
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        //Regresa la edad en base a la fecha de nacimiento
        txtEdad.setText(String.valueOf(año)+" Años");
    
    }//GEN-LAST:event_txtFechaNacFocusLost

    private void jCheckBoxNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNoActionPerformed

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
            java.util.logging.Logger.getLogger(Inscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inscripcion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e){
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inscripcion1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelDatos;
    private javax.swing.JLabel LabellTelefono;
    private javax.swing.JPanel SituacionMedica;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox jCheckBoxCardio;
    private javax.swing.JCheckBox jCheckBoxCompetencia;
    private javax.swing.JCheckBox jCheckBoxEsteticaS;
    private javax.swing.JCheckBox jCheckBoxFlexibilidad;
    private javax.swing.JCheckBox jCheckBoxFuerza;
    private javax.swing.JCheckBox jCheckBoxME;
    private javax.swing.JCheckBox jCheckBoxMN;
    private javax.swing.JCheckBox jCheckBoxNo;
    private javax.swing.JCheckBox jCheckBoxPerdidaP;
    private javax.swing.JCheckBox jCheckBoxPesas;
    private javax.swing.JCheckBox jCheckBoxSalud;
    private javax.swing.JCheckBox jCheckBoxSi;
    private javax.swing.JCheckBox jCheckBoxSpining;
    private javax.swing.JCheckBox jCheckBoxSquash;
    private javax.swing.JCheckBox jCheckBoxTornicidad;
    private javax.swing.JCheckBox jCheckBoxVE;
    private javax.swing.JCheckBox jCheckBoxVn;
    private javax.swing.JCheckBox jCheckBoxZumba;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JComboBox<String> jComboBoxSexoE;
    private javax.swing.JComboBox<String> jComboBoxTipoSangre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelContactoE;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEnfermedad;
    private javax.swing.JLabel jLabelEstatura;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelIMC;
    private javax.swing.JLabel jLabelNumFolio;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelServicioMedico;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelSexoE;
    private javax.swing.JLabel jLabelTelefonoE;
    private javax.swing.JLabel jLabelTipoSangre;
    private javax.swing.JLabel jLabellNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextIMC;
    private javax.swing.JTextField txtContactoE;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnfermedad;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumFolio;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtServicioM;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoE;
    // End of variables declaration//GEN-END:variables
}