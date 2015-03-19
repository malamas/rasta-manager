/*
 * Copyright (c) 2015 Apostolis Iakovakis & Malamas Malamidis.
 * All rights reserved.
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
package eu.malamas.rastaman.ui.playlist;

import eu.malamas.rastaman.model.Playlist;
import eu.malamas.rastaman.model.PlaylistSong;
import eu.malamas.rastaman.ui.MainFrameController;
import eu.malamas.rastaman.ui.skins.SkinProvider;
import eu.malamas.rastaman.ui.tablecellrenderers.TableCellRendererFactory;
import eu.malamas.rastaman.util.DatabaseHandler;
import eu.malamas.rastaman.util.XmlHandler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Η κλάση {@code PlaylistTablePanel} είναι ένα {@code JPanel} για εμφάνιση
 * πίνακα με λίστες αναπαραγωγής.
 *
 * @author Malamas Malamidis
 */
public class PlaylistTablePanel extends javax.swing.JPanel {

    /**
     * Creates new form PlaylistPanel
     */
    public PlaylistTablePanel() {
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

        boundPlaylistList = playlists;
        JScrollPane scrollPane1 = new JScrollPane();
        playlistTable = new JTable();
        buttonPanel = new JPanel();
        Box.Filler filler3 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        backButton = new JButton();
        Box.Filler filler8 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        importButton = new JButton();
        Box.Filler filler7 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        exportButton = new JButton();
        Box.Filler filler2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767));
        newButton = new JButton();
        Box.Filler filler4 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        editButton = new JButton();
        Box.Filler filler5 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));
        deleteButton = new JButton();
        Box.Filler filler6 = new Box.Filler(new Dimension(5, 15), new Dimension(5, 15), new Dimension(5, 15));

        setLayout(new BorderLayout());

        playlistTable.getTableHeader().setReorderingAllowed(false);

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, boundPlaylistList, playlistTable);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${name}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${creationDate}"));
        columnBinding.setColumnName("Ημερομηνία δημιουργίας");
        columnBinding.setColumnClass(Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${songCount}"));
        columnBinding.setColumnName("Πλήθος τραγουδιών");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${duration}"));
        columnBinding.setColumnName("Διάρκεια");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollPane1.setViewportView(playlistTable);

        add(scrollPane1, BorderLayout.CENTER);

        buttonPanel.setPreferredSize(new Dimension(0, 50));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(filler3);

        backButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/home22.png"))); // NOI18N
        backButton.setText("Αρχική");
        backButton.setPreferredSize(new Dimension(120, 36));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(backButton);
        buttonPanel.add(filler8);

        importButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/document-open.png"))); // NOI18N
        importButton.setText("από XML");
        importButton.setPreferredSize(new Dimension(120, 36));
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(importButton);
        buttonPanel.add(filler7);

        exportButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/document-save.png"))); // NOI18N
        exportButton.setText("σε XML");
        exportButton.setPreferredSize(new Dimension(120, 36));

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, playlistTable, ELProperty.create("${selectedElement!=null}"), exportButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        exportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(exportButton);
        buttonPanel.add(filler2);

        newButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/add22.png"))); // NOI18N
        newButton.setText("Εισαγωγή");
        newButton.setPreferredSize(new Dimension(120, 36));
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(newButton);
        buttonPanel.add(filler4);

        editButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/edit22.png"))); // NOI18N
        editButton.setText("Επεξεργασία");
        editButton.setPreferredSize(new Dimension(120, 36));

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, playlistTable, ELProperty.create("${selectedElement!=null}"), editButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(editButton);
        buttonPanel.add(filler5);

        deleteButton.setIcon(new ImageIcon(getClass().getResource("/eu/malamas/rastaman/resources/images/delete22.png"))); // NOI18N
        deleteButton.setText("Διαγραφή");
        deleteButton.setPreferredSize(new Dimension(120, 36));

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, playlistTable, ELProperty.create("${selectedElement!=null}"), deleteButton, BeanProperty.create("enabled"));
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

    private void backButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        controller.switchToPanel(MainFrameController.PanelType.ROOT_MENU);
    }//GEN-LAST:event_backButtonActionPerformed

    private void editButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedIndex = playlistTable.getSelectedRow();
        if (selectedIndex != -1) {
            // ανάκτηση λίστας προς επεξεργασία
            Playlist sp = playlists.get(selectedIndex);
            // αίτημα για μετάβαση στον PlaylistEditor
            controller.switchToEditor(MainFrameController.EditorType.PLAYLIST_EDITOR, sp);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void importButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        importListFromXml();
    }//GEN-LAST:event_importButtonActionPerformed

    private void exportButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        int selectedIndex = playlistTable.getSelectedRow();
        if (selectedIndex != -1) {
            Playlist sp = playlists.get(selectedIndex);
            exportListToXml(sp);
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void deleteButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedIndex = playlistTable.getSelectedRow();
        if (selectedIndex != -1) {
            Playlist sp = playlists.get(selectedIndex);
            Object[] options = {"Ναι", "Όχι"};
            int selectedOption = JOptionPane.showOptionDialog(this, "Να διαγραφεί η λίστα '" + sp.getName() + "';", "Επιβεβαίωση διαγραφής", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (selectedOption == JOptionPane.YES_OPTION) {
                for (PlaylistSong ps : sp.getPlaylistSongList()) {
                    ps.getSong().getPlaylistSongList().remove(ps);
                }
                em.getTransaction().begin();
                em.remove(sp);
                em.getTransaction().commit();
                playlists.remove(sp);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // δημιουργία νέας λίστας
        Playlist newPlaylist = new Playlist();
        newPlaylist.setCreationDate(new Date());
        newPlaylist.setPlaylistSongList(Collections.emptyList());
        // αίτημα για μετάβαση στον PlaylistEditor
        controller.switchToEditor(MainFrameController.EditorType.PLAYLIST_EDITOR, newPlaylist);
    }//GEN-LAST:event_newButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton backButton;
    private List<Playlist> boundPlaylistList;
    private JPanel buttonPanel;
    private JButton deleteButton;
    private JButton editButton;
    private JButton exportButton;
    private JButton importButton;
    private JButton newButton;
    private JTable playlistTable;
    private BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //
    // Ο δικός μας κώδικας αρχίζει εδώ, για να είναι
    // εμφανώς διαχωρισμένος από τον αυτόματα δημιουργούμενο
    //
    private static final Logger LOGGER = Logger.getLogger(PlaylistTablePanel.class.getName());
    private MainFrameController controller;
    private EntityManager em;
    private List<Playlist> playlists;

    /**
     * Δημιουργεί ένα {@code PlaylistTablePanel} με ελεγκτή τον
     * {@code controller}. Δέχεται αναφορά σε έναν {@code EntityManager} που θα
     * χρησιμοποιήσει η φόρμα.
     *
     * @param controller ο ελεγκτής
     */
    public PlaylistTablePanel(MainFrameController controller) {
        this.controller = controller;
        this.em = DatabaseHandler.getInstance().getEm();
        playlists = ObservableCollections.observableList(em.createNamedQuery("Playlist.findAll", Playlist.class).getResultList());
        initComponents();
        initFurther();
    }

    /**
     * Αρχικοποίεί περαιτέρω στοιχεία του UI.
     */
    private void initFurther() {
        buttonPanel.setPreferredSize(new Dimension(0, SkinProvider.getInstance().getSkin().getButtonPanelHeight()));

        // ρύθμιση στηλών πίνακα επιλεγμένων (επικεφαλίδες, πλάτη, renderers)
        TableColumnModel tcm = playlistTable.getColumnModel();
        String[] headers = {"Όνομα", "Ημερομηνία δημιουργίας", "Πλήθος τραγουδιών", "Διάρκεια"};
        int[] widths = {100, 100, 100, 100};
        TableCellRendererFactory.RendererType[] renderers
                = {TableCellRendererFactory.RendererType.GENERIC,
                    TableCellRendererFactory.RendererType.DATE,
                    TableCellRendererFactory.RendererType.GENERIC_RIGHT_ALIGNED,
                    TableCellRendererFactory.RendererType.DURATION
                };
        for (int i = 0; i < tcm.getColumnCount(); i++) {
            TableColumn col = tcm.getColumn(i);
            col.setCellRenderer(TableCellRendererFactory.getTableCellRenderer(renderers[i]));
            col.setHeaderValue(headers[i]);
            col.setPreferredWidth(widths[i]);
        }
    }

    /**
     * Εισάγει μια λίστα αναπαραγωγής από αρχείο xml.
     */
    private void importListFromXml() {
        File file = getUserSelectedFile(JFileChooser.OPEN_DIALOG, null);
        if (file != null) {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(file);

                Playlist newPl = XmlHandler.buildPlaylistFromDocument(doc, em);
                if (newPl != null) {
                    String newName = newPl.getName();
                    for (Playlist p : playlists) {
                        String g = p.getName();
                        if (newName.toLowerCase().equals(g.toLowerCase())) {
                            newName = g + " [αντίγραφο]";
                            JOptionPane.showMessageDialog(this, "Υπάρχει ήδη λίστα με το όνομα '" + g + "'. Η λίστα θα εισαχθεί με όνομα '" + newName + "'", "Προσοχή!", JOptionPane.WARNING_MESSAGE);
                            newPl.setName(newName);
                        }
                    }
                    for (PlaylistSong ps : newPl.getPlaylistSongList()) {
                        ps.getSong().getPlaylistSongList().add(ps);
                    }
                    em.getTransaction().begin();
                    em.persist(newPl);
                    em.getTransaction().commit();
                    playlists.add(newPl);
                } else {
                    JOptionPane.showMessageDialog(this, "Το αρχείο xml δεν είναι έγκυρο!", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
                }

            } catch (ParserConfigurationException | SAXException | IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Η εισαγωγή του αρχείου xml απέτυχε...", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Εξάγει μια λίστα αναπαραγωγής σε αρχείο xml.
     */
    private void exportListToXml(Playlist pl) {
        // Επιλογή αρχείου από το χρήστη
        File file = getUserSelectedFile(JFileChooser.SAVE_DIALOG, pl.getName());
        if (file != null) {
            try {
                Document doc = XmlHandler.buildDocumentFromPlaylist(pl);
                // Εξαγωγή του δένδρου σε αρχείο
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);

                transformer.transform(source, result);
                JOptionPane.showMessageDialog(this, "Η εξαγωγή της λίστας ολοκληρώθηκε με επιτυχία.", "Εξαγωγή xml", JOptionPane.INFORMATION_MESSAGE);

            } catch (ParserConfigurationException | TransformerException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Η δημιουργία του αρχείου xml απέτυχε...", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Εμφανίζει {@code JFileChooser} για την επιλογή του αρχείου από τον χρήστη
     * και επιστρέφει το επιλεγμένο αρχείο. Η παράμετρος {@code fileChooserType}
     * δέχεται μόνο τις τιμές {@code JFileChooser.OPEN_DIALOG} ή
     * {@code JFileChooser.SAVE_DIALOG} και καθορίζει τον τύπο του πλαισίου
     * διαλόγου.
     *
     * @param fileChooserType ο τύπος του διαλόγου (άνοιγμα/κλείσιμο)
     * @param filename το προτεινόμενο όνομα αρχείου σε περίπτωση αποθήκευσης
     * @return File το επιλεγμένο αρχείο
     */
    private File getUserSelectedFile(int fileChooserType, String filename) {
        if (fileChooserType != JFileChooser.OPEN_DIALOG && fileChooserType != JFileChooser.SAVE_DIALOG) {
            throw new IllegalArgumentException("fileChooserType should be either JFileChooser.OPEN_DIALOG or JFileChooser.SAVE_DIALOG");
        }
        JFileChooser fc = new JFileChooser();
        File selectedFile = null;
        fc.setDialogType(fileChooserType);
        FileFilter xmlFilter = new FileNameExtensionFilter("αρχεία XML (*.xml)", "xml");
        fc.setFileFilter(xmlFilter);
        switch (fileChooserType) {
            case JFileChooser.OPEN_DIALOG:
                fc.setDialogTitle("Εισαγωγή από XML");
                fc.setApproveButtonText("Εισαγωγή");
                break;
            case JFileChooser.SAVE_DIALOG:
                fc.setDialogTitle("Εξαγωγή σε XML");
                fc.setApproveButtonText("Εξαγωγή");
                fc.setSelectedFile(new File(filename + ".xml"));
                break;
        }
        if (fc.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
        }
        return selectedFile;
    }
}