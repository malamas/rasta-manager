package eap.pli24.rastaman.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Η κλάση {@code UIProperties} παρέχει μια σειρά από σταθερές {@code public
 * static final} που ορίζουν ιδιότητες του user interface. Είναι {@code final}
 * ώστε να μην μπορεί να κληρονομηθεί, και έχει {@code private} δημιουργό, ώστε
 * να μη μπορούν να δημιουργηθούν στιγμιότυπά της.
 *
 * @author Malamas Malamidis
 */
public final class UIProperties {

    public static final Dimension MAIN_FRAME_INIT_SIZE = new Dimension(1000, 700);
    public static final Dimension MAIN_FRAME_MIN_SIZE = new Dimension(900, 600);

    public static final int SIDEBAR_WIDTH = 240;
    public static final Color SIDEBAR_BACKGROUND = new Color(104, 104, 0);
    public static final Color RASTAMAN_FOREGROUND = new Color(240, 220, 48);
    public static final Font RASTAMAN_FONT = new Font("Tahoma", 1, 14);

    public static final Dimension CREDITS_SIZE = new Dimension(200, 200);
    public static final Color CREDITS_FOREGROUND = new Color(224, 224, 224);
    public static final Font CREDITS_FONT = new Font("Tahoma", 1, 11);

    public static final int HEADER_HEIGHT = 50;
    public static final Color HEADER_BACKGROUND = new Color(204, 208, 204);
    public static final Font HEADER_FONT = new Font("Tahoma", 1, 14);
    public static final Color HEADER_FOREGROUND = new Color(48, 48, 24);

    public static final int BUTTON_PANEL_HEIGHT = 42;

    public static final Color TABLE_ODD_ROW_BACKGROUND = new Color(255, 255, 255);
    public static final Color TABLE_EVEN_ROW_BACKGROUND = new Color(224, 232, 216);
    public static final Color TABLE_SELECTED_ROW_BACKGROUND = new Color(104, 104, 0);

    /*
     * {@code private} δημιουργός, ώστε να μη μπορούν να δημιουργηθούν στιγμιότυπα της κλάσης.
     */
    private UIProperties() {
    }
}
