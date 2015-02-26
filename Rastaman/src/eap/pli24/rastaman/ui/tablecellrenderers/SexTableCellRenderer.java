package eap.pli24.rastaman.ui.tablecellrenderers;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class SexTableCellRenderer extends GenericTableCellRenderer {

    public SexTableCellRenderer() {
        super();
    }

    @Override
    protected void setValue(Object value) {
        String v = (String) value;
        switch (v) {
            case "m":
                setText("Άνδρας");
                break;
            case "f":
                setText("Γυναίκα");
                break;
            default:
                setText(v);
                break;
        }
    }
}
