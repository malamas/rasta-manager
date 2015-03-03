/*
 * Copyright (c) 2015 Apostolis Iakovakis, Nikos Karagiannis,
 * Nikos Krommydas & Malamas Malamidis. All rights reserved.
 *
 * This file is part of Rastaman.
 *
 * Rastaman is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Rastaman is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Rastaman.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.entities.Album;
import eap.pli24.rastaman.entities.Artist;
import eap.pli24.rastaman.entities.Song;
import eap.pli24.rastaman.ui.tablecellrenderers.TableCellRendererFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Beans;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class ArtistAlbumTablePanel extends javax.swing.JPanel {

    /**
     * Creates new form ArtistAlbumTablePanel
     */
    public ArtistAlbumTablePanel() {
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
        bindingGroup = new BindingGroup();

        localEm = em;
        artistQuery = Beans.isDesignTime() ? null : localEm.createQuery("SELECT a FROM Artist a");
        artistList = Beans.isDesignTime() ? Collections.emptyList() : artistQuery.getResultList();
        albumQuery = Beans.isDesignTime() ? null : localEm.createQuery("SELECT a FROM Album a where a.artistartistid is not null");
        albumList = Beans.isDesignTime() ? Collections.emptyList() : albumQuery.getResultList();
        scrollPane1 = new JScrollPane();
        artistAlbumTable = new JTable();
        buttonPanel = new JPanel();
        filler3 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        backButton = new JButton();
        filler2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        newButton = new JButton();
        filler4 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        editButton = new JButton();
        filler5 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        deleteButton = new JButton();
        filler6 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));

        setLayout(new BorderLayout());

        artistAlbumTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        artistAlbumTable.getTableHeader().setReorderingAllowed(false);

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, albumList, artistAlbumTable);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${artistartistid.firstname}"));
        columnBinding.setColumnName("Ονομα Καλιτέχνη");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${artistartistid.lastname}"));
        columnBinding.setColumnName("Επίθετο Καλλιτέχνη");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${artistartistid.artisticname}"));
        columnBinding.setColumnName("Καλιτεχνικό Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${type}"));
        columnBinding.setColumnName("Τύπος");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${disknumber}"));
        columnBinding.setColumnName("No Δίσκου");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${labelid.name}"));
        columnBinding.setColumnName("Εταιρία");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${releasedate}"));
        columnBinding.setColumnName("Ημ.Κυκλοφορίας");
        columnBinding.setColumnClass(Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollPane1.setViewportView(artistAlbumTable);

        add(scrollPane1, BorderLayout.CENTER);

        buttonPanel.setPreferredSize(new Dimension(0, 50));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(filler3);

        backButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/home22.png"))); // NOI18N
        backButton.setText("Αρχική");
        backButton.setPreferredSize(new Dimension(120, 36));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(backButton);
        buttonPanel.add(filler2);

        newButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/add22.png"))); // NOI18N
        newButton.setText("Εισαγωγή");
        newButton.setPreferredSize(new Dimension(120, 36));
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(newButton);
        buttonPanel.add(filler4);

        editButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/edit22.png"))); // NOI18N
        editButton.setText("Επεξεργασία");
        editButton.setPreferredSize(new Dimension(120, 36));

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, artistAlbumTable, ELProperty.create("${selectedElement!=null}"), editButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(editButton);
        buttonPanel.add(filler5);

        deleteButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/delete22.png"))); // NOI18N
        deleteButton.setText("Διαγραφή");
        deleteButton.setPreferredSize(new Dimension(120, 36));

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, artistAlbumTable, ELProperty.create("${selectedElement!=null}"), deleteButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(deleteButton);
        buttonPanel.add(filler6);

        add(buttonPanel, BorderLayout.PAGE_END);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // κλικ στο πλήκτρο Εισαγωγή νέου Αλμπουμ
    private void newButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // Ανοιγμα της φόρμας επεξεργασίας Αλμπουμ για νέο Αλμπουμ
        controller.showArtistAlbumEditor(new Album());
    }//GEN-LAST:event_newButtonActionPerformed

    // κλικ στο πλήκτρο Επεξεργασία Αλμπουμ
    private void editButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // Ανοιγμα της φόρμας επεξεργασίας Αλμπουμ για το επιλεγμένο Αλμπουμ
        int selectedIndex = artistAlbumTable.getSelectedRow();
        if (selectedIndex != -1) {
            Album selectedAlbum = albumList.get(selectedIndex);
            controller.showArtistAlbumEditor(selectedAlbum);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    // κλικ στο πλήκτρο Διαγραφή Αλμπουμ       
    private void deleteButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteArtistAlbum();
    }//GEN-LAST:event_deleteButtonActionPerformed

    // κλικ στο πλήκτρο επιστροφή στο κυρίως μενού    
    private void backButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.ROOT_MENU);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private List<Album> albumList;
    private Query albumQuery;
    private JTable artistAlbumTable;
    private List<Artist> artistList;
    private Query artistQuery;
    private JButton backButton;
    private JPanel buttonPanel;
    private JButton deleteButton;
    private JButton editButton;
    private Box.Filler filler2;
    private Box.Filler filler3;
    private Box.Filler filler4;
    private Box.Filler filler5;
    private Box.Filler filler6;
    private EntityManager localEm;
    private JButton newButton;
    private JScrollPane scrollPane1;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private MainFrameController controller;
    private EntityManager em;

    public ArtistAlbumTablePanel(MainFrameController controller, EntityManager em) {
        this.controller = controller;
        this.em = em;
        initComponents();
        initFurther();
    }

    private void initFurther() {
        buttonPanel.setPreferredSize(new Dimension(0, UIProperties.BUTTON_PANEL_HEIGHT));

        // Καθορισμός εμφάνισης πίνακα
        TableColumnModel tcm = artistAlbumTable.getColumnModel();
        for (int i = 0; i < tcm.getColumnCount(); i++) {
            switch (i) {
                case 5: //στήλη Νο δισκου
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.GENERIC_RIGHT_ALIGNED));
                    break;
                case 7: //στήλη Ημερομηνία Κυκλοφορίας
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.DATE));
                    break;
                default:
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.GENERIC));
                    break;
            }
        }
    }

    // Μέθοδος deleteGroupAlbum()
    // Καλείται όταν πατηθεί το πλήκτρο Διαγραφή Album και αφου κάνει τους 
    // απαραίτητους ελέγχους διαγράφει το επιλεγμένο Album    
    private void deleteArtistAlbum() {
        int selectedIndex = artistAlbumTable.getSelectedRow();
        if (selectedIndex != -1) {
            Album a = albumList.get(selectedIndex);
            //Έλεγχος Συμμετοχής κάποιου τραγουδιού σε PlayList
            boolean isInPlaylist = false;
            for (Song s : a.getSongList()) {
                if (!s.getPlaylistSongList().isEmpty()) {
                    isInPlaylist = true;
                    break;
                }
            }
            if (!isInPlaylist) { // Εαν δεν συμμετέχει σε PlayList  διαγράφεται
                Object[] options = {"Ναι", "Όχι"};
                int n = JOptionPane.showOptionDialog(this,
                        "Να διαγραφεί το Άλμπουμ " + a.getTitle() + ";",
                        "Επιβεβαίωση Διαγραφής",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, //do not use a custom Icon
                        options, //the titles of buttons
                        options[1]); //default button title
                if (n == 0) {
                    localEm.getTransaction().begin();
                    Query q = localEm.createQuery("DELETE FROM Album al WHERE al.albumid=:albumID ",
                            Album.class).setParameter("albumID", a.getAlbumid());
                    q.executeUpdate();
                    localEm.getTransaction().commit();
                    albumList.remove(selectedIndex);
                    artistAlbumTable.updateUI();
                }
            } else { // Εαν συμμετέχει σε PlayList δεν διαγράφεται
                JOptionPane.showMessageDialog(this, "Kάποιο(α) τραγούδι(α) συμμετέχει σε λίστα \n"
                        + "πρέπει πρώτα να διαγραφεί απο αυτή",
                        "Αδυναμία διαγραφής", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}