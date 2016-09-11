package gimnasio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class Login extends javax.swing.JFrame {
    public static String UsuarioLogueado;
    
    public void ProcesoAceptar(){
        Conexion basedatos = new Conexion().conectar();
        String User = (String)jComboBoxUsuario.getSelectedItem();
        String Pass = jPasswordFieldContraseña.getText();
        
        String Ejecutar= "select Nombre from usuarios where UserName= '"+User+"' and Password= '"+Pass+"'";
        ResultSet rs=basedatos.consultar(Ejecutar);
        try {
            if (rs.last()) {
                UsuarioLogueado = rs.getString("Nombre");
                JOptionPane.showMessageDialog(null, "Bienvenido "+UsuarioLogueado);
                Principal obj = new Principal();
                obj.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(User);
        System.out.println(Pass);
        System.out.println(Ejecutar);
    }
    public void RellenarComboBox(){
        Conexion baseDatos = new Conexion().conectar();
        ResultSet resultados = baseDatos.consultar("SELECT UserName FROM usuarios");
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
    }
    public Login() {
        setLocationRelativeTo(null);
        initComponents();
        jComboBoxUsuario.removeAll();
        RellenarComboBox();
        UsuarioLogueado = "";
        jPasswordFieldContraseña.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    ProcesoAceptar();
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jComboBoxUsuario = new javax.swing.JComboBox();
        jLabelContraseña = new javax.swing.JLabel();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();
        BotonCancelarLogin = new javax.swing.JButton();
        BotonAceptarLogin = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 210));

        jLabelUsuario.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabelUsuario.setText("Usuario: ");

        jComboBoxUsuario.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N

        jLabelContraseña.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabelContraseña.setText("Contraseña:");

        jPasswordFieldContraseña.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N

        BotonCancelarLogin.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        BotonCancelarLogin.setText("Cancelar");
        BotonCancelarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelarLoginActionPerformed(evt);
            }
        });

        BotonAceptarLogin.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        BotonAceptarLogin.setText("Aceptar");
        BotonAceptarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarLoginActionPerformed(evt);
            }
        });

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N

        jLabelLogin.setFont(new java.awt.Font("Times New Roman", 3, 42)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(0, 153, 255));
        jLabelLogin.setText("LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonAceptarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonCancelarLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelUsuario)
                            .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelContraseña))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonAceptarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonCancelarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAceptarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarLoginActionPerformed
        ProcesoAceptar();
    }//GEN-LAST:event_BotonAceptarLoginActionPerformed

    private void BotonCancelarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarLoginActionPerformed
        //dispose();
        System.exit(0);
    }//GEN-LAST:event_BotonCancelarLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e){
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
           
            public void run() {
                new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptarLogin;
    private javax.swing.JButton BotonCancelarLogin;
    private javax.swing.JComboBox jComboBoxUsuario;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    // End of variables declaration//GEN-END:variables
}
