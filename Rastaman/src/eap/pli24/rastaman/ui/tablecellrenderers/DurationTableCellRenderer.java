package eap.pli24.rastaman.ui.tablecellrenderers;

import java.text.DecimalFormat;
import javax.swing.SwingConstants;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class DurationTableCellRenderer extends GenericTableCellRenderer {

    private DecimalFormat dcf = new DecimalFormat("#00");

    public DurationTableCellRenderer() {
        super();
        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    protected void setValue(Object value) {
        if (value == null) {
            setText(null);
        } else {
            int d = (int) value;
            setText(dcf.format(d / 60) + ":" + dcf.format(d % 60));
        }
    }
}
