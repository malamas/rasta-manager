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

import eap.pli24.rastaman.ui.tablemodels.SongTableModel;
import eap.pli24.rastaman.ui.tablemodels.OrderedSongTableModel;
import eap.pli24.rastaman.entities.Playlist;
import eap.pli24.rastaman.entities.PlaylistSong;
import eap.pli24.rastaman.entities.Song;
import eap.pli24.rastaman.ui.skins.SkinProvider;
import eap.pli24.rastaman.ui.tablecellrenderers.TableCellRendererFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;

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
        namePanel = new JPanel();
        nameLabel = new JLabel();
        nameTextField = new JTextField();
        tablesPanel = new JPanel();
        filler8 = new Box.Filler(new Dimension(5, 50), new Dimension(5, 50), new Dimension(5, 50));
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
        filterPanel = new JPanel();
        filterLabel = new JLabel();
        filler10 = new Box.Filler(new Dimension(10, 50), new Dimension(10, 50), new Dimension(10, 50));
        filterTextField = new JTextField();
        filler11 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        filler12 = new Box.Filler(new Dimension(10, 50), new Dimension(10, 50), new Dimension(10, 50));
        filterCountLabel = new JLabel();
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

        namePanel.setMaximumSize(new Dimension(32767, 50));
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

        scrollPane1.setMinimumSize(new Dimension(50, 0));
        scrollPane1.setPreferredSize(new Dimension(300, 0));

        playlistSongTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        playlistSongTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playlistSongTable.getTableHeader().setReorderingAllowed(false);
        scrollPane1.setViewportView(playlistSongTable);

        tablesPanel.add(scrollPane1);

        songButtonPanel.setMaximumSize(new Dimension(150, 32767));
        songButtonPanel.setMinimumSize(new Dimension(150, 0));
        songButtonPanel.setPreferredSize(new Dimension(150, 0));
        songButtonPanel.setLayout(new BoxLayout(songButtonPanel, BoxLayout.PAGE_AXIS));
        songButtonPanel.add(filler5);

        upButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/go-up.png"))); // NOI18N
        upButton.setText("Πάνω");
        upButton.setAlignmentX(0.5F);
        upButton.setHorizontalTextPosition(SwingConstants.CENTER);
        upButton.setMaximumSize(new Dimension(100, 50));
        upButton.setMinimumSize(new Dimension(100, 50));
        upButton.setPreferredSize(new Dimension(100, 50));
        upButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, playlistSongTable, ELProperty.create("${selectedElement!=null}"), upButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(upButton);
        songButtonPanel.add(filler14);

        downButton.setIcon(new ImageIcon(getClass().getResource("/eap/pli24/rastaman/resources/images/go-down.png"))); // NOI18N
        downButton.setText("Κάτω");
        downButton.setAlignmentX(0.5F);
        downButton.setHorizontalTextPosition(SwingConstants.CENTER);
        downButton.setMaximumSize(new Dimension(100, 50));
        downButton.setMinimumSize(new Dimension(100, 50));
        downButton.setPreferredSize(new Dimension(100, 50));
        downButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, playlistSongTable, ELProperty.create("${selectedElement!=null}"), downButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        songButtonPanel.add(downButton);
        songButtonPanel.add(filler15);

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

        availableSongPanel.setMinimumSize(new Dimension(50, 0));
        availableSongPanel.setPreferredSize(new Dimension(300, 0));
        availableSongPanel.setLayout(new BoxLayout(availableSongPanel, BoxLayout.PAGE_AXIS));

        filterPanel.setMaximumSize(new Dimension(32767, 30));
        filterPanel.setMinimumSize(new Dimension(0, 30));
        filterPanel.setPreferredSize(new Dimension(0, 30));
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
        filterPanel.add(filler11);
        filterPanel.add(filler12);

        filterCountLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        filterCountLabel.setLabelFor(nameTextField);
        filterCountLabel.setMaximumSize(new Dimension(0, 14));
        filterCountLabel.setMinimumSize(new Dimension(0, 14));
        filterCountLabel.setPreferredSize(new Dimension(40, 14));
        filterPanel.add(filterCountLabel);

        availableSongPanel.add(filterPanel);

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

        tablesPanel.add(availableSongPanel);
        tablesPanel.add(filler9);

        add(tablesPanel);

        buttonPanel.setMaximumSize(new Dimension(32999, 50));
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
        removeSongFromList();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addSongToList();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
        controller.switchToPanel(MainFrameController.PanelType.PLAYLIST_TABLE);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void upButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int s = playlistSongTable.getSelectedRow();
        if (s > 0) {
            swapSelectedSongs(s - 1);
            updateLeft(s - 1);
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int s = playlistSongTable.getSelectedRow();
        if (s < selectedSongList.size() - 1) {
            swapSelectedSongs(s);
            updateLeft(s + 1);
        }
    }//GEN-LAST:event_downButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addButton;
    private JPanel availableSongPanel;
    private JTable availableSongTable;
    private Playlist boundPlaylist;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JButton downButton;
    private Box.Filler filler10;
    private Box.Filler filler11;
    private Box.Filler filler12;
    private Box.Filler filler14;
    private Box.Filler filler15;
    private Box.Filler filler2;
    private Box.Filler filler3;
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
    private JPanel songButtonPanel;
    private JPanel tablesPanel;
    private JButton upButton;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private MainFrameController controller;
    private EntityManager em;
    private Playlist playlist;
    private final Comparator<Song> songTitleComparator = (Song s1, Song s2) -> (s1.getTitle().compareTo(s2.getTitle()));
    private List<Song> availableSongList;
    private List<Song> selectedSongList;
    private List<Song> filteredList;
    private SongTableModel stm;
    private String filterString;

    public PlaylistEditorPanel(MainFrameController controller, EntityManager em, Playlist playlist) {
        this.controller = controller;
        this.em = em;
        this.playlist = playlist;
        this.filterString = "";
        initComponents();
        initLists();
        initTables();
        initFurther();
    }

    private void initLists() {
        selectedSongList = new ArrayList<>();
        availableSongList = new ArrayList<>();
        availableSongList.addAll(em.createNamedQuery("Song.findAll", Song.class).getResultList());

        for (PlaylistSong ps : playlist.getPlaylistSongList()) {
            availableSongList.remove(ps.getSong());
            selectedSongList.add(ps.getSong());
        }

//        playlist.getPlaylistSongList().stream().forEach((ps) -> {
//            availableSongList.remove(ps.getSong());
//        });
        availableSongList.sort(songTitleComparator);
        filteredList = new ArrayList<>(availableSongList);
    }

    private void initFurther() {
        buttonPanel.setPreferredSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        buttonPanel.setMaximumSize(new Dimension(32767, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        buttonPanel.setMinimumSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        namePanel.setPreferredSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        namePanel.setMaximumSize(new Dimension(32767, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));
        namePanel.setMinimumSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));

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
    }

    private void initTables() {
        stm = new SongTableModel(selectedSongList);
        availableSongTable.setModel(stm);
        updateRight();

        playlistSongTable.setModel(new OrderedSongTableModel(selectedSongList));
        updateLeft(-1);

        // Καθορισμός εμφάνισης στηλών πινάκων
        TableColumnModel tcm;

        // Πίνακας τραγουδιών λίστας
        tcm = playlistSongTable.getColumnModel();
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
        // Πίνακας διαθέσιμων τραγουδιών
        tcm = availableSongTable.getColumnModel();
        for (int i = 0; i < tcm.getColumnCount(); i++) {
            switch (i) {
                case 2:
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.DURATION));
                    break;
                default:
                    tcm.getColumn(i).setCellRenderer(TableCellRendererFactory.getTableCellRenderer(TableCellRendererFactory.RendererType.GENERIC));
                    break;
            }
        }
    }

    private List<Song> getFilteredList() {
        return availableSongList.stream().filter(s -> (s.getTitle().toLowerCase().contains(filterString) || s.getAlbumId().getPerformerScreenName().toLowerCase().contains(filterString))).collect(Collectors.toList());
    }

    private void addSongToList() {
        Song song = filteredList.remove(availableSongTable.getSelectedRow());
        availableSongList.remove(song);
        int s = playlistSongTable.getSelectedRow();
        int e = selectedSongList.size();
        int ins = ((s == -1) ? e : s);
        selectedSongList.add(ins, song);
        updateLeft(ins);
        updateRight();
    }

    private void removeSongFromList() {
        int sel = playlistSongTable.getSelectedRow();
        Song song = selectedSongList.remove(sel);
        availableSongList.add(song);
        availableSongList.sort(songTitleComparator);
        filteredList = getFilteredList();

        int newSel = -1;
        if (selectedSongList.size() != 0) {
            newSel = ((sel < selectedSongList.size()) ? sel : sel - 1);
        }
        updateLeft(newSel);

        updateRight();
    }

    private void swapSelectedSongs(int firstIndex) {
        Song song = selectedSongList.remove(firstIndex);
        selectedSongList.add(firstIndex + 1, song);
    }

    private void updateForFilterChange() {
        filterString = filterTextField.getText().toLowerCase();
        filteredList = getFilteredList();
        updateRight();
    }

    private void updateLeft(int newSel) {
        ((AbstractTableModel) playlistSongTable.getModel()).fireTableDataChanged();
        playlistSongTable.getSelectionModel().setSelectionInterval(newSel, newSel);
    }

    private void updateRight() {
        stm.setSongList(filteredList);
        stm.fireTableDataChanged();
        updateLabels();
    }

    private void updateLabels() {
        filterCountLabel.setText("(" + Integer.toString(filteredList.size()) + "/" + availableSongList.size() + ")");
    }

    private void save() {
        List<PlaylistSong> psl = new ArrayList<>();
        for (int i = 0; i < selectedSongList.size(); i++) {
            PlaylistSong ps = new PlaylistSong();
            ps.setSlot(i + 1);
            ps.setPlaylist(playlist);
            ps.setSong(selectedSongList.get(i));
            psl.add(ps);
        }
        playlist.setName(boundPlaylist.getName());
        playlist.setCreationDate(new Date());
        playlist.setPlaylistSongList(psl);
        em.getTransaction().begin();
        em.merge(playlist);
        em.getTransaction().commit();
    }
}
