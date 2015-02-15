package eap.pli24.rastaman.ui.tablecellrenderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Malamas Malamidis
 */
public class GenericTableCellRenderer extends DefaultTableCellRenderer {

    private static final Color oddRowColor = new Color(255, 255, 255);
    private static final Color evenRowColor = new Color(216, 224, 232);

    public GenericTableCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground((row % 2 == 0) ? oddRowColor : evenRowColor);
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return this;
    }
}
