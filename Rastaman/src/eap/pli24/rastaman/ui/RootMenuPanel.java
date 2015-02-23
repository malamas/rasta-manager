package eap.pli24.rastaman.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/**
 *
 * @author Malamas Malamidis
 * @author Apostolis Iakovakis
 */
public class RootMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form RootMenuPanel
     */
    public RootMenuPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new JPanel();
        artistButton = new JButton();
        musicgroupButton = new JButton();
        artistAlbumButton = new JButton();
        groupAlbumButton = new JButton();
        playlistButton = new JButton();
        exitButton = new JButton();

        setLayout(new BorderLayout());

        artistButton.setText("Καλλιτέχνες");
        artistButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                artistButtonActionPerformed(evt);
            }
        });

        musicgroupButton.setText("Συγκροτήματα");
        musicgroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                musicgroupButtonActionPerformed(evt);
            }
        });

        artistAlbumButton.setText("Αλμπουμ Καλλιτεχνών");
        artistAlbumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                artistAlbumButtonActionPerformed(evt);
            }
        });

        groupAlbumButton.setText("Άλμπουμ Συγκροτημάτων");
        groupAlbumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                groupAlbumButtonActionPerformed(evt);
            }
        });

        playlistButton.setText("Λίστες");
        playlistButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                playlistButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Έξοδος");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(groupAlbumButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(artistAlbumButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicgroupButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(artistButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playlistButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(artistButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(musicgroupButton)
                .addGap(18, 18, 18)
                .addComponent(artistAlbumButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(groupAlbumButton)
                .addGap(18, 18, 18)
                .addComponent(playlistButton)
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        add(menuPanel, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void musicgroupButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_musicgroupButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.GROUP_TABLE);
    }//GEN-LAST:event_musicgroupButtonActionPerformed

    private void artistButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_artistButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.ARTIST_TABLE);
    }//GEN-LAST:event_artistButtonActionPerformed

    private void exitButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        controller.shutdown();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void artistAlbumButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_artistAlbumButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.ARTIST_ALBUM_TABLE);
    }//GEN-LAST:event_artistAlbumButtonActionPerformed

    private void groupAlbumButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_groupAlbumButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.GROUP_ALBUM_TABLE);
    }//GEN-LAST:event_groupAlbumButtonActionPerformed

    private void playlistButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_playlistButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.PLAYLIST_TABLE);
    }//GEN-LAST:event_playlistButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton artistAlbumButton;
    private JButton artistButton;
    private JButton exitButton;
    private JButton groupAlbumButton;
    private JPanel menuPanel;
    private JButton musicgroupButton;
    private JButton playlistButton;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private MainFrameController controller;

    public RootMenuPanel(MainFrameController controller) {
        this.controller = controller;
        initComponents();
        initFurther();
    }

    private void initFurther() {
    }
}
