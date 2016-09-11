package gimnasio;

import dao.DAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Mancilla
 */
public class Checador extends javax.swing.JFrame implements Runnable {
    public static String HoraCompleta;
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    
    /*public void ProcesoAceptar(){
        Conexion basedatos = new Conexion().conectar();
        String User = "";
        String Pass = jPasswordContrasenia.getText();
        
        String Ejecutar= "select Nombre from usuarios where UserName= '"+User+"' and Password= '"+Pass+"'";
        ResultSet rs=basedatos.consultar(Ejecutar);
        try {
            if (rs.last()) {
                String UsuarioChecado = rs.getString("Nombre");
                this.dispose();
                String Insertar = "INSERT INTO CHECADOR(nombreusuario,hora)VALUES('"+UsuarioChecado+"','"+lbHora.getText()+"')";
                System.out.println(Insertar);
                if(basedatos.ejecutar(Insertar)){
                    JOptionPane.showMessageDialog(null, "Registrado a la(s) : "+lbHora.getText());
                }
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Pass);
        System.out.println(Ejecutar);
    }*/
/*    public void RellenarComboBox(){
        Conexion baseDatos = new Conexion().conectar();
        ResultSet resultados = baseDatos.consultar("SELECT UserName FROM usuarios");
        AutoCompleteDecorator.decorate(jComboBoxUsuario);
        if (resultados != null) {
            try {
                while (resultados.next()) {
                    this.jComboBoxUsuario.addItem(resultados.getString("UserName"));                    
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e+"qqqq");
            }
        }else{
            System.out.println("No hay Datos insertados");
            JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }*/
    public Checador() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        initComponents();
        //RellenarComboBox();
        h1 = new Thread(this);
        h1.start();
        jPasswordContrasenia.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    registraEntradaSalida();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHora = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContrasenia = new javax.swing.JLabel();
        jPasswordContrasenia = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNumEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reloj Checador");

        lbHora.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelUsuario.setText("Num de empleado");

        jLabelContrasenia.setText("Contraseña:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelContrasenia)
                                .addComponent(jLabelUsuario))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                .addComponent(txtNumEmpleado)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(txtNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContrasenia)
                    .addComponent(jPasswordContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registraEntradaSalida();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registraEntradaSalida() {
                String numEmpleado = txtNumEmpleado.getText();
        String pass = jPasswordContrasenia.getText();
        String nombre = "";

        DAO dao = new DAO();

        try {
            nombre = dao.getNombreEmpleado(numEmpleado, pass);
            if (!nombre.equals("")) {
                if (dao.isEntradaRegistrada(numEmpleado, nombre)) {
                    System.out.println("Registrando Salida");
                    dao.registra(numEmpleado, "Salida");
                    JOptionPane.showMessageDialog(rootPane, String.format(
                            "[%s] Registro de Salida", nombre));
                } else {
                    System.out.println("Registrando Entrada");
                    dao.registra(numEmpleado, "Entrada");
                    JOptionPane.showMessageDialog(rootPane, String.format(
                            "[%s] Registro de entrada", nombre));
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "El número de empleado"
                        + " o contraseña no coinciden", "Datos no coinciden",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar"
                    + " el registro");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordContrasenia;
    private javax.swing.JLabel lbHora;
    private javax.swing.JTextField txtNumEmpleado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            HoraCompleta = lbHora.getText();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e){
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checador();
            }
        });
    }
}