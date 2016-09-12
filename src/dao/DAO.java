package dao;

import gimnasio.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JTable;
import utils.Utils;

/**
 * Clase de persitencia para gestionar la tabla registroES
 * de la BD.
 * @author Misael Cruz Palacios
 */
public class DAO {

    /**
     * Registra la hora de entrada o salida segun sea el caso.
     * @param numEmpleado Número de empleado.
     * @param campo Campo que se registrará "entrada" o "salida"
     * @return Estado de la ejecucuión.
     * @throws SQLException Manejo de Excepción de BD.
     */
    public boolean registra(final String numEmpleado, final String campo)
            throws SQLException {
        Conexion basedatos = new Conexion().conectar();

        Date dateTimeNow = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String date  = formatDate.format(dateTimeNow);
        boolean status = false;
        String query = "";

        if (campo.equals("Entrada")) {
            query = String.format(
                    "insert into registroEs (fecha, IDEmpleado, Entrada)"
                        + " values (sysdate(), '%s', sysdate())", numEmpleado);
            status = basedatos.ejecutar(query);
        } else {
            query = String.format("update registroES set salida = sysdate()"
                    + " where idEmpleado = '%s' and fecha = '%s'",
                    numEmpleado, date);

            basedatos.ejecutar(query);

            String horas = calculaHoras(numEmpleado, date);
            System.out.println("Horas Calculadas " + horas);
            query = String.format("update registroES set horas = '%s' where"
                    + " idEmpleado = '%s' and fecha = '%s'", horas, numEmpleado,
                    date);

            System.out.println("Ejecutando " + query);
            status = basedatos.ejecutar(query);
        }
        return status;
    }

    /**
     * Verifica si el usuario ya registro la entrada.
     * @param numEmpleado Numero de empleado.
     * @param nombre Nombre de Empleado.
     * @return True Si ya tiene entrada, false caso contrario.
     * @throws SQLException Manejo de excepciones.
     */
    public boolean isEntradaRegistrada(final String numEmpleado, final String
            nombre) throws SQLException {
        Date dateTimeNow = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String date  = formatDate.format(dateTimeNow);

        String query = "select IDEmpleado from registroes where fecha = '"
                + date + "' and idempleado = '" + numEmpleado + "'";

        System.out.println(String.format("Verificnado si el usuario [%s] ya"
                + " tiene el registro de entrada del dia [%s]", nombre, date));

        String status = new Conexion().conectar().queryForString(query);
        System.out.println("-> " + status);
        if (status.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Válida el usuario.
     * @return 
     */
    public String getNombreEmpleado(final String idEmpelado, final String pass)
            throws SQLException {

        String query = "select concat_ws(' ', Nombre, Apellidos) from empleados"
                + " where IDEmpleado = '" + idEmpelado + "' and "
                + "pass = '" + pass + "'";

        String nombre = "";
        nombre = new Conexion().conectar().queryForString(query);
        System.out.println("getNombreEmpleado " + nombre);
        return nombre;
    }

    public boolean getIDEmpleado(final String user, final String pass)
            throws SQLException {

        String query = "select IDEmpleado from empleados where Nombre= '"
                + user + "' and Password= '" + pass + "'";

        String result = new Conexion().conectar().queryForString(query);

        if (result.equals("")) {
            return false;
        } else {
            return true;
        }
    }
    public String calculaHoras(final String numEmpleado, final String date)
            throws SQLException {
        String sql = "select entrada, salida from registroES  where"
                + " IDEmpleado = '" + numEmpleado + "' "
                + "and Fecha = '" + date + "' ";
        Conexion basedatos = new Conexion().conectar();
        ResultSet rs = basedatos.consultar(sql);

        if (rs.last()) {
            String entrada = rs.getString("Entrada");
            String salida = rs.getString("Salida");
            System.out.println("E/S " + entrada + " " + salida);
            /*String horas = basedatos.queryForString(
                    "SELECT SEC_TO_TIME((TIMESTAMPDIFF(minute,
            '" + entrada + "', '" + salida + "')) * 60)");*/
            String horas = basedatos.queryForString(
                    "SELECT SEC_TO_TIME(TIME_TO_SEC('" + salida + "') - "
                            + "TIME_TO_SEC('" + entrada + "')) AS totalHours ");
            return horas;
        }
        return "";
    }

    /**
     * Carga tabla con datos de empleados.
     * @param tblEmpleados tabla a Cargar.
     */
    final public void cargaTablaEmpleados(JTable tblEmpleados) {
        String[] Titulos = {"N° Empleado", "Nombre", "Dirección",
            "Ciudad", "Telefono"};
        String sql = "Select idEmpleado, concat_ws(' ', nombre, apellidos),"
                + " direccion, ciudad, telefono from empleados";

        new Conexion().CargarDatosEnTabla(sql, Titulos, tblEmpleados);
        new Utils().adjustColumnPreferredWidths(tblEmpleados);
    }
    

    /**
     * Carga tabla con datos de empleados.
     * @param tblDetalle  tabla a Cargar.
     */
    final public void cargaDetallesSalaio(JTable tblDetalle) {
        String[] Titulos = {"N° Empleado", "Nombre", "Dirección",
            "Ciudad", "Telefono"};
        String sql = "Select idEmpleado, concat_ws(' ', nombre, apellidos),"
                + " direccion, ciudad, telefono from empleados";

        new Conexion().CargarDatosEnTabla(sql, Titulos, tblDetalle);
        new Utils().adjustColumnPreferredWidths(tblDetalle);
    }

    public HashMap<String, String> calculaHorasTrabajadas(final String fechaIni, final String
            fechaFin, final String numEmpleado) throws SQLException {

        Conexion db = new Conexion().conectar();

        String horas = "";
        String dias = "";
        HashMap<String, String> datos = new HashMap<String, String>();

        String queryHoras = String.format(""
                + " SELECT concat( SEC_TO_TIME(SUM(TIME_TO_SEC(horas))), '')"
                + " AS totalHours"
                + " from registroes where idEmpleado = '%s'"
                + " and fecha >= '%s' and fecha <= '%s' ",
                numEmpleado, fechaIni, fechaFin);

        String queryDias = String.format(
                "SELECT DATEDIFF('%s','%s') + 1 as dias", fechaFin, fechaIni);

        String querySalario = String.format("select salarioHora, salarioDia"
                + " from puestos, empleados where idPuesto = puesto"
                + " and idEmpleado ='%s'", numEmpleado);
        try {

            horas = db.queryForString(queryHoras);
            dias = db.queryForString(queryDias);
            datos = db.queryForMap(querySalario);
            datos.put("Horas", horas);
            datos.put("Dias", dias);
        } finally {
            db.getConexion().close();
        }

        return datos;
    }

    private void executeQuery() {
        
    }
}
