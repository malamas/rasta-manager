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

import eap.pli24.rastaman.entities.Playlist;
import eap.pli24.rastaman.entities.Song;
import eap.pli24.rastaman.ui.tablecellrenderers.TableCellRendererFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Beans;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
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
public class PlaylistEditorPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlaylistEditorPanel
     */
    public PlaylistEditorPanel() {
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

        boundPlaylist = playlist;
        RastamanPUEntityManager = Beans.isDesignTime() ? null : Persistence.createEntityManagerFactory("RastamanPU").createEntityManager();
        songQuery = Beans.isDesignTime() ? null : RastamanPUEntityManager.createQuery("SELECT s FROM Song s");
        songList = Beans.isDesignTime() ? Collections.emptyList() : songQuery.getResultList();
        namePanel = new JPanel();
        nameLabel = new JLabel();
        nameTextField = new JTextField();
        tablesPanel = new JPanel();
        filler8 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        scrollPane1 = new JScrollPane();
        playlistSongTable = new JTable();
        songButtonPanel = new JPanel();
        filler5 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        addButton = new JButton();
        filler6 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(120, 50));
        removeButton = new JButton();
        filler7 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        scrollPane2 = new JScrollPane();
        availableSongTable = new JTable();
        filler9 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        buttonPanel = new JPanel();
        filler2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        cancelButton = new JButton();
        filler4 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        saveButton = new JButton();
        filler3 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        namePanel.setPreferredSize(new Dimension(0, 50));
        namePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 12));

        nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        nameLabel.setLabelFor(nameTextField);
        nameLabel.setText("Όνομα:");
        nameLabel.setPreferredSize(new Dimension(40, 14));
        namePanel.add(nameLabel);

        nameTextField.setPreferredSize(new Dimension(200, 20));

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, boundPlaylist, ELProperty.create("${name}"), nameTextField, BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        namePanel.add(nameTextField);

        add(namePanel);

        tablesPanel.setPreferredSize(new Dimension(0, 200));
        tablesPanel.setLayout(new BoxLayout(tablesPanel, BoxLayout.LINE_AXIS));
        tablesPanel.add(filler8);

        scrollPane1.setPreferredSize(new Dimension(300, 0));

        playlistSongTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playlistSongTable.getTableHeader().setReorderingAllowed(false);

        ELProperty eLProperty = ELProperty.create("${playlistSongList}");
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, boundPlaylist, eLProperty, playlistSongTable);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${slot}"));
        columnBinding.setColumnName("Σειρά");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${song.title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${song.albumId.performerScreenName}"));
        columnBinding.setColumnName("Ερμηνευτής");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${song.duration}"));
        columnBinding.setColumnName("Διάρκεια");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollPane1.setViewportView(playlistSongTable);

        tablesPanel.add(scrollPane1);

        songButtonPanel.setAlignmentX(0.5F);
        songButtonPanel.setMaximumSize(new Dimension(150, 32767));
        songButtonPanel.setMinimumSize(new Dimension(150, 0));
        songButtonPanel.setPreferredSize(new Dimension(150, 0));
        songButtonPanel.setLayout(new BoxLayout(songButtonPanel, BoxLayout.PAGE_AXIS));
        songButtonPanel.add(filler5);

        addButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/go-previous.png"))); // NOI18N
        addButton.setText("Προσθήκη");
        addButton.setAlignmentX(0.5F);
        addButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addButton.setMaximumSize(new Dimension(100, 50));
        addButton.setMinimumSize(new Dimension(100, 50));
        addButton.setPreferredSize(new Dimension(100, 50));
        addButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, availableSongTable, ELProperty.create("${selectedElement!=null}"), addButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(addButton);
        songButtonPanel.add(filler6);

        removeButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/go-next.png"))); // NOI18N
        removeButton.setText("Αφαίρεση");
        removeButton.setAlignmentX(0.5F);
        removeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        removeButton.setMaximumSize(new Dimension(100, 50));
        removeButton.setMinimumSize(new Dimension(100, 50));
        removeButton.setPreferredSize(new Dimension(100, 50));
        removeButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, playlistSongTable, ELProperty.create("${selectedElement!=null}"), removeButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(removeButton);
        songButtonPanel.add(filler7);

        tablesPanel.add(songButtonPanel);

        scrollPane2.setPreferredSize(new Dimension(300, 0));

        availableSongTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        availableSongTable.getTableHeader().setReorderingAllowed(false);

        jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, songList, availableSongTable);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${albumId.performerScreenName}"));
        columnBinding.setColumnName("Ερμηνευτής");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${duration}"));
        columnBinding.setColumnName("Διάρκεια");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollPane2.setViewportView(availableSongTable);

        tablesPanel.add(scrollPane2);
        tablesPanel.add(filler9);

        add(tablesPanel);

        buttonPanel.setPreferredSize(new Dimension(0, 50));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(filler2);

        cancelButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/undo22.png"))); // NOI18N
        cancelButton.setText("Ακύρωση");
        cancelButton.setPreferredSize(new Dimension(120, 36));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);
        buttonPanel.add(filler4);

        saveButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/accept22.png"))); // NOI18N
        saveButton.setText("Αποθήκευση");
        saveButton.setPreferredSize(new Dimension(120, 36));
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(saveButton);
        buttonPanel.add(filler3);

        add(buttonPanel);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.PLAYLIST_TABLE);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void removeButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private EntityManager RastamanPUEntityManager;
    private JButton addButton;
    private JTable availableSongTable;
    private Playlist boundPlaylist;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private Box.Filler filler2;
    private Box.Filler filler3;
    private Box.Filler filler4;
    private Box.Filler filler5;
    private Box.Filler filler6;
    private Box.Filler filler7;
    private Box.Filler filler8;
    private Box.Filler filler9;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JTextField nameTextField;
    private JTable playlistSongTable;
    private JButton removeButton;
    private JButton saveButton;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JPanel songButtonPanel;
    private List<Song> songList;
    private Query songQuery;
    private JPanel tablesPanel;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private MainFrameController controller;
    private EntityManager em;
    private Playlist playlist;

    public PlaylistEditorPanel(MainFrameController controller, EntityManager em, Playlist playlist) {
        this.controller = controller;
        this.em = em;
        this.playlist = playlist;
        initComponents();
        initFurther();
    }

    private void initFurther() {
        buttonPanel.setPreferredSize(new Dimension(0, UIProperties.BUTTON_PANEL_HEIGHT));
        buttonPanel.setMaximumSize(new Dimension(32767, UIProperties.BUTTON_PANEL_HEIGHT));
        buttonPanel.setMinimumSize(new Dimension(0, UIProperties.BUTTON_PANEL_HEIGHT));
        namePanel.setPreferredSize(new Dimension(0, UIProperties.BUTTON_PANEL_HEIGHT));
        namePanel.setMaximumSize(new Dimension(32767, UIProperties.BUTTON_PANEL_HEIGHT));
        namePanel.setMinimumSize(new Dimension(0, UIProperties.BUTTON_PANEL_HEIGHT));

        // Καθορισμός εμφάνισης πίνακα
        TableColumnModel tcm = playlistSongTable.getColumnModel();
        for (int i = 0; i < tcm.getColumnCount(); i++) {
            switch (i) {
                case 0:
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.GENERIC_RIGHT_ALIGNED));
                    break;
                case 3:
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.DURATION));
                    break;
                default:
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.GENERIC));
                    break;
            }
        }
        // Καθορισμός εμφάνισης πίνακα
        TableColumnModel tcm2 = availableSongTable.getColumnModel();
        for (int i = 0; i < tcm2.getColumnCount(); i++) {
            switch (i) {
                case 2:
                    tcm2.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.DURATION));
                    break;
                default:
                    tcm2.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.GENERIC));
                    break;
            }
        }
    }
}
