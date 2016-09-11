package gimnasio;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UnTalNose
 */
public class Inscripcion extends javax.swing.JFrame {
    public static DefaultTableModel Modelo;
    public static boolean Confirm = true;
    public static String IDModificar = "";
    public static String Respuesta1 = "", Respuesta2 = "", Respuesta3 = "";

    public static String Fecha(Calendar F) {
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
    public static void setEnableContainer(Container c, boolean band) {

        Component[] components = c.getComponents();
        c.setEnabled(band);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);

            if (components[i] instanceof Container) {
                setEnableContainer((Container) components[i], band);
            }

        }
    }
    boolean ValidarCasillas() {
        if (txtNombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "NOMBRE campo vacio");
            txtNombre.requestFocus();
        } else if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "APELLIDOS campo vacio");
            txtApellidos.requestFocus();
        } //else if (DCFechaNacimiento.getDateFormatString().trim().length() == 0) {
            //JOptionPane.showMessageDialog(null, "FECHA DE NACIMIENTO campo vacio");
            //DCFechaNacimiento.requestFocus();
        //} 
        else if (txtEdad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "EDAD campo vacio");
            txtEdad.requestFocus();
        } else if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "TELEFONO campo vacio");
            txtTelefono.requestFocus();
        } else if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "DIRECCIÓN campo vacio");
            txtDireccion.requestFocus();
        } else if (txtEmail.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "EMAIL DEL CLIENTE campo vacio");
            txtEmail.requestFocus();
        } else if (txtServicioM.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "SERVICIO MÉDICO campo vacio");
            txtServicioM.requestFocus();
        } else if (txtNumFolio.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "NUMERO DE FOLIO campo vacio");
            txtNumFolio.requestFocus();
        } else if (txtEnfermedad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "ENFERMEDAD campo vacio");
            txtEnfermedad.requestFocus();
        } else if (txtPeso.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "PESO campo vacio");
            txtPeso.requestFocus();
        } else if (txtEstatura.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "ESTATURA campo vacio");
            txtEstatura.requestFocus();
        } else if (txtIMC.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "IMC campo vacio");
            txtIMC.requestFocus();
        } else if (txtContactoE.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "CONTACTO DE EMERGENCIA campo vacio");
            txtContactoE.requestFocus();
        } else if (txtApellidosE.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "APELLIDOS DE CONTACTO DE EMERGENCIA campo vacio");
            txtApellidosE.requestFocus();
        } else if (txtTelefonoE.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "TELÉFONO DE CONTACTO  campo vacio");
            txtTelefonoE.requestFocus();
        } else {
            Confirm = true;
        }
        return Confirm;
    }
    
    void CalcularEdad(){
        Calendar fechaNacimiento = DCFechaNacimiento.getCalendar();
        Calendar fechaActual = Calendar.getInstance();
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        String Años = String.valueOf(año);
        txtEdad.setText(Años +" Años");
        System.out.println("Tiene "+Años+" Años");
    }
    
    void Buscar(String texto) {
        String mostrar = "Select * from c_datosgenerales where concat(IDCliente,Nombre,apellidos,edad,telefono,sexo,correo) like '%" + texto + "%'";
        Conexion baseDatos = new Conexion().conectar();
        String[] Titulos = {"IDCliente", "NOMBRE", "APELLIDOS", "FECHA DE NACIMIENTO", "EDAD", "TELEFONO", "DIRECCION", "SEXO", "EMAIL"};
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
                TablaClientes.setModel(Modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + "qqqq");
            }
        } else {
            System.out.println("No hay Datos insertados");
            JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void bloquear() {
        txtNombre.setEditable(false);
        txtApellidos.setEditable(false);
        DCFechaNacimiento.setEnabled(false);
        txtEdad.setEditable(false);
        txtTelefono.setEditable(false);
        txtDireccion.setEditable(false);
        txtEmail.setEditable(false);
        txtServicioM.setEditable(false);
        txtNumFolio.setEditable(false);
        txtEnfermedad.setEditable(false);
        txtPeso.setEditable(false);
        txtEstatura.setEditable(false);
        txtIMC.setEditable(false);
        txtContactoE.setEditable(false);
        txtApellidosE.setEditable(false);
        txtTelefonoE.setEditable(false);
        jComboBoxSexoE.setEnabled(false);
        jComboBoxTipoSangre.setEnabled(false);
        jComboBoxSexo.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(false);
        btnactualizar.setEnabled(false);
        setEnableContainer(jPanel3, false);
    }
    void desbloquear() {
        txtNombre.setEditable(true);
        txtApellidos.setEditable(true);
        DCFechaNacimiento.setEnabled(true);
        txtTelefono.setEditable(true);
        txtDireccion.setEditable(true);
        txtEmail.setEditable(true);
        txtServicioM.setEditable(true);
        txtNumFolio.setEditable(true);
        txtEnfermedad.setEditable(true);
        txtPeso.setEditable(true);
        txtEstatura.setEditable(true);
        txtContactoE.setEditable(true);
        txtApellidosE.setEditable(true);
        txtTelefonoE.setEditable(true);
        jComboBoxSexoE.setEnabled(true);
        jComboBoxTipoSangre.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btncancelar.setEnabled(true);
        btnactualizar.setEnabled(false);
        setEnableContainer(jPanel3, true);
    }
    void limpiar() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtServicioM.setText("");
        txtNumFolio.setText("");
        txtEnfermedad.setText("");
        txtPeso.setText("");
        txtEstatura.setText("");
        txtIMC.setText("");
        txtContactoE.setText("");
        txtApellidosE.setText("");
        txtTelefonoE.setText("");
        jComboBoxSexoE.setSelectedIndex(0);
        jComboBoxTipoSangre.setSelectedIndex(0);
        jComboBoxSexo.setSelectedIndex(0);
        Pregunta1.clearSelection();
        Pregunta2.clearSelection();
        Pregunta3.clearSelection();
    }
    void Modificar() {
        int filamodificar = TablaClientes.getSelectedRow();
        if (filamodificar >= 0) {
            IDModificar = TablaClientes.getValueAt(filamodificar, 0).toString();
            txtNombre.setText(TablaClientes.getValueAt(filamodificar, 1).toString());
            txtApellidos.setText(TablaClientes.getValueAt(filamodificar, 2).toString());
            String FechaStringI = TablaClientes.getValueAt(filamodificar, 3).toString();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fechaDate = formato.parse(FechaStringI);
                DCFechaNacimiento.setDate(fechaDate);
            } catch (ParseException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtEdad.setText(TablaClientes.getValueAt(filamodificar, 4).toString());
            txtTelefono.setText(TablaClientes.getValueAt(filamodificar, 5).toString());
            txtDireccion.setText(TablaClientes.getValueAt(filamodificar, 6).toString());
            jComboBoxSexo.setSelectedItem(TablaClientes.getValueAt(filamodificar, 7).toString());
            txtEmail.setText(TablaClientes.getValueAt(filamodificar, 8).toString());

            Conexion basedatos = new Conexion().conectar();
            String select = "SELECT * FROM c_datosmedicos where idcliente='" + IDModificar + "'";
            System.out.println(select);
            ResultSet resultados = basedatos.consultar(select);
            System.out.println(resultados);
            if (resultados != null) {
                try {
                    while (resultados.next()) {
                        txtServicioM.setText(resultados.getString("Servicio"));
                        txtNumFolio.setText(resultados.getString("FolioMedico"));
                        txtEnfermedad.setText(resultados.getString("Enfermedades"));
                        txtPeso.setText(resultados.getString("Peso"));
                        txtEstatura.setText(resultados.getString("Estatura"));
                        txtIMC.setText(resultados.getString("IMC"));
                        String TipoSangre = resultados.getString("TipoSangre");
                        jComboBoxTipoSangre.setSelectedItem(TipoSangre);
                    }
                    //
                    System.out.println(txtServicioM.getText() + ", " + txtNumFolio.getText() + ", " + txtEnfermedad.getText() + ", " + txtPeso.getText() + ", "
                            + txtEstatura.getText() + ", " + txtIMC.getText() + ", " + (String) jComboBoxTipoSangre.getSelectedItem());
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e + "qqqq");
                }
            } else {
                System.out.println("No hay Datos insertados");
                JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ");
        }
        Conexion basedatos1 = new Conexion().conectar();
        String selectE = "SELECT * FROM c_datosemergencia where idcliente='" + IDModificar + "'";
        System.out.println(selectE);
        ResultSet resultados1 = basedatos1.consultar(selectE);
        System.out.println(resultados1);
        if (resultados1 != null) {
            try {
                while (resultados1.next()) {
                    txtContactoE.setText(resultados1.getString("Nombre"));
                    txtApellidosE.setText(resultados1.getString("Apellidos"));
                    txtTelefonoE.setText(resultados1.getString("Telefono"));
                    String Sexo = resultados1.getString("Sexo");
                    jComboBoxSexoE.setSelectedItem(Sexo);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + "qqqq");
            }
        } else {
            System.out.println("No hay Datos insertados");
            JOptionPane.showMessageDialog(this, "No hay datos insertados en la tabla", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println(txtContactoE.getText() + ", " + txtApellidosE.getText() + ", " + txtTelefonoE.getText() + ", "
                + txtPeso.getText() + ", " + (String) jComboBoxSexoE.getSelectedItem());
    }
    boolean BotonModificar() throws SQLException {
        
        String Insertar1, Insertar2, Insertar3;
        String Nombre = txtNombre.getText();
        String Apellidos = txtApellidos.getText();
        Calendar FechaN = DCFechaNacimiento.getCalendar();
        JOptionPane.showMessageDialog(null, "Fecha de Nacimiento a Modificar es: " + Fecha(FechaN));
        String Edad = txtEdad.getText();
        String Telefono = txtTelefono.getText();
        String Direccion = txtDireccion.getText();
        String Sexo = (String) jComboBoxSexo.getSelectedItem();
        String Email = txtEmail.getText();
        //************************************
        String ServicioM = txtServicioM.getText();
        String NumeroF = txtNumFolio.getText();
        String Enfermedad = txtEnfermedad.getText();
        String Peso = txtPeso.getText();
        String Estatura = txtEstatura.getText();
        String IMC = txtIMC.getText();
        String TipoSangre = (String) jComboBoxTipoSangre.getSelectedItem();
        //******************************************************************
        String NombreE = txtContactoE.getText();
        String ApellidosE = txtApellidosE.getText();
        String TelefonoE = txtTelefonoE.getText();
        String SexoE = (String) jComboBoxSexoE.getSelectedItem();

        Conexion basedatos = new Conexion().conectar();

        //****String Modificar = "UPDATE PRODUCTOS set nombreproducto='" + Nombre + "',Stock='" + Stock + "', Tamanio='" + Tamanio + "', Precio='" + Precio + "'  WHERE IDProducto ='" + ID + "'";
        Insertar1 = "UPDATE c_datosgenerales set nombre='" + Nombre + "',apellidos='" + Apellidos + "',FechaNacimiento='" + Fecha(FechaN) + "',"
                + "Edad='" + Edad + "',Telefono='" + Telefono + "',Direccion='" + Direccion + "',Sexo='" + Sexo + "',Correo='" + Email + "' where IDCliente='" + IDModificar + "'";
        

        Insertar2 = "UPDATE c_datosmedicos set Servicio='" + ServicioM + "',FolioMedico='" + NumeroF
                + "',Enfermedades='" + Enfermedad + "',Peso='" + Peso + "',estatura='" + Estatura
                + "',IMC='" + IMC + "',TipoSangre='" + TipoSangre + "' where IDCliente='" + IDModificar + "' ;";

        Insertar3 = "UPDATE c_datosemergencia set Nombre='" + NombreE + "',Apellidos='" + ApellidosE
                + "',Telefono='" + TelefonoE + "',Sexo='" + SexoE + "'where IDCliente='" + IDModificar + "' ;";

        System.out.println(Insertar1);
        System.out.println(Insertar2);
        System.out.println(Insertar3);

        if (basedatos.ejecutar(Insertar1)) {
            JOptionPane.showMessageDialog(null, "Cliente Modificado");
            Conexion basedatos2 = new Conexion().conectar();
            if (basedatos2.ejecutar(Insertar2)) {
                JOptionPane.showMessageDialog(null, "Datos medicos Modificados");
                Conexion basedatos3 = new Conexion().conectar();
                if (basedatos3.ejecutar(Insertar3)) {
                    JOptionPane.showMessageDialog(null, "Contacto de emergencia Modificado");
                    Confirm = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Modificar Contacto de emergencia");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al Modificar Datos Medicos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al Modificar el Cliente");
        }
        return Confirm;
    }
    boolean ValidarRadioButton() {
        if (RadioSi.isSelected()) {
            Respuesta1 = (String) RadioSi.getText();
        } else if (RadioNo.isSelected()) {
            Respuesta1 = (String) RadioNo.getText();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción de la Primer pregunta");
            Confirm = false;
        }
        if (Respuesta1 != "") {
            if (RadioPesas.isSelected()) {
                Respuesta2 = (String) RadioPesas.getText();
            } else if (RadioZumba.isSelected()) {
                Respuesta2 = (String) RadioZumba.getText();
            } else if (RadioCardio.isSelected()) {
                Respuesta2 = (String) RadioCardio.getText();
            } else if (RadioSquash.isSelected()) {
                Respuesta2 = (String) RadioSquash.getText();
            } else if (RadioSpining.isSelected()) {
                Respuesta2 = (String) RadioSpining.getText();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción de la segunda pregunta");
                Confirm = false;
            }
        }
        if (Respuesta2 != "") {
            if (RadioPerdidaPeso.isSelected()) {
                Respuesta3 = (String) RadioPerdidaPeso.getText();
            } else if (RadioFuerza.isSelected()) {
                Respuesta3 = (String) RadioFuerza.getText();
            } else if (RadioTornicidad.isSelected()) {
                Respuesta3 = (String) RadioTornicidad.getText();
            } else if (RadioCompetencia.isSelected()) {
                Respuesta3 = (String) RadioCompetencia.getText();
            } else if (RadioFlexibilidad.isSelected()) {
                Respuesta3 = (String) RadioFlexibilidad.getText();
            } else if (RadioEstetica.isSelected()) {
                Respuesta3 = (String) RadioEstetica.getText();
            } else if (RadioSalud.isSelected()) {
                Respuesta3 = (String) RadioSalud.getText();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción de la tercer pregunta");
                Confirm = false;
            }
        }

        System.out.println(Respuesta1);
        System.out.println(Respuesta2);
        System.out.println(Respuesta3);
        return Confirm;
    }
    boolean InsertarGeneral() throws SQLException {
        try {
            String Insertar1, Insertar2, Insertar3;
            String Nombre = txtNombre.getText();
            String Apellidos = txtApellidos.getText();
            Calendar FechaN = DCFechaNacimiento.getCalendar();
            JOptionPane.showMessageDialog(null, "Fecha de Nacimiento a Insertar es: " + Fecha(FechaN));
            String Edad = txtEdad.getText();
            String Telefono = txtTelefono.getText();
            String Direccion = txtDireccion.getText();
            String Sexo = (String) jComboBoxSexo.getSelectedItem();
            String Email = txtEmail.getText();
            Calendar FechaIns = Calendar.getInstance();
            JOptionPane.showMessageDialog(null, "Fecha de Inscripcion a Insertar es: " + Fecha(FechaIns));
            //************************************
            String ServicioM = txtServicioM.getText();
            String NumeroF = txtNumFolio.getText();
            String Enfermedad = txtEnfermedad.getText();
            String Peso = txtPeso.getText();
            String Estatura = txtEstatura.getText();
            String IMC = txtIMC.getText();
            String TipoSangre = (String) jComboBoxTipoSangre.getSelectedItem();
            //******************************************************************
            String NombreE = txtContactoE.getText();
            String ApellidosE = txtApellidosE.getText();
            //int  TelefonoE = Integer.parseInt(txtTelefonoE.getText());
            String TelefonoE = txtTelefonoE.getText();
            String SexoE = (String) jComboBoxSexoE.getSelectedItem();
            int ID = 0;
            Conexion basedatos = new Conexion().conectar();

            //*******************************************************************************
            //*******************************************************************
            Insertar1 = "INSERT INTO c_datosgenerales(nombre,apellidos,FechaNacimiento,Edad,Telefono,Direccion,Sexo,Correo,FechaInscripcion) "
                    + "VALUES('" + Nombre + "','" + Apellidos + "','" + Fecha(FechaN) + "','" + Edad + "','" + Telefono + "','" + Direccion + "','"
                    + Sexo + "','" + Email + "','" + Fecha(FechaIns) + "');";
            if (basedatos.ejecutar(Insertar1)) {
                ResultSet rs = basedatos.consultar("Select idcliente from c_datosgenerales where NOMBRE='" + Nombre + "'");
                if (rs.last()) {
                    String a = rs.getString("idcliente");
                    ID = Integer.parseInt(a);
                    System.out.println(ID);
                    //(servicio,FolioMedico,Enfermedades,Peso,estatura,IMC,Tiposangre)******************************************************************************
                    Insertar2 = "INSERT INTO c_datosmedicos "
                            + "VALUES('" + ID + "','" + ServicioM + "','" + NumeroF
                            + "','" + Enfermedad + "','" + Peso + "','" + Estatura + "','" + IMC + "','"
                            + TipoSangre + "') ;";
                    //(Nombre,Apellidos,Telefono,Sexo)*******************************************************************************
                    Insertar3 = "INSERT INTO c_datosemergencia VALUES('" + ID + "','" + NombreE + "','" + ApellidosE
                            + "'," + TelefonoE + ",'" + SexoE + "');";

                    Conexion basedatos2 = new Conexion().conectar();
                    if (basedatos2.ejecutar(Insertar2)) {
                        Conexion basedatos3 = new Conexion().conectar();
                        if (basedatos3.ejecutar(Insertar3)) {
                            Conexion basedatos4 = new Conexion().conectar();
                            String Insertar = "INSERT INTO C_OPCIONES VALUES('" + ID + "','" + Respuesta1 + "','" + Respuesta2 + "','" + Respuesta3 + "')";
                            if (basedatos4.ejecutar(Insertar)) {
                                System.out.println(Insertar1);
                                System.out.println(Insertar2);
                                System.out.println(Insertar3);
                                System.out.println(Insertar);
                                JOptionPane.showMessageDialog(null, "Cliente agregado");
                            } else {
                                Confirm = false;
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Agregar el Cliente");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return Confirm;
    }
    
    
    public Inscripcion() {
        initComponents();
        setLocationRelativeTo(null);
        bloquear();
        Buscar("");

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
        Pregunta1 = new javax.swing.ButtonGroup();
        Pregunta2 = new javax.swing.ButtonGroup();
        Pregunta3 = new javax.swing.ButtonGroup();
        JPanelDatos = new javax.swing.JPanel();
        jLabellNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelFechaNac = new javax.swing.JLabel();
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
        jLabelApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        DCFechaNacimiento = new com.toedter.calendar.JDateChooser();
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
        txtIMC = new javax.swing.JTextField();
        jLabelTipoSangre = new javax.swing.JLabel();
        jComboBoxTipoSangre = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtContactoE = new javax.swing.JTextField();
        jComboBoxSexoE = new javax.swing.JComboBox<>();
        jLabelTelefonoE = new javax.swing.JLabel();
        txtTelefonoE = new javax.swing.JTextField();
        jLabelSexoE = new javax.swing.JLabel();
        jLabelContactoE = new javax.swing.JLabel();
        txtApellidosE = new javax.swing.JTextField();
        jLabelApellidosE = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        RadioNo = new javax.swing.JRadioButton();
        RadioSi = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        RadioPesas = new javax.swing.JRadioButton();
        RadioZumba = new javax.swing.JRadioButton();
        RadioCardio = new javax.swing.JRadioButton();
        RadioSquash = new javax.swing.JRadioButton();
        RadioSpining = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        RadioPerdidaPeso = new javax.swing.JRadioButton();
        RadioFuerza = new javax.swing.JRadioButton();
        RadioTornicidad = new javax.swing.JRadioButton();
        RadioCompetencia = new javax.swing.JRadioButton();
        RadioFlexibilidad = new javax.swing.JRadioButton();
        RadioEstetica = new javax.swing.JRadioButton();
        RadioSalud = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        Modificar.setText("Modificar");
        Modificar.setComponentPopupMenu(jPopupMenu1);
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

        setResizable(false);

        JPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos "));
        JPanelDatos.setToolTipText("Datos");
        JPanelDatos.setName("Datos"); // NOI18N

        jLabellNombre.setText("Nombre: ");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabelFechaNac.setText("Fecha de Nacimiento:");

        jLabelEdad.setText("Edad:");

        txtEdad.setEditable(false);
        txtEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdadFocusLost(evt);
            }
        });

        LabellTelefono.setText("Teléfono: ");

        txtTelefono.setMinimumSize(new java.awt.Dimension(100, 20));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabelDireccion.setText("Dirección:");

        jLabelSexo.setText("Sexo:");

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Otro.." }));

        jLabelEmail.setText("Email:");

        jLabelApellidos.setText("Apellidos:");

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        DCFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DCFechaNacimientoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout JPanelDatosLayout = new javax.swing.GroupLayout(JPanelDatos);
        JPanelDatos.setLayout(JPanelDatosLayout);
        JPanelDatosLayout.setHorizontalGroup(
            JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelDatosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabellNombre)
                        .addGap(15, 15, 15)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabelDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSexo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelDatosLayout.createSequentialGroup()
                        .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelEmail)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabelFechaNac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DCFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEdad)
                        .addGap(15, 15, 15)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(LabellTelefono)
                        .addGap(15, 15, 15)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        JPanelDatosLayout.setVerticalGroup(
            JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelDatosLayout.createSequentialGroup()
                .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelDatosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelApellidos)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelDatosLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabellNombre)
                                    .addComponent(jLabelFechaNac)
                                    .addComponent(jLabelEdad)
                                    .addComponent(LabellTelefono)))))
                    .addComponent(DCFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelSexo)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        SituacionMedica.setBorder(javax.swing.BorderFactory.createTitledBorder("Situación Médica"));
        SituacionMedica.setToolTipText("Situación Médica");
        SituacionMedica.setFocusable(false);
        SituacionMedica.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        SituacionMedica.setName("Datos"); // NOI18N

        jLabelServicioMedico.setText("Servicio Médico:");

        txtServicioM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtServicioMKeyTyped(evt);
            }
        });

        jLabelNumFolio.setText("Num. Folio:");

        jLabelEnfermedad.setText("Alguna Enfermedad / Alegia");

        txtEnfermedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnfermedadKeyTyped(evt);
            }
        });

        jLabelPeso.setText("Peso:");

        jLabelEstatura.setText("Estatura:");

        txtEstatura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstaturaFocusLost(evt);
            }
        });

        jLabelIMC.setText("IMC :");

        txtIMC.setEditable(false);

        jLabelTipoSangre.setText("Tipo de Sangre:");

        jComboBoxTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "O+", "A-" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Emergencia"));

        txtContactoE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactoEKeyTyped(evt);
            }
        });

        jComboBoxSexoE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Otro.." }));

        jLabelTelefonoE.setText("Teléfono de Emergencia:");

        txtTelefonoE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoEKeyTyped(evt);
            }
        });

        jLabelSexoE.setText("Sexo:");

        jLabelContactoE.setText("Nombre de contacto:");

        txtApellidosE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosEKeyTyped(evt);
            }
        });

        jLabelApellidosE.setText("Apellidos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelContactoE)
                .addGap(5, 5, 5)
                .addComponent(txtContactoE, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelApellidosE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidosE, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabelTelefonoE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSexoE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTelefonoE)
                        .addComponent(txtTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSexoE)
                        .addComponent(jComboBoxSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelApellidosE)
                        .addComponent(txtApellidosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtContactoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelContactoE)))
                .addGap(0, 0, Short.MAX_VALUE))
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
                        .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTipoSangre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(20, 20, 20)
                .addGroup(SituacionMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstatura)
                    .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIMC)
                    .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoSangre)
                    .addComponent(jComboBoxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicio"));
        jPanel3.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N

        Pregunta1.add(RadioNo);
        RadioNo.setText("NO");

        Pregunta1.add(RadioSi);
        RadioSi.setText("SI");
        RadioSi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("¿Experiencia en entrenamiento?");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(71, 71, 71)
                .addComponent(RadioSi)
                .addGap(82, 82, 82)
                .addComponent(RadioNo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioSi)
                    .addComponent(RadioNo)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("¿Cuál de nuestros servicios te interesa?");

        Pregunta2.add(RadioPesas);
        RadioPesas.setText("Pesas");

        Pregunta2.add(RadioZumba);
        RadioZumba.setText("Zumba");

        Pregunta2.add(RadioCardio);
        RadioCardio.setText("Cardio");

        Pregunta2.add(RadioSquash);
        RadioSquash.setText("Squash");

        Pregunta2.add(RadioSpining);
        RadioSpining.setText("Spining");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(RadioPesas)
                .addGap(18, 18, 18)
                .addComponent(RadioZumba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioCardio)
                .addGap(18, 18, 18)
                .addComponent(RadioSquash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioSpining)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RadioPesas)
                    .addComponent(RadioZumba)
                    .addComponent(RadioCardio)
                    .addComponent(RadioSquash)
                    .addComponent(RadioSpining))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel4.setText("¿Cuáles son tus objetivos para estar en forma?");

        Pregunta3.add(RadioPerdidaPeso);
        RadioPerdidaPeso.setText("Pérdida depeso");

        Pregunta3.add(RadioFuerza);
        RadioFuerza.setText("Fuerza");

        Pregunta3.add(RadioTornicidad);
        RadioTornicidad.setText("Tornicidadad muscular");

        Pregunta3.add(RadioCompetencia);
        RadioCompetencia.setText("Competencia");

        Pregunta3.add(RadioFlexibilidad);
        RadioFlexibilidad.setText("Flexibilidad");

        Pregunta3.add(RadioEstetica);
        RadioEstetica.setText("Estetica y salud");

        Pregunta3.add(RadioSalud);
        RadioSalud.setText("Salud");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(RadioPerdidaPeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioFuerza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioTornicidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioCompetencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioFlexibilidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioEstetica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioSalud)
                .addGap(0, 286, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RadioPerdidaPeso)
                    .addComponent(RadioFuerza)
                    .addComponent(RadioTornicidad)
                    .addComponent(RadioCompetencia)
                    .addComponent(RadioFlexibilidad)
                    .addComponent(RadioEstetica)
                    .addComponent(RadioSalud))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Modificar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btnactualizar)
                .addGap(18, 18, 18)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaClientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TablaClientes);

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel10.setText("BUSCAR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SituacionMedica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SituacionMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JPanelDatos.getAccessibleContext().setAccessibleName("Datos");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtEstaturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstaturaFocusLost
        int P = Integer.parseInt(txtPeso.getText());
        float E = Float.parseFloat(txtEstatura.getText());
        String IMC = String.valueOf(P / (E * E));
        System.out.println(IMC);
        System.out.println(P);
        System.out.println(E);
        txtIMC.setText(IMC);
        jComboBoxTipoSangre.requestFocus();
    }//GEN-LAST:event_txtEstaturaFocusLost

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        desbloquear();
        limpiar();
        txtNombre.requestFocus();
        Buscar("");
        setEnableContainer(this, true);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        try {
            if (ValidarCasillas() && ValidarRadioButton() && InsertarGeneral()) {
                limpiar();
                bloquear();
                Buscar("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        try {
            BotonModificar();
            limpiar();
            bloquear();
        } catch (SQLException ex) {
            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        bloquear();
        limpiar();
        Buscar("");
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
        FrameInterno Cerrar = new FrameInterno();
        Cerrar.setVisible(true);

        Principal.PanelInterno.removeAll();
        Principal.PanelInterno.add(Cerrar);
        try {
            Cerrar.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        Buscar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        desbloquear();
        setEnableContainer(jPanel3, false);
        btnactualizar.setEnabled(true);
        //btnguardar.setEnabled(false);
        Modificar();
    }//GEN-LAST:event_ModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try {
            Conexion basedatos = new Conexion().conectar();
            int fila = TablaClientes.getSelectedRow();
            String IDP = TablaClientes.getValueAt(fila, 0).toString();
            System.out.println(IDP);
            String Nom = TablaClientes.getValueAt(fila, 1).toString();
            System.out.println(Nom);
            int confirmado = JOptionPane.showConfirmDialog(null,
                    "Seguro de eliminar el cliente con nombre '" + Nom + "'", "Confirmar Salida",
                    JOptionPane.OK_OPTION);

            if (JOptionPane.OK_OPTION == confirmado) {
                String Eliminar = "DELETE FROM c_datosgenerales WHERE IDCliente = '" + IDP + "'";
                System.out.println(Eliminar);
                if (basedatos.ejecutar(Eliminar)) {
                    JOptionPane.showMessageDialog(null, "Cliente Eliminado");

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se elimino el Cliente");
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        TablaClientes.clearSelection();
        Buscar("");
    }//GEN-LAST:event_EliminarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        //para que me acepte letras minusculas y mayusculas y espacio
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        //para que me acepte letras minusculas y mayusculas y espacio
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoEKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoEKeyTyped

    private void txtContactoEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoEKeyTyped
        //para que me acepte letras minusculas y mayusculas y espacio
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtContactoEKeyTyped

    private void txtApellidosEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosEKeyTyped
        //para que me acepte letras minusculas y mayusculas y espacio
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosEKeyTyped

    private void txtServicioMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicioMKeyTyped
        //para que me acepte letras minusculas y mayusculas y espacio
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtServicioMKeyTyped

    private void txtEnfermedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnfermedadKeyTyped
        //para que me acepte letras minusculas y mayusculas y espacio
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEnfermedadKeyTyped

    private void DCFechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DCFechaNacimientoFocusLost
        CalcularEdad();
        txtTelefono.requestFocus();
    }//GEN-LAST:event_DCFechaNacimientoFocusLost

    private void txtEdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusLost
        CalcularEdad();
    }//GEN-LAST:event_txtEdadFocusLost

    private void txtEdadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusGained
        CalcularEdad();
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtEdadFocusGained

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
            java.util.logging.Logger.getLogger(Inscripcion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inscripcion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inscripcion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inscripcion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            //UIManager.setLookAndFeel(Respuesta1);
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inscripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCFechaNacimiento;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JPanel JPanelDatos;
    private javax.swing.JLabel LabellTelefono;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.ButtonGroup Pregunta1;
    private javax.swing.ButtonGroup Pregunta2;
    private javax.swing.ButtonGroup Pregunta3;
    private javax.swing.JRadioButton RadioCardio;
    private javax.swing.JRadioButton RadioCompetencia;
    private javax.swing.JRadioButton RadioEstetica;
    private javax.swing.JRadioButton RadioFlexibilidad;
    private javax.swing.JRadioButton RadioFuerza;
    private javax.swing.JRadioButton RadioNo;
    private javax.swing.JRadioButton RadioPerdidaPeso;
    private javax.swing.JRadioButton RadioPesas;
    private javax.swing.JRadioButton RadioSalud;
    private javax.swing.JRadioButton RadioSi;
    private javax.swing.JRadioButton RadioSpining;
    private javax.swing.JRadioButton RadioSquash;
    private javax.swing.JRadioButton RadioTornicidad;
    private javax.swing.JRadioButton RadioZumba;
    private javax.swing.JPanel SituacionMedica;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JComboBox<String> jComboBoxSexoE;
    private javax.swing.JComboBox<String> jComboBoxTipoSangre;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelApellidosE;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosE;
    private javax.swing.JTextField txtContactoE;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnfermedad;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtIMC;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumFolio;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtServicioM;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoE;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
