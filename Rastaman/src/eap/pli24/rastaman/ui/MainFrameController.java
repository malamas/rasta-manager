package eap.pli24.rastaman.ui;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.WindowConstants;

/**
 *
 * @author Malamas Malamidis
 */
public class MainFrameController implements Runnable {

    MainFrame mainFrame;

    @Override
    public void run() {
        initMainFrame();
    }

    private void initMainFrame() {
        mainFrame = new MainFrame();
        //pass a reference of this controller to the frame for callbacks
        mainFrame.setController(this);

        //set frame size
        mainFrame.setSize(900, 600);

        //Center the frame on screen
        Point screenCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        mainFrame.setLocation(screenCenter.x - mainFrame.getWidth() / 2, screenCenter.y - mainFrame.getHeight() / 2);

        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //The window closing event is handled in a listener

        mainFrame.setTitle("Rastaman");

        mainFrame.setVisible(true);
    }

    public void shutdown() {
        mainFrame.dispose();
    }
}
