package utils;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Misael Cruz Palacios (yp_u2@yahoo.com.mx)
 * @version 1.
 */
public class Utils {

    public void adjustColumnPreferredWidths(JTable table) {
        // strategy - get max width for cells in column and
        // make that the preferred width
        TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {
            int maxwidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer rend
                        = table.getCellRenderer(row, col);
                Object value = table.getValueAt(row, col);
                Component comp
                        = rend.getTableCellRendererComponent(table,
                                value,
                                false,
                                false,
                                row,
                                col);
                maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
            } // for row
            TableColumn column = columnModel.getColumn(col);
            column.setPreferredWidth(maxwidth);
        } // for col
    }

    public static boolean isFechaInicioMayor(
            final String inicio, final String fin) {
        boolean fechaInicioMayor = false;
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate1 = formateador.parse(inicio);
            Date fechaDate2 = formateador.parse(fin);

            System.out.println("inicio " + fechaDate1);
            System.out.println("fin " + fechaDate2);

            if (fechaDate1.before(fechaDate2)) {
                fechaInicioMayor = false;
            } else {
                fechaInicioMayor = true;
            }
        } catch (ParseException e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }
        return fechaInicioMayor;
    }
}

