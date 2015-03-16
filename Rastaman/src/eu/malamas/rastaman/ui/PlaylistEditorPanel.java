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
package eu.malamas.rastaman.ui;

import eu.malamas.rastaman.ui.tablemodels.SongTableModel;
import eu.malamas.rastaman.ui.tablemodels.OrderedSongTableModel;
import eu.malamas.rastaman.model.Playlist;
import eu.malamas.rastaman.ui.skins.SkinProvider;
import eu.malamas.rastaman.ui.tablecellrenderers.TableCellRendererFactory;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * Η κλάση {@code PlaylistEditorPanel} είναι ένα {@code JPanel} για εμφάνιση ui
 * για επεξεργασία μιας λίστας αναπαραγωγής.
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

        tablesPanel = new JPanel();
        filler8 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        selectedSongPanel = new JPanel();
        filler13 = new Box.Filler(new Dimension(5, 10), new Dimension(5, 10), new Dimension(120, 10));
        namePanel = new JPanel();
        filler23 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        nameLabel = new JLabel();
        filler27 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        nameTextField = new JTextField();
        filler18 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        filler16 = new Box.Filler(new Dimension(5, 5), new Dimension(5, 5), new Dimension(120, 5));
        datePanel = new JPanel();
        filler24 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        dateabel = new JLabel();
        filler26 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        dateTextField = new JTextField();
        filler25 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        dateChangeComboBox = new JComboBox();
        filler17 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        filler20 = new Box.Filler(new Dimension(5, 5), new Dimension(5, 5), new Dimension(120, 5));
        durationPanel = new JPanel();
        filler28 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        durationLabel = new JLabel();
        filler29 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        durationTextField = new JTextField();
        filler30 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        filler31 = new Box.Filler(new Dimension(5, 10), new Dimension(5, 10), new Dimension(120, 10));
        scrollPane1 = new JScrollPane();
        playlistSongTable = new JTable();
        songButtonPanel = new JPanel();
        filler5 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        upButton = new JButton();
        filler14 = new Box.Filler(new Dimension(5, 40), new Dimension(5, 40), new Dimension(120, 40));
        downButton = new JButton();
        filler15 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        addButton = new JButton();
        filler6 = new Box.Filler(new Dimension(5, 40), new Dimension(5, 40), new Dimension(120, 40));
        removeButton = new JButton();
        filler7 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        availableSongPanel = new JPanel();
        filler19 = new Box.Filler(new Dimension(5, 10), new Dimension(5, 10), new Dimension(120, 10));
        filterPanel = new JPanel();
        filterLabel = new JLabel();
        filler10 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        filterTextField = new JTextField();
        filler12 = new Box.Filler(new Dimension(10, 50), new Dimension(10, 50), new Dimension(10, 50));
        filterCountLabel = new JLabel();
        filler11 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        filler21 = new Box.Filler(new Dimension(5, 10), new Dimension(5, 10), new Dimension(120, 10));
        scrollPane2 = new JScrollPane();
        availableSongTable = new JTable();
        filler22 = new Box.Filler(new Dimension(5, 5), new Dimension(5, 5), new Dimension(120, 5));
        filler9 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
        buttonPanel = new JPanel();
        filler2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        cancelButton = new JButton();
        filler4 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        saveButton = new JButton();
        filler3 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        tablesPanel.setPreferredSize(new Dimension(0, 200));
        tablesPanel.setLayout(new BoxLayout(tablesPanel, BoxLayout.LINE_AXIS));
        tablesPanel.add(filler8);

        selectedSongPanel.setMinimumSize(new Dimension(50, 0));
        selectedSongPanel.setPreferredSize(new Dimension(300, 0));
        selectedSongPanel.setLayout(new BoxLayout(selectedSongPanel, BoxLayout.PAGE_AXIS));
        selectedSongPanel.add(filler13);

        namePanel.setMaximumSize(new Dimension(32767, 20));
        namePanel.setMinimumSize(new Dimension(0, 20));
        namePanel.setPreferredSize(new Dimension(0, 20));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        namePanel.add(filler23);

        nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        nameLabel.setLabelFor(nameTextField);
        nameLabel.setText("Όνομα:");
        nameLabel.setAlignmentX(0.5F);
        nameLabel.setPreferredSize(new Dimension(60, 14));
        namePanel.add(nameLabel);
        namePanel.add(filler27);

        nameTextField.setMaximumSize(new Dimension(220, 20));
        nameTextField.setMinimumSize(new Dimension(220, 20));
        nameTextField.setPreferredSize(new Dimension(220, 20));
        namePanel.add(nameTextField);
        namePanel.add(filler18);

        selectedSongPanel.add(namePanel);
        selectedSongPanel.add(filler16);

        datePanel.setMaximumSize(new Dimension(32767, 20));
        datePanel.setMinimumSize(new Dimension(0, 20));
        datePanel.setPreferredSize(new Dimension(0, 20));
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.LINE_AXIS));
        datePanel.add(filler24);

        dateabel.setHorizontalAlignment(SwingConstants.TRAILING);
        dateabel.setLabelFor(dateTextField);
        dateabel.setText("Ημερομηνία:");
        dateabel.setAlignmentX(0.5F);
        datePanel.add(dateabel);
        datePanel.add(filler26);

        dateTextField.setEditable(false);
        dateTextField.setMaximumSize(new Dimension(80, 20));
        dateTextField.setMinimumSize(new Dimension(80, 20));
        dateTextField.setPreferredSize(new Dimension(80, 20));
        datePanel.add(dateTextField);
        datePanel.add(filler25);

        dateChangeComboBox.setModel(new DefaultComboBoxModel(new String[] { "Διατήρηση αρχικής", "Ενημέρωση (σημερινή)" }));
        dateChangeComboBox.setMaximumSize(new Dimension(135, 32767));
        dateChangeComboBox.setMinimumSize(new Dimension(135, 20));
        dateChangeComboBox.setPreferredSize(new Dimension(135, 20));
        dateChangeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dateChangeComboBoxActionPerformed(evt);
            }
        });
        datePanel.add(dateChangeComboBox);
        datePanel.add(filler17);

        selectedSongPanel.add(datePanel);
        selectedSongPanel.add(filler20);

        durationPanel.setMaximumSize(new Dimension(32767, 20));
        durationPanel.setMinimumSize(new Dimension(0, 20));
        durationPanel.setPreferredSize(new Dimension(0, 20));
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.LINE_AXIS));
        durationPanel.add(filler28);

        durationLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        durationLabel.setLabelFor(nameTextField);
        durationLabel.setText("Διάρκεια:");
        durationLabel.setAlignmentX(0.5F);
        durationLabel.setPreferredSize(new Dimension(60, 14));
        durationPanel.add(durationLabel);
        durationPanel.add(filler29);

        durationTextField.setEditable(false);
        durationTextField.setHorizontalAlignment(JTextField.TRAILING);
        durationTextField.setMaximumSize(new Dimension(80, 20));
        durationTextField.setMinimumSize(new Dimension(80, 20));
        durationTextField.setPreferredSize(new Dimension(80, 20));
        durationPanel.add(durationTextField);
        durationPanel.add(filler30);

        selectedSongPanel.add(durationPanel);
        selectedSongPanel.add(filler31);

        scrollPane1.setPreferredSize(new Dimension(300, 500));

        playlistSongTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        playlistSongTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playlistSongTable.getTableHeader().setReorderingAllowed(false);
        scrollPane1.setViewportView(playlistSongTable);

        selectedSongPanel.add(scrollPane1);

        tablesPanel.add(selectedSongPanel);

        songButtonPanel.setMaximumSize(new Dimension(150, 32767));
        songButtonPanel.setMinimumSize(new Dimension(150, 0));
        songButtonPanel.setPreferredSize(new Dimension(150, 0));
        songButtonPanel.setLayout(new BoxLayout(songButtonPanel, BoxLayout.PAGE_AXIS));
        songButtonPanel.add(filler5);

        upButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/go-up.png"))); // NOI18N
        upButton.setText("Πάνω");
        upButton.setAlignmentX(0.5F);
        upButton.setHorizontalTextPosition(SwingConstants.CENTER);
        upButton.setMaximumSize(new Dimension(100, 50));
        upButton.setMinimumSize(new Dimension(100, 50));
        upButton.setPreferredSize(new Dimension(100, 50));
        upButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(upButton);
        songButtonPanel.add(filler14);

        downButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/go-down.png"))); // NOI18N
        downButton.setText("Κάτω");
        downButton.setAlignmentX(0.5F);
        downButton.setHorizontalTextPosition(SwingConstants.CENTER);
        downButton.setMaximumSize(new Dimension(100, 50));
        downButton.setMinimumSize(new Dimension(100, 50));
        downButton.setPreferredSize(new Dimension(100, 50));
        downButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(downButton);
        songButtonPanel.add(filler15);

        addButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/go-previous.png"))); // NOI18N
        addButton.setText("Προσθήκη");
        addButton.setAlignmentX(0.5F);
        addButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addButton.setMaximumSize(new Dimension(100, 50));
        addButton.setMinimumSize(new Dimension(100, 50));
        addButton.setPreferredSize(new Dimension(100, 50));
        addButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(addButton);
        songButtonPanel.add(filler6);

        removeButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/go-next.png"))); // NOI18N
        removeButton.setText("Αφαίρεση");
        removeButton.setAlignmentX(0.5F);
        removeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        removeButton.setMaximumSize(new Dimension(100, 50));
        removeButton.setMinimumSize(new Dimension(100, 50));
        removeButton.setPreferredSize(new Dimension(100, 50));
        removeButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(removeButton);
        songButtonPanel.add(filler7);

        tablesPanel.add(songButtonPanel);

        availableSongPanel.setMinimumSize(new Dimension(50, 0));
        availableSongPanel.setPreferredSize(new Dimension(300, 0));
        availableSongPanel.setLayout(new BoxLayout(availableSongPanel, BoxLayout.PAGE_AXIS));
        availableSongPanel.add(filler19);

        filterPanel.setMaximumSize(new Dimension(32767, 20));
        filterPanel.setMinimumSize(new Dimension(0, 20));
        filterPanel.setPreferredSize(new Dimension(0, 20));
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.LINE_AXIS));

        filterLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        filterLabel.setLabelFor(nameTextField);
        filterLabel.setText("Φίλτρο:");
        filterLabel.setPreferredSize(new Dimension(40, 14));
        filterPanel.add(filterLabel);
        filterPanel.add(filler10);

        filterTextField.setMaximumSize(new Dimension(150, 20));
        filterTextField.setMinimumSize(new Dimension(150, 20));
        filterTextField.setPreferredSize(new Dimension(150, 20));
        filterPanel.add(filterTextField);
        filterPanel.add(filler12);

        filterCountLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        filterCountLabel.setLabelFor(nameTextField);
        filterCountLabel.setMaximumSize(new Dimension(0, 14));
        filterCountLabel.setMinimumSize(new Dimension(0, 14));
        filterCountLabel.setPreferredSize(new Dimension(40, 14));
        filterPanel.add(filterCountLabel);
        filterPanel.add(filler11);

        availableSongPanel.add(filterPanel);
        availableSongPanel.add(filler21);

        scrollPane2.setPreferredSize(new Dimension(300, 0));

        availableSongTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        availableSongTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        availableSongTable.getTableHeader().setReorderingAllowed(false);
        scrollPane2.setViewportView(availableSongTable);

        availableSongPanel.add(scrollPane2);
        availableSongPanel.add(filler22);

        tablesPanel.add(availableSongPanel);
        tablesPanel.add(filler9);

        add(tablesPanel);

        buttonPanel.setMaximumSize(new Dimension(32999, 50));
        buttonPanel.setPreferredSize(new Dimension(0, 50));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(filler2);

        cancelButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/undo22.png"))); // NOI18N
        cancelButton.setText("Ακύρωση");
        cancelButton.setPreferredSize(new Dimension(120, 36));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);
        buttonPanel.add(filler4);

        saveButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/accept22.png"))); // NOI18N
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
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controller.goBack();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void removeButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        removeSongFromList();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addSongToList();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (controller.save()) {
            controller.goBack();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void upButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int s = playlistSongTable.getSelectedRow();
        if (s > 0) {
            controller.swapSongs(s, s - 1);
            updateSelectedSongTable(s - 1);
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int s = playlistSongTable.getSelectedRow();
        if (s < controller.getSelectedSongList().size() - 1) {
            controller.swapSongs(s, s + 1);
            updateSelectedSongTable(s + 1);
        }
    }//GEN-LAST:event_downButtonActionPerformed

    private void dateChangeComboBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_dateChangeComboBoxActionPerformed
        switch (dateChangeComboBox.getSelectedIndex()) {
            case 0:
                dateTextField.setText(sdf.format(controller.getPlaylistCreationDate()));
                break;
            case 1:
                dateTextField.setText(sdf.format(new Date()));
                break;
        }
    }//GEN-LAST:event_dateChangeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addButton;
    private JPanel availableSongPanel;
    private JTable availableSongTable;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JComboBox dateChangeComboBox;
    private JPanel datePanel;
    private JTextField dateTextField;
    private JLabel dateabel;
    private JButton downButton;
    private JLabel durationLabel;
    private JPanel durationPanel;
    private JTextField durationTextField;
    private Box.Filler filler10;
    private Box.Filler filler11;
    private Box.Filler filler12;
    private Box.Filler filler13;
    private Box.Filler filler14;
    private Box.Filler filler15;
    private Box.Filler filler16;
    private Box.Filler filler17;
    private Box.Filler filler18;
    private Box.Filler filler19;
    private Box.Filler filler2;
    private Box.Filler filler20;
    private Box.Filler filler21;
    private Box.Filler filler22;
    private Box.Filler filler23;
    private Box.Filler filler24;
    private Box.Filler filler25;
    private Box.Filler filler26;
    private Box.Filler filler27;
    private Box.Filler filler28;
    private Box.Filler filler29;
    private Box.Filler filler3;
    private Box.Filler filler30;
    private Box.Filler filler31;
    private Box.Filler filler4;
    private Box.Filler filler5;
    private Box.Filler filler6;
    private Box.Filler filler7;
    private Box.Filler filler8;
    private Box.Filler filler9;
    private JLabel filterCountLabel;
    private JLabel filterLabel;
    private JPanel filterPanel;
    private JTextField filterTextField;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JTextField nameTextField;
    private JTable playlistSongTable;
    private JButton removeButton;
    private JButton saveButton;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JPanel selectedSongPanel;
    private JPanel songButtonPanel;
    private JPanel tablesPanel;
    private JButton upButton;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private PlaylistEditorController controller;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("el", "GR"));
    private SongTableModel stm;

    /**
     * Δημιουργεί ένα {@code PlaylistEditorPanel} για επεξεργασία μιας λίστας με
     * ελεγκτή τον {@code controller}.
     *
     * @param controller ο ελεγκτής
     */
    public PlaylistEditorPanel(PlaylistEditorController controller) {
        this.controller = controller;
        initComponents();
        initTables();
        initFurther();
    }

    /**
     * Αρχικοποιεί τους δύο πίνακες (επιλεγμένων και διαθέσιμων τραγουδιών) που
     * εμφανίζονται σ' αυτό το PlaylistEditorPanel.
     *
     */
    private void initTables() {
        // εγκατάσταση μοντέλου πίνακα επιλεγμένων
        playlistSongTable.setModel(new OrderedSongTableModel(controller.getSelectedSongList()));

        // εγκατάσταση μοντέλου πίνακα διαθέσιμων
        stm = new SongTableModel(controller.getFilteredSongList());
        availableSongTable.setModel(stm);

        // ρύθμιση στηλών πίνακα επιλεγμένων (επικεφαλίδες, πλάτη, renderers)
        TableColumnModel tcm1 = playlistSongTable.getColumnModel();
        String[] headers1 = {"Σειρά", "Τίτλος", "Ερμηνευτής", "Διάρκεια"};
        int[] widths1 = {40, 110, 110, 40};
        TableCellRendererFactory.RendererType[] renderers1
                = {TableCellRendererFactory.RendererType.GENERIC_RIGHT_ALIGNED,
                    TableCellRendererFactory.RendererType.GENERIC,
                    TableCellRendererFactory.RendererType.GENERIC,
                    TableCellRendererFactory.RendererType.DURATION
                };
        for (int i = 0; i < tcm1.getColumnCount(); i++) {
            TableColumn col = tcm1.getColumn(i);
            col.setCellRenderer(TableCellRendererFactory.getTableCellRenderer(renderers1[i]));
            col.setHeaderValue(headers1[i]);
            col.setPreferredWidth(widths1[i]);
        }

        // ρύθμιση στηλών πίνακα διαθέσιμων (επικεφαλίδες, πλάτη, renderers)
        TableColumnModel tcm2 = availableSongTable.getColumnModel();
        String[] headers2 = {"Τίτλος", "Ερμηνευτής", "Διάρκεια"};
        int[] widths2 = {130, 130, 40};
        TableCellRendererFactory.RendererType[] renderers2
                = {TableCellRendererFactory.RendererType.GENERIC,
                    TableCellRendererFactory.RendererType.GENERIC,
                    TableCellRendererFactory.RendererType.DURATION
                };
        for (int i = 0; i < tcm2.getColumnCount(); i++) {
            TableColumn col = tcm2.getColumn(i);
            col.setCellRenderer(TableCellRendererFactory.getTableCellRenderer(renderers2[i]));
            col.setHeaderValue(headers2[i]);
            col.setPreferredWidth(widths2[i]);
        }

        // ανανέωση πινάκων
        updateSelectedSongTable(-1);
        updateAvailableSongTable(-1);

        // εγκατάσταση listener για παρακολούθηση μεταβολών επιλογής στους πίνακες
        ListSelectionListener lsl = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateButtons();
            }
        };
        playlistSongTable.getSelectionModel().addListSelectionListener(lsl);
        availableSongTable.getSelectionModel().addListSelectionListener(lsl);
    }

    /**
     * Αρχικοποίεί περαιτέρω στοιχεία του UI.
     */
    private void initFurther() {
        buttonPanel.setPreferredSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        buttonPanel.setMaximumSize(new Dimension(32767, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        buttonPanel.setMinimumSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));

        nameTextField.setText(controller.getPlaylistName());
        dateTextField.setText(sdf.format(controller.getPlaylistCreationDate()));

        // εγκατάσταση listener για παρακολούθηση μεταβολών του κειμένου του φίλτρου
        filterTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateForFilterChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateForFilterChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        updateButtons();
    }

    /**
     * Προσθέτει το επιλεγμένο στον πίνακα διαθέσιμων τραγούδι στη λίστα των
     * επιλεγμένων και το αφαιρεί από τη λίστα των διαθέσιμων.
     */
    private void addSongToList() {
        int avSel = availableSongTable.getSelectedRow();
        int s = playlistSongTable.getSelectedRow();

        int ins = controller.addSongToList(avSel, s);

        // ανανέωση πινάκων
        updateSelectedSongTable(ins);
        updateAvailableSongTable(avSel);
    }

    /**
     * Αφαιρεί το επιλεγμένο στον πίνακα των επιλεγμένων τραγούδι από τη λίστα
     * των επιλεγμένων, και το προσθέτει στη λίστα των διαθέσιμων.
     */
    private void removeSongFromList() {
        int sel = playlistSongTable.getSelectedRow();
        int newSel = controller.removeSongFromList(sel);

        updateSelectedSongTable(newSel);
        updateAvailableSongTable(0);
    }

    /**
     * Καλείται για να ανανεώσει τα σχετικά στοιχεία του ui σε κάθε μεταβολή του
     * κειμένου του φίλτρου.
     */
    private void updateForFilterChange() {
        controller.updateForFilterChange(filterTextField.getText().toLowerCase());
        updateAvailableSongTable(0);
    }

    /**
     * Ανανεώνει την εμφάνιση του πίνακα των επιλεγμένων τραγουδιών, ορίζοντας
     * ως επιλεγμένη σειρά την {@code newSel}.
     *
     * @param newSel η σειρά που ορίζεται ως επιλεγμένη
     */
    private void updateSelectedSongTable(int newSel) {
        ((AbstractTableModel) playlistSongTable.getModel()).fireTableDataChanged();
        playlistSongTable.getSelectionModel().setSelectionInterval(newSel, newSel);
        durationTextField.setText(controller.getFormattedTotalDuration());
    }

    /**
     * Ανανεώνει την εμφάνιση του πίνακα των διαθέσιμων τραγουδιών, ορίζοντας ως
     * επιλεγμένη σειρά την {@code newSel}. Ανανεώνει επίσης την ετικέτα με το
     * αποτέλεσμα (πλήθος εγγραφών) του φίλτρου.
     *
     * @param newSel η σειρά που ορίζεται ως επιλεγμένη
     */
    private void updateAvailableSongTable(int newSel) {
        stm.setSongList(controller.getFilteredSongList());
        stm.fireTableDataChanged();
        int fs = controller.getFilteredSongList().size();
        if (newSel >= fs) {
            newSel = fs - 1;
        }
        availableSongTable.getSelectionModel().setSelectionInterval(newSel, newSel);
        filterCountLabel.setText("(" + fs + "/" + controller.getAvailableSongCount() + ")");
    }

    /**
     * Ενημερώνει την κατάσταση ενεργοποίησης των πλήκτρων προσθήκης/αφαίρεσης
     * και μετακίνησης πάνω/κάτω, ανάλογα με τις επιλεγμένες σειρές στους δύο
     * πίνακες.
     */
    private void updateButtons() {
        int s = playlistSongTable.getSelectedRow();
        upButton.setEnabled(s > 0);
        downButton.setEnabled(s != -1 && s < controller.getSelectedSongList().size() - 1);
        removeButton.setEnabled(s != -1);
        addButton.setEnabled(availableSongTable.getSelectedRow() != -1);
    }

    public int getDateChangeComboBoxSelectedIndex() {
        return dateChangeComboBox.getSelectedIndex();
    }

    public String getNameTextFieldText() {
        return nameTextField.getText();
    }
}
