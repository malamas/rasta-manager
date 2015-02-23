package eap.pli24.rastaman.ui.tablecellrenderers;

import eap.pli24.rastaman.ui.UIProperties;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Malamas Malamidis
 */
public class GenericTableCellRenderer extends DefaultTableCellRenderer {

    private static final Color oddRowColor = UIProperties.TABLE_ODD_ROW_BACKGROUND;
    private static final Color evenRowColor = UIProperties.TABLE_EVEN_ROW_BACKGROUND;
    private static final Color selectedColor = UIProperties.TABLE_SELECTED_ROW_BACKGROUND;

    public GenericTableCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.setBackground((isSelected ? selectedColor : (row % 2 == 0) ? oddRowColor : evenRowColor));
        return this;
    }
}
