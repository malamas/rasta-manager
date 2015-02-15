package eap.pli24.rastaman.ui.tablecellrenderers;

import java.util.EnumMap;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Malamas Malamidis
 */
public class TableCellRendererFactory {

    public static enum RendererType {

        GENERIC,
        GENERIC_RIGHT_ALIGNED,
        DATE,
        SEX
    }
    private static final TableCellRenderer genericTableCellRenderer = new GenericTableCellRenderer();
    private static final TableCellRenderer rightAlignedTableCellRenderer = new RightAlignedTableCellRenderer();
    private static final TableCellRenderer dateTableCellRenderer = new DateTableCellRenderer();
    private static final TableCellRenderer sexTableCellRenderer = new SexTableCellRenderer();
    private static final EnumMap<RendererType, TableCellRenderer> renderers = new EnumMap<>(RendererType.class);

    static {
        renderers.put(RendererType.GENERIC, genericTableCellRenderer);
        renderers.put(RendererType.GENERIC_RIGHT_ALIGNED, rightAlignedTableCellRenderer);
        renderers.put(RendererType.DATE, dateTableCellRenderer);
        renderers.put(RendererType.SEX, sexTableCellRenderer);
    }

    private TableCellRendererFactory() {
    }

    public static TableCellRenderer getTableCellRenderer(RendererType type) {
        return renderers.get(type);
    }
}
