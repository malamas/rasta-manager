package eap.pli24.rastaman.ui.tablecellrenderers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.SwingConstants;

/**
 *
 * @author Malamas Malamidis
 */
public class DateTableCellRenderer extends GenericTableCellRenderer {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "US"));

    public DateTableCellRenderer() {
        super();
        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    protected void setValue(Object value) {
        setText(sdf.format((Date) value));
    }
}
