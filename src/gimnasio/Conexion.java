/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UnTalNose
 */
public class Conexion {

    private Connection conexion;

    public Conexion conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BaseDeDatos = "jdbc:mysql://localhost:3306/ixtapapalacegym";
            conexion = DriverManager.getConnection(BaseDeDatos, "root", "frijolito132");
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
        }
        return this;
    }
    
    public boolean ejecutar(String sql) {
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            conexion.setAutoCommit(false);
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            conexion.commit();
        } catch (SQLException e) {
            System.err.print(e+"  ---");
            e.printStackTrace();
            return null;
        }
        return resultado;
    }

    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public static void main(String[] args) {
         
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.blueiceLookAndFeel");
        } catch (Exception e){
        }

        Login obj= new Login();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
        Conexion baseDatos = new Conexion().conectar();

            //System.out.println("Ejecucion correcta!");
      
        
    }        

    //Metodo que regresa un dato consultado
    public String queryForString(String query) throws SQLException {
        String Dato = "";

        System.out.println("Ejecutando Query " + query);

        ResultSet resultado = null;
        resultado = consultar(query);
        while (resultado.next()) {
            String tmpStrObtenido = resultado.getString(1);
            Dato = tmpStrObtenido.toUpperCase();
        }
        return Dato;
    }

    /**
     * Carga los datos en un JTable.
     * @param sql Sentencia SQL.
     * @param titulos Arreglo de titulos.
     * @param tablaACargar Tabla a cargar.
     */
    public void CargarDatosEnTabla(String sql, String[] titulos, JTable tablaACargar) {
        Conexion baseDatos = new Conexion().conectar();

        String[] Datos = new String[titulos.length];
        DefaultTableModel Modelo = new DefaultTableModel(null, titulos);

        ResultSet resultados = baseDatos.consultar(sql);
        if (resultados != null) {
            try {
                //int i=0;
                while (resultados.next()) {
                    int j = 0;
                    for (int i = 1; i <= Datos.length; i++) {
                        Datos[j] = resultados.getString(i);
                        j++;
                    }
                    Modelo.addRow(Datos);
                }
                tablaACargar.setModel(Modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public ArrayList<String> queryForList(final String sql)
            throws SQLException {

        ArrayList<String> list = null;
        Conexion baseDatos = new Conexion().conectar();

        ResultSet rs = baseDatos.consultar(sql);
        if (rs != null && rs.next()) {
            list = new ArrayList<String>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    list.add(rs.getString(i));
                }
            }
        }
        return list;
    }

    public HashMap<String, String> queryForMap(final String sql)
            throws SQLException {
        new Conexion().conectar();
        HashMap<String, String> map = null;

        ResultSet rs = consultar(sql);

        if (rs != null && rs.next()) {
            map = new HashMap<String, String>();
            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
                map.put(rs.getMetaData().getColumnName(i), rs.getString(i));
            }
        }
        return map;
    }
}
